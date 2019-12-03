package com.resource.api.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IVentaDao;
import com.resource.api.entity.Venta;
import com.resource.api.service.IVentaService;

@Service
public class VentasService implements IVentaService {
	
	@Autowired
	private IVentaDao ventaDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Venta> findAll() {
		return(List<Venta>)ventaDao.findAll();
	}

	@Override
	public void saveVenta(Venta venta) {
		ventaDao.save(venta);
		
	}

	@Override
	public Venta updateVenta(Venta venta) {
		return(Venta)ventaDao.save(venta);
	}

	@Override
	public Venta findById(Long venid) {
		return ventaDao.findById(venid).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	@Transactional(readOnly=true)
	public List<Venta> getVentasEmpleado(Long empid) {
		return(List<Venta>)ventaDao.findByVenempleado(empid);
	}

	@Override
	public void deleteProducto(Long venid) {
		ventaDao.deleteById(venid);
		
	}

}
