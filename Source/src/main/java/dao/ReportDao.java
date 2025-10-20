package dao;

import java.util.List;

import model.Report;

public interface ReportDao {
	List<Report> selectAll();
    Report selectByPlayer(String username);
}
