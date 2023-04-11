package org.test.app;

import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	static DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
	
	public static void insertarS_Region() 
	{
			S_Region region = new S_Region();
			region.setName("ATLIXCO");
			dao.addS_Region(region);
	}
	
	public static void updateS_Region() 
	{
			S_Region region = new S_Region();
			region.setId(17);
			region.setName("ATLIXCO PUEBLA");
			dao.updateS_Region(region);
	}
	
	public static void deleteS_Region() 
	{
			S_Region region = new S_Region();
			region.setId(17);
			dao.deleteS_Region(region);
	}
	
	public static void getS_RegionById() 
	{
			S_Region region = new S_Region();
			region = dao.getS_RegionById(2);
			System.out.println(region.getId()+", "+region.getName());
	}
	
	public static void getS_RegionAll()
	{
		List<S_Region> regions = dao.getAllS_Region();
		for(S_Region x : regions)
		{
			System.out.println(x.getId()+", "+x.getName());
		}
	}
	
	
	public static void main(String[] args) {
		//getS_RegionAll();
		//getS_RegionById();
		//insertarS_Region();
		//updateS_Region();
		deleteS_Region();
	}
	
}
