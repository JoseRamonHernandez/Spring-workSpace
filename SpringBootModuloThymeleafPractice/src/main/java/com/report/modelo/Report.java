package com.report.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Report")
public class Report {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name = "FOLIO")
	private String folio;
	@Column(name = "COMENTARIO")
	private String comentario;
	
	
	//SUPERCLASS
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}


	//FIELDS
	public Report(Integer id, String tipo, String folio, String comentario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.folio = folio;
		this.comentario = comentario;
	}


	//Getters and Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getFolio() {
		return folio;
	}


	public void setFolio(String folio) {
		this.folio = folio;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
	
}
