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
import com.resource.api.entity.Negocio;
import com.resource.api.service.IEmpleadoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmpleadosController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public ResponseEntity<?>listaEmpleados(){
		List<Empleado>listaEmpleados=empleadoService.joinedList();
		if(listaEmpleados!=null) {
			if(listaEmpleados.size()!=0) {
				return new ResponseEntity<>(listaEmpleados,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	
	} 
	@GetMapping("/empleados/{empid}")
	public Empleado obtener(@PathVariable(value="empid")Long empid) {
		Empleado empleado=empleadoService.findById(empid);
		return empleado;
	}
	@PostMapping("/empleados")
	public ResponseEntity<?>agregarEmpleado(@RequestBody Empleado empleado){
		empleadoService.saveEmpleado(empleado);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PostMapping("/empleados/buscar")
	public ResponseEntity<?>verEmpleadosNegocio(@RequestBody Negocio negocio){
		List<Empleado> listaEmpleados=empleadoService.getEmpleadosNegocio(negocio.getNegid());
		if(listaEmpleados!=null) {
			if(listaEmpleados.size()!=0) {
				return new ResponseEntity<>(listaEmpleados,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/empleados/{empid}")
	public ResponseEntity<?>updateEmpleado(@PathVariable(value="empid")Long empid,@RequestBody Empleado empleado){
		Empleado empDb=null;
		empDb=empleadoService.findById(empid);
		if(empDb!=null) {
			empDb.setEmparea(empleado.getEmparea());
			empDb.setEmpsueldo(empleado.getEmpsueldo());
			empDb.setEmpentrada(empleado.getEmpentrada());
			empDb.setEmpsalida(empleado.getEmpsalida());
			empleadoService.updateEmpleado(empDb);
			return new ResponseEntity<>(empDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/empleados/{empid}")
	public ResponseEntity<?>deleteProducto(@PathVariable(value="empid")Long empid){
		empleadoService.deleteEmpleado(empid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
