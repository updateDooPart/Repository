package com.TicketSystem.entity;

import java.util.Scanner;

import com.TicketSystem.controller.UserController;
import com.TicketSystem.entity.User;

/**
 * 登录
 */
public class LoginView {

	public static void show() {
		//输入用户名和密码
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的账号：");
		String name = sc.next();
		System.out.println("请输入您的密码：");
		String password = sc.next();
		//实例化User,使用user对象来获取用户名和密码
		User user = new User(null, name, password, null, null);
		//实例化UserController控制器，调用登录方法获取user对象
		UserController userController=
				new UserController();
		userController.doLogin(user);
	}

	public static void show(String error) {
		System.out.println(error);
		show();
	}
}
