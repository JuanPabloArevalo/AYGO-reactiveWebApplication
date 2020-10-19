package edu.eci.aygo.reactiveWeb.persistence;

import edu.eci.aygo.reactiveWeb.application.Factura;
import reactor.core.publisher.Flux;

public interface Persistence {

	Flux<Factura> getAll();
}
