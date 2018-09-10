package com.TicketSystem.view;

import java.util.Scanner;

import com.TicketSystem.controller.MovieConntroller;
import com.TicketSystem.entity.User;
/**
 *主页面
 */
public class MainView {
	/**
	 * 进行电影查询
	 * @param user
	 */
	public static void show(User user) {
		System.out.println("欢迎你："+user.getName());
		Scanner sc = new Scanner(System.in);
		System.out.println("请选择您要进行的操作");
		System.out.println("1、查看最近热播的电影：");
		int order = sc.nextInt();
		MovieConntroller movieConntroller = 
				new MovieConntroller();
		switch (order) {
		case 1:
//			调用movieConntroller的方法查询近期电影信息
			movieConntroller.showMovices(user);
			break;
		default:
			break;
		}
	}

	public static void show(User user, String error) {
		System.out.println(error);
		show(user);
	}

}
