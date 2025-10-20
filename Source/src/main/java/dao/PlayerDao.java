package dao;

import model.Player;

public interface PlayerDao {
	//create
	void insert(Player player);  
	
	//read
	String selectAll();  
	boolean selectUsername(String username);
	Player selectByUsername(String username);
	Player selectByUsernameAndPassword(String username,String password);
}
