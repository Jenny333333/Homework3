package dao;

import java.util.List;

import model.AchievementRecord;

public interface AchievementRecordDao {
	//create
	void insert(AchievementRecord achievementRecord);
				
	//read
	List<AchievementRecord > selectAll();
			
	//update
	void update(AchievementRecord achievementRecord);
				
	//delete
	void delete(int id);
}
