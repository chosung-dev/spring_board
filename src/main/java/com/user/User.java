package com.user;

import com.security.Encryption;

public class User {
	private String userName;
	private String userId;
	private String userPw;
	
	
	public void setUserInfo(String userName, String userId, String userPw) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = Encryption.encryptSHA256(userPw);
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	
	
}
