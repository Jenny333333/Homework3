package service.impl;

import java.util.List;

import dao.impl.Vw_recordDaoImpl;
import model.Vw_record;
import service.Vw_recordService;

public class Vw_recordServiceImpl implements Vw_recordService{

	public static void main(String[] args) {
		System.out.println(new Vw_recordDaoImpl().selectByPlayer("hope"));

	}

	private static final Vw_recordDaoImpl vd=new Vw_recordDaoImpl();

	@Override
	public List<Vw_record> selectByPlayer(String Player) {
		return vd.selectAll();
	}

}
