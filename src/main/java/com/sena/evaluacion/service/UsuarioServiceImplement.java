package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.evaluacion.model.Usuario;
import com.sena.evaluacion.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorId(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminar(Integer id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
}
