package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Solicitud;

public interface ISolicitudService {
	
	public List<Solicitud>findAll();
	
	public void saveSolicitud(Solicitud solicitud);
	
	public Solicitud updateSolicitud(Solicitud solicitud);
	
	public Solicitud findById(Long solid);
	
	public List<Solicitud>getSolicitudesNegocio(Long negid);
	
	public void deleteSolicitud(Long solid);


}
