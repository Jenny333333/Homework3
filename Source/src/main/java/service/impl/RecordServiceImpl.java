package service.impl;

import model.Record;

import java.util.List;

import dao.RecordDao;
import dao.impl.RecordDaoImpl;
import service.RecordService;

public class RecordServiceImpl implements RecordService{

	public static void main(String[] args) {

	}

	private RecordDao recordDao = new RecordDaoImpl();
	
	@Override
	public void saveRecord(Record record) {
		recordDao.insert(record);
	}

	@Override
	public List<Record> getAllRecords() {
		return recordDao.selectAll();
	}

}
