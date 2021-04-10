package com.board;

public class Comment {
	private String commentId;
	private String content;
	private String time;
	private String userId;
	private String boardId;
	
	public Comment(String commentId, String content, String time, String userId, String boardId) {
		this.commentId = commentId;
		this.content = content;
		this.time = time;
		this.userId = userId;
		this.boardId = boardId;
	}
	
	
	public String getContent() {
		return this.content;
	}
	
}
