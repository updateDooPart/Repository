package com.TicketSystem.service.impl;

import java.util.List;

import com.TicketSystem.dao.MovieDao;
import com.TicketSystem.dao.Impl.MovieDaoImpl;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.service.MovieService;
/**
 * ����Movieҵ���ʵ�ַ���
 * @author zomg
 *
 */
public class MovieServiceImpl implements MovieService {
	private MovieDao movieDao;
	public MovieServiceImpl() {
		movieDao = new MovieDaoImpl();
	}
	/**
	 * ��ѯ�����Ȳ��ĵ�Ӱ
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
