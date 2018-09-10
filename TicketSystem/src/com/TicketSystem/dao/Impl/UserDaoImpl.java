package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.TicketSystem.dao.UserDao;
import com.TicketSystem.entity.User;
import com.TicketSystem.util.DButil;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByName(String name) {
//		实例化User对象
		User user = new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			String sql = "select id,name,password,lvl,balance from t_user " + 
					"WHERE name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setBalance(rs.getDouble("balance"));
				user.setId(rs.getLong("id"));
				user.setLvl(rs.getInt("lvl"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return user;
	}
	/**
	 * 此方法使用Oracle中的序列ID自增添加
	 */
	@Override
	public Long getNextId() {
		Long id=0L;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			String sql = "select LAST_INSERT_ID() ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return id;
	}
	@Override
	public int save(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DButil.getConn();
			String sql = "insert into t_user(id,name,password,lvl,balance) "
					+ " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());;
			pstmt.setInt(4, user.getLvl());
			pstmt.setDouble(5, user.getBalance());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt,null);
		}
		return -1;
	}
	@Override
	public User findById(Long id) {
		User user = new User();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			String sql = "select id,name,password,lvl,balance "
						+ "from t_user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setBalance(rs.getDouble("balance"));
				user.setId(rs.getLong("id"));
				user.setLvl(rs.getInt("lvl"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return user;
	}
	@Override
	public int update(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DButil.getConn();
			String sql = "update t_user set name=?,"
						+ "password=?,lvl=?,balance=? "
						+ "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());;
			pstmt.setInt(3, user.getLvl());
			pstmt.setDouble(4, user.getBalance());
			pstmt.setLong(5, user.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, null);
		}
		return -1;
	}

}