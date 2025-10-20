package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GameLevelDao;
import model.GameLevel;
import util.DbConnection;

public class GameLevelDaoImpl implements GameLevelDao{

	public static void main(String[] args) {
		//GameLevel gl=new GameLevel(1,"中級","");
		//new GameLevelDaoImpl().insert(gl);
				
		//List<GameLevel> gameLevel = new GameLevelDaoImpl().selectAll();
		//gameLevel.forEach(System.out::println);
		
		//System.out.println(new GameLevelDaoImpl().selectByLevel("初級"));
		
		System.out.println(new GameLevelDaoImpl().findDescriptionById(3));
						
		/*GameLevel gl = new GameLevel();
		gl.setId(3);
		gl.setGame(2);
		gl.setLevel("中級");
		gl.setDescription("等");
		new GameLevelDaoImpl().update(gl);*/
						
		//new GameLevelDaoImpl().delete(6);
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(GameLevel gameLevel) {
		String sql="insert into gameLevel(game, level, description)"
				+"value(?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, gameLevel.getGame());
			ps.setString(2, gameLevel.getLevel());
			ps.setString(3, gameLevel.getDescription());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<GameLevel> selectAll() {
		String sql="SELECT gamelevel.*, gamecategory.game AS gamename " +
                "FROM gamelevel " +
                "JOIN gamecategory ON gamelevel.game = gamecategory.id";
		List<GameLevel> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				GameLevel gl=new GameLevel();  
				gl.setId(rs.getInt("id"));
				gl.setGame(rs.getInt("game"));
				gl.setLevel(rs.getString("level"));
				gl.setDescription(rs.getString("description"));
				gl.setGamename(rs.getString("gamename"));
				list.add(gl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(GameLevel gameLevel) {
String sql="update gameLevel set game=?, level=?, description=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, gameLevel.getGame());
			ps.setString(2, gameLevel.getLevel());
			ps.setString(3, gameLevel.getDescription());
			ps.setInt(4, gameLevel.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from gameLevel where id=?";
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
	public GameLevel selectByLevel(String level) {	 
	        String sql = "SELECT * FROM gameLevel WHERE level = ?";
	        GameLevel gl = null;
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, level);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                gl = new GameLevel();
	                gl.setId(rs.getInt("id"));
	                gl.setGame(rs.getInt("game"));
	                gl.setLevel(rs.getString("level"));
	                gl.setDescription(rs.getString("description"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return gl;
	}

	@Override
	public String findDescriptionById(int id) {
		String sql = "SELECT description FROM gamelevel WHERE id = ?";
		String description = null;
	    try {
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            description = rs.getString("description");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return description;
	}

}
