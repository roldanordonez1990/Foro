package models;

import java.io.Serializable;

public class Administrador implements Serializable {
	
	String nombre;
	String pass;
	
	public Administrador(String nombre,String password) {
		
		super();
		this.nombre = "admin";
		
		this.pass= "admin";
		
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	


}