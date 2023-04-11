package org.dao.report;

import java.util.ArrayList;
import java.util.List;

import org.modelo.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class DaoImpl {

	@Autowired
	private HibernateTemplate template;
	
	public void addReport(Report report)
	{
		template.save(report);
	}
	
	public void updateReport(Report report)
	{
		template.update(report);
	}
	
	public void deleteReport(Report report)
	{
		template.delete(report);
	}
	
	
	public Report getReportById(int id) {
		Report report = (Report) template.get(Report.class, id);
		return report;
	}
	
	public List<Report> getAllReport()
	{
		List<Report> reportes = new ArrayList<Report>();
		reportes = template.loadAll(Report.class);
		return reportes;
	}
	
}
