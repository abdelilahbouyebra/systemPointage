package com.pointage.Metier;


import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.LoginDao;
import com.pointage.Entities.Users;

@Transactional
public class LoginMetierImpl implements LoginMetier {
	
	private LoginDao daoLogin;

	public void setDaoLogin(LoginDao daoLogin) {
		this.daoLogin = daoLogin;
	}

	public Users FindUser(Users users) {
		return daoLogin.FindUser(users);
	}

	public Users login(Users users) {
		return daoLogin.login(users);
	}

}
