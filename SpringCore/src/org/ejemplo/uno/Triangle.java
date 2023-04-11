package org.ejemplo.uno;

/*
 * REALIZAR INYECCIONES DE DEPENDENCIAS POR MEDIO DEL CONSTRUCTOR
 */
public class Triangle {

	private int height;
	private String type;
	
	
	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}


	// FIELDS OF HEIGHT
	public Triangle(int height) {
		super();
		this.height = height;
	}


	// FIELDS OF HEIGHT AND TYPE
	public Triangle(int height, String type) {
		super();
		this.height = height;
		this.type = type;
	}


	
	//Getters and Setters
	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString()
	{
		return "Triangle [height= "+height+", type= "+type+"]";
	}
	
	
}
