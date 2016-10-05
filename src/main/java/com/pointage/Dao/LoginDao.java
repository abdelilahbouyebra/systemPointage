package com.pointage.Dao;

import com.pointage.Entities.Users;


public  interface LoginDao {

	public Users FindUser(Users users);
	public Users login(Users users);
	
}
