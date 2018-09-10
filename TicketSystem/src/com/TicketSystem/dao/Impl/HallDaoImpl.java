package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.TicketSystem.dao.HallDao;
import com.TicketSystem.entity.Hall;
import com.TicketSystem.entity.Session;
import com.TicketSystem.util.DButil;

public class HallDaoImpl implements HallDao {

	@Override
	public Hall findById(Long hid) {
		Hall hall = new Hall();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select id,name,cid,capacity "
					+ "from t_hall "
					+ "where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, hid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hall.setCapacity(rs.getInt("capacity"));
				hall.setCid(rs.getInt("cid"));
				hall.setId(rs.getLong("id"));
				hall.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return hall;
	}

}
