package org.ingservicios.p1;

import java.io.Serializable;

public class DTOUsuarios  implements Serializable  {
	/**
	 * 
	 */
	/*La misión de un DTO es encapsular los datos a transferir 
	en un único objeto.*/
	//Atributos
	private String apellidos;
	private String nombre;
	private String email;
	
	//Constructor por defecto
	public DTOUsuarios() {
		this.nombre="";
		this.email="";
		this.email="";
	}
	
//Constructor
	public DTOUsuarios(String nombre, String apellidos, String email) {
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.email = email;
	}
//Get y set
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
