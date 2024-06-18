package ar.edu.unlam.olimpiadas;

import java.util.*;

public abstract class ComplejoDeportivo {
	
	private String nombre; 
	private Integer areaOcupada;

	
	
	public ComplejoDeportivo(String nombre, Integer areaOcupada) {
		super();
		this.nombre = nombre;
		this.areaOcupada = areaOcupada;
	}


	public String getNombre() {
		return nombre;
	}

	public Integer getAreaOcupada() {
		return areaOcupada;
	}
	
	public abstract Boolean comprobarQueExisteElEvento(Evento evento);

	public abstract Boolean agregarEvento(Evento evento);
	
	public abstract Set<Evento> getEventos();
	
	public abstract Integer obtenerElTotalDePartipantesDeTodosLosEventos();

	


	
	
	

}
