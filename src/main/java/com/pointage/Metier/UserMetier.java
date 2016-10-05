package com.pointage.Metier;

import java.util.List;

import com.pointage.Entities.Users;

public interface UserMetier {
	public void AddUser(Users user );
	public List<Users> AllUsers();
	public boolean SuppUser(Integer id);
	public void ModiefierUser(Users user);

}
