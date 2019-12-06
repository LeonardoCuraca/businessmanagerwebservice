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

import com.resource.api.entity.Solicitud;
import com.resource.api.service.ISolicitudService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SolicitudesController {
	
	@Autowired
	private ISolicitudService solicitudService;
	
	@GetMapping("/solicitudes")
	public ResponseEntity<?>listaSolicitudes(){
		List<Solicitud>listaSolicitudes=solicitudService.findAll();	
		if(listaSolicitudes!=null) {
			if(listaSolicitudes.size()!=0) {
				return new ResponseEntity<>(listaSolicitudes,HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/solicitudes/{solid}")
	public Solicitud obtener(@PathVariable(value="solid")Long solid) {
		Solicitud solicitud=solicitudService.findById(solid);
		return solicitud;
	}
	
	@PostMapping("/solicitudes")
	public ResponseEntity<?>agregarSolicitud(@RequestBody Solicitud solicitud){
		solicitudService.saveSolicitud(solicitud);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	@PutMapping("/solicitudes/{solid}")
	public ResponseEntity<?> updateSolicitud(@PathVariable(value ="solid") Long solid,@RequestBody Solicitud solicitud) {
		Solicitud soliDb = null;
		soliDb=solicitudService.findById(solid);
		if (soliDb != null) {
			soliDb.setSolinombre(solicitud.getSolinombre());
			soliDb.setSoliapellido(solicitud.getSoliapellido());
			soliDb.setSoliemail(solicitud.getSoliemail());
			soliDb.setSolicelular(solicitud.getSolicelular());
			soliDb.setSolimensaje(solicitud.getSolimensaje());
			solicitudService.updateSolicitud(soliDb);
			return new ResponseEntity<>(soliDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}

	@DeleteMapping("/solicitudes/{solid}")
	public ResponseEntity<?>deleteProducto(@PathVariable(value="solid")Long solid){
		solicitudService.deleteSolicitud(solid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
