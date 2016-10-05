package com.pointage.Metier;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pointage.Entities.TbUser;
import com.pointage.Entities.TbUserDept;

public class TestDepartement {
	private static ClassPathXmlApplicationContext context;
	private static DepartementMetier service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		service =  (DepartementMetier) context.getBean("metier3");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAllDeparetement() {
		List<TbUserDept> list= service.AllDeparetement();
		if(list.size()>0){
			assertTrue(true);
			for(TbUserDept elem: list)
		       {
		       	 System.out.println ("-----------"+elem);
		       }
		}else{
			assertTrue(false);
		}
	}

}
