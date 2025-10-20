package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.RecordDao;
import model.Record;
import util.DbConnection;

public class RecordDaoImpl implements RecordDao{

	public static void main(String[] args) {
		/*LocalDateTime start=LocalDateTime.of(2025, 3,23,11,23,07);
		LocalDateTime end=LocalDateTime.of(2025, 3,23,11,30,10);
		Record r=new Record(1,1,1,3,start,end);
		new RecordDaoImpl().insert(r);*/
				
		List<Record> record = new RecordDaoImpl().selectAll();
		record.forEach(System.out::println);
						
		/*Record r = new Record();
		r.setId(2);
		r.setUserid(2);
		r.setGameid(1);
		r.setLevelid(1);
		r.setStar(2);
		LocalDateTime start=LocalDateTime.of(2025, 3,2,8,15,07);
		LocalDateTime end=LocalDateTime.of(2025, 3,2,8,20,22);
		r.setStartTime(start);
		r.setEndTime(end);
		new RecordDaoImpl().update(r);*/
						
		//new RecordDaoImpl().delete(6);
	}

	Connection conn=DbConnection.getDb();

	@Override
	public void insert(Record record) {
		if (record.getStartTime() != null && record.getEndTime() != null) 
		{
	        int durationSeconds = (int) Duration.between(record.getStartTime(), record.getEndTime()).getSeconds();
	        record.setDuration(durationSeconds);
	    }
		
		String sql="insert into record(userid, gameid, levelid, star, startTime, endTime, duration)"
				+"value(?,?,?,?,?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, record.getUserid());
			ps.setInt(2, record.getGameid());
			ps.setInt(3, record.getLevelid());
			ps.setInt(4, record.getStar());
			ps.setTimestamp(5, Timestamp.valueOf(record.getStartTime()));
			ps.setTimestamp(6, Timestamp.valueOf( record.getEndTime()));
			ps.setInt(7, record.getDuration());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<Record> selectAll() {
		String sql="SELECT record.*, "
	            +"player.username AS player, "
	            +"gameCategory.game AS game, "
	            +"gamelevel.level AS level "
	            +"FROM record "
	            +" JOIN player ON record.userid = player.id "
	            +"JOIN gameCategory ON record.gameid = gameCategory.id "
	            +"JOIN gamelevel ON record.levelid = gamelevel.id "
	            +"ORDER BY record.id";
		List<Record> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Record r=new Record();  
				 r.setId(rs.getInt("id"));
		            r.setUserid(rs.getInt("userid"));
		            r.setGameid(rs.getInt("gameid"));
		            r.setLevelid(rs.getInt("levelid"));
		            r.setStar(rs.getInt("star"));
		            r.setPlayer(rs.getString("player"));
		            r.setGame(rs.getString("game"));
		            r.setLevel(rs.getString("level"));

		            LocalDateTime start = rs.getTimestamp("startTime").toLocalDateTime();
		            LocalDateTime end = rs.getTimestamp("endTime").toLocalDateTime();
		            r.setStartTime(start);
		            r.setEndTime(end);

		            r.setDuration(rs.getInt("duration"));

		            list.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Record record) {
		 if (record.getStartTime() != null && record.getEndTime() != null) 
		 {
		        int durationSeconds = (int) Duration.between(record.getStartTime(), record.getEndTime()).getSeconds();
		        record.setDuration(durationSeconds);
		 }
		
	String sql="update record set userid=?, gameid=?, levelid=?, star=?, startTime=?, endTime=?,duration=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, record.getUserid());
			ps.setInt(2, record.getGameid());
			ps.setInt(3, record.getLevelid());
			ps.setInt(4, record.getStar());
			ps.setTimestamp(5, Timestamp.valueOf(record.getStartTime()));
			ps.setTimestamp(6, Timestamp.valueOf( record.getEndTime()));
			ps.setInt(7, record.getDuration());
			ps.setInt(8, record.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from record where id=?";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	
}
