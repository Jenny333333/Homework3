package service.impl;

import dao.impl.PlayerDaoImpl;
import model.Player;
import service.PlayerService;

public class PlayerServiceImpl implements PlayerService{

	public static void main(String[] args) {

	}
	
	private PlayerDaoImpl pdi=new PlayerDaoImpl();

	@Override
	public int addPlayer(Player player) {
		if(pdi.selectUsername(player.getUsername()))
		{
			return 1;
		}
		else
		{
			pdi.insert(player);
			return 0;
		}
	}

	@Override
	public Player Login(String username, String password) {
		return pdi.selectByUsernameAndPassword(username,password);
	}

}
