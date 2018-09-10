package com.TicketSystem.dao;

import com.TicketSystem.entity.Ticket;

public interface TicketDao {
	/**
	 * 生成ID
	 * @return
	 */
	public Long getNestId();
	/**
	 * 添加ticket信息
	 * @param ticket
	 */
	public int save(Ticket ticket);

}
