package com.TicketSystem.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TicketSystem.dao.MovieDao;
import com.TicketSystem.entity.Movie;
import com.TicketSystem.entity.User;
import com.TicketSystem.util.DButil;
/**
 *	负责movie的数据库操作
 */
public class MovieDaoImpl implements MovieDao {
	/**
	 * 查询近期热播电影的数据库操作
	 */
	@Override
	public List<Movie> findRecentMovie() {
		List<Movie> movies = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select distinct m.id,m.name,m.detail,m.duration,m.type "
					+ "from t_movie m join t_session s "
					+ "on m.id = s.mid "
					+ "where s.time > sysdate()";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setDetail(rs.getString("detail"));
				movie.setDuration(rs.getInt("duration"));
				movie.setId(rs.getLong("id"));
				movie.setName(rs.getString("name"));
				movie.setType(rs.getString("type"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return movies;
	}

	@Override
	public Movie findRecentMovieById(int id) {
		Movie movie = new Movie();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConn();
			String sql = "select distinct m.id,m.name,m.detail,m.duration,m.type "
					+ "from t_movie m join t_session s "
					+ "on m.id = s.mid "
					+ "where s.time > sysdate() "
					+ "and m.id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				movie.setDetail(rs.getString("detail"));
				movie.setDuration(rs.getInt("duration"));
				movie.setId(rs.getLong("id"));
				movie.setName(rs.getString("name"));
				movie.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.colse(conn, pstmt, rs);
		}
		return movie;
	}

}
