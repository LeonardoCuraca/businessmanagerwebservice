package com.resource.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado,Long>{
	
	public List<Empleado>findByEmpneg(Long negid);
	
	@Query(value = "SELECT e.emparea, e.empsueldo, e.empentrada, e.empsalida, u.usuid, u.usunombre, u.usuapellido FROM empleados e INNER JOIN usuarios u ON u.usuid = e.empid", nativeQuery = true)
	public List<Object> joinedList();
	
}
