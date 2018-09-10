package com.TicketSystem.view;

import java.util.Scanner;

import com.TicketSystem.controller.UserController;
import com.TicketSystem.entity.User;

/**
 * ע��
 */
public class RegisterView {
	/**
	 * ��д�û����������Ϣ������֤
	 */
	public static void show() {
		
		Scanner sc = new Scanner(System.in);
//		�������û���
		System.out.println("�������û���:");
		String name = sc.next();
//		��֤�û����Ƿ�����û�����
		UserController userController = 
				new UserController();
		while(userController.existing(name)) {
//			���ظ������������û���
			System.out.println("�û����Ѵ��ڣ����������룺");
			name = sc.next();
			}
//		����������
		System.out.println("����������:��6-12���ַ���");
		String passWord = sc.next();
		while(passWord.length()<6||passWord.length()>12) {
			 System.out.println("��������������:��6-12���ַ���");
			 passWord = sc.next();
		 }
//		ȷ������
		System.out.println("������ȷ�����룺6-12���ַ�");
		String rePassWord = sc.next();
		while(!passWord.equals(rePassWord)) {
			System.out.println("�����������벻һ�£��������������룺");
			System.out.println("���������룺6-12���ַ�");
			passWord = sc.next();
			while(passWord.length()<6||passWord.length()>12) {
				 System.out.println("��������������:��6-12���ַ���");
				 passWord = sc.next();
			 }
			System.out.println("������ȷ�����룺");
			rePassWord =sc.next();
		}
//		��ֵ���
		System.out.println("�������ֵ��");
		double balance = sc.nextDouble();
//		��װ��user����
		User user=new User(null, name, passWord, null, balance);
//		�ύ����Ӧ��UserController
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
