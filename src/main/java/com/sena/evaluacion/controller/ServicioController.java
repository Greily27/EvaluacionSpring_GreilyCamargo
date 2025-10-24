package com.sena.evaluacion.controller;

import com.sena.evaluacion.model.Cita;
import com.sena.evaluacion.model.Servicio;
import com.sena.evaluacion.service.ICitaService;
import com.sena.evaluacion.service.IProfesionalService;
import com.sena.evaluacion.service.IServicioService;
import com.sena.evaluacion.service.IUsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private IServicioService servicioService;
	private IProfesionalService profesionalService;
	private IUsuarioService usuarioService;
	private ICitaService citaService;

	@GetMapping("/servicios")
	public String servicios() {
		return "servicios"; // <- nombre exacto del archivo servicios.html
	}

	@GetMapping("/")
	public String index() {
		return "index"; // <- para tu index.html
	}

	@GetMapping
	public String listarServicios(Model model) {
		model.addAttribute("servicios", servicioService.listarTodos());
		return "servicios"; // Nombre de la vista
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "servicios/formulario";
	}

	@PostMapping("/guardar")
	public String guardarServicio(@ModelAttribute Servicio servicio) {
		servicioService.guardar(servicio);
		return "redirect:/servicios";
	}

	@GetMapping("/editar/{id}")
	public String editarServicio(@PathVariable Integer id, Model model) {
		Servicio servicio = servicioService.buscarPorId(id).orElse(null);
		model.addAttribute("servicio", servicio);
		return "servicios/formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarServicio(@PathVariable Integer id) {
		servicioService.eliminar(id);
		return "redirect:/servicios";
	}

	// ================================
	// GESTIÓN DE CITAS POR SERVICIO
	// ================================

	@GetMapping("/{id}/citas")
	public String listarCitasPorServicio(@PathVariable Integer id, Model model) {
		Servicio servicio = servicioService.buscarPorId(id).orElse(null);
		List<Cita> citas = citaService.listarTodas().stream().filter(c -> c.getServicio().getId().equals(id)).toList();

		model.addAttribute("servicio", servicio);
		model.addAttribute("citas", citas);
		return "servicios/citas"; // -> vista nueva
	}

	@GetMapping("/{id}/citas/nueva")
	public String nuevaCitaParaServicio(@PathVariable Integer id, Model model) {
		Cita cita = new Cita();
		cita.setServicio(servicioService.buscarPorId(id).orElse(null));

		model.addAttribute("cita", cita);
		model.addAttribute("profesionales", profesionalService.listarTodos());
		model.addAttribute("usuarios", usuarioService.listarTodos());
		return "servicios/cita-form"; // formulario modal o vista separada
	}

	@PostMapping("/{id}/citas/guardar")
	public String guardarCitaServicio(@PathVariable Integer id, @ModelAttribute Cita cita) {
		cita.setServicio(servicioService.buscarPorId(id).orElse(null));
		citaService.guardar(cita);
		return "redirect:/servicios/" + id + "/citas";
	}

	@GetMapping("/{id}/citas/eliminar/{citaId}")
	public String eliminarCitaServicio(@PathVariable Integer id, @PathVariable Integer citaId) {
		citaService.eliminar(citaId);
		return "redirect:/servicios/" + id + "/citas";
	}

}
