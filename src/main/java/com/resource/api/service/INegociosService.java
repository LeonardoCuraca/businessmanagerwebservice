package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Negocio;


public interface INegociosService {
	
	public List<Negocio>findAll();
	public void saveNegocio(Negocio negocio);
	public Negocio updateNegocio(Negocio negocio);
	public List<Negocio>getNegociosUsuario(Long usuid);
	public Negocio findById(Long negid);
	public void deleteNegocio(Long negid);
}
