package com.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import com.user.User;

public class UserDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring_board?serverTimezone=Asia/Seoul";
	private String userid = "root";
	private String userpw = "pw1234";
	
	private DriverManagerDataSource dataSource;
	
	private JdbcTemplate template;
	
	public UserDao() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(userid);
		dataSource.setPassword(userpw);
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
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
	
}
