package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Administrador;
import models.Mensaje;
import models.Persona;

public class ControladorFicherosMensajes {

	public static void guardarArrayList(ArrayList<Persona> estudiantes, String fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(estudiantes);

			ficheroSalida.close();
			System.out.println("Personas guardadas correctamente...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}

	public static void guardarArrayListAdmin(ArrayList<Administrador> administradores, String fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(administradores);

			ficheroSalida.close();
			System.out.println("Administradores guardadas correctamente...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}

	public static void guardarArrayListMensajes(ArrayList<Mensaje> mensajes, String fichero) {
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
			ficheroSalida.writeObject(mensajes);

			ficheroSalida.close();
			System.out.println("Mensajes guardados correctamente...");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}

	public static ArrayList<Persona> leerFichero(String fichero) {
		ArrayList<Persona> lista = null;
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Persona>) ficheroEntrada.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static ArrayList<Administrador> leerFicheroAdmin(String fichero) {
		ArrayList<Administrador> lista = null;
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Administrador>) ficheroEntrada.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static ArrayList<Mensaje> leerFicheroMensajes(String fichero) {
		ArrayList<Mensaje> lista = null;
		try {
			ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
			lista = (ArrayList<Mensaje>) ficheroEntrada.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static void main(String args[]) {
		String fichero = "D:\\personas.dat";
		String ficheroAdmin = "D:\\admin.dat";
		String ficheroMensaje = "D:\\mensajes.dat";
		Persona p1 = new Persona("1", "Alberto", "123");
		Persona p2 = new Persona("2", "Manuela", "123");
		Persona p3 = new Persona("3", "Carlitos", "123");
		Administrador a1 = new Administrador("admin", "admin");
		Mensaje m1 = new Mensaje(1, p1, "Hola tio que pasa como va la vida");
		Mensaje m2 = new Mensaje(2, p2, "Vete a tomar por culo payaso");

		ArrayList<Persona> personas = new ArrayList<Persona>();
		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		administradores.add(a1);
		mensajes.add(m1);
		mensajes.add(m2);
		guardarArrayList(personas, fichero);
		guardarArrayListAdmin(administradores, ficheroAdmin);
		guardarArrayListMensajes(mensajes, ficheroMensaje);
	}

}