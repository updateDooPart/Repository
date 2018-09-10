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
	 * ͨ����ӰID��ѯ��Ӱ��Ӧ�ĳ���
	 * @param order
	 * @param user
	 */
	public void findSessionByMovieId(int id, User user) {
//		��֤�û�����ĵ�ӰID
		Movie movie = movieService.findRecentMovieById(id);
//		����ID��ѯ���ڵ�Ӱ����
		if(movie == null || movie.getId() == null) {
			String error = "û����Ҫ��ѯ���ĵ�Ӱ";
			MainView.show(user,error);
			return;
		}
		List<Session> sessions = sessionService.findSessionByMOvieId(movie);
//		��ת����Ӧ��ҳ��
		SessionView.show(sessions,user);
	}
}
