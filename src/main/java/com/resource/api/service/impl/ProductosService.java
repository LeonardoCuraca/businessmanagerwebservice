package com.resource.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IProductoDao;
import com.resource.api.entity.Producto;
import com.resource.api.service.IProductoService;

@Service
public class ProductosService implements IProductoService{
	
	@Autowired(required=true)
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return(List<Producto>)productoDao.findAll();
	}

	@Override
	public void saveProducto(Producto producto) {
		productoDao.save(producto);
		
	}

	@Override
	public List<Producto> getProductosNegocio(Long negid) {
		return(List<Producto>)productoDao.findByProneg(negid);
	}

	
}
