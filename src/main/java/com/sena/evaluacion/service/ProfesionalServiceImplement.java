package com.sena.evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.evaluacion.model.Profesional;
import com.sena.evaluacion.repository.IProfesionalRepository;

@Service
public class ProfesionalServiceImplement implements IProfesionalService {

	@Autowired
	private IProfesionalRepository profesionalRepository;

	@Override
	public List<Profesional> listarTodos() {
		return profesionalRepository.findAll();
	}

	@Override
	public Optional<Profesional> buscarPorId(Integer id) {
		return profesionalRepository.findById(id);
	}

	@Override
	public Profesional guardar(Profesional profesional) {
		return profesionalRepository.save(profesional);
	}

	@Override
	public void eliminar(Integer id) {
		profesionalRepository.deleteById(id);
	}

	@Override
	public Profesional buscarPorEspecialidad(String especialidad) {
		return profesionalRepository.findByEspecialidad(especialidad);
	}
}
