package model;

public class ShoppingItem {
	private int id;
	private String goods;
	private int price;
	private String image;
	private boolean active;
	
	public ShoppingItem() {
		super();
	}
	
	public ShoppingItem(String goods, int price, String image, boolean active) {
		super();
		this.goods = goods;
		this.price = price;
		this.image = image;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String toString() {
		return "id:"+id+"\t品名:"+goods+"\t價錢:"+price+"\t商品圖:"+image+"\t上架:"+active+"\n";
	}
}
