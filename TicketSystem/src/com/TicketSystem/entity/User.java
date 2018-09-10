package com.TicketSystem.entity;

/**
 *	�û���
 */
public class User {
	private Long id;//�û�ID
	private String name;//�û�����
	private String password;//�û�����
	private Integer lvl;//�û��ȼ�
	private Double balance;//�û����
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public User(Long id, String name, String password, Integer lvl, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.lvl = lvl;
		this.balance = balance;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", lvl=" + lvl + ", balance=" + balance
				+ "]";
	}
}
