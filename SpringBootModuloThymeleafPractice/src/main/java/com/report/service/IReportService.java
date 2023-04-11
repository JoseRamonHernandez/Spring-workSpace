package com.report.service;

import java.util.List;
import java.util.Optional;

import com.report.modelo.Report;

public interface IReportService {

	public List<Report> listReports();
	public Optional<Report> getReportById(int id);
	public int save(Report report);
	public void delete(int id);
	
}
