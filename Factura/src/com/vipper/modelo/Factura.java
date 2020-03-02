package com.vipper.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id_factura;
	private LocalDate fecha;
	private double importe;
	private String concepto;
	private double iva;
	private int id;
	private int id_forma_pago;
	private int id_contrato;
	private int id_pedido;
	private int id_servicio;
	
	public Factura() {
		// TODO Auto-generated constructor stub
	}

	public Factura(int id_factura, LocalDate fecha, double importe, String concepto, double iva, int id,
			int id_forma_pago, int id_contrato, int id_pedido, int id_servicio) {
		super();
		this.id_factura = id_factura;
		this.fecha = fecha;
		this.importe = importe;
		this.concepto = concepto;
		this.iva = iva;
		this.id = id;
		this.id_forma_pago = id_forma_pago;
		this.id_contrato = id_contrato;
		this.id_pedido = id_pedido;
		this.id_servicio = id_servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_factura() {
		return id_factura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getImporte() {
		return importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public double getIva() {
		return iva;
	}

	public int getId() {
		return id;
	}

	public int getId_forma_pago() {
		return id_forma_pago;
	}

	public int getId_contrato() {
		return id_contrato;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	@Override
	public String toString() {
		return "\nFactura [id_factura=" + id_factura + ", fecha=" + fecha + ", importe=" + importe + ", concepto="
				+ concepto + ", iva=" + iva + ", id=" + id + ", id_forma_pago=" + id_forma_pago + ", id_contrato="
				+ id_contrato + ", id_pedido=" + id_pedido + ", id_servicio=" + id_servicio + "]";
	}
	
	
	
	
	
	
}
