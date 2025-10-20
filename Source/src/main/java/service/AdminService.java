package service;

import model.Admin;

public interface AdminService {
	//create
	int addAdmin(Admin admin);  
			
	//read	
	Admin Login(String username,String password);
}
