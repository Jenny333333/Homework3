package service.impl;

import dao.impl.AdminDaoImpl;
import model.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService{

	public static void main(String[] args) {

	}
	
	private AdminDaoImpl adi=new AdminDaoImpl();

	@Override
	public int addAdmin(Admin admin) {
		if(adi.selectUsername(admin.getUsername()))
		{
			return 1;
		}
		else
		{
			adi.insert(admin);
			return 0;
		}
	}

	@Override
	public Admin Login(String username, String password) {
		return adi.selectByUsernameAndPassword(username,password);
	}

}
