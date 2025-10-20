package service;

import java.util.List;

import model.Vw_record;

public interface Vw_recordService {
	List<Vw_record> selectByPlayer(String Player);
}
