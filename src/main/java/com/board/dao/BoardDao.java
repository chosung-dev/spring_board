package com.board.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.user.User;

public class BoardDao {
	private JdbcTemplate template;
	
	public BoardDao(JdbcTemplate template) {
		this.template = template;
	}
	
	//게시판 리스트 n~n+10개까지 조회
	public List<String> selectBoardTittle(int n) {
		List<String> boardTitleList = null;
		
		final String sql = "SELECT id, tittle FROM board order by `id` desc limit ?, ?";
		
		boardTitleList = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub	
				if(n==0) {
					pstmt.setInt(1, 0);
				}else {
					pstmt.setInt(1, n*10);
				}
				pstmt.setInt(2, 10);
				System.out.println(pstmt.toString());
			}
		}, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("tittle");
			}
		});
		
		return boardTitleList;
	}
	
	
	public void insertTestBoard() {
		final String sql = "INSERT INTO spring_board.board (tittle, content, user_id, `time`) "
				+ "VALUES(?, ?, 'chosung1144', now())";
		for(int i=0; i<50000; i++) {
			System.out.println("insert "+i);
			template.update(sql, "testTittle"+i, "testContent"+i);
		}
	}
	
	public int insertBoard(String tittle, String content, User user) {
		final String sql = "INSERT INTO spring_board.board (tittle, content, user_id, `time`) "
				+ "VALUES(?, ?, ?, now())";
		
		int result;
		
		result = template.update(sql, tittle, content, user.getUserId());
		
		return result;
	}
}
