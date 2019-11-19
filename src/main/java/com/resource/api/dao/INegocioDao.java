package com.resource.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Negocio;

public interface INegocioDao extends CrudRepository<Negocio, Long>{

	public List<Negocio>findByNegusuario(Long negusuario);
	
}
