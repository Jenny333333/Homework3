package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GameCategoryDao;
import model.GameCategory;
import util.DbConnection;

public class GameCategoryDaoImpl implements GameCategoryDao{

	public static void main(String[] args) {
		//GameCategory gc=new GameCategory("購物小能手","");
		//new GameCategoryDaoImpl().insert(gc);
		
		List<GameCategory> gameCategory = new GameCategoryDaoImpl().selectAll();
		gameCategory.forEach(System.out::println);
				
		GameCategory gc = new GameCategory();
		gc.setId(2);
		gc.setGame("時間管理大師");
		gc.setDescription("看時鐘寫時間");
		new GameCategoryDaoImpl().update(gc);
				
		new GameCategoryDaoImpl().delete(3);
	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public void insert(GameCategory gameCategory) {
		String sql="insert into gameCategory(game, description)"
				+"value(?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gameCategory.getGame());
			ps.setString(2, gameCategory.getDescription());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<GameCategory> selectAll() {
		String sql="select * from gameCategory";
		List<GameCategory> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				GameCategory gc=new GameCategory();  
				gc.setId(rs.getInt("id"));
				gc.setGame(rs.getString("game"));
				gc.setDescription(rs.getString("description"));
				list.add(gc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(GameCategory gameCategory) {
		String sql="update gameCategory set game=?, description=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gameCategory.getGame());
			ps.setString(2, gameCategory.getDescription());
			ps.setInt(3, gameCategory.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(int id) {
		String sql="delete from gameCategory where id=?";
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
