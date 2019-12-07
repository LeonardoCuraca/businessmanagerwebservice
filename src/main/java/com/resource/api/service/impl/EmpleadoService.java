package com.resource.api.service.impl;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IEmpleadoDao;
import com.resource.api.entity.Empleado;

import com.resource.api.service.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Empleado> findAll() {
		return(List<Empleado>)empleadoDao.findAll();
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		empleadoDao.save(empleado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Empleado> getEmpleadosNegocio(Long negid) {
		return(List<Empleado>)empleadoDao.findByEmpneg(negid);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		return(Empleado)empleadoDao.save(empleado);
	}

	@Override
	public Empleado findById(Long empid) {
		return empleadoDao.findById(empid).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void deleteEmpleado(Long empid) {
		empleadoDao.deleteById(empid);
		
	}

	@Override
	public List<Empleado> joinedList() {
		return empleadoDao.joinedList();
	}

}
