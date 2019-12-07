package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public void saveEmpleado(Empleado empleado);
	
	public List<Empleado>getEmpleadosNegocio(Long negid);
	
	public Empleado updateEmpleado(Empleado empleado);
	
	public Empleado findById(Long empid);
	
	public void deleteEmpleado(Long empid);
	
	public List<Empleado> joinedList();

}
