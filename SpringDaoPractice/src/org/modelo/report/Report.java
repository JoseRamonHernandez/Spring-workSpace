package org.modelo.report;

public class Report {

	private int id;
	private String tipo;
	private String folio;
	private String comentario;
	
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/* SELECT * FROM REPORT WHERE ID = ? */
	// FIELD ID
	public Report(int id) {
		super();
		this.id = id;
	}
	
	
	
	
	/* INSERT INTO REPORT(ID, TIPO, FOLIO, COMENTARIO) VALUES (?,?,?,?) */
	// FIELD ID, TIPO, FOLIO, COMENTARIO
	public Report(int id, String tipo, String folio, String comentario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.folio = folio;
		this.comentario = comentario;
	}


	


	/* UPDATE REPORT SET TIPO = ? WHERE ID = ? */
	// FIELD NAME, ID
	public Report(String tipo, int id) {
		super();
		this.tipo = tipo;
		this.id = id;
	}


	
	//Getters and Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
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
