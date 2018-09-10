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
//		调用Service查询近期的热门电影
		List<Movie> movies = moviceService.findRecentMovice();
//		将查询到的结果展示到界面上
		if(movies == null || movies.size()==0) {
			String error = "没有您查询要查看的电影";
			MainView.show(user,error);
		}
		MovieView.show(movies,user);
	}

}
