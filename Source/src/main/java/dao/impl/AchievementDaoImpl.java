package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AchievementDao;
import model.Achievement;
import util.DbConnection;

public class AchievementDaoImpl implements AchievementDao{
	
	public static void main(String[] args) {
		//Achievement a=new Achievement("測試","te","tes","test");
		//new AchievementDaoImpl().insert(a);
		
		List<Achievement> achievement = new AchievementDaoImpl().selectAll();
		achievement.forEach(System.out::println);
				
		/*Achievement a = new Achievement();
		a.setId(3);
		a.setTitle("Testt");
		a.setDescription("hhh");
		a.setIcon("dhbsil");
		a.setRequirement("www");
		new AchievementDaoImpl().update(a);*/
				
		//new AchievementDaoImpl().delete(3);
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(Achievement achievement) {
		String sql="insert into achievement(title, description, icon, requirement)"
				+"value(?,?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, achievement.getTitle());
			ps.setString(2, achievement.getDescription());
			ps.setString(3, achievement.getIcon());
			ps.setString(4, achievement.getRequirement());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<Achievement> selectAll() {
		String sql="select * from achievement";
		List<Achievement> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Achievement a=new Achievement();  
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setDescription(rs.getString("description"));
				a.setIcon(rs.getString("icon"));
				a.setRequirement(rs.getString("requirement"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Achievement achievement) {
String sql="update achievement set title=?, description=?, icon=?, requirement=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, achievement.getTitle());
			ps.setString(2, achievement.getDescription());
			ps.setString(3, achievement.getIcon());
			ps.setString(4, achievement.getRequirement());
			ps.setInt(5, achievement.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from achievement where id=?";
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
