package com.pointage.Metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pointage.Dao.UserDao;
import com.pointage.Entities.Users;

@Transactional
public class UserMetierImpl implements UserMetier {
	
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Users> AllUsers() {
		return dao.AllUsers();
	}

	@Override
	public boolean SuppUser(Integer id) {
		boolean m;
		try {
			dao.SuppUser(id);
			m=true;;
		} catch (Exception e) {
			m=false;
		}
		
		return m;
		
	}


	@Override
	public void AddUser(Users user) {
		// TODO Auto-generated method stub
		 dao.AddUser(user);
	}

	@Override
	public void ModiefierUser(Users user) {
		// TODO Auto-generated method stub
		 dao.ModifierUser(user);
	}


}
