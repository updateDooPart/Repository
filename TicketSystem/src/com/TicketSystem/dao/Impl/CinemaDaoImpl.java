package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.TicketSystem.dao.CinemaDao;
import com.TicketSystem.entity.Cinema;
import com.TicketSystem.entity.Hall;
import com.TicketSystem.util.DButil;

public class CinemaDaoImpl implements CinemaDao {

	@Override
	public Cinema findById(Long cid) {
		Cinema cinema = new Cinema();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select id,name,address "
					+ "from t_cinema "
					+ "where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cinema.setAddress(rs.getString("address"));
				cinema.setId(rs.getLong("id"));
				cinema.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return cinema;
	}

}
