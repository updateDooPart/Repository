package com.TicketSystem.service;

import com.TicketSystem.entity.User;

public interface UserService {
	/**
	 * �����¼ҵ��
	 * @param user
	 * @return
	 */
	User findUserByNameAndPassword(User user);
	/**
	 * ��ѯ�û����Ƿ����
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	/**
	 * ע���û���ҵ��
	 * @param user
	 * @return
	 */
	User save(User user);
}
