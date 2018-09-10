package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.TicketSystem.dao.SessionDao;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.Session;
import com.TicketSystem.util.DButil;
/**
 * 负责Session的数据库的实现方法
 */
public class SessionDaoImpl implements SessionDao {
	/**
	 * 根据数据库的session表中的电影ID进行查询
	 */
	@Override
	public List<Session> findSessionByMovieId(Long id) {
		List<Session> sessions = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select id,hid,cid,mid,time,price,remain "
					+ "from t_session "
					+ "where mid=? "
					+ "and time > sysdate() "
					+ "order by time ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Session session = new Session();
				session.setCid(rs.getLong("cid"));
				session.setHid(rs.getLong("hid"));
				session.setId(rs.getLong("id"));
				session.setMid(rs.getLong("mid"));
				session.setPrice(rs.getDouble("price"));
				session.setRemain(rs.getInt("remain"));
				Date time = new Date(rs.getTimestamp("time").getTime());
				session.setTime(time);
				sessions.add(session);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return sessions;
	}

	@Override
	public Session findSessionById(int id) {
		Session session = new Session();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select id,hid,cid,mid,time,price,remain "
					+ "from t_session "
					+ "where id=? "
					+ "and time > sysdate()";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				session.setCid(rs.getLong("cid"));
				session.setHid(rs.getLong("hid"));
				session.setId(rs.getLong("id"));
				session.setMid(rs.getLong("mid"));
				session.setPrice(rs.getDouble("price"));
				session.setRemain(rs.getInt("remain"));
				Date time = new Date(rs.getTimestamp("time").getTime());
				session.setTime(time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return session;
	}

	@Override
	public int upate(Session session) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DButil.getConn();
			String sql = "update t_session set hid=?,"
					+ "cid=?,mid=?,time=?,price=?,remain=? "
					+ "where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, session.getHid());
			pstmt.setLong(2, session.getCid());
			pstmt.setLong(3, session.getMid());
			pstmt.setTimestamp(4, new Timestamp(session.getTime().getTime()));;
			pstmt.setDouble(5, session.getPrice());
			pstmt.setInt(6, session.getRemain());
			pstmt.setLong(7, session.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, null);
		}
		return -1;
	}

}
