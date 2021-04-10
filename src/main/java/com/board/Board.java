package com.board;

import java.util.List;

public class Board {
	private String boardId;
	private String title;
	private String userId;
	private String time;
	private String content;
	private List<Comment> comments;
	
	public Board(String boardId,String title, String content, String userId,String time) {
		this.boardId =boardId;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.time = time;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments= comments;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public List<Comment> getComments() {
		return this.comments;
	}
	
	public String getId() {
		return this.boardId;
	}
	

}
