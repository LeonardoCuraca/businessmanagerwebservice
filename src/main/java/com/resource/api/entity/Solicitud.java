package com.resource.api.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes")
public class Solicitud implements Serializable {
	
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long solid;
	private String solinombre;
	private String soliapellido;
	private String soliemail;
	private String solicelular;
	private String solimensaje;
	private Long soliusu;
	private Long solineg;
	@Column(name = "solifecha", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp solifecha;
	public String soliimage;
	
	
	
	public Solicitud() {
		
	}
	
	public Long getSolid() {
		return solid;
	}
	public void setSolid(Long solid) {
		this.solid = solid;
	}
	public String getSolinombre() {
		return solinombre;
	}
	public void setSolinombre(String solinombre) {
		this.solinombre = solinombre;
	}
	
	public String getSoliapellido() {
		return soliapellido;
	}

	public void setSoliapellido(String soliapellido) {
		this.soliapellido = soliapellido;
	}

	public String getSoliemail() {
		return soliemail;
	}
	public void setSoliemail(String soliemail) {
		this.soliemail = soliemail;
	}
	public String getSolicelular() {
		return solicelular;
	}
	public void setSolicelular(String solicelular) {
		this.solicelular = solicelular;
	}
	public String getSolimensaje() {
		return solimensaje;
	}
	public void setSolimensaje(String solimensaje) {
		this.solimensaje = solimensaje;
	}
	public Long getSoliusu() {
		return soliusu;
	}
	public void setSoliusu(Long soliusu) {
		this.soliusu = soliusu;
	}
	public Long getSolineg() {
		return solineg;
	}
	public void setSolineg(Long solineg) {
		this.solineg = solineg;
	}
	
	
	public Timestamp getSolifecha() {
		return solifecha;
	}

	public void setSolifecha(Timestamp solifecha) {
		this.solifecha = solifecha;
	}

	public String getSoliimage() {
		return soliimage;
	}

	public void setSoliimage(String soliimage) {
		this.soliimage = soliimage;
	}


	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Solicitud [solid=" + solid + ", solinombre=" + solinombre + ", soliapellido=" + soliapellido
				+ ", soliemail=" + soliemail + ", solicelular=" + solicelular + ", solimensaje=" + solimensaje
				+ ", soliusu=" + soliusu + ", solineg=" + solineg + "]";
	}

}
