package com.sena.evaluacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sena.evaluacion.model.Cita;
import com.sena.evaluacion.model.Profesional;
import com.sena.evaluacion.model.Usuario;

public interface ICitaService {

	List<Cita> listarTodas(); // Listar todas las citas

	Optional<Cita> buscarPorId(Integer id); // Buscar cita por ID

	Cita guardar(Cita cita); // Crear o actualizar cita

	void eliminar(Integer id); // Eliminar cita

	List<Cita> buscarPorUsuario(Usuario usuario); // Buscar por usuario

	List<Cita> buscarPorProfesional(Profesional profesional); // Buscar por profesional

	List<Cita> buscarPorEstado(String estado); // Buscar por estado

	List<Cita> buscarPorRangoFecha(Date inicio, Date fin); // Buscar entre fechas
}
