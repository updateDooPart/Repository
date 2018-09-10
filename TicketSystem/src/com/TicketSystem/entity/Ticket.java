package com.TicketSystem.entity;
/**
 *	影票表
 */
public class Ticket {
	private Long id;//影票ID
	private Long usid;//所属用户
	private Long seid;//场次
	private Integer seat;//座位号
	private User user;//关联用户表
	private Session session;//关联场次表
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUsid() {
		return usid;
	}
	public void setUsid(Long usid) {
		this.usid = usid;
	}
	public Long getSeid() {
		return seid;
	}
	public void setSeid(Long seid) {
		this.seid = seid;
	}
	public Integer getSeat() {
		return seat;
	}
	public void setSeat(Integer seat) {
		this.seat = seat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
