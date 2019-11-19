package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Producto;

public interface IProductoService {
	
	public List<Producto>findAll();
	
	public void saveProducto(Producto producto);
	
	public List<Producto>getProductosNegocio(Long negid);
	
}
