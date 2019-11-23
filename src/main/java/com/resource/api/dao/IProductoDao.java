package com.resource.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.resource.api.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	public List<Producto>findByProneg(Long negid);
	
}
