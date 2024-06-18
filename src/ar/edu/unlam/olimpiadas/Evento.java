package ar.edu.unlam.olimpiadas;

import java.time.LocalDate;
import java.util.*;

public class Evento {
	
	private LocalDate fecha;
	private Integer idEvento;
	private Integer duracion;
	private Integer numeroDeParticipantes;
	private Set<Comisario>comisarios;
	
	
	public Evento(LocalDate fecha, Integer idEvento, Integer duracion, Integer numeroDeParticipantes) {
		super();
		this.fecha = fecha;
		this.idEvento = idEvento;
		this.duracion = duracion;
		this.numeroDeParticipantes = numeroDeParticipantes;
		this.comisarios = new HashSet<>();
	}

	public Integer getNumeroDeParticipantes() {
		return this.numeroDeParticipantes;
	}

	public Boolean agregarComisario(Comisario comisario) throws ComisarioException {
		if(!(comisarios.contains(comisario))) {
			comisarios.add(comisario);
			return true;
		}else {
			throw new ComisarioException("El comisario ya esta registrado para este evento");
		}
	}

	public Double calcularPromedioDeEdadDeLosComisariosObservadores() throws ComisarioException {
		Double promedio = 0.0;
		Double edadTotalComisarios = 0.0;
		
		if(comisarios.size()>0) {
			for(Comisario c : comisarios) {
				edadTotalComisarios += c.getEdad();
			}
		}else {
			throw new ComisarioException("No hay comisarios registrados");
		}
		
		promedio = edadTotalComisarios / comisarios.size();
		
		return promedio;
	}

	public Set<Comisario> getComisarios() {
		return comisarios;
	}


	
	
}
