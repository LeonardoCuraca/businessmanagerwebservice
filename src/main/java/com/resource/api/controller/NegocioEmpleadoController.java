package com.resource.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.api.entity.Empleado;
import com.resource.api.entity.Negocio;
import com.resource.api.entity.NegocioEmpleado;
import com.resource.api.service.IEmpleadoService;
import com.resource.api.service.INegociosService;

@RestController
@RequestMapping("/api")
public class NegocioEmpleadoController {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private INegociosService negocioService;
	
	@GetMapping("/negocio/empleado")
	public ResponseEntity<?>listaEmpleadoNegocio(@RequestBody Negocio negocio){
		Negocio negDb=negocioService.findById(negocio.getNegid());
		if(negDb!=null) {
			Collection<Empleado>listaEmpleados=negDb.getEmpleados();
			if(listaEmpleados!=null) {
				return new ResponseEntity<>(listaEmpleados,HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/negocio/empleado")
	public ResponseEntity<?>saveEmpleadoNegocio(@RequestBody NegocioEmpleado negocioEmpleado){
		Negocio negDb=negocioService.findById(negocioEmpleado.getNegocio().getNegid());
		if(negDb!=null) {
			Empleado empDb=empleadoService.findEmpleadoById(negocioEmpleado.getEmpleado().getEmpid());
			negDb.addEmpleado(empDb);
			negocioService.saveNegocio(negDb);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
}
