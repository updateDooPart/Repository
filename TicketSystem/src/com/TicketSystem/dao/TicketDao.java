package com.TicketSystem.dao;

import com.TicketSystem.entity.Ticket;

public interface TicketDao {
	/**
	 * ����ID
	 * @return
	 */
	public Long getNestId();
	/**
	 * ���ticket��Ϣ
	 * @param ticket
	 */
	public int save(Ticket ticket);

}
