package org.report.controller;

import java.util.Map;

import org.report.modelo.Report;
import org.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	@RequestMapping(value = "/index")
	public String listReports(Map<String, Object>map)
	{
		map.put("report", new Report());
		map.put("reportList", service.listReports());
		return "reportForms";
	}
	
	@RequestMapping (value = "/report/add", method = RequestMethod.POST)
	public String addReport(@ModelAttribute Report report, BindingResult result)
	{
		
		service.addReport(report);
		return "redirect:/index";
		
	}
	
	@RequestMapping (value = "delete/{id}")
	public String deleteReport(@PathVariable ("id") Integer id)
	{
		service.deleteReport(id);
		return "redirect:/index";
	}
	
	@RequestMapping (value = "/edit/{id}")
	public String updateReport (@PathVariable ("id") int id, Model model)
	{
		model.addAttribute("report", service.getReportById(id));
		model.addAttribute("reportList", service.listReports());
		return "reportForms";
	}

	
}
