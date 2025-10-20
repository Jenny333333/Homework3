package model;

public class Player {
	private int id;
	private String name;
	private String username;
	private String password;
	private String picture;
	
	public Player() {
		super(); 
	}
	
	public Player(String name, String username, String password, String picture) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
