package com.TicketSystem.view;

import java.util.Scanner;

import com.TicketSystem.controller.UserController;
import com.TicketSystem.entity.User;

/**
 * 注册
 */
public class RegisterView {
	/**
	 * 填写用户个人身份信息，并验证
	 */
	public static void show() {
		
		Scanner sc = new Scanner(System.in);
//		请输入用户名
		System.out.println("请输入用户名:");
		String name = sc.next();
//		验证用户名是否存在用户表里
		UserController userController = 
				new UserController();
		while(userController.existing(name)) {
//			若重复请重新输入用户名
			System.out.println("用户名已存在，请重新输入：");
			name = sc.next();
			}
//		请输入密码
		System.out.println("请输入密码:（6-12个字符）");
		String passWord = sc.next();
		while(passWord.length()<6||passWord.length()>12) {
			 System.out.println("请重新输入密码:（6-12个字符）");
			 passWord = sc.next();
		 }
//		确认密码
		System.out.println("请输入确认密码：6-12个字符");
		String rePassWord = sc.next();
		while(!passWord.equals(rePassWord)) {
			System.out.println("两次密码输入不一致，请重新输入密码：");
			System.out.println("请输入密码：6-12个字符");
			passWord = sc.next();
			while(passWord.length()<6||passWord.length()>12) {
				 System.out.println("请重新输入密码:（6-12个字符）");
				 passWord = sc.next();
			 }
			System.out.println("请输入确认密码：");
			rePassWord =sc.next();
		}
//		充值金额
		System.out.println("请输入充值金额：");
		double balance = sc.nextDouble();
//		分装到user对象
		User user=new User(null, name, passWord, null, balance);
//		提交到对应的UserController
		userController.doRegister(user);
	}
	/**
	 * 
	 * @param error
	 */
	public static void show(String error) {
		System.out.println(error);
		show();
	}
}
