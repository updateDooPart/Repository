package com.TicketSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	/**
	 * Driver：MySQL数据库驱动
	 * Url：MySQL中的ticket_system数据库路径
	 * UserName：MySQL账号
	 * Password：MySQL密码
	 */
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/ticket_system";
	private static final String UserName="root";
	private static final String Password="mysql";
	/**
	 * 连接数据库
	 * @throws SQLException 
	 */
	public static Connection getConn(){
		Connection conn =null;
			try {
				//加载MySQL数据库驱动
				Class.forName(Driver);
				//连接到MySQL数据库
			    conn = DriverManager.getConnection(Url, UserName, Password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return conn;
	}
	/**
	 * 关闭数据库连接
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
