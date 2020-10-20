package edu.eci.aygo.reactiveWeb.application;

public class Persona {

  private String nombres;
  private String documento;
  private String cargo;
  
  
	public Persona(String nombres, String documento, String cargo) {
		this.nombres = nombres;
		this.documento = documento;
		this.cargo = cargo;
	}
	
	public Persona() {
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

  
  
}