package models;

import java.io.Serializable;

public class Mensaje implements Serializable{
	
	String mensaje;
	Persona creador;
	int id;
	
	public Mensaje(int id,Persona creador, String mensaje) {
		this.id = id;
		this.creador = creador;
		this.mensaje = mensaje;
		
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Persona getCreador() {
		return creador;
	}

	public void setCreador(Persona creador) {
		this.creador = creador;
	}

	
}
