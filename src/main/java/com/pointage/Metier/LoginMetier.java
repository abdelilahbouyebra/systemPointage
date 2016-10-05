package com.pointage.Metier;


import com.pointage.Entities.Users;

public interface LoginMetier {
	public Users FindUser(Users users);
	public Users login(Users users);

}
