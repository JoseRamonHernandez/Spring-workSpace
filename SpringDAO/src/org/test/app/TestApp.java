package org.test.app;


import java.util.List;

import org.dao.sregion.DaoImpl;
import org.modelo.sregion.S_Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	static DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
	
	public static void insertS_Region()
	{
		dao.insertS_Region(new S_Region(15, "CD_MENDOZA"));
	}
	
	public static void updateS_Region()
	{
		dao.updateS_Region(new S_Region("CIUDAD MENDOZA", 14));
	}
	
	public static void deleteS_Region()
	{
		dao.deleteS_Region(new S_Region(11));
	}
	
	public static void selectById()
	{
		S_Region region = dao.getS_RegionById(2);
		System.out.println(region.getId()+ ", "+region.getName());
	}
	
	public static void selectS_RegionAll()
	{
		List<S_Region> regiones = dao.getAllS_Region();
		for(S_Region x : regiones)
		{
			System.out.println(x.getId()+" "+x.getName());
		}
	}
	
	public static void main(String[] args) {
		//selectS_RegionAll();
		//selectById();
		insertS_Region();
		//updateS_Region();
		//deleteS_Region();
	}
	
}
