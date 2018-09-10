package com.TicketSystem.service;

import java.util.List;

import com.TicketSystem.entity.Movie;
/**
 * 负责处理Movie相关的业务
 * @author zomg
 *
 */
public interface MovieService {
	/**
	 * 查询近期热播的电影
	 * @return
	 */
	List<Movie> findRecentMovice();
	/**
	 * 根据场次查询近期热门电影
	 * @param id
	 * @return
	 */
	Movie findRecentMovieById(int id);

}
