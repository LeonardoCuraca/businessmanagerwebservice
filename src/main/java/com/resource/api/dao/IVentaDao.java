package com.resource.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Venta;

public interface IVentaDao extends CrudRepository<Venta,Long> {
	
	public List<Venta>findByVenempleado(Long empid);
	public List<Venta>findByVenproducto(Long proid);
	public List<Venta>findByVennegocio(Long negid);
	
}
