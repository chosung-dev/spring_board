package com.user.configration;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.user.dao.UserDao;
import com.user.service.UserService;

@Configuration
public class UserConfig {
	
	@Bean
	public UserDao userDao() {
		return new UserDao(template());
	}
	
	@Bean
	public UserService userService() {
		return new UserService(userDao());
	}
	
	
	@Bean
	public JdbcTemplate template() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_board?serverTimezone=Asia/Seoul");
			dataSource.setUser("root");
			dataSource.setPassword("pw1234");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		return template;
	}
	 
}
