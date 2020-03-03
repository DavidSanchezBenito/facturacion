package com.vipper.modelo;

import java.io.Serializable;

public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id_servicio;
	private double coste;
	private double iva;
	private String descrip;
	private int id;
	
	public Servicio() {
		// TODO Auto-generated constructor stub
	}

	public Servicio(int id_servicio, double coste, double iva, String descrip, int id) {
		super();
		this.id_servicio = id_servicio;
		this.coste = coste;
		this.iva = iva;
		this.descrip = descrip;
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public double getCoste() {
		return coste;
	}

	public double getIva() {
		return iva;
	}

	public String getDescrip() {
		return descrip;
	}

	public int getId() {
		return id;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\nServicio [id_servicio=" + id_servicio + ", coste=" + coste + ", iva=" + iva + ", descrip=" + descrip
				+ ", id=" + id + "]";
	}
	
	
}
