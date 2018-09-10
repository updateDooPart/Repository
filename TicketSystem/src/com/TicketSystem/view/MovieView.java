package com.TicketSystem.view;

import java.util.List;
import java.util.Scanner;

import com.TicketSystem.controller.SessionController;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.User;

public class MovieView {

	public static void show(List<Movie> movies, User user) {
		System.out.println("ID\t\t电影名称\t\t\t\t电影时长\t\t电影类型\t\t电影简介");
		for (Movie movie : movies) {
			System.out.println(movie.getId()+"\t\t"+
					movie.getName()+"\t\t"+
					movie.getDuration()+"\t\t"+
					movie.getType()+"\t\t"+
					movie.getDetail().substring(0, 20)+"..."
					);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("请您选择要观看的电影ID");
		int order=sc.nextInt();
//		使用sessionController查询近期电影场次
		SessionController sessionController = 
				new SessionController();
		sessionController.findSessionByMovieId(order,user);
	}

}
