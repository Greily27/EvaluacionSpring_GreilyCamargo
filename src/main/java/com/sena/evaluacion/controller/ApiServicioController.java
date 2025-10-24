package com.sena.evaluacion.controller;

import com.sena.evaluacion.model.Servicio;
import com.sena.evaluacion.service.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicios")
public class ApiServicioController {

	@Autowired
	private IServicioService servicioService;

	// Listar todos
	@GetMapping
	public ResponseEntity<List<Servicio>> listarTodos() {
		return ResponseEntity.ok(servicioService.listarTodos());
	}

	// Buscar por ID
	@GetMapping("/{id}")
	public ResponseEntity<Servicio> buscarPorId(@PathVariable Integer id) {
		Optional<Servicio> servicio = servicioService.buscarPorId(id);
		return servicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Crear nuevo servicio
	@PostMapping
	public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
		return ResponseEntity.ok(servicioService.guardar(servicio));
	}

	// Actualizar servicio
	@PutMapping("/{id}")
	public ResponseEntity<Servicio> actualizarServicio(@PathVariable Integer id, @RequestBody Servicio servicio) {
		Optional<Servicio> existente = servicioService.buscarPorId(id);
		if (existente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		servicio.setId(id);
		return ResponseEntity.ok(servicioService.guardar(servicio));
	}

	// Eliminar servicio
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarServicio(@PathVariable Integer id) {
		Optional<Servicio> existente = servicioService.buscarPorId(id);
		if (existente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		servicioService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
