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
		Long id = usuario.getUsuid();
		if(usuarioService.findById(id)==null) {
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
	@PutMapping("/usuarios/{usuid}/portada")
	public ResponseEntity<?>updateUsuarioPortada(@PathVariable(value="usuid")Long usuid,@RequestBody Usuario usuario){
		Usuario usuarioDb=null;	
		usuarioDb=usuarioService.findById(usuid);
		if(usuarioDb!=null) {
			usuarioDb.setUsuPortada(usuario.getUsuPortada());
			usuarioService.updateUsuario(usuarioDb);
			return new ResponseEntity<>(usuarioDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	@PutMapping("/usuarios/{usuid}/foto")
	public ResponseEntity<?>updateUsuarioFoto(@PathVariable(value="usuid")Long usuid,@RequestBody Usuario usuario){
		Usuario usuarioDb=null;	
		usuarioDb=usuarioService.findById(usuid);
		if(usuarioDb!=null) {
			usuarioDb.setUsufoto(usuario.getUsufoto());
			usuarioService.updateUsuario(usuarioDb);
			return new ResponseEntity<>(usuarioDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	@PutMapping("/usuarios/{usuid}/skills")
	public ResponseEntity<?>updateUsuarioSkills(@PathVariable(value="usuid")Long usuid,@RequestBody Usuario usuario){
		Usuario usuarioDb=null;	
		usuarioDb=usuarioService.findById(usuid);
		if(usuarioDb!=null) {
			usuarioDb.setHonestidad(usuario.getHonestidad());
			usuarioDb.setConfianza(usuario.getConfianza());
			usuarioDb.setCreatividad(usuario.getCreatividad());
			usuarioDb.setComunicacion(usuario.getComunicacion());
			usuarioDb.setCooperacion(usuario.getCooperacion());
			usuarioDb.setRespeto(usuario.getRespeto());
			usuarioDb.setFlexibilidad(usuario.getFlexibilidad());
			usuarioDb.setDedicacion(usuario.getDedicacion());
			usuarioDb.setIniciativa(usuario.getIniciativa());
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