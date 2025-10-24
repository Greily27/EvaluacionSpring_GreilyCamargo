package com.sena.evaluacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.evaluacion.model.Cita;
import com.sena.evaluacion.model.Profesional;
import com.sena.evaluacion.model.Usuario;
import com.sena.evaluacion.repository.ICitaRepository;

@Service
public class CitaServiceImplement implements ICitaService {

	@Autowired
	private ICitaRepository citaRepository;

	@Override
	public List<Cita> listarTodas() {
		return citaRepository.findAll();
	}

	@Override
	public Optional<Cita> buscarPorId(Integer id) {
		return citaRepository.findById(id);
	}

	@Override
	public Cita guardar(Cita cita) {
		return citaRepository.save(cita);
	}

	@Override
	public void eliminar(Integer id) {
		citaRepository.deleteById(id);
	}

	@Override
	public List<Cita> buscarPorUsuario(Usuario usuario) {
		return citaRepository.findByUsuario(usuario);
	}

	@Override
	public List<Cita> buscarPorProfesional(Profesional profesional) {
		return citaRepository.findByProfesional(profesional);
	}

	@Override
	public List<Cita> buscarPorEstado(String estado) {
		return citaRepository.findByEstado(estado);
	}

	@Override
	public List<Cita> buscarPorRangoFecha(Date inicio, Date fin) {
		return citaRepository.findByFechahoraBetween(inicio, fin);
	}
}
