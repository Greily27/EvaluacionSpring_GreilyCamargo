package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;
import com.sena.evaluacion.model.Servicio;

public interface IServicioService {

	List<Servicio> listarTodos(); // Listar todos los servicios

	Optional<Servicio> buscarPorId(Integer id); // Buscar por ID

	Servicio guardar(Servicio servicio); // Crear o actualizar

	void eliminar(Integer id); // Eliminar por ID

	Servicio buscarPorNombre(String nombre); // Buscar por nombre
}
