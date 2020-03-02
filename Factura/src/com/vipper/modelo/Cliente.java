package com.vipper.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String NIF;
	private String nombre;
	private String direccion;
	private String tipo;
	private String email;
	private String telefono;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Cliente(int id, String nIF, String nombre, String direccion, String tipo, String email, String telefono) {
		super();
		this.id = id;
		NIF = nIF;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.email = email;
		this.telefono = telefono;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getNIF() {
		return NIF;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "\nCliente [id=" + id + ", NIF=" + NIF + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo="
				+ tipo + ", email=" + email + ", telefono=" + telefono + "]";
	}
	
	

}
