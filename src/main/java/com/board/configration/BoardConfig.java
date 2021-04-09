package com.board.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.board.dao.BoardDao;
import com.board.service.BoardService;

@Configuration
public class BoardConfig {
	
	@Autowired
	JdbcTemplate template;
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao(template);
	}
	
	
	@Bean
	public BoardService boardService() {
		return new BoardService(boardDao());
	}
	
}
