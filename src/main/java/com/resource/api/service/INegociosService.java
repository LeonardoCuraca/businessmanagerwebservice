package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Negocio;


public interface INegociosService {
	
	public List<Negocio>findAll();
	public void saveNegocio(Negocio negocio);
	public Negocio updateNegocio(Negocio negocio);
	public List<Negocio>getNegociosUsuario(Integer usuid);
	public Negocio findById(Integer negid);
	public void deleteNegocio(Integer negid);
}
