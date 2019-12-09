package com.resource.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empid;
	private String emparea;
	private double empsueldo;
	
	@Column(name="empentrada")
	@Temporal(TemporalType.DATE)
	private Date empentrada;
	
	@Column(name="empsalida")
	@Temporal(TemporalType.DATE)
	private Date empsalida;
	
	private Long empneg;
	
	private Long empusu;
	private String empestado;
	private String empnombre;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="venempleado",referencedColumnName="empid")
	private List<Venta>venta=new ArrayList<>();
	
	
	
	
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	public Empleado() {

	}

	public Long getEmpid() {
		return empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getEmparea() {
		return emparea;
	}

	public void setEmparea(String emparea) {
		this.emparea = emparea;
	}
	public double getEmpsueldo() {
		return empsueldo;
	}

	public void setEmpsueldo(double empsueldo) {
		this.empsueldo = empsueldo;
	}

	public Date getEmpentrada() {
		return empentrada;
	}

	public void setEmpentrada(Date empentrada) {
		this.empentrada = empentrada;
	}

	public Date getEmpsalida() {
		return empsalida;
	}


	public void setEmpsalida(Date empsalida) {
		this.empsalida = empsalida;
	}
	
	public Long getEmpneg() {
		return empneg;
	}

	public void setEmpneg(Long empneg) {
		this.empneg = empneg;
	}
	
	
	
	public Long getEmpusu() {
		return empusu;
	}

	public void setEmpusu(Long empusu) {
		this.empusu = empusu;
	}
	
	


	public String getEmpestado() {
		return empestado;
	}

	public void setEmpestado(String empestado) {
		this.empestado = empestado;
	}


	public String getEmpnombre() {
		return empnombre;
	}

	public void setEmpnombre(String empnombre) {
		this.empnombre = empnombre;
	}




	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "Empleado [empid=" + empid + ", emparea=" + emparea + ", empsueldo=" + empsueldo + ", empentrada="
				+ empentrada + ", empsalida=" + empsalida + ", empneg=" + empneg + "]";
	}

	

	
}
