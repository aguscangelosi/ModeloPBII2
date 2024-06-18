package ar.edu.unlam.olimpiadas;
import java.util.*;

public class ComplejoPolideportivo extends ComplejoDeportivo {
	
	private Set<Evento>eventos;
	private Set<AreasComplejo>areasComplejo;
	private Map<Evento, AreasComplejo>areaDelEvento;


	public ComplejoPolideportivo(String nombre, Integer areaOcupada) {
		super(nombre, areaOcupada);
		this.eventos = new HashSet<>();
		this.areasComplejo = new HashSet<>();
		this.areaDelEvento = new HashMap<>();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return getNombre();
	}

	@Override
	public Integer getAreaOcupada() {
		// TODO Auto-generated method stub
		return getAreaOcupada();
	}

	public Boolean agregarArea(AreasComplejo areaAAgregar) {
		
		for(AreasComplejo a : areasComplejo){
			if(a.equals(areaAAgregar)) {
				return false;
			}
		}
		this.areasComplejo.add(areaAAgregar);
		return true;
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

	public Set<AreasComplejo> getAreas() {
		// TODO Auto-generated method stub
		return areasComplejo;
	}

	public Boolean comprobarQueExisteElArea(AreasComplejo area) {
		for(AreasComplejo a : areasComplejo) {
			if(a.equals(area)) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean comprobarQueExisteElEvento(Evento evento) {
		for(Evento e : eventos) {
			if(e.equals(evento)) {
				return true;
			}
		}
		return false;
	}

	public Boolean designarAreaAEvento(Evento evento, AreasComplejo area) {
		if(comprobarQueExisteElArea(area) && comprobarQueExisteElEvento(evento)) {
			areaDelEvento.put(evento, area);
			return true;
		}
		return false;
	}

	@Override
	public Set<Evento> getEventos() {
		// TODO Auto-generated method stub
		return eventos;
	}
	
	public AreasComplejo getAreaDelEvento(Evento evento) throws AreaComplejoException{
		if(comprobarQueExisteElEvento(evento)) {
			if(areaDelEvento.get(evento).equals(null)) {
				throw new AreaComplejoException("El evento no tiene un area asignada"); 
			}
		}else {
			throw new AreaComplejoException("El evento no existe");
		}
		
		return areaDelEvento.get(evento);
	}
	
	public Integer obtenerElTotalDePartipantesDeTodosLosEventos() {
		Integer total = 0;
		
		for(Evento e : eventos) {
			total += e.getNumeroDeParticipantes();
		}
		
		return total;
	}
}
