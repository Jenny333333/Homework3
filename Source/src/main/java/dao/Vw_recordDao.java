package dao;

import java.util.List;

import model.Vw_record;

public interface Vw_recordDao {
	List<Vw_record> selectAll();
	
	List<Vw_record> selectByPlayer(String Player);
}
