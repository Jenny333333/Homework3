package dao;

import java.util.List;

import model.Achievement;

public interface AchievementDao {
	//create
	void insert(Achievement achievement);
			
	//read
	List<Achievement > selectAll();
			
	//update
	void update(Achievement achievement);
			
	//delete
	void delete(int id);
}
