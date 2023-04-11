package org.report.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.report.modelo.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDaoImpl implements ReportDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addReport(Report report) {
		
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(report);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Report> listReports() {
		
		List<Report> reports = null;
		
		try {
			
			reports = (List<Report>)
			sessionFactory.getCurrentSession().createQuery("from Report").list();
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return reports;
	}

	@Override
	public Report getReportById(Integer id) {
		
		Report report = null;
		
		try {
			
			report = (Report)
			sessionFactory.getCurrentSession().get(Report.class, id);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		return report;
	}

	@Override
	public void deleteReport(Integer id) {
		
		Report report = null;
		
		try {
			
			report = (Report)
			sessionFactory.getCurrentSession().get(Report.class, id);
			sessionFactory.getCurrentSession().delete(report);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
	}

}
