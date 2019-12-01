package com.resource.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long>{
	
	public List<Empleado>findByEmpneg(Long negid);
	

	
}
