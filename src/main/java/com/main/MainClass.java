package com.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.board.configration.BoardConfig;
import com.board.dao.BoardDao;
import com.user.User;
import com.user.configration.UserConfig;
import com.user.service.UserService;


public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserConfig.class, BoardConfig.class);
		
		UserService userService = ctx.getBean("userService", UserService.class);
		BoardDao boardDao = ctx.getBean("boardDao", BoardDao.class);
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			String str = "";
			
			System.out.println("\n==================================================================="
					+ "==============================================================================");
			System.out.println("Select number.");
			System.out.println("1. User register");
			System.out.println("2. Print user list");
			System.out.println("3. Exit");
			System.out.println("4. insert test board data");
			
			str = scanner.next();
			if(str.equals("3")) {
				System.out.println("Bye");
				break;
			} else if(str.equals("2")) {
				List<User> userList = userService.getUserList();
				System.out.printf("%-15s%-20s%s\n", "userName","userId","userPw");
				for(User user : userList) { //for문을 통한 전체출력
					System.out.printf("%-15s%-20s%s\n", user.getUserName(), user.getUserId(), user.getUserPw());
				}
			} else if(str.equals("4")) {
				boardDao.insertTestBoard();
			} else {
				System.out.println("user name");
				scanner = new Scanner(System.in);
				String userName = scanner.next();
				User new_user = new User();

				System.out.println("user id");
				scanner = new Scanner(System.in);
				String userId = scanner.next();

				System.out.println("user pwd");
				scanner = new Scanner(System.in);
				String userPw = scanner.next();
				
				User newUser = new User();
				newUser.setUserInfo(userName, userId, userPw);
				
				userService.userRegister(newUser);
			}
			
		}
		ctx.close();
	}
}
