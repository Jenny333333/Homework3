package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.ClockDao;
import model.Clock;
import util.DbConnection;

public class ClockDaoImpl implements ClockDao{

	public static void main(String[] args) {
		//Clock c=new Clock("高階", null, "3:30");
		//new ClockDaoImpl().insert(c);
		
		//System.out.println(new ClockDaoImpl().selectAll());
	    //List<Clock> clocks = new ClockDaoImpl().selectAll();
		//clocks.forEach(System.out::println);
		
		Clock random=(new ClockDaoImpl().getRandomClockByLevel("初級"));
		System.out.println(random);
		
		//System.out.println(new ClockDaoImpl().getAnswerById(2));
		
		/*Clock c = new Clock();
		c.setId(2);
		c.setLevel("高階");
		c.setImage(null);
		c.setAnswer("5:45");
		new ClockDaoImpl().update(c);
		
		new ClockDaoImpl().delete(3);*/
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(Clock clock) {
		String sql="insert into clock(level, image, answer)"
				+"value(?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, clock.getLevel());
			ps.setString(2, clock.getImage());
			ps.setString(3, clock.getAnswer());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override 
	public Clock getRandomClockByLevel(String level) {
		String sql="select * from clock where level=? order by rand() limit 1";
		 try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, level);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		        	Clock clock = new Clock();
		            clock.setId(rs.getInt("id"));
		            clock.setLevel(rs.getString("level"));
		            clock.setImage(rs.getString("image"));
		            clock.setAnswer(rs.getString("answer")); 
		            return clock;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		}

	@Override
	public List<Clock> selectAll() {
		String sql="select * from clock";
		List<Clock> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Clock c=new Clock();  
				c.setId(rs.getInt("id"));
				c.setLevel(rs.getString("level"));
				c.setImage(rs.getString("image"));
				c.setAnswer(rs.getString("answer"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(Clock clock) {
		String sql="update clock set level=?, image=?, answer=? where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, clock.getLevel());
			ps.setString(2, clock.getImage());
			ps.setString(3, clock.getAnswer());
			ps.setInt(4, clock.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql="delete from clock where id=?";
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

	@Override
	public LocalTime getAnswerById(int id) {
		String sql = "SELECT answer FROM clock WHERE id = ?";
        try  {
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	 String answerStr = rs.getString("answer"); 
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                 return LocalTime.parse(answerStr, formatter);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
	}
}
