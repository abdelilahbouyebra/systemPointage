package com.pointage.Metier;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pointage.Entities.Users;


public class TestLogin {
	private static ClassPathXmlApplicationContext context;
	private static LoginMetier daoLogin;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		daoLogin= (LoginMetier) context.getBean("metierLogin");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testFindUser() {
		Users us=new Users("test", "test");
     Users  u=daoLogin.FindUser(us);
     assertTrue(u.getUserName().equals("test"));

  
	}

	@Test
	public void testLogin() {
		Users us=new Users("test", "123");
		Users model=daoLogin.login(us);
		assertTrue(model.getPassword().equals(us.getPassword()));
	}

}
