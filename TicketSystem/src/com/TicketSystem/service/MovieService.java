package com.TicketSystem.service;

import java.util.List;

import com.TicketSystem.entity.Movie;
/**
 * ������Movie��ص�ҵ��
 * @author zomg
 *
 */
public interface MovieService {
	/**
	 * ��ѯ�����Ȳ��ĵ�Ӱ
	 * @return
	 */
	List<Movie> findRecentMovice();
	/**
	 * ���ݳ��β�ѯ�������ŵ�Ӱ
	 * @param id
	 * @return
	 */
	Movie findRecentMovieById(int id);

}
