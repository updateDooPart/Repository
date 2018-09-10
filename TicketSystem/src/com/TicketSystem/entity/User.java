package com.TicketSystem.entity;

/**
 *	用户表
 */
public class User {
	private Long id;//用户ID
	private String name;//用户姓名
	private String password;//用户密码
	private Integer lvl;//用户等级
	private Double balance;//用户余额
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
