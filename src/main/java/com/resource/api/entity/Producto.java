package com.resource.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long proid;
	private String procodigo;
	private String pronombre;
	private Integer prostock;
	private double proprecio;
	private String prodetalles;
	private Long proneg;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="venproducto",referencedColumnName="proid")
	
	private List<Venta> venta=new ArrayList<>();
	
	
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	public Producto() {
		
	}

	public Long getProid() {
		return proid;
	}

	public void setProid(Long proid) {
		this.proid = proid;
	}

	public String getProcodigo() {
		return procodigo;
	}

	public void setProcodigo(String procodigo) {
		this.procodigo = procodigo;
	}

	public String getPronombre() {
		return pronombre;
	}

	public void setPronombre(String pronombre) {
		this.pronombre = pronombre;
	}

	public Integer getProstock() {
		return prostock;
	}

	public void setProstock(Integer prostock) {
		this.prostock = prostock;
	}

	public double getProprecio() {
		return proprecio;
	}

	public void setProprecio(double proprecio) {
		this.proprecio = proprecio;
	}

	public String getProdetalles() {
		return prodetalles;
	}

	public void setProdetalles(String prodetalles) {
		this.prodetalles = prodetalles;
	}

	public Long getProneg() {
		return proneg;
	}

	public void setProneg(Long proneg) {
		this.proneg = proneg;
	}
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "Producto [proid=" + proid + ", procodigo=" + procodigo + ", pronombre=" + pronombre + ", prostock="
				+ prostock + ", proprecio=" + proprecio + ", prodetalles=" + prodetalles + ", proneg=" + proneg + "]";
	}

	
}