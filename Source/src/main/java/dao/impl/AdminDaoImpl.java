package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;
import model.Admin;
import model.Player;
import util.DbConnection;

public class AdminDaoImpl implements AdminDao{

	public static void main(String[] args) {
		//Admin ad=new Admin("Alex","xxxx","x0x0x0");
		//new AdminDaoImpl().insert(ad);
				
		System.out.println(new AdminDaoImpl().selectAll());
		
		System.out.println(new AdminDaoImpl().selectUsername("xxx"));

		System.out.println(new AdminDaoImpl().selectByUsernameAndPassword("xxxx", "x0x0x0"));
		
		Admin ad=new AdminDaoImpl().selectByUsernameAndPassword("xxxx", "x0x0x0");
		
		System.out.println(ad+"\t"+ad.getId()+
				"\t"+ad.getName()+
				"\t"+ad.getUsername()+
				"\t"+ad.getPassword());
	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void insert(Admin admin) {
		String sql="insert into admin(name,username,password)"
				+"values(?,?,?)";
		try
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Admin> selectAll() {
		String sql="select * from admin";
		List<Admin> list=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Admin adm=new Admin();  
				adm.setId(rs.getInt("id"));
				adm.setName(rs.getString("name"));
				adm.setUsername(rs.getString("username"));
				adm.setPassword(rs.getString("password"));
				list.add(adm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public boolean selectUsername(String username) {
		String sql="select * from admin where username=?";
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
	public Admin selectByUsernameAndPassword(String username, String password) {
		String sql="select * from admin where username=? and password=?";
		Admin admin=null;
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setName(rs.getString("name"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return admin;
	}

}
