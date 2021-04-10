package com.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.board.Board;
import com.board.Comment;
import com.user.User;

public class CommentDao {
	private JdbcTemplate template;
	
	public CommentDao(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Comment> getBoardComment(String boardId) {
		List<Comment> comments = null;
		
		final String sql = "SELECT * FROM comment WHERE board_id = ?";
		
		comments = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub	
				pstmt.setString(1, boardId);
			}
		}, new RowMapper<Comment>() {
			@Override
			public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Comment(rs.getString("id"), rs.getString("content"), 
						rs.getString("time"), rs.getString("user_id"), rs.getString("board_id"));
			}
		});
		
		return comments;
	}
	
	public int insertContent(String boardId, String content, String userId) {
		final String sql = "INSERT INTO comment (board_id, user_id, content, `time`) "
				+ "VALUES(?, ?, ?, now())";
		
		int result;
		
		result = template.update(sql, boardId, userId, content);
		
		return result;
	}
}
