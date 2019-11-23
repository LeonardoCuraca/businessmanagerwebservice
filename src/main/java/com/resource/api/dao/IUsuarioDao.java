package com.resource.api.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	public Usuario findByUsuemail(String usuemail);
	public Optional<Usuario>findById(Long usuid);
	
}
