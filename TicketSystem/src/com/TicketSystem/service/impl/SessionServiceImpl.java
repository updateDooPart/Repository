package com.TicketSystem.service.impl;

import java.util.List;

import com.TicketSystem.dao.CinemaDao;
import com.TicketSystem.dao.HallDao;
import com.TicketSystem.dao.MovieDao;
import com.TicketSystem.dao.SessionDao;
import com.TicketSystem.dao.Impl.CinemaDaoImpl;
import com.TicketSystem.dao.Impl.HallDaoImpl;
import com.TicketSystem.dao.Impl.MovieDaoImpl;
import com.TicketSystem.dao.Impl.SessionDaoImpl;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;
import com.TicketSystem.service.SessionService;
/**
 *����Session�����ҵ���ʵ�ַ���
 */
public class SessionServiceImpl implements SessionService {
	private SessionDao sessionDao;
	private HallDao hallDao;
	private CinemaDao cinemaDao;
	private MovieDao movieDao;
	public SessionServiceImpl() {
		sessionDao = new SessionDaoImpl();
		hallDao = new HallDaoImpl();
		cinemaDao = new CinemaDaoImpl();
		movieDao = new MovieDaoImpl();
	}
	@Override
	public List<Session> findSessionByMOvieId(Movie movie) {
//		���ݵ�ӰID��ѯ��Ӧ�ĳ���
		List<Session> sessions = sessionDao.findSessionByMovieId(movie.getId());
//		��ȫ�����еĵ�Ӱ��������ӰԺ��Ϣ 
		for (Session session : sessions) {
			session.setMovie(movie);
			session.setHall(hallDao.findById(session.getHid()));
			session.setCinema(cinemaDao.findById(session.getCid()));
		}
		return sessions;
	}
	@Override
	public Session findSessionById(int id) {
//		���ݳ���ID��ѯ��Ӧ�ĳ���
		Session session = sessionDao.findSessionById(id);
//		��ȫ�����еĵ�Ӱ��������ӰԺ��Ϣ 
		session.setMovie(movieDao.findRecentMovieById(id));
		session.setHall(hallDao.findById(session.getHid()));
		session.setCinema(cinemaDao.findById(session.getCid()));
		return session;
	}

}
