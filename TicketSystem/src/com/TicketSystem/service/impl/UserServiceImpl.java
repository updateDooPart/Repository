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
//		1�������û�����ѯ�����Ƿ����
		User temp = userDao.findUserByName(user.getName());
//		2���ȶ��û�����
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
//		�����û�ID
		user.setId(userDao.getNextId());
//		�����û��ȼ�
		user.setLvl(1);
//		�����ݿ�������û���Ϣ
		int res=userDao.save(user);
		if(res < 1) {
			return null;
		}
//		���ؽ��
		return user;
	}
}
