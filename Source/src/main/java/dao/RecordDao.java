package dao;

import java.util.List;

import model.Record;

public interface RecordDao {
	//create
	void insert(Record record);
			
	//read
	List<Record > selectAll();
			
	//update
	void update(Record record);
			
	//delete
	void delete(int id);
}
