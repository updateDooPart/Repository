package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.TicketSystem.dao.TicketDao;
import com.TicketSystem.entity.Ticket;
import com.TicketSystem.util.DButil;

public class ticketDaoImpl implements TicketDao {

	@Override
	public Long getNestId() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return id;
	}

	@Override
	public int save(Ticket ticket) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DButil.getConn();
			String sql = "insert into t_ticket(id,usid,seid,seat) "
					+ " values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, ticket.getId());
			pstmt.setLong(2, ticket.getUsid());
			pstmt.setLong(3, ticket.getSeid());
			pstmt.setInt(4, ticket.getSeat());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt,null);
		}
		return -1;
	}

}
