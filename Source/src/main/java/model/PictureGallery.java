package model;

public class PictureGallery {
	private int id;
	private String image;
	
	public PictureGallery() {
		super();
	}
	
	public PictureGallery(String image) {
		super();
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String toString() {
		return "id:"+id+"\t圖片:"+image+"\n";
	}
}
