package dao;

import java.util.List;

import model.ShoppingItem;

public interface ShoppingItemDao {
	//create
	void insert(ShoppingItem shoppingItem);
			
	//read
	List<ShoppingItem > selectAll();
			
	//update
	void update(ShoppingItem shoppingItem);
			
	//delete
	void delete(int id);
}
