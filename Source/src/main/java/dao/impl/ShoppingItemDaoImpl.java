package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ShoppingItemDao;
import model.ShoppingItem;
import util.DbConnection;

public class ShoppingItemDaoImpl implements ShoppingItemDao{

	public static void main(String[] args) {
		//ShoppingItem si=new ShoppingItem("購物袋",20," ",false);
		//new ShoppingItemDaoImpl().insert(si);
				
		List<ShoppingItem> shoppingItem = new ShoppingItemDaoImpl().selectAll();
		shoppingItem.forEach(System.out::println);
						
		/*ShoppingItem si = new ShoppingItem();
		si.setId(3);
		si.setGoods("藏寶盒");
		si.setPrice(200);
		si.setImage("");
		si.setActive(true);
		new ShoppingItemDaoImpl().update(si);*/
						
		//new ShoppingItemDaoImpl().delete(3);
	}
	
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(ShoppingItem shoppingItem) {
		String sql="insert into ShoppingItem(goods, price, image, active)"
				+"value(?,?,?,?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, shoppingItem.getGoods());
			ps.setInt(2, shoppingItem.getPrice());
			ps.setString(3, shoppingItem.getImage());
			ps.setBoolean(4, shoppingItem.isActive());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<ShoppingItem> selectAll() {
		String sql="select * from shoppingItem";
		List<ShoppingItem> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ShoppingItem si=new ShoppingItem();  
				si.setId(rs.getInt("id"));
				si.setGoods(rs.getString("goods"));
				si.setPrice(rs.getInt("price"));
				si.setImage(rs.getString("image"));
				si.setActive(rs.getBoolean("active"));
				list.add(si);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(ShoppingItem shoppingItem) {
		String sql="update ShoppingItem set goods=?, price=?, image=?, active=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, shoppingItem.getGoods());
			ps.setInt(2, shoppingItem.getPrice());
			ps.setString(3, shoppingItem.getImage());
			ps.setBoolean(4, shoppingItem.isActive());
			ps.setInt(5, shoppingItem.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from ShoppingItem where id=?";
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
