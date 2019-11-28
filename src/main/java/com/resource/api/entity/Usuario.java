package com.resource.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

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
	private String usucelular;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="negusuario",referencedColumnName="usuid")
	private List<Negocio> negocio=new ArrayList<>();
	

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
	private static final long serialVersionUID=1L;
	
	@Override
	public String toString() {
		return "Usuario [usuid=" + usuid + ", usunombre=" + usunombre + ", usuapellido=" + usuapellido + ", usuemail="
				+ usuemail + ", usugenero=" + usugenero + ", usudetalle=" + usudetalle + ", usudireccion="
				+ usudireccion + ", usufoto=" + usufoto + ", usucelular=" + usucelular + "]";
	}
	

}
