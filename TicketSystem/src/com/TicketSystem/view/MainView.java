package com.TicketSystem.view;

import java.util.Scanner;

import com.TicketSystem.controller.MovieConntroller;
import com.TicketSystem.entity.User;
/**
 *��ҳ��
 */
public class MainView {
	/**
	 * ���е�Ӱ��ѯ
	 * @param user
	 */
	public static void show(User user) {
		System.out.println("��ӭ�㣺"+user.getName());
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ����Ҫ���еĲ���");
		System.out.println("1���鿴����Ȳ��ĵ�Ӱ��");
		int order = sc.nextInt();
		MovieConntroller movieConntroller = 
				new MovieConntroller();
		switch (order) {
		case 1:
//			����movieConntroller�ķ�����ѯ���ڵ�Ӱ��Ϣ
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
