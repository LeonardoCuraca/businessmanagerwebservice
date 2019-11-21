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
import com.resource.api.entity.Usuario;
import com.resource.api.service.INegociosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class NegociosController {

	@Autowired
	private INegociosService negocioService;

	@GetMapping("/negocio")
	public ResponseEntity<?> listaNegocios() {
		List<Negocio> listaNegocios = negocioService.findAll();
		if (listaNegocios != null) {
			if (listaNegocios.size() != 0) {
				return new ResponseEntity<>(listaNegocios, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/negocio/{negid}")
	public Negocio obtener(@PathVariable(value="negid")Long negid){
		Negocio negocio=negocioService.findById(negid);
		return negocio;
	}

	@PostMapping("/negocio")
	public ResponseEntity<?> agregarNegocio(@RequestBody Negocio negocio) {
		negocioService.saveNegocio(negocio);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/negocio_buscar")
	public ResponseEntity<?> verNegociosUsuario(@RequestBody Usuario usuario) {
		List<Negocio> listaNegocios = negocioService.getNegociosUsuario(usuario.getUsuid());
		if (listaNegocios != null) {
			if (listaNegocios.size() != 0) {
				return new ResponseEntity<>(listaNegocios, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/negocio/{negid}")
	public ResponseEntity<?> updateNegocio(@PathVariable(value ="negid")Long negid,@RequestBody Negocio negocio) {
		Negocio negDb = null;
		negDb=negocioService.findById(negid);
		if (negDb != null) {
			negDb.setNegnombre(negocio.getNegnombre());
			negDb.setNegdetalles(negocio.getNegdetalles());
			negDb.setNegdireccion(negocio.getNegdireccion());
			negDb.setNegemail(negocio.getNegemail());
			negDb.setNegcodpostal(negocio.getNegcodpostal());
			negDb.setNegpassword(negocio.getNegpassword());
			negDb.setNegcelular(negocio.getNegcelular());
			negDb.setNeglogo(negocio.getNeglogo());
			negDb.setNegestado(negocio.getNegestado());
			negocioService.updateNegocio(negDb);
			return new ResponseEntity<>(negDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/negocio/{negid}")
	public ResponseEntity<?>deleteNegocio(@PathVariable(value="negid")Long negid){
		negocioService.deleteNegocio(negid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
