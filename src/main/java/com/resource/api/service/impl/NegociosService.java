package com.resource.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.INegocioDao;
import com.resource.api.entity.Negocio;
import com.resource.api.service.INegociosService;


@Service
public class NegociosService implements INegociosService{
	
	@Autowired
	private INegocioDao negocioDao;
	
	@Transactional(readOnly=true)
	public List<Negocio>findAll() {
		return(List<Negocio>) negocioDao.findAll();
	}

	@Override
	public void saveNegocio(Negocio negocio) {
		negocioDao.save(negocio);
		
	}
	
	@Override
	public List<Negocio> getNegociosUsuario(Integer usuid) {
		return (List<Negocio>)negocioDao.findByNegusuario(usuid);
	}

	@Override
	public Negocio updateNegocio(Negocio negocio) {
		return (Negocio)negocioDao.save(negocio);
	}

	@Override
	@Transactional(readOnly=true)
	public Negocio findById(Integer negid) {
		return negocioDao.findById(negid).orElse(null);
	}

	@Override
	public void deleteNegocio(Integer negid) {
		negocioDao.deleteById(negid);
	}



}
