package com.TicketSystem.service;

import com.TicketSystem.entity.Session;
import com.TicketSystem.entity.Ticket;
import com.TicketSystem.entity.User;

public interface TicketService {
	/**
	 * ��Ʊҵ��
	 * @param session
	 * @param user
	 * @return
	 */
	Ticket save(Session session, User user);

}
