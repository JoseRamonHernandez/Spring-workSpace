package org.test.app;

import java.util.List;

import org.dao.report.DaoImpl;
import org.modelo.report.Report;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	static DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
	
	public static void insertReport()
	{
		dao.insertReport(new Report(4, "POWER POINT", ".pp", "File PowerPoint"));
	}
	
	public static void updateReport()
	{
		dao.updateReport(new Report("POWER-POINT", 4));
	}
	
	public static void deleteReport()
	{
		dao.deleteReport(new Report(4));
	}
	
	public static void selectById()
	{
		Report report = dao.getReportById(2);
		System.out.println(report.getId()+ ", "+report.getTipo()+ ", "+report.getFolio()+ ", "+report.getComentario());
	}
	
	public static void selectReportAll()
	{
		List<Report> reports = dao.getAllReport();
		for(Report x : reports)
		{
			System.out.println(x.getId()+ ", "+x.getTipo()+ ", "+x.getFolio()+ ", "+x.getComentario());
		}
	}
	
	public static void main(String[] args) {
		//selectReportAll();
		//selectById();
		//insertReport();
		//updateReport();
		deleteReport();
	}
	
	
}
