package com.TicketSystem.service.impl;

import java.util.List;

import com.TicketSystem.dao.MovieDao;
import com.TicketSystem.dao.Impl.MovieDaoImpl;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.service.MovieService;
/**
 * 负责Movie业务的实现方法
 * @author zomg
 *
 */
public class MovieServiceImpl implements MovieService {
	private MovieDao movieDao;
	public MovieServiceImpl() {
		movieDao = new MovieDaoImpl();
	}
	/**
	 * 查询近期热播的电影
	 * @return
	 */
	@Override
	public List<Movie> findRecentMovice() {
		return movieDao.findRecentMovie();
	}
	@Override
	public Movie findRecentMovieById(int id) {
		return movieDao.findRecentMovieById(id);
	}

}
