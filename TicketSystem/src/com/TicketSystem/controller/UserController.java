package com.TicketSystem.controller;

import com.TicketSystem.entity.User;
import com.TicketSystem.service.UserService;
import com.TicketSystem.service.impl.UserServiceImpl;
import com.TicketSystem.view.AdminView;
import com.TicketSystem.view.LoginView;
import com.TicketSystem.view.MainView;
import com.TicketSystem.view.RegisterView;
/**
 *处理用户相关请求的控制器
 */
public class UserController {
	private UserService userService;
	public UserController() {
		userService = new UserServiceImpl();
	} 
	/**
	 *处理用户登录请求的方法 
	 */
	public void doLogin(User user) {
//		使用service方法对用户进行查询
		User temp = userService.findUserByNameAndPassword(user);
//		判断是否是用户登录
//			如果是用户登录则跳转用户页面
		if(temp != null
				&&temp.getId() != null
				&& !"admin".equals(temp.getName())) {
			MainView.show(user);
		}else if(temp != null
				&&temp.getId() != null
				&& "admin".equals(temp.getName())) {
//			如果是管理员登录则跳转管理员页面
			AdminView.show(user);
		}else {
//		         判断用户名和密码错误则跳转到登录页面
			String error = "用户名或密码错误，请您从新登录";
			LoginView.show(error);
		}
			
	}
	/**
	 * 比对用户名是否重复
	 * @param name
	 * @return
	 */
	public boolean existing(String name) {
		User user = userService.findUserByName(name);
		if(user == null || user.getId() == null) {
			return false;
		}
		return true;
	}
	/**
	 * 注册用户
	 * @param user 
	 */
	public void doRegister(User user) {
//		完成注册业务
		User  temp  = userService.save(user);
//		根据注册情况，返回不同的界面
		if(temp == null || temp.getId()== null) {
			String error = "系统故障，请稍后再试";
			RegisterView.show(error);
		}else {
			MainView.show(temp);
		}
	}
	
}
