package com.vipper.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id_pedido;
	private LocalDate fecha;
	private double total;
	private double importe_facturado;
	private String descrip;
	private int id;
	private int id_contrato;
	private int id_servicio;
	private int id_forma_pago;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Pedido(int id_pedido, LocalDate fecha, double total, double importe_facturado, String descrip, int id,
			int id_contrato, int id_servicio, int id_forma_pago) {
		super();
		this.id_pedido = id_pedido;
		this.fecha = fecha;
		this.total = total;
		this.importe_facturado = importe_facturado;
		this.descrip = descrip;
		this.id = id;
		this.id_contrato = id_contrato;
		this.id_servicio = id_servicio;
		this.id_forma_pago = id_forma_pago;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getTotal() {
		return total;
	}

	public double getImporte_facturado() {
		return importe_facturado;
	}

	public String getDescrip() {
		return descrip;
	}

	public int getId() {
		return id;
	}

	public int getId_contrato() {
		return id_contrato;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public int getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setImporte_facturado(double importe_facturado) {
		this.importe_facturado = importe_facturado;
	}

	public void setDescrp(String descrip) {
		this.descrip = descrip;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fecha=" + fecha + ", total=" + total + ", importe_facturado="
				+ importe_facturado + ", descrp=" + descrip + ", id=" + id + ", id_contrato=" + id_contrato
				+ ", id_servicio=" + id_servicio + ", id_forma_pago=" + id_forma_pago + "]";
	}

	
	
}
