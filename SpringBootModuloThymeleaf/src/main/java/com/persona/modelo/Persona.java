package com.persona.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "PERSONA")
public class Persona {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "TELEFONO")
	private String telefono;
	
	
	//SUPER CLASS
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	//FIELDS
	public Persona(Integer id, String nombre, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}


	//Getters and Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
}
