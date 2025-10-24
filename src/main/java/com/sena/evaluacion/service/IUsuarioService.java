package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;
import com.sena.evaluacion.model.Usuario;

public interface IUsuarioService {

	List<Usuario> listarTodos(); // Obtener todos los usuarios

	Optional<Usuario> buscarPorId(Integer id); // Buscar usuario por ID

	Usuario guardar(Usuario usuario); // Crear o actualizar usuario

	void eliminar(Integer id); // Eliminar usuario por ID

	Usuario buscarPorEmail(String email); // Buscar usuario por email
}
