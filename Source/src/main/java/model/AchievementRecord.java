package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AchievementRecord {
	private int id;
	private int userid;
	private int achievement;
	private LocalDateTime unlockDate;
	private String achievementname;
	private String playername;
	
	public AchievementRecord() {
		super();
	}
	
	public AchievementRecord(int userid, int achievement, LocalDateTime unlockDate) {
		super();
		this.userid = userid;
		this.achievement = achievement;
		this.unlockDate = unlockDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAchievement() {
		return achievement;
	}

	public void setAchievement(int achievement) {
		this.achievement = achievement;
	}

	public LocalDateTime getUnlockDate() {
		return unlockDate;
	}

	public void setUnlockDate(LocalDateTime unlockDate) {
		this.unlockDate = unlockDate;
	}

	public String getAchievementname() {
		return achievementname;
	}

	public void setAchievementname(String achievementname) {
		this.achievementname = achievementname;
	}
	
	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "id:"+id+"\t玩家:"+playername+"\t成就名稱:"+achievementname+"\t達成時間:"+unlockDate.format(formatter)+"\n";
	}
}
