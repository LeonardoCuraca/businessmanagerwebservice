package com.resource.api.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long proid;
	private String procodigo;
	private String pronombre;
	private Integer prostock;
	private double proprecio;
	private String prodetalles;
	private Integer proneg;

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

	public Integer getProneg() {
		return proneg;
	}
	public void setProneg(Integer proneg) {
		this.proneg = proneg;
	}
	private static final long serialVersionUID=1L;

	@Override
	public String toString() {
		return "Producto [proid=" + proid + ", procodigo=" + procodigo + ", pronombre=" + pronombre + ", prostock="
				+ prostock + ", proprecio=" + proprecio + ", prodetalles=" + prodetalles + ", proneg=" + proneg
				+ ", getProid()=" + getProid() + ", getProcodigo()=" + getProcodigo() + ", getPronombre()="
				+ getPronombre() + ", getProstock()=" + getProstock() + ", getProprecio()=" + getProprecio()
				+ ", getProdetalles()=" + getProdetalles() + ", getProneg()=" + getProneg() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
