package dao;

import java.time.LocalTime;
import java.util.List;

import model.Clock;

public interface ClockDao {
	//create
	void insert(Clock clock);
	
	//read
	Clock getRandomClockByLevel(String level);
	List<Clock > selectAll();
	LocalTime getAnswerById(int id);
	
	//update
	void update(Clock clock);
	
	//delete
	void delete(int id);
}
