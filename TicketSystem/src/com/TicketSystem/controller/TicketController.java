package com.TicketSystem.controller;

import com.TicketSystem.entity.Session;
import com.TicketSystem.entity.Ticket;
import com.TicketSystem.entity.User;
import com.TicketSystem.service.SessionService;
import com.TicketSystem.service.TicketService;
import com.TicketSystem.service.impl.SessionServiceImpl;
import com.TicketSystem.service.impl.TicketServiceImpl;
import com.TicketSystem.view.MainView;

public class TicketController {
	private SessionService sessionService;
	private TicketService ticketService;
	public TicketController() {
		sessionService = new SessionServiceImpl();
		ticketService = new TicketServiceImpl();
	}
	public void doBuy(int id, User user) {
//		检查场次是否合理
		Session session = sessionService.findSessionById(id);
		if(session == null || session.getId() == null) {
			String error = "没有您要查看的场次";
			MainView.show(user, error);
			return;
		}
//		购买影票
		Ticket ticket=ticketService.save(session,user);
//		根据购买结果返回不同界面
		if(ticket == null || ticket.getId() == null) {
			String error = "购买失败";
			MainView.show(user, error);
		}else {
			String error = "购买成功";
			MainView.show(user, error);
		}
	}
}
