package com.TicketSystem.dao;

import java.util.List;

import com.TicketSystem.entity.Movie;
/**
 * 负责movie数据库操作的方法
 * @author zomg
 *
 */
public interface MovieDao {
	/**
	 * 查询近期热播电影
	 * @return
	 */
	public List<Movie> findRecentMovie();
	/**
	 * 查询近期热播电影通过ID
	 * @return id
	 */
	public Movie findRecentMovieById(int id);

}
