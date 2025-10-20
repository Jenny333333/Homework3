package dao;

import java.util.List;

import model.Admin;
import model.Player;

public interface AdminDao {
	//create
	void insert(Admin admin);
	
	//read
	List<Admin>selectAll();
	boolean selectUsername(String username);
	Admin selectByUsernameAndPassword(String username,String password);
}
