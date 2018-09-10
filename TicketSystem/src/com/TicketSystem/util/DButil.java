package com.TicketSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	/**
	 * Driver��MySQL���ݿ�����
	 * Url��MySQL�е�ticket_system���ݿ�·��
	 * UserName��MySQL�˺�
	 * Password��MySQL����
	 */
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/ticket_system";
	private static final String UserName="root";
	private static final String Password="mysql";
	/**
	 * �������ݿ�
	 * @throws SQLException 
	 */
	public static Connection getConn(){
		Connection conn =null;
			try {
				//����MySQL���ݿ�����
				Class.forName(Driver);
				//���ӵ�MySQL���ݿ�
			    conn = DriverManager.getConnection(Url, UserName, Password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return conn;
	}
	/**
	 * �ر����ݿ�����
	 * @param conn
	 * @param psmt
	 * @param rs
	 */
	public static void colse(Connection conn,PreparedStatement psmt,ResultSet rs) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
