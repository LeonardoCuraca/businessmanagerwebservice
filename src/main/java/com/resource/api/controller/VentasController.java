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

import com.resource.api.entity.Empleado;
import com.resource.api.entity.Producto;
import com.resource.api.entity.Venta;
import com.resource.api.service.IProductoService;
import com.resource.api.service.IVentaService;
import com.resource.api.service.impl.ProductosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class VentasController {
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IProductoService iproductoservice;
	
	@GetMapping("/ventas")
	public ResponseEntity<?>listaVentas(){
		List<Venta>listaVentas=ventaService.findAll();	
		if(listaVentas!=null) {
			if(listaVentas.size()!=0) {
				return new ResponseEntity<>(listaVentas,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/ventas/{venid}")
	public Venta obtener(@PathVariable(value="venid")Long venid) {
		Venta venta=ventaService.findById(venid);
		return venta;
	}
	@PostMapping("/ventas")
	public ResponseEntity<?>agregarProducto(@RequestBody Venta venta){
		Producto producto = iproductoservice.findById(venta.getVenproducto());
		if (venta.getVencantidad() <= producto.getProstock()) {
			ventaService.saveVenta(venta);
			producto.setProstock(producto.getProstock() - venta.getVencantidad());
			iproductoservice.updateProducto(producto); 
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	@PostMapping("/ventas/buscar")
	public ResponseEntity<?>verVentasEmpleado(@RequestBody Empleado empleado){
		List<Venta> listaVentas=ventaService.getVentasEmpleado(empleado.getEmpid());
		if(listaVentas!=null) {
			if(listaVentas.size()!=0) {
				return new ResponseEntity<>(listaVentas,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/ventas/{venid}")
	public ResponseEntity<?> updateVenta(@PathVariable(value ="venid") Long venid,@RequestBody Venta venta) {
		Venta venDb = null;
		venDb=ventaService.findById(venid);
		if (venDb != null) {
			venDb.setVencantidad(venta.getVencantidad());;
			venDb.setVenprecio(venta.getVenprecio());;
			venDb.setVentotal(venta.getVentotal());;
			venDb.setVenfecha(venta.getVenfecha());;
			ventaService.updateVenta(venDb);
			return new ResponseEntity<>(venDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/ventas/{venid}")
	public ResponseEntity<?>deleteProducto(@PathVariable(value="venid")Long venid){
		ventaService.deleteProducto(venid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
