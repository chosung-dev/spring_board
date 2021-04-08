package com.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.user.User;

public class UserDao {
	private JdbcTemplate template;
	
	public UserDao(JdbcTemplate template) {
		this.template = template;
	}
	
	public int userInsert(User user) {
		int result = 0;
		
		final String sql = "INSERT INTO user (name, id, password) values (?, ?, ?)";
		result = template.update(sql, user.getUserName(), user.getUserId(), user.getUserPw());
		
		return result;
	}
	
	public List<User> getUserList() {
		List<User> userList = null;
		final String sql = "SELECT * FROM user";
		
		userList = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub	
			}
		}, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserName(rs.getString("name"));
				user.setUserId(rs.getString("id"));
				user.setUserPw(rs.getString("password"));
				
				return user;
			}
		});
		
		return userList;
	}
	
	public User userSearch(String userId, String userPassword) {
		System.out.println(userId+" "+userPassword);
		List<User> userList = null;
		final String sql = "SELECT * FROM user WHERE id= ? AND password= ?";
		
		userList = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub	
				pstmt.setString(1, userId);
				pstmt.setString(2, userPassword);
			}
		}, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserName(rs.getString("name"));
				user.setUserId(rs.getString("id"));
				user.setUserPw(rs.getString("password"));
				
				return user;
			}
		});
		
		if(userList.size()==0) {
			return null;
		} else {
			return userList.get(0);
		}
	}
}
