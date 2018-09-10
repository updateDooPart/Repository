package com.TicketSystem.entity;

/**
 *	影厅表
 */
public class Hall {
	private Long id;//影厅ID
	private String name;//影厅名称
	private Integer cid;//所属影院
	private Integer capacity;//影厅容量
	
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
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Hall(Long id, String name, Integer cid, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.cid = cid;
		this.capacity = capacity;
	}
	public Hall() {
		super();
	}
	@Override
	public String toString() {
		return "Hall [id=" + id + ", name=" + name + ", cid=" + cid + ", capacity=" + capacity + "]";
	}
}
