package com.TicketSystem.dao;

import com.TicketSystem.entity.User;

public interface UserDao {
	/**
	 * �����û��������û���Ϣ
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	/**
	 * �����û�ID
	 * @return
	 */
	Long getNextId();
	/**
	 *���û����������Ϣ 
	 */
	int save(User user);
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 */
	User findById(Long id);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 */
	int update(User user);
	
}
