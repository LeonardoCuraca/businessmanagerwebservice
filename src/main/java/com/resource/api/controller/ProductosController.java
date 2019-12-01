package com.resource.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.api.entity.Negocio;
import com.resource.api.entity.Producto;
import com.resource.api.service.IProductoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductosController {
		
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public ResponseEntity<?>listaProductos(){
		List<Producto>listaProductos=productoService.findAll();	
		if(listaProductos!=null) {
			if(listaProductos.size()!=0) {
				return new ResponseEntity<>(listaProductos,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/productos/{proid}")
	public Producto obtener(@PathVariable(value="proid")Long proid) {
		Producto producto=productoService.findById(proid);
		return producto;
	}
	@PostMapping("/productos")
	public ResponseEntity<?>agregarProducto(@RequestBody Producto producto){
		productoService.saveProducto(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PostMapping("/productos/buscar")
	public ResponseEntity<?>verProductosNegocio(@RequestBody Negocio negocio){
		List<Producto> listaProductos=productoService.getProductosNegocio(negocio.getNegid());
		if(listaProductos!=null) {
			if(listaProductos.size()!=0) {
				return new ResponseEntity<>(listaProductos,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/productos/{proid}")
	public ResponseEntity<?> updateProducto(@PathVariable(value ="proid") Long proid,@RequestBody Producto producto) {
		Producto proDb = null;
		proDb=productoService.findById(proid);
		if (proDb != null) {
			proDb.setProcodigo(producto.getProcodigo());
			proDb.setPronombre(producto.getPronombre());
			proDb.setProstock(producto.getProstock());
			proDb.setProprecio(producto.getProprecio());
			proDb.setProdetalles(producto.getProdetalles());	
			productoService.updateProducto(proDb);
			return new ResponseEntity<>(proDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/productos/{proid}")
	public ResponseEntity<?>deleteProducto(@PathVariable(value="proid")Long proid){
		productoService.deleteProducto(proid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}