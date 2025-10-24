package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.evaluacion.model.Servicio;
import com.sena.evaluacion.repository.IServicioRepository;

@Service
public class ServicioServiceImplement implements IServicioService {

	@Autowired
	private IServicioRepository servicioRepository;

	@Override
	public List<Servicio> listarTodos() {
		return servicioRepository.findAll();
	}

	@Override
	public Optional<Servicio> buscarPorId(Integer id) {
		return servicioRepository.findById(id);
	}

	@Override
	public Servicio guardar(Servicio servicio) {
		return servicioRepository.save(servicio);
	}

	@Override
	public void eliminar(Integer id) {
		servicioRepository.deleteById(id);
	}

	@Override
	public Servicio buscarPorNombre(String nombre) {
		return servicioRepository.findByNombre(nombre);
	}
}
