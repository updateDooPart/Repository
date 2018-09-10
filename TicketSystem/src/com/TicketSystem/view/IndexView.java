package com.TicketSystem.view;

import java.util.Scanner;

/**
 * 首页
 */
public class IndexView {
	
	public static void show(){
		System.out.println("**********************");
		System.out.println("* 欢迎使用影票订购系统  *");
		System.out.println("**********************");
		System.out.println("请选择要进行的操作：");
		System.out.println("登录请选择：1");
		System.out.println("注册请选择：2");
		Scanner sc = new Scanner(System.in);
		int login=sc.nextInt();
		switch (login) {
		case 1:
			LoginView.show(); 
			break;
		case 2:
			RegisterView.show();
			break;
		default:
			System.err.println("输入指令不正确，请您从新输入");
		}
	}
}

