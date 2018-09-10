package com.TicketSystem.controller;

import java.util.List;

import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.User;
import com.TicketSystem.service.MovieService;
import com.TicketSystem.service.impl.MovieServiceImpl;
import com.TicketSystem.view.MainView;
import com.TicketSystem.view.MovieView;
/**
 * 
 */
public class MovieConntroller {
	private MovieService moviceService;
	public MovieConntroller() {
		moviceService = new MovieServiceImpl();
	}
	/**
	 * 
	 * @param user
	 */
	public void showMovices(User user) {
//		����Service��ѯ���ڵ����ŵ�Ӱ
		List<Movie> movies = moviceService.findRecentMovice();
//		����ѯ���Ľ��չʾ��������
		if(movies == null || movies.size()==0) {
			String error = "û������ѯҪ�鿴�ĵ�Ӱ";
			MainView.show(user,error);
		}
		MovieView.show(movies,user);
	}

}
