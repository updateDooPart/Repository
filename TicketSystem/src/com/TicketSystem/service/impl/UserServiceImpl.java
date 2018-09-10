package com.TicketSystem.service.impl;

import com.TicketSystem.dao.UserDao;
import com.TicketSystem.dao.Impl.UserDaoImpl;
import com.TicketSystem.entity.User;
import com.TicketSystem.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	@Override
	public User findUserByNameAndPassword(User user) {
//		1、根据用户名查询密码是否存在
		User temp = userDao.findUserByName(user.getName());
//		2、比对用户密码
		if(temp ==null ||temp.getId() == null) {
			return null;
		}
		if(!user.getPassword().equals(temp.getPassword())) {
			return null;
		}
		return temp;
	}
	@Override
	public User findUserByName(String name) {
		return userDao.findUserByName(name);
	}
	@Override
	public User save(User user) {
//		生成用户ID
		user.setId(userDao.getNextId());
//		计算用户等级
		user.setLvl(1);
//		向数据库中添加用户信息
		int res=userDao.save(user);
		if(res < 1) {
			return null;
		}
//		返回结果
		return user;
	}
}
