package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PictureGalleryDao;
import model.PictureGallery;
import util.DbConnection;

public class PictureGalleryDaoImpl implements PictureGalleryDao{

	public static void main(String[] args) {
		//PictureGallery pg=new PictureGallery("test2");
		//new PictureGalleryDaoImpl().insert(pg);
				
		List<PictureGallery> pictureGallery = new PictureGalleryDaoImpl().selectAll();
		pictureGallery.forEach(System.out::println);
						
		/*PictureGallery pg = new PictureGallery();
		pg.setId(2);
		pg.setImage("test3");
		new PictureGalleryDaoImpl().update(pg);*/
						
		//new PictureGalleryDaoImpl().delete(2);
	}

	Connection conn=DbConnection.getDb();
	

	@Override
	public void insert(PictureGallery pictureGallery) {
		String sql="insert into pictureGallery(image)"
				+"value(?)";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pictureGallery.getImage());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

	@Override
	public List<PictureGallery> selectAll() {
		String sql="select * from pictureGallery";
		List<PictureGallery> list=new ArrayList();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PictureGallery pg=new PictureGallery();  
				pg.setId(rs.getInt("id"));
				pg.setImage(rs.getString("image"));
				list.add(pg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(PictureGallery pictureGallery) {
		String sql="update pictureGallery set image=?  where id=?";
		
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, pictureGallery.getImage());
			ps.setInt(2, pictureGallery.getId());
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}				
	}

	@Override
	public void delete(int id) {
		String sql="delete from pictureGallery where id=?";
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
