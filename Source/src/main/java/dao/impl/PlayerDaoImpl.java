package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.PlayerDao;
import model.Player;
import util.DbConnection;

public class PlayerDaoImpl implements PlayerDao{

	public static void main(String[] args) {
		//Player p=new Player("Haily","hope","3e3ee3eee",null);
		//new PlayerDaoImpl().insert(p);
		
		System.out.println(new PlayerDaoImpl().selectAll());

		System.out.println(new PlayerDaoImpl().selectUsername("milk"));

		System.out.println(new PlayerDaoImpl().selectByUsernameAndPassword("hope", "3e3ee3eee"));
		
		Player pl=new PlayerDaoImpl().selectByUsernameAndPassword("hope", "3e3ee3eee");
		
		System.out.println(pl+"\t"+pl.getId()+
				"\t"+pl.getName()+
				"\t"+pl.getUsername()+
				"\t"+pl.getPassword()+
				"\t"+pl.getPicture());
	}
	
	private static Connection conn=DbConnection.getDb();
	
	@Override
	public void insert(Player player) {
		String sql="insert into player(name,username,password,picture) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, player.getName());
			ps.setString(2, player.getUsername());
			ps.setString(3, player.getPassword());
			ps.setString(4, player.getPicture());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public String selectAll() {
		String sql="select * from player";
		String show=" ";
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")
				+"\t姓名:"+rs.getString("name")+
				"\t帳號:"+rs.getString("username")+
				"\t密碼:"+rs.getString("password")+
				"\t頭像:"+rs.getString("picture")+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}
	
	@Override
	public boolean selectUsername(String username) {
		String sql="select * from player where username=?";
		boolean result=false;
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) result=true;
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return result;
	}

	@Override
	public Player selectByUsernameAndPassword(String username, String password) {
		String sql="select * from player where username=? and password=?";
		Player player=null;
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				player=new Player();
				player.setId(rs.getInt("id"));
				player.setName(rs.getString("name"));
				player.setUsername(rs.getString("username"));
				player.setPassword(rs.getString("password"));
				player.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return player;
	}

	@Override
	public Player selectByUsername(String username) {
		String sql="select * from player where username=? ";
		Player player=null;
		
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				player=new Player();
				player.setId(rs.getInt("id"));
				player.setName(rs.getString("name"));
				player.setUsername(rs.getString("username"));
				player.setPassword(rs.getString("password"));
				player.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return player;
	}
}


