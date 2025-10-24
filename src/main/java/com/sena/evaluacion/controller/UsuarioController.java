package com.sena.evaluacion.controller;

import com.sena.evaluacion.model.Cita;
import com.sena.evaluacion.model.Usuario;
import com.sena.evaluacion.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired
	private ICitaService citaService;

	@Autowired
	private IServicioService servicioService;

	@Autowired
	private IProfesionalService profesionalService;

	// ================================
	// CRUD de USUARIOS
	// ================================

	@GetMapping
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.listarTodos());
		return "usuarios/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuarios/formulario";
	}

	@PostMapping("/guardar")
	public String guardarUsuario(@ModelAttribute Usuario usuario) {
		usuarioService.guardar(usuario);
		return "redirect:/usuarios";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable Integer id, Model model) {
		Usuario usuario = usuarioService.buscarPorId(id).orElse(null);
		model.addAttribute("usuario", usuario);
		return "usuarios/formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Integer id) {
		usuarioService.eliminar(id);
		return "redirect:/usuarios";
	}

	@GetMapping("/dashboard")
	public String mostrarDashboard(Model model) {
		model.addAttribute("servicios", servicioService.listarTodos());
		return "dashboard"; // o el nombre de tu vista
	}

	// ================================
	// GESTIÓN DE CITAS POR USUARIO
	// ================================
	@GetMapping("/{id}/citas")
	public String listarCitasUsuario(@PathVariable Integer id, Model model) {
		Usuario usuario = usuarioService.buscarPorId(id).orElse(null);

		// Filtramos solo las citas de ese usuario
		List<Cita> citas = citaService.listarTodas().stream().filter(c -> c.getUsuario().getId().equals(id)).toList();

		model.addAttribute("usuario", usuario);
		model.addAttribute("citas", citas);
		model.addAttribute("nuevaCita", new Cita()); // para el formulario del modal
		model.addAttribute("servicios", servicioService.listarTodos());
		model.addAttribute("profesionales", profesionalService.listarTodos());

		return "usuarios/citas"; // Vista única
	}

	// Guardar (crear o editar) cita
	@PostMapping("/{id}/citas/guardar")
	public String guardarCitaUsuario(@PathVariable Integer id, @ModelAttribute Cita cita) {
		Usuario usuario = usuarioService.buscarPorId(id).orElse(null);
		cita.setUsuario(usuario);
		citaService.guardar(cita);
		return "redirect:/usuarios/" + id + "/citas";
	}

	// Eliminar cita
	@GetMapping("/{id}/citas/eliminar/{citaId}")
	public String eliminarCitaUsuario(@PathVariable Integer id, @PathVariable Integer citaId) {
		citaService.eliminar(citaId);
		return "redirect:/usuarios/" + id + "/citas";
	}
}