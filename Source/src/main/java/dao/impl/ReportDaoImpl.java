package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDao;
import model.Report;
import util.DbConnection;

public class ReportDaoImpl implements ReportDao{

	public static void main(String[] args) {
		List<Report> report = new ReportDaoImpl().selectAll();
		report.forEach(System.out::println);
		
		//System.out.println(new ReportDaoImpl().selectByPlayer("Apple"));
	}
	
    Connection conn = DbConnection.getDb();

	@Override
	public List<Report> selectAll() {
		List<Report> list = new ArrayList();
        String sql = "SELECT * FROM report";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Report report = new Report();
                report.setUserid(rs.getInt("userid"));
                report.setPlayer(rs.getString("player"));
                report.setClockBeginnerPlayed(rs.getInt("clockBeginnerPlayed"));
                report.setClockAdvancedPlayed(rs.getInt("clockAdvancedPlayed"));
                report.setShoppingBeginnerPlayed(rs.getInt("shoppingBeginnerPlayed"));
                report.setShoppingIntermediatePlayed(rs.getInt("shoppingIntermediatePlayed"));
                report.setShoppingAdvancedPlayed(rs.getInt("shoppingAdvancedPlayed"));
                report.setTotalPlayTime(rs.getInt("totalPlayTime"));
                report.setAchievements(rs.getInt("achievements"));
                list.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
	}

	@Override
	public Report selectByPlayer(String username) {
		String sql = "SELECT * FROM report WHERE player = ?";
        Report report = null;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                report = new Report();
                report.setUserid(rs.getInt("userid"));
                report.setPlayer(rs.getString("player"));
                report.setClockBeginnerPlayed(rs.getInt("clockBeginnerPlayed"));
                report.setClockAdvancedPlayed(rs.getInt("clockAdvancedPlayed"));
                report.setShoppingBeginnerPlayed(rs.getInt("shoppingBeginnerPlayed"));
                report.setShoppingIntermediatePlayed(rs.getInt("shoppingIntermediatePlayed"));
                report.setShoppingAdvancedPlayed(rs.getInt("shoppingAdvancedPlayed"));
                report.setTotalPlayTime(rs.getInt("totalPlayTime"));
                report.setAchievements(rs.getInt("achievements"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
	}

}
