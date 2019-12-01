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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resource.api.entity.Usuario;
import com.resource.api.service.IUsuariosService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService usuarioService;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario>getUsuarios(){
		return usuarioService.findAll();
	}
	@GetMapping("/usuarios/{usuid}")
	public Usuario obtener(@PathVariable(value="usuid")Long usuid) {
		Usuario usuario=usuarioService.findById(usuid);
		return usuario;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Void>addUsuario(@RequestBody Usuario usuario){
		if(usuarioService.findUsuario(usuario)==null) {
			usuarioService.save(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	@PutMapping("/usuarios/{usuid}")
	public ResponseEntity<?>updateUsuario(@PathVariable(value="usuid")Long usuid,@RequestBody Usuario usuario){
		Usuario usuarioDb=null;	
		usuarioDb=usuarioService.findById(usuid);
		if(usuarioDb!=null) {
			usuarioDb.setUsunombre(usuario.getUsunombre());
			usuarioDb.setUsuapellido(usuario.getUsuapellido());
			usuarioDb.setUsuemail(usuario.getUsuemail());
			usuarioDb.setUsudetalle(usuario.getUsudetalle());
			usuarioDb.setUsugenero(usuario.getUsugenero());
			usuarioDb.setUsudireccion(usuario.getUsudireccion());
			usuarioDb.setUsufoto(usuario.getUsufoto());
			usuarioDb.setUsucelular(usuario.getUsucelular());
			usuarioService.updateUsuario(usuarioDb);
			return new ResponseEntity<>(usuarioDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	@DeleteMapping("/usuarios/{usuid}")
	public ResponseEntity<Void>deleteUsuario(@PathVariable(value="usuid")Long usuid){
		usuarioService.deleteUsuario(usuid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
}