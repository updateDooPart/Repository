package com.TicketSystem.view;

import java.util.Scanner;

/**
 * ��ҳ
 */
public class IndexView {
	
	public static void show(){
		System.out.println("**********************");
		System.out.println("* ��ӭʹ��ӰƱ����ϵͳ  *");
		System.out.println("**********************");
		System.out.println("��ѡ��Ҫ���еĲ�����");
		System.out.println("��¼��ѡ��1");
		System.out.println("ע����ѡ��2");
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
			System.err.println("����ָ���ȷ��������������");
		}
	}
}

