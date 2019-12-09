package com.resource.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Negocio;

public interface INegocioDao extends CrudRepository<Negocio,Long>{

	public List<Negocio>findByNegusuario(Long usuid);
	@Query(value = "select * from negocios where negid = ?1 and negpassword = ?2", nativeQuery = true)
	public Negocio login(Long negid, String negpassword);
}
