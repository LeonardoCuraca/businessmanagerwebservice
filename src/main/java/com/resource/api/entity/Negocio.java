package com.resource.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="negocios")
public class Negocio implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long negid;
	private String negnombre;
	private String negdetalles;
	private String negdireccion;
	private String negemail;
	private String negcodpostal;
	private String negpassword;
	private String negcelular;
	private String neglogo;
	private String negestado;
	private Long negusuario;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="proneg",referencedColumnName="negid")
	private List<Producto> producto=new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name="negocios_empleados",
	joinColumns=@JoinColumn(name="negocio_id",referencedColumnName="negid"),
			inverseJoinColumns=@JoinColumn(name="empleado_id",referencedColumnName="empid"))
	
	private Set<Empleado>empleados=new HashSet<Empleado>();
	
	

	public Set<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}
	public List<Producto> getProducto() {
		return producto;
	}
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	public Negocio() {
		
	}
	public Long getNegusuario() {
		return negusuario;
	}
	public void setNegusuario(Long negusuario) {
		this.negusuario = negusuario;
	}

	public Long getNegid() {
		return negid;
	}
	public void setNegid(Long negid) {
		this.negid = negid;
	}
	public String getNegnombre() {
		return negnombre;
	}
	public void setNegnombre(String negnombre) {
		this.negnombre = negnombre;
	}
	public String getNegdetalles() {
		return negdetalles;
	}
	public void setNegdetalles(String negdetalles) {
		this.negdetalles = negdetalles;
	}
	public String getNegdireccion() {
		return negdireccion;
	}
	public void setNegdireccion(String negdireccion) {
		this.negdireccion = negdireccion;
	}
	public String getNegemail() {
		return negemail;
	}
	public void setNegemail(String negemail) {
		this.negemail = negemail;
	}
	public String getNegcodpostal() {
		return negcodpostal;
	}
	public void setNegcodpostal(String negcodpostal) {
		this.negcodpostal = negcodpostal;
	}
	public String getNegpassword() {
		return negpassword;
	}
	public void setNegpassword(String negpassword) {
		this.negpassword = negpassword;
	}
	public String getNegcelular() {
		return negcelular;
	}
	public void setNegcelular(String negcelular) {
		this.negcelular = negcelular;
	}
	public String getNeglogo() {
		return neglogo;
	}
	public void setNeglogo(String neglogo) {
		this.neglogo = neglogo;
	}
	public String getNegestado() {
		return negestado;
	}
	public void setNegestado(String negestado) {
		this.negestado = negestado;
	}
	
	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}
	private static final long serialVersionUID=1L;


	@Override
	public String toString() {
		return "Negocio [negid=" + negid + ", negnombre=" + negnombre + ", negdetalles=" + negdetalles
				+ ", negdireccion=" + negdireccion + ", negemail=" + negemail + ", negcodpostal=" + negcodpostal
				+ ", negpassword=" + negpassword + ", negcelular=" + negcelular + ", neglogo=" + neglogo
				+ ", negestado=" + negestado + ", negusuario=" + negusuario + ", producto=" + producto + "]";
	}

}
