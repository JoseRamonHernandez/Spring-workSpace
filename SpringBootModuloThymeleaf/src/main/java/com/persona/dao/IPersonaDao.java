package com.persona.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.persona.modelo.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Serializable>{

	/*
	 *  NO SE PROGRAMAN LAS CONSULTAS (CRUD)
	 *  
	 *  CRUD REPOSITORY: SAVE, DELETE, SELECTBYID, UPDATE, ETC
	 */
	
}
