package com.TicketSystem.controller;

import com.TicketSystem.entity.User;
import com.TicketSystem.service.UserService;
import com.TicketSystem.service.impl.UserServiceImpl;
import com.TicketSystem.view.AdminView;
import com.TicketSystem.view.LoginView;
import com.TicketSystem.view.MainView;
import com.TicketSystem.view.RegisterView;
/**
 *�����û��������Ŀ�����
 */
public class UserController {
	private UserService userService;
	public UserController() {
		userService = new UserServiceImpl();
	} 
	/**
	 *�����û���¼����ķ��� 
	 */
	public void doLogin(User user) {
//		ʹ��service�������û����в�ѯ
		User temp = userService.findUserByNameAndPassword(user);
//		�ж��Ƿ����û���¼
//			������û���¼����ת�û�ҳ��
		if(temp != null
				&&temp.getId() != null
				&& !"admin".equals(temp.getName())) {
			MainView.show(user);
		}else if(temp != null
				&&temp.getId() != null
				&& "admin".equals(temp.getName())) {
//			����ǹ���Ա��¼����ת����Աҳ��
			AdminView.show(user);
		}else {
//		         �ж��û����������������ת����¼ҳ��
			String error = "�û�������������������µ�¼";
			LoginView.show(error);
		}
			
	}
	/**
	 * �ȶ��û����Ƿ��ظ�
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
	 * ע���û�
	 * @param user 
	 */
	public void doRegister(User user) {
//		���ע��ҵ��
		User  temp  = userService.save(user);
//		����ע����������ز�ͬ�Ľ���
		if(temp == null || temp.getId()== null) {
			String error = "ϵͳ���ϣ����Ժ�����";
			RegisterView.show(error);
		}else {
			MainView.show(temp);
		}
	}
	
}
