package com.user.service;

import java.util.List;

import com.security.Encryption;
import com.user.User;
import com.user.dao.UserDao;

public class UserService {
	UserDao dao;
	
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	public int userRegister(User user) {
		int result = dao.userInsert(user);
		if(result == 0) {
			System.out.println("ERROR: User Join Fail");
		} else {
			System.out.println("User Join Success");
		}
		return result;
	}
	
	public List<User> getUserList() {
		List<User> userList = dao.getUserList();
		return userList;
	}
	
	public User userSearch(String userId, String userPassword) {
		return dao.userSearch(userId, Encryption.encryptSHA256(userPassword));
	}
}
