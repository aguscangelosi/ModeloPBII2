package ar.edu.unlam.olimpiadas;

import java.util.*;

public class ComplejoSimple extends ComplejoDeportivo {
	
	private Set<Evento>eventos;

	public ComplejoSimple(String nombre, Integer areaOcupada) {
		super(nombre, areaOcupada);
		// TODO Auto-generated constructor stub
		this.eventos = new HashSet<>();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return getNombre();
	}

	@Override
	public Integer getAreaOcupada() {
		return getAreaOcupada();
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		for(Evento e : eventos) {
			if(e.equals(evento)) {
				return false;
			}
		}
		eventos.add(evento);
		return true;
	}

	@Override
	public Set<Evento> getEventos() {
		return eventos;
	}

	public Boolean comprobarQueExisteElEvento(Evento evento) {
		for(Evento e : eventos) {
			if(e.equals(evento)) {
				return true;
			}
		}
		return false;
	}

	public Integer obtenerElTotalDePartipantesDeTodosLosEventos() {
		Integer total = 0;
		
		for(Evento e : eventos) {
			total += e.getNumeroDeParticipantes();
		}
		
		return total;
	}


	
	

}
