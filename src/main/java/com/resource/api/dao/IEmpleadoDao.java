package com.resource.api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long> {
	
	@Query("select e from Empleado e where e.empid=?1")
	public Empleado findByIdSQL(Long empid);

}
