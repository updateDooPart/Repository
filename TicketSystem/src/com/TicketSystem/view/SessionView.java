package com.TicketSystem.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.TicketSystem.controller.TicketController;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;
import com.TicketSystem.entity.User;

public class SessionView {

	public static void show(List<Session> sessions, User user) {
		Movie movie=sessions.get(0).getMovie();
		System.out.println("��Ӱ���"+movie.getId());
		System.out.println("��Ӱ����"+movie.getName());
		System.out.println("��Ӱʱ��"+movie.getDuration()+"����");
		System.out.println("��Ӱ����"+movie.getType());
		System.out.println("��Ӱ���"+movie.getDetail());
		System.out.println("ID\t\t��ӳʱ��\t\t\t\t����ӰԺ\t\t\t\t��ӳ��\t\t�ۼ�\t\tʣ����λ��\t\tӰԺ��ַ");
		DateFormat format=new SimpleDateFormat("yyyy��MM��dd hh:mm:ss");
		for (Session session : sessions) {
			System.out.println(session.getId()+"\t\t"+
					format.format(session.getTime())+"\t\t"+
								session.getCinema().getName()+"\t\t"+
								session.getHall().getName()+"\t\t"+
								session.getPrice()+"\t\t"+
								session.getRemain()+"\t\t"+
								session.getCinema().getAddress()
								);
		}
		Scanner sc =new Scanner(System.in);
		System.out.println("��������Ҫ�鿴�ĳ���ID");
		int id = sc.nextInt();
//		���ö�Ӧ��Controller�곡��Ʊ
		TicketController ticketController = 
				new TicketController();
		ticketController.doBuy(id,user);
	}
}





