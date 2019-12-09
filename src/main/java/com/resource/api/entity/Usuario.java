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
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	@Id
	private Long usuid;
	private String usunombre;
	private String usuapellido;
	private String usuemail;
	private String usugenero;
	private String usudetalle;
	private String usudireccion;
	private String usufoto;
	private String usuPortada;
	private String usucelular;
	private int honestidad;
	private int confianza;
	private int creatividad;
	private int comunicacion;
	private int cooperacion;
	private int respeto;
	private int flexibilidad;
	private int dedicacion;
	private int iniciativa;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empusu",referencedColumnName="usuid")
	private List<Empleado> empleado=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="soliusu",referencedColumnName="usuid")
	private List<Solicitud> solicitud=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="negusuario",referencedColumnName="usuid")
	
	private List<Negocio> negocio=new ArrayList<>();
	

	public List<Solicitud> getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(List<Solicitud> solicitud) {
		this.solicitud = solicitud;
	}
	
	public List<Empleado> getEmpleado() {
		return empleado;
	}
	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}
	public List<Negocio> getNegocio() {
		return negocio;
	}
	public void setNegocio(List<Negocio> negocio) {
		this.negocio = negocio;
	}
	
	public Long getUsuid() {
		return usuid;
	}
	public void setUsuid(Long usuid) {
		this.usuid = usuid;
	}
	public String getUsunombre() {
		return usunombre;
	}
	public void setUsunombre(String usunombre) {
		this.usunombre = usunombre;
	}
	public String getUsuapellido() {
		return usuapellido;
	}
	public void setUsuapellido(String usuapellido) {
		this.usuapellido = usuapellido;
	}
	public String getUsuemail() {
		return usuemail;
	}
	public void setUsuemail(String usuemail) {
		this.usuemail = usuemail;
	}
	public String getUsugenero() {
		return usugenero;
	}
	public void setUsugenero(String usugenero) {
		this.usugenero = usugenero;
	}
	public String getUsudetalle() {
		return usudetalle;
	}
	public void setUsudetalle(String usudetalle) {
		this.usudetalle = usudetalle;
	}
	public String getUsudireccion() {
		return usudireccion;
	}
	public void setUsudireccion(String usudireccion) {
		this.usudireccion = usudireccion;
	}
	public String getUsufoto() {
		return usufoto;
	}
	public void setUsufoto(String usufoto) {
		this.usufoto = usufoto;
	}
	public String getUsucelular() {
		return usucelular;
	}
	public void setUsucelular(String usucelular) {
		this.usucelular = usucelular;
	}
	
	public int getHonestidad() {
		return honestidad;
	}
	public void setHonestidad(int honestidad) {
		this.honestidad = honestidad;
	}
	public int getConfianza() {
		return confianza;
	}
	public void setConfianza(int confianza) {
		this.confianza = confianza;
	}
	public int getCreatividad() {
		return creatividad;
	}
	public void setCreatividad(int creatividad) {
		this.creatividad = creatividad;
	}
	public int getComunicacion() {
		return comunicacion;
	}
	public void setComunicacion(int comunicacion) {
		this.comunicacion = comunicacion;
	}
	public int getCooperacion() {
		return cooperacion;
	}
	public void setCooperacion(int cooperacion) {
		this.cooperacion = cooperacion;
	}
	public int getRespeto() {
		return respeto;
	}
	public void setRespeto(int respeto) {
		this.respeto = respeto;
	}
	public int getFlexibilidad() {
		return flexibilidad;
	}
	public void setFlexibilidad(int flexibilidad) {
		this.flexibilidad = flexibilidad;
	}
	public int getDedicacion() {
		return dedicacion;
	}
	public void setDedicacion(int dedicacion) {
		this.dedicacion = dedicacion;
	}
	public int getIniciativa() {
		return iniciativa;
	}
	public void setIniciativa(int iniciativa) {
		this.iniciativa = iniciativa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsuPortada() {
		return usuPortada;
	}
	public void setUsuPortada(String usuPortada) {
		this.usuPortada = usuPortada;
	}



	private static final long serialVersionUID=1L;


	@Override
	public String toString() {
		return "Usuario [usuid=" + usuid + ", usunombre=" + usunombre + ", usuapellido=" + usuapellido + ", usuemail="
				+ usuemail + ", usugenero=" + usugenero + ", usudetalle=" + usudetalle + ", usudireccion="
				+ usudireccion + ", usufoto=" + usufoto + ", usucelular=" + usucelular + ", negocio=" + negocio + "]";
	}
	

}
