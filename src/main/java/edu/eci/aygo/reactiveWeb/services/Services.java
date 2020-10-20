package edu.eci.aygo.reactiveWeb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.aygo.reactiveWeb.application.Factura;
import edu.eci.aygo.reactiveWeb.application.Persona;
import edu.eci.aygo.reactiveWeb.persistence.Persistence;
import reactor.core.publisher.Flux;

/**
*
* @author Juan Pablo Arévalo
*/
@Service
public class Services {
	
	@Autowired
	Persistence persistence;
	
	public Flux<Factura> getFacturas(){
	    return persistence.getAll();
	}
	
	public Flux<Persona> getPersonas(){
	    return persistence.getAllPerson();
	}
}
