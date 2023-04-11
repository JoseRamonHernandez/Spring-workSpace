package org.report.service;

import java.util.List;

import org.report.modelo.Report;

public interface ReportService {

	public void addReport(Report report);
	public List<Report> listReports();
	public Report getReportById(Integer id);
	public void deleteReport(Integer id);
	
}
