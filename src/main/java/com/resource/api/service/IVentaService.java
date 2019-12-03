package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Venta;

public interface IVentaService {
	
	public List<Venta>findAll();
	
	public void saveVenta(Venta venta);
	
	public Venta updateVenta(Venta venta);
	
	public Venta findById(Long venid);
	
	public List<Venta>getVentasEmpleado(Long empid);
	
	public void deleteProducto(Long venid);
	
}
