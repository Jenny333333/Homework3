package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.AchievementRecordDao;
import model.AchievementRecord;
import model.GameCategory;
import util.DbConnection;

public class AchievementRecordDaoImpl implements AchievementRecordDao{

	public static void main(String[] args) {
		/*LocalDateTime unlock=LocalDateTime.of(2025, 3,23,11,23,07);
		AchievementRecord ar=new AchievementRecord(2, 1,unlock);
		new AchievementRecordDaoImpl().insert(ar);*/
				
		//List<AchievementRecord> achievementRecord = new AchievementRecordDaoImpl().selectAll();
		//achievementRecord.forEach(System.out::println);
						
		/*AchievementRecord ar = new AchievementRecord();
		ar.setId(3);
		ar.setUserid(1);
		ar.setAchievement(1);
		ar.setUnlockDate("2025-10-19 19:52:00");
		new AchievementRecordDaoImpl().update(ar);*/
						
		//new AchievementRecordDaoImpl().delete(3);
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(AchievementRecord achievementRecord) {
		String sql="insert into achievementRecord(userid, achievement, unlockDate)"
				+"value(?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, achievementRecord.getUserid());
			ps.setInt(2, achievementRecord.getAchievement());
			ps.setTimestamp(3, Timestamp.valueOf(achievementRecord.getUnlockDate()));
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<AchievementRecord> selectAll() {
		String sql="SELECT achievementrecord.*, " +
                "achievement.title AS achievementname, " +
                "player.username AS playername " +
                "FROM achievementrecord " +
                "JOIN achievement ON achievementrecord.achievement = achievement.id " +
                "JOIN player ON achievementrecord.userid = player.id";
		List<AchievementRecord> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				AchievementRecord ar=new AchievementRecord();  
				ar.setId(rs.getInt("id"));
				ar.setUserid(rs.getInt("userid"));
				ar.setAchievement(rs.getInt("achievement"));
				ar.setUnlockDate(rs.getTimestamp("unlockDate").toLocalDateTime());
				ar.setAchievementname(rs.getString("achievementname"));
				ar.setPlayername(rs.getString("playername"));
				list.add(ar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(AchievementRecord achievementRecord) {
String sql="update achievementRecord set userid=?, achievement=?, unlockDate=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, achievementRecord.getUserid());
			ps.setInt(2, achievementRecord.getAchievement());
			ps.setTimestamp(3, Timestamp.valueOf(achievementRecord.getUnlockDate()));
			ps.setInt(4, achievementRecord.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from achievementRecord where id=?";
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
