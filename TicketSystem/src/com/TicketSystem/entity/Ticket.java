package com.TicketSystem.entity;
/**
 *	ӰƱ��
 */
public class Ticket {
	private Long id;//ӰƱID
	private Long usid;//�����û�
	private Long seid;//����
	private Integer seat;//��λ��
	private User user;//�����û���
	private Session session;//�������α�
	
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
