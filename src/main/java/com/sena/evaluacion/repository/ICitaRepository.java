package com.sena.evaluacion.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.evaluacion.model.Cita;
import com.sena.evaluacion.model.Profesional;
import com.sena.evaluacion.model.Usuario;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {

	// Buscar citas por usuario
	List<Cita> findByUsuario(Usuario usuario);

	// Buscar citas por profesional
	List<Cita> findByProfesional(Profesional profesional);

	// Buscar citas por estado (Pendiente, Confirmada, Cancelada)
	List<Cita> findByEstado(String estado);

	// Buscar citas en una fecha específica
	List<Cita> findByFechahoraBetween(Date inicio, Date fin);
}
