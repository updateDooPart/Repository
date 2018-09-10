package com.TicketSystem.service;

import java.util.List;

import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;

/**
 *负责Session的相关业务
 */
public interface SessionService {
	/**
	 * 通过场次的ID查询场次
	 * @param movie 
	 * @return
	 */
	List<Session> findSessionByMOvieId(Movie movie);

	Session findSessionById(int id);

}
