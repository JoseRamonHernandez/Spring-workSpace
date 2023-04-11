package org.test.app;

import java.util.List;

import org.dao.report.DaoImpl;
import org.modelo.report.Report;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	static DaoImpl dao = context.getBean("daoImpl", DaoImpl.class);
	
	public static void insertarReport() 
	{
		Report report = new Report();
			report.setTipo("CONTRATO");
			report.setFolio("CRT5457");
			report.setComentario("Reporte Contrate");
			dao.addReport(report);
	}
	
	public static void updateReport() 
	{
		Report report = new Report();
			report.setId(4);
			report.setComentario("Other report");
			dao.updateReport(report);
	}
	
	public static void deleteReport() 
	{
		Report report = new Report();
			report.setId(17);
			dao.deleteReport(report);
	}
	
	public static void getReportById() 
	{
		Report report = new Report();
			report = dao.getReportById(2);
			System.out.println(report.getId()+", "+report.getTipo()+", "+report.getFolio()+", "+report.getComentario());
	}
	
	public static void getReportAll()
	{
		List<Report> reports = dao.getAllReport();
		for(Report x : reports)
		{
			System.out.println(x.getId()+", "+x.getTipo()+", "+x.getFolio()+", "+x.getComentario());
		}
	}
	
	
	public static void main(String[] args) {
		getReportAll();
		//deleteReport();
	}
	
}
