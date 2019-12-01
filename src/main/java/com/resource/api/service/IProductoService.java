package com.resource.api.service;

import java.util.List;

import com.resource.api.entity.Producto;

public interface IProductoService {
	
	public List<Producto>findAll();
	
	public void saveProducto(Producto producto);
	
	public Producto updateProducto(Producto producto);
	
	public Producto findById(Long proid);
	
	public List<Producto>getProductosNegocio(Long negid);
	
	public void deleteProducto(Long proid);
	
}
