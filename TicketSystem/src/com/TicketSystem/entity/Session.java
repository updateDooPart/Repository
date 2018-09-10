package com.TicketSystem.entity;

import java.util.Date;

/**
 *	���α�
 */
public class Session {
	private Long id;//����ID
	private Long hid;//Ӱ��ID
	private Long cid;//ӰԺID
	private Long mid;//��ӰID
	private Date time;//����ʱ��
	private Double price;//���μ۸�
	private Integer remain;//ʣ����λ
	private Hall hall;//����Ӱ����
	private Cinema cinema;//����ӰԺ��
	private Movie movie;//������Ӱ��
	
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getHid() {
		return hid;
	}
	public void setHid(Long hid) {
		this.hid = hid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getRemain() {
		return remain;
	}
	public void setRemain(Integer remain) {
		this.remain = remain;
	}
	public Session(Long id, Long hid, Long cid, Long mid, Date time, Double price, Integer remain) {
		super();
		this.id = id;
		this.hid = hid;
		this.cid = cid;
		this.mid = mid;
		this.time = time;
		this.price = price;
		this.remain = remain;
	}
	public Session() {
		super();
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", hid=" + hid + ", cid=" + cid + ", mid=" + mid + ", time=" + time + ", price="
				+ price + ", remain=" + remain + "]";
	}
}
