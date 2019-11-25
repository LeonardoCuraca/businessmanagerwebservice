package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public void saveEmpleado(Empleado empleado);
	
	public Empleado findEmpleadoById(Long empid);
	
	public Empleado findById(Long empid);
	
	public Empleado updateEmpleado(Empleado empleado);
	
	public void deleteEmpleado(Long empid);
}
