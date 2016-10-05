package com.pointage.Dao;

import java.util.List;

import com.pointage.Entities.Users;


public  interface UserDao {

	public void AddUser(Users user );
	public List<Users> AllUsers();
	public void SuppUser(Integer id);
	public void ModifierUser(Users idUser);
	
}
