package com.resource.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="empleados")
public class Empleado implements Serializable {


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
	
	@ManyToMany
	@JoinTable(name="negocios_empleados",
		joinColumns=@JoinColumn(name="empleado_id",referencedColumnName="empid"),
				inverseJoinColumns=@JoinColumn(name="negocio_id",referencedColumnName="negid"))
	
	private Set<Negocio>negocios=new HashSet<Negocio>();
	
	
	@PrePersist
	public void prePersist() {
		empentrada=new Date();
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

	public Set<Negocio> getNegocios() {
		return negocios;
	}


	public void setNegocios(Set<Negocio> negocios) {
		this.negocios = negocios;
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Empleado [empid=" + empid + ", emparea=" + emparea + ", empsueldo=" + empsueldo + ", empentrada="
				+ empentrada + ", empsalida=" + empsalida + ", negocios=" + negocios + "]";
	}
	
	
}



