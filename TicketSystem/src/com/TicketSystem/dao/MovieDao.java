package com.TicketSystem.dao;

import java.util.List;

import com.TicketSystem.entity.Movie;
/**
 * ����movie���ݿ�����ķ���
 * @author zomg
 *
 */
public interface MovieDao {
	/**
	 * ��ѯ�����Ȳ���Ӱ
	 * @return
	 */
	public List<Movie> findRecentMovie();
	/**
	 * ��ѯ�����Ȳ���Ӱͨ��ID
	 * @return id
	 */
	public Movie findRecentMovieById(int id);

}
