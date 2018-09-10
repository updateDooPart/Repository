package com.TicketSystem.service;

import com.TicketSystem.entity.User;

public interface UserService {
	/**
	 * 负责登录业务
	 * @param user
	 * @return
	 */
	User findUserByNameAndPassword(User user);
	/**
	 * 查询用户名是否存在
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	/**
	 * 注册用户的业务
	 * @param user
	 * @return
	 */
	User save(User user);
}
