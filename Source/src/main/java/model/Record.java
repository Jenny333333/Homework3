package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Record {
	private int id;
	private int userid;
	private int gameid;
	private int levelid;
	private int star;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private int duration;
	private String player;
	private String game;
	private String level;
	
	public Record() {
		super();
	}
	
	public Record(int userid, int gameid, int levelid, int star, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.userid = userid;
		this.gameid = gameid;
		this.levelid = levelid;
		this.star = star;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public int getLevelid() {
		return levelid;
	}

	public void setLevelid(int levelid) {
		this.levelid = levelid;
	}
	
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "id:"+id+"\t玩家:"+player+"\t遊戲:"+game+"\t等級:"+level+"\t星星:"+star+"\t開始時間:"+startTime.format(formatter)+"\t結束時間:"+endTime.format(formatter)+"\t遊玩時長:"+duration+"秒"+"\n";
	}
}
