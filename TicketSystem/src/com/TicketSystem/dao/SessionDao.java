package com.TicketSystem.dao;

import java.util.List;

import com.TicketSystem.entity.Session;
/**
 * ����Session�����ݿ�Ĳ���CRUD
 */
public interface SessionDao {
	/**
	 * �������ݿ��session���еĵ�ӰID���в�ѯ
	 */
	List<Session> findSessionByMovieId(Long id);
	/**
	 * ͨ������ID��ѯ����
	 * @param id
	 * @return
	 */
	Session findSessionById(int id);
	/**
	 * ���³�����Ϣ
	 * @param session
	 */
	int upate(Session session);
}
