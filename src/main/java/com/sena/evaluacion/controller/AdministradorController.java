package com.sena.evaluacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

	@GetMapping("/admin")
	public String mostrarPanelAdmin() {
		return "admin"; // nombre del archivo admin.html
	}
}
