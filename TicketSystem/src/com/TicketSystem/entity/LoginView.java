package com.TicketSystem.entity;

import java.util.Scanner;

import com.TicketSystem.controller.UserController;
import com.TicketSystem.entity.User;

/**
 * ��¼
 */
public class LoginView {

	public static void show() {
		//�����û���������
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������˺ţ�");
		String name = sc.next();
		System.out.println("�������������룺");
		String password = sc.next();
		//ʵ����User,ʹ��user��������ȡ�û���������
		User user = new User(null, name, password, null, null);
		//ʵ����UserController�����������õ�¼������ȡuser����
		UserController userController=
				new UserController();
		userController.doLogin(user);
	}

	public static void show(String error) {
		System.out.println(error);
		show();
	}
}
