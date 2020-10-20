package edu.eci.aygo.reactiveWeb.persistence;

import org.springframework.stereotype.Service;

import edu.eci.aygo.reactiveWeb.application.Factura;
import edu.eci.aygo.reactiveWeb.application.Persona;
import reactor.core.publisher.Flux;

@Service
public class MockPersistence implements Persistence {

	private Flux<Factura> lista = Flux.just(new Factura(1,"Computador Escritorio",2850000), 
			new Factura(2,"Tablet A 7",2100000), new Factura(3,"Celular Iphone",3500000), 
			new Factura(4,"Celular Samnsung",2900000), new Factura(5,"Pantalla 21",450000), 
			new Factura(6, "TV 4K",1290000));
	
	private Flux<Persona> personas = Flux.just(new Persona("Juan Arevalo","1020771111", "CEO"), 
			new Persona("Pepito Perez","1111111", "CTO"), new Persona("Andrea Alvarez","15afasf", "CIO"),
			new Persona("Josefina Roselina","4445358", "Adminstradora"), 
			new Persona("Nicolas Matallana","101845236", "Mensajero"));
	
	@Override
	public Flux<Factura> getAll() {
		return lista;
	}

	@Override
	public Flux<Persona> getAllPerson() {
		return personas;
	}

}
