package model;

public class Report {
	private int userid;
	private String player;
	private int clockBeginnerPlayed;
	private int clockAdvancedPlayed;
	private int shoppingBeginnerPlayed;
	private int shoppingIntermediatePlayed;
	private int shoppingAdvancedPlayed;
	private int totalPlayTime;
	private int achievements;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public int getClockBeginnerPlayed() {
		return clockBeginnerPlayed;
	}
	public void setClockBeginnerPlayed(int clockBeginnerPlayed) {
		this.clockBeginnerPlayed = clockBeginnerPlayed;
	}
	public int getClockAdvancedPlayed() {
		return clockAdvancedPlayed;
	}
	public void setClockAdvancedPlayed(int clockAdvancedPlayed) {
		this.clockAdvancedPlayed = clockAdvancedPlayed;
	}
	public int getShoppingBeginnerPlayed() {
		return shoppingBeginnerPlayed;
	}
	public void setShoppingBeginnerPlayed(int shoppingBeginnerPlayed) {
		this.shoppingBeginnerPlayed = shoppingBeginnerPlayed;
	}
	public int getShoppingIntermediatePlayed() {
		return shoppingIntermediatePlayed;
	}
	public void setShoppingIntermediatePlayed(int shoppingIntermediatePlayed) {
		this.shoppingIntermediatePlayed = shoppingIntermediatePlayed;
	}
	public int getShoppingAdvancedPlayed() {
		return shoppingAdvancedPlayed;
	}
	public void setShoppingAdvancedPlayed(int shoppingAdvancedPlayed) {
		this.shoppingAdvancedPlayed = shoppingAdvancedPlayed;
	}
	public int getTotalPlayTime() {
		return totalPlayTime;
	}
	public void setTotalPlayTime(int totalPlayTime) {
		this.totalPlayTime = totalPlayTime;
	}
	public int getAchievements() {
		return achievements;
	}
	public void setAchievements(int achievements) {
		this.achievements = achievements;
	}

	public String toString() {
		return "id:"+userid+"\t玩家:"+player+"\t時間管理大師初級遊玩次數:"+clockBeginnerPlayed
				+"\t時間管理大師高級遊玩次數:"+clockAdvancedPlayed
				+"\t購物小能手初級遊玩次數:"+shoppingBeginnerPlayed
				+"\t購物小能手中級遊玩次數:"+shoppingIntermediatePlayed
				+"\t購物小能手高級遊玩次數:"+shoppingAdvancedPlayed
				+"\t總遊玩時間:"+totalPlayTime
				+"\t成就數:"+achievements+"\n";
	}
}
