package com.pointage.Metier;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsers {
	private static ClassPathXmlApplicationContext context;
	private static UserMetier userMetier;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		userMetier =  (UserMetier) context.getBean("metier");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	

}
