package com.resource.api.service;

import java.util.List;
import java.util.Optional;

import com.resource.api.entity.Usuario;



public interface IUsuariosService {
	
	public List<Usuario> findAll();
	public Usuario findUsuario(Usuario usuario);
	public void save(Usuario usuario);
	public  Usuario updateUsuario(Usuario usuario);
	public Optional<Usuario>findUsuarioById(Integer usuid);
	public void deleteUsuario(Integer usuid);
	public Usuario findById(Integer usuid);
}
