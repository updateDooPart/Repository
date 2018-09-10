package com.TicketSystem.entity;

/**
 *	��Ӱ��
 */
public class Movie {
	private Long id;//��ӰID
	private String name;//��Ӱ����
	private String detail;//��Ӱ���
	private Integer duration;//��Ӱʱ��
	private String type;//��Ӱ���
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Movie(Long id, String name, String detail, Integer duration, String type) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.duration = duration;
		this.type = type;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", detail=" + detail + ", duration=" + duration + ", type=" + type
				+ "]";
	}
}
