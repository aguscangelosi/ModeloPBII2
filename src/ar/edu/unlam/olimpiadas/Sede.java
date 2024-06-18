package ar.edu.unlam.olimpiadas;

import java.util.*;

public class Sede {
	
	private Set<ComplejoDeportivo>complejosDeportivos;
	private Set<Comisario>comisarios;
	
	public Sede() {
		this.complejosDeportivos = new HashSet<>();
		this.comisarios = new HashSet<>();
	}
	

	public Boolean agregarComplejoDeportivo(ComplejoDeportivo complejo) {
		for(ComplejoDeportivo c : complejosDeportivos) {
			if(c.equals(complejo)) {		
				return false;
			}
		}
			this.complejosDeportivos.add(complejo);
			return true;
	}


	public Boolean agregarAreaDefinidaAComplejoDeportivo(ComplejoPolideportivo complejo, AreasComplejo areaAAgregar) throws IndicadorAreaException {
		Boolean complejoExiste = false;
		
		for(ComplejoDeportivo c : complejosDeportivos) {
			if(c.equals(complejo)) {		
				complejoExiste = true;
			}
		}
		
		if(complejoExiste) {
			if(complejo.agregarArea(areaAAgregar)){
				return true;
			}else {
				throw new IndicadorAreaException("El area ya existe");
			}
		}
		return false;
		
	}


	public Boolean agregarEvento(ComplejoDeportivo complejo, Evento evento) {
		Boolean complejoExiste = false;
		
		for(ComplejoDeportivo c : complejosDeportivos) {
			if(c.equals(complejo)) {		
				complejoExiste = true;
				}
		}
			if(complejoExiste) {
				complejo.agregarEvento(evento);
				return true;
			}
			return false;
		
	}


	public Boolean agregarUnEventoConUnAreaODesignarUnAreaAUnEvento(AreasComplejo area, Evento evento, ComplejoPolideportivo complejo) {
		// TODO Auto-generated method stub
		Boolean complejoExiste = false;
		
		for(ComplejoDeportivo c : complejosDeportivos) {
			if(c.equals(complejo)) {		
				complejoExiste = true;
				}
		}
		
		if(complejoExiste) {
			complejo.agregarEvento(evento);
		}
		
		if(complejo.comprobarQueExisteElArea(area)) {
			return complejo.designarAreaAEvento(evento, area);
		}
		
		return false;
	}
	
	public ComplejoDeportivo obtenerComplejoDondeSeDesarrollaraElEvento(Evento evento) throws BuscarEventoException {
			ComplejoDeportivo buscado = null;
			
			for(ComplejoDeportivo c : this.complejosDeportivos) {
				if(c.getEventos().contains(evento)) {
					buscado = c;
				}
			}
			
			if(buscado == null) {
				throw new BuscarEventoException("El complejo no existe");
			}
			
			return buscado;
	}
	



	public AreasComplejo obtenerAreaDeEvento(Evento evento) throws BuscarEventoException, AreaComplejoException {
		ComplejoDeportivo complejo = obtenerComplejoDondeSeDesarrollaraElEvento(evento);
		
		if(complejo instanceof ComplejoPolideportivo) {
			return ((ComplejoPolideportivo) complejo).getAreaDelEvento(evento);
		}else {
			throw new BuscarEventoException("El evento se desarrollara en un complejo simple");
		}
		
	}
	
	public Boolean agregarComisario(Comisario comisario) {
		if(!comisarios.contains(comisario)) {
			comisarios.add(comisario);
			return true;
		}
		return false;
	}


	public Boolean agregarComisarioAEvento(ComplejoDeportivo complejo, Evento evento, Comisario comisario) throws BuscarEventoException, ComisarioException {
		if(complejo.comprobarQueExisteElEvento(evento) && comisarios.contains(comisario)) {
			evento.agregarComisario(comisario);
			return true;
		}else if(!comisarios.contains(comisario)) {
			throw new ComisarioException("El comisario no esta registrado");
		}else if(!complejo.comprobarQueExisteElEvento(evento)) {
			throw new BuscarEventoException("El evento no existe");
		}
		return false;
	}


	public Integer calcularElTotalDeParticipantesDeLosEventosDeUnComplejo(ComplejoSimple complejoSimple) {
		Integer totalParticipantes = 0;
		
		if(complejosDeportivos.contains(complejoSimple)) {
			totalParticipantes = complejoSimple.obtenerElTotalDePartipantesDeTodosLosEventos();
		}
		
		return totalParticipantes;
	}


	public Double obtenerElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico(ComplejoPolideportivo complejo, Evento evento) throws ComisarioException, BuscarEventoException {
		Double promedio = 0.0;
		if(complejo.comprobarQueExisteElEvento(evento)) {
			promedio = evento.calcularPromedioDeEdadDeLosComisariosObservadores();
		}else {
			throw new BuscarEventoException("El evento no existe");
		}
		return promedio;
	}


	public Set<Comisario> obtenerLosComisariosDeUnEvento(ComplejoDeportivo complejo, Evento evento) throws BuscarEventoException {
		Set<Comisario>comisariosEvento = new HashSet<>();
		if(complejo.comprobarQueExisteElEvento(evento)) {
			comisariosEvento = evento.getComisarios();
		}else {
			throw new BuscarEventoException("El evento no existe");
		}
		return comisariosEvento;
	}

	
	
	
	
}
