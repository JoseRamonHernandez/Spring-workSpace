package com.report.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.report.modelo.Report;
import com.report.service.IReportService;


@Controller
public class ReportController {

	@Autowired
	private IReportService service;
	
	@GetMapping(value = "/listar")
	public String listarReport(Model model)
	{
		List<Report> reports = service.listReports();
		model.addAttribute("reports", reports);
		return "index";
	}
	
	@GetMapping(value = "/new")
	public String guardarReport(Model model)
	{
		model.addAttribute("report", new Report());
		return "form";
	}
	
	@PostMapping(value = "/save")
	public String saveReport(Report report)
	{
		service.save(report);
		return "redirect:/listar";
	}
	
	@GetMapping(value = "/editar/{id}")
	public String editarReport(@PathVariable int id, Model model)
	{
		Optional<Report> report = service.getReportById(id);
		model.addAttribute("report", report);
		
		return "form";
	}
	
	@GetMapping(value = "/eliminar/{id}")
	public String editarReport(@PathVariable int id)
	{
	
		service.delete(id);
		
		return "redirect:/listar";
	}

	
}
