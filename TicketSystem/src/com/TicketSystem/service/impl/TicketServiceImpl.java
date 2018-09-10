package com.TicketSystem.service.impl;

import com.TicketSystem.dao.SessionDao;
import com.TicketSystem.dao.TicketDao;
import com.TicketSystem.dao.UserDao;
import com.TicketSystem.dao.Impl.SessionDaoImpl;
import com.TicketSystem.dao.Impl.UserDaoImpl;
import com.TicketSystem.dao.Impl.ticketDaoImpl;
import com.TicketSystem.entity.Session;
import com.TicketSystem.entity.Ticket;
import com.TicketSystem.entity.User;
import com.TicketSystem.service.TicketService;

public class TicketServiceImpl implements TicketService {
	private UserDao userDao;
	private SessionDao sessionDao;
	private TicketDao ticketDao;
	public TicketServiceImpl() {
		userDao = new UserDaoImpl();
		sessionDao = new SessionDaoImpl();
		ticketDao = new ticketDaoImpl();
	}
	/**
	 * 买票业务的实现类
	 */
	@Override
	public Ticket save(Session session, User user) {
//		验证
//			剩余票量是否足够
		if(session.getRemain() <= 0) {
			return null;
		}
//			用户余额是否足够
//		user = userDao.findById(user.getId());
		user = userDao.findUserByName(user.getName());
		if(user.getBalance() < session.getPrice()) {
			return null;
		}
//		操作
//			票量减少
		session.setRemain(session.getRemain()-1);
		int res = sessionDao.upate(session);
		if(res < 1) {
			return null;
		}
//			用户余额减少
		user.setBalance(user.getBalance()-session.getPrice());
		res = userDao.update(user);
		if(res < 1) {
			return null;
		}
//			生成对应订单
		Ticket ticket = new Ticket();
		ticket.setId(ticketDao.getNestId());
		ticket.setSeat(1);
		ticket.setSeid(session.getId());
		ticket.setSession(session);
		ticket.setUser(user);
		ticket.setUsid(user.getId());
		ticketDao.save(ticket);
//		返回结果
		return ticket;
	}

}
