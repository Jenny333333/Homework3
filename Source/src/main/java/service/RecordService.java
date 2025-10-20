package service;

import java.util.List;

import model.Record;

public interface RecordService {
	void saveRecord(Record record);
	
	 List<Record> getAllRecords();
}
