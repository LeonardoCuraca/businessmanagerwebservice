package com.resource.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Solicitud;

public interface ISolicitudDao extends CrudRepository<Solicitud,Long>{
	
	public List<Solicitud>findBySolineg(Long negid);
}
