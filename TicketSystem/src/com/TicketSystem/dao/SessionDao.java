package com.TicketSystem.dao;

import java.util.List;

import com.TicketSystem.entity.Session;
/**
 * 负责Session的数据库的操作CRUD
 */
public interface SessionDao {
	/**
	 * 根据数据库的session表中的电影ID进行查询
	 */
	List<Session> findSessionByMovieId(Long id);
	/**
	 * 通过场次ID查询场次
	 * @param id
	 * @return
	 */
	Session findSessionById(int id);
	/**
	 * 更新场次信息
	 * @param session
	 */
	int upate(Session session);
}
