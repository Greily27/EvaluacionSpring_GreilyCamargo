package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;
import com.sena.evaluacion.model.Profesional;

public interface IProfesionalService {

	List<Profesional> listarTodos(); // Listar todos los profesionales

	Optional<Profesional> buscarPorId(Integer id); // Buscar profesional por ID

	Profesional guardar(Profesional profesional); // Crear o actualizar profesional

	void eliminar(Integer id); // Eliminar por ID

	Profesional buscarPorEspecialidad(String especialidad); // Buscar por especialidad
}
