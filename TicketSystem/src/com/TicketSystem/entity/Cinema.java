package com.TicketSystem.entity;

/**
 *	ӰԺ��
 */
public class Cinema {
	private Long id;//ӰԺID
	private String name;//ӰԺ����
	private String address;//ӰԺ��ַ
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Cinema(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Cinema() {
		super();
	}
	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
