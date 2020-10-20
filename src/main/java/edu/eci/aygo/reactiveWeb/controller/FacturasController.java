package edu.eci.aygo.reactiveWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.aygo.reactiveWeb.application.Factura;
import edu.eci.aygo.reactiveWeb.application.Persona;
import edu.eci.aygo.reactiveWeb.services.Services;
import reactor.core.publisher.Flux;

@RestController
public class FacturasController {
	
	@Autowired
	Services services;

	@CrossOrigin(origins = "*")
	@GetMapping("/facturas")
	public Flux<Factura> buscarTodas() { 
		return services.getFacturas();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/personas")
	public Flux<Persona> buscarTodasPersonas() { 
		return services.getPersonas();
	}
}
