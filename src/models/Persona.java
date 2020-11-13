package models;

import java.io.Serializable;

public class Persona implements Serializable{
	
	String id;
	String nombre;
	String password;

	public Persona(String id, String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
