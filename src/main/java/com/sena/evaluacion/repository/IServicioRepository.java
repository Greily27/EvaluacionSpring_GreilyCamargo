package com.sena.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.evaluacion.model.Servicio;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

	// Método personalizado (opcional)
	Servicio findByNombre(String nombre);
}
