package dao;

import java.util.List;

import model.PictureGallery;

public interface PictureGalleryDao {
	//create
	void insert(PictureGallery pictureGallery);
			
	//read
	List<PictureGallery > selectAll();
			
	//update
	void update(PictureGallery pictureGallery);
			
	//delete
	void delete(int id);
}
