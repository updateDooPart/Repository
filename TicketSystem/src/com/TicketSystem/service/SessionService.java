package com.TicketSystem.service;

import java.util.List;

import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;

/**
 *����Session�����ҵ��
 */
public interface SessionService {
	/**
	 * ͨ�����ε�ID��ѯ����
	 * @param movie 
	 * @return
	 */
	List<Session> findSessionByMOvieId(Movie movie);

	Session findSessionById(int id);

}
