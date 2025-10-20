package service.impl;

import dao.impl.GameLevelDaoImpl;
import service.GameLevelService;

public class GameLevelServiceImpl implements GameLevelService{

	public static void main(String[] args) {
		System.out.println(new GameLevelDaoImpl().findDescriptionById(3));
	}

	private GameLevelDaoImpl gdi=new GameLevelDaoImpl();
	
	@Override
	public String getDescriptionById(int id) {
		return gdi.findDescriptionById(id);
	}

}
