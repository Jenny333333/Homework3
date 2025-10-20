package model;

public class Achievement {
	private int id;
	private String title;
	private String icon;
	private String description;
	private String requirement;
	
	public Achievement() {
		super();
	}

	public Achievement(String title, String icon, String description, String requirement) {
		super();
		this.title = title;
		this.icon = icon;
		this.description = description;
		this.requirement = requirement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	
	public String toString() {
		return "id:"+id+"\t成就:"+title+"\t說明:"+description+"\t圖示:"+icon+"\t條件:"+requirement+"\n";
	}
}