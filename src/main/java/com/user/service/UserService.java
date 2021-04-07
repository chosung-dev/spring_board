package com.user.service;

import java.util.LinkedList;

import com.user.User;
import com.user.dao.UserDao;

public class UserService {
	UserDao dao;
	
	
	public UserService(UserDao dao) {
		this.dao = dao;
	}
	
	public void userRegister(User user) {
		int result = dao.userInsert(user);
		if(result == 0) {
			System.out.println("ERROR: User Join Fail");
		} else {
			System.out.println("User Join Success");
		}
	}
	
	public LinkedList<User> getUserList() {
		LinkedList<User> userList = dao.getUserList();
		return userList;
	}
}
