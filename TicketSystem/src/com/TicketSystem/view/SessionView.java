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
		System.out.println("电影编号"+movie.getId());
		System.out.println("电影名称"+movie.getName());
		System.out.println("电影时长"+movie.getDuration()+"分钟");
		System.out.println("电影类型"+movie.getType());
		System.out.println("电影简介"+movie.getDetail());
		System.out.println("ID\t\t放映时长\t\t\t\t所在影院\t\t\t\t放映厅\t\t售价\t\t剩余座位数\t\t影院地址");
		DateFormat format=new SimpleDateFormat("yyyy年MM月dd hh:mm:ss");
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
		System.out.println("请输入您要查看的场次ID");
		int id = sc.nextInt();
//		调用对应的Controller完场购票
		TicketController ticketController = 
				new TicketController();
		ticketController.doBuy(id,user);
	}
}





