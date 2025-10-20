package dao;

import java.util.List;

import model.GameLevel;


public interface GameLevelDao {
	//create
	void insert(GameLevel gameLevel);
			
	//read
	List<GameLevel > selectAll();
	GameLevel selectByLevel(String level); 
	String findDescriptionById(int id);
		
	//update
	void update(GameLevel gameLevel);
			
	//delete
	void delete(int id);
}
