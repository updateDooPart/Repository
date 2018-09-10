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
 *负责Session的相关业务的实现方法
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
//		根据电影ID查询对应的场次
		List<Session> sessions = sessionDao.findSessionByMovieId(movie.getId());
//		补全场次中的电影、场厅、影院信息 
		for (Session session : sessions) {
			session.setMovie(movie);
			session.setHall(hallDao.findById(session.getHid()));
			session.setCinema(cinemaDao.findById(session.getCid()));
		}
		return sessions;
	}
	@Override
	public Session findSessionById(int id) {
//		根据场次ID查询对应的场次
		Session session = sessionDao.findSessionById(id);
//		补全场次中的电影、场厅、影院信息 
		session.setMovie(movieDao.findRecentMovieById(id));
		session.setHall(hallDao.findById(session.getHid()));
		session.setCinema(cinemaDao.findById(session.getCid()));
		return session;
	}

}
