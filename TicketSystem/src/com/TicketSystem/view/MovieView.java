package com.TicketSystem.view;

import java.util.List;
import java.util.Scanner;

import com.TicketSystem.controller.SessionController;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.User;

public class MovieView {

	public static void show(List<Movie> movies, User user) {
		System.out.println("ID\t\t��Ӱ����\t\t\t\t��Ӱʱ��\t\t��Ӱ����\t\t��Ӱ���");
		for (Movie movie : movies) {
			System.out.println(movie.getId()+"\t\t"+
					movie.getName()+"\t\t"+
					movie.getDuration()+"\t\t"+
					movie.getType()+"\t\t"+
					movie.getDetail().substring(0, 20)+"..."
					);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("����ѡ��Ҫ�ۿ��ĵ�ӰID");
		int order=sc.nextInt();
//		ʹ��sessionController��ѯ���ڵ�Ӱ����
		SessionController sessionController = 
				new SessionController();
		sessionController.findSessionByMovieId(order,user);
	}

}
