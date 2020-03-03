package com.vipper.modelo;

import java.io.Serializable;

public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id_contrato;
	private double comision;
	private String encargadoFacturacion;
	private int id_proveedor;
	
	public Contrato() {
		// TODO Auto-generated constructor stub
	}

	public Contrato(int id_contrato, double comision, String encargadoFacturacion, int id_proveedor) {
		super();
		this.id_contrato = id_contrato;
		this.comision = comision;
		this.encargadoFacturacion = encargadoFacturacion;
		this.id_proveedor = id_proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_contrato() {
		return id_contrato;
	}

	public double getComision() {
		return comision;
	}

	public String getEncargadoFacturacion() {
		return encargadoFacturacion;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public void setEncargadoFacturacion(String encargadoFacturacion) {
		this.encargadoFacturacion = encargadoFacturacion;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	@Override
	public String toString() {
		return "\nContrato [id_contrato=" + id_contrato + ", comision=" + comision + ", encargadoFacturacion="
				+ encargadoFacturacion + ", id_proveedor=" + id_proveedor + "]";
	}

}
