package model;

public class GameCategory {
	private int id;
	private String game;
	private String description;
	
	public GameCategory() {
		super();
	}
	
	public GameCategory(String game, String description) {
		super();
		this.game = game;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "id:"+id+"\t遊戲:"+game+"\t規則:"+description;
	}
}
