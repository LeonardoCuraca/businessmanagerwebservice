package com.resource.api.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.api.dao.ISolicitudDao;
import com.resource.api.entity.Solicitud;
import com.resource.api.service.ISolicitudService;

@Service
public class SolicitudesService implements ISolicitudService{
	
	@Autowired
	private ISolicitudDao solicitudDao;
	
	@Override
	public List<Solicitud> findAll() {
		return(List<Solicitud>)solicitudDao.findAll();
	}

	@Override
	public void saveSolicitud(Solicitud solicitud) {
		solicitudDao.save(solicitud);
	}

	@Override
	public Solicitud updateSolicitud(Solicitud solicitud) {
		return(Solicitud)solicitudDao.save(solicitud);
	}

	@Override
	public Solicitud findById(Long solid) {
		return solicitudDao.findById(solid).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public List<Solicitud> getSolicitudesNegocio(Long negid) {
		return(List<Solicitud>)solicitudDao.findBySolineg(negid);
	}

	@Override
	public void deleteSolicitud(Long solid) {
		solicitudDao.deleteById(solid);
		
	}

}
