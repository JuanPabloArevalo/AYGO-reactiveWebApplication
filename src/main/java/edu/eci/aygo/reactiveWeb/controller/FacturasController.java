package edu.eci.aygo.reactiveWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.aygo.reactiveWeb.application.Factura;
import edu.eci.aygo.reactiveWeb.services.Services;
import reactor.core.publisher.Flux;

@RestController
public class FacturasController {
	
	@Autowired
	Services services;

	@GetMapping("/facturas")
	public Flux<Factura> buscarTodas() { 
		return services.getFacturas();
	}
}
