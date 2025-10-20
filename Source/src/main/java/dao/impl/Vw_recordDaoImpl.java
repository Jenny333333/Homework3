package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.Vw_recordDao;
import model.Vw_record;
import util.DbConnection;

public class Vw_recordDaoImpl implements Vw_recordDao{

	public static void main(String[] args) {
		System.out.println(new Vw_recordDaoImpl().selectByPlayer("hope"));
	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public List<Vw_record> selectAll() {
		String Sql="select * from vw_record";
		List<Vw_record> list=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Vw_record vw=new Vw_record();
				vw.setId(rs.getInt("id"));
				vw.setPlayer(rs.getString("player"));
				vw.setGame(rs.getString("game"));
				vw.setLevel(rs.getString("level"));
				vw.setStar(rs.getInt("star"));
				 LocalDateTime start = rs.getTimestamp("startTime").toLocalDateTime();
		         LocalDateTime end = rs.getTimestamp("endTime").toLocalDateTime();
		         vw.setStartTime(start);
		         vw.setEndTime(end);
				 vw.setDuration(rs.getInt("duration"));
				 list.add(vw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Vw_record> selectByPlayer(String Player) {
		String Sql="select * from vw_record where player=?";
		List<Vw_record> list=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, Player);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Vw_record vw=new Vw_record();
				vw.setId(rs.getInt("id"));
				vw.setPlayer(rs.getString("player"));
				vw.setGame(rs.getString("game"));
				vw.setLevel(rs.getString("level"));
				vw.setStar(rs.getInt("star"));
				 LocalDateTime start = rs.getTimestamp("startTime").toLocalDateTime();
		         LocalDateTime end = rs.getTimestamp("endTime").toLocalDateTime();
		         vw.setStartTime(start);
		         vw.setEndTime(end);
				 vw.setDuration(rs.getInt("duration"));
				 list.add(vw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
