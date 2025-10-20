package dao;

import java.util.List;

import model.GameCategory;

public interface GameCategoryDao {
	//create
	void insert(GameCategory gameCategory);
		
	//read
	List<GameCategory > selectAll();
		
	//update
	void update(GameCategory gameCategory);
		
	//delete
	void delete(int id);
}
