package com.TicketSystem.dao;

import com.TicketSystem.entity.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户信息
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
	/**
	 * 生成用户ID
	 * @return
	 */
	Long getNextId();
	/**
	 *向用户表中添加信息 
	 */
	int save(User user);
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	User findById(Long id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
	
}
