package com.TicketSystem.controller;

import java.util.List;

import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;
import com.TicketSystem.entity.User;
import com.TicketSystem.service.MovieService;
import com.TicketSystem.service.SessionService;
import com.TicketSystem.service.impl.MovieServiceImpl;
import com.TicketSystem.service.impl.SessionServiceImpl;
import com.TicketSystem.view.MainView;
import com.TicketSystem.view.SessionView;

public class SessionController {
	private MovieService movieService;
	private SessionService sessionService;
	public SessionController() {
		movieService = new MovieServiceImpl();
		sessionService = new SessionServiceImpl();
	}
	/**
	 * 通过电影ID查询电影对应的场次
	 * @param order
	 * @param user
	 */
	public void findSessionByMovieId(int id, User user) {
//		验证用户输入的电影ID
		Movie movie = movieService.findRecentMovieById(id);
//		根据ID查询近期电影场次
		if(movie == null || movie.getId() == null) {
			String error = "没有您要查询到的电影";
			MainView.show(user,error);
			return;
		}
		List<Session> sessions = sessionService.findSessionByMOvieId(movie);
//		跳转到对应的页面
		SessionView.show(sessions,user);
	}
}
