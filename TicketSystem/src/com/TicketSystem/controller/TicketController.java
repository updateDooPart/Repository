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
//		��鳡���Ƿ����
		Session session = sessionService.findSessionById(id);
		if(session == null || session.getId() == null) {
			String error = "û����Ҫ�鿴�ĳ���";
			MainView.show(user, error);
			return;
		}
//		����ӰƱ
		Ticket ticket=ticketService.save(session,user);
//		���ݹ��������ز�ͬ����
		if(ticket == null || ticket.getId() == null) {
			String error = "����ʧ��";
			MainView.show(user, error);
		}else {
			String error = "����ɹ�";
			MainView.show(user, error);
		}
	}
}
