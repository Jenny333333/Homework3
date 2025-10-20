package model;

public class GameLevel {
	private int id;
	private int game;
	private String level;
	private String description;
	private String gamename;
	
	public GameLevel() {
		super();
	}
	
	public GameLevel(int game, String level, String description) {
		super();
		this.game = game;
		this.level = level;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	
	public String toString() {
		return "id:"+id+"\t遊戲:"+gamename+"\t等級:"+level+"\t規則:"+description+"\n";
	}
}
