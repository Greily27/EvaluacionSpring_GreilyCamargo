package com.sena.evaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.evaluacion.service.IServicioService;

@Controller
public class HomUserController {
	
    @Autowired
    private IServicioService servicioService;

    @GetMapping({"/", "/home"})
    public String mostrarHome(Model model) {
        model.addAttribute("servicios", servicioService.listarTodos());
        return "index"; // 
    }
}

