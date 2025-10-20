package service;

import model.Player;

public interface PlayerService {
	//create
	int addPlayer(Player player);  
		
	//read	
	Player Login(String username,String password);
}
