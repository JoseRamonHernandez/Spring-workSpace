package com.report.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.report.modelo.Report;

public interface IReportDao extends CrudRepository<Report, Serializable>{

}
