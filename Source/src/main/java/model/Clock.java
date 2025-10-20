package model;

public class Clock {
	private int id;
	private String level;
	private String image;
	private String answer;
	
	public Clock(){
		super();
	}
	
	public Clock(String level, String image, String answer) {
		super();
		this.level = level;
		this.image = image;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toString() {
	    return "id:" + id + "\t等級:" + level + "\t題目:" + image + "\t答案:" + answer+"\n";
	}
}
