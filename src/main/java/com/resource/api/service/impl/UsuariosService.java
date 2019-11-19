package com.resource.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IUsuarioDao;
import com.resource.api.entity.Usuario;
import com.resource.api.service.IUsuariosService;



@Service
public class UsuariosService implements IUsuariosService {
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {	
		return (List<Usuario>)usuarioDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuario(Usuario usuario) {
		return (Usuario)usuarioDao.findByUsuemail(usuario.getUsuemail());
	}
	@Override
	@Transactional
	public Usuario updateUsuario(Usuario usuario) {
		return (Usuario)usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findUsuarioById(Long usuid) {
		return(Optional<Usuario>)usuarioDao.findById(usuid);
	}

	@Override
	@Transactional
	public void deleteUsuario(Long usuid) {
		usuarioDao.deleteById(usuid);
		
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Long usuid) {
		return usuarioDao.findById(usuid).orElse(null);
	}
	
}
