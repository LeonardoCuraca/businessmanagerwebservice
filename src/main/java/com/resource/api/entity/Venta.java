package com.resource.api.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ventas")
public class Venta implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long venid;
	private Integer vencantidad;
	private double venprecio;
	private double ventotal;
	
	@Column(name = "venfecha", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp venfecha;
	
	private Long vennegocio;
	
	private Long venempleado;

	private Long venproducto;
	
	public Venta() {
		
	}

	public Long getVenid() {
		return venid;
	}
	
	public void setVenid(Long venid) {
		this.venid = venid;
	}

	public Integer getVencantidad() {
		return vencantidad;
	}

	public void setVencantidad(Integer vencantidad) {
		this.vencantidad = vencantidad;
	}

	public double getVenprecio() {
		return venprecio;
	}

	public void setVenprecio(double venprecio) {
		this.venprecio = venprecio;
	}

	public double getVentotal() {
		return ventotal;
	}

	public void setVentotal(double ventotal) {
		this.ventotal = ventotal;
	}

	public Timestamp getVenfecha() {
		return venfecha;
	}

	public void setVenfecha(Timestamp venfecha) {
		this.venfecha = venfecha;
	}


	public Long getVennegocio() {
		return vennegocio;
	}

	public void setVennegocio(Long vennegocio) {
		this.vennegocio = vennegocio;
	}

	public Long getVenempleado() {
		return venempleado;
	}

	public void setVenempleado(Long venempleado) {
		this.venempleado = venempleado;
	}


	public Long getVenproducto() {
		return venproducto;
	}

	public void setVenproducto(Long venproducto) {
		this.venproducto = venproducto;
	}
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Venta [venid=" + venid + ", vencantidad=" + vencantidad + ", venprecio=" + venprecio + ", ventotal="
				+ ventotal + ", venfecha=" + venfecha + ", vennegocio=" + vennegocio + ", venempleado=" + venempleado
				+ ", venproducto=" + venproducto + "]";
	}
	
}
