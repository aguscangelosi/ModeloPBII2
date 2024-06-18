package ar.edu.unlam.olimpiadas;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Set;

import org.junit.Test;

public class TestOlimpiadas {

	@Test
	public void tqueSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpica() {
		Sede sede = new Sede();
		
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;

		
		ComplejoDeportivo complejo1 = new ComplejoSimple(nombreComplejo, 300);
		
		assertTrue(sede.agregarComplejoDeportivo(complejo1));
	}
	
	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaEnUnaSedeOlimpica() throws IndicadorAreaException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		
		assertTrue(sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO));
	}
	
	@Test
	public void queSePuedaCrearUnComplejoConUnEvento() throws IndicadorAreaException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		assertTrue(sede.agregarEvento(complejoPolideportivo1, evento));
	}
	
	@Test
	public void queSePuedaDesignarUnAreaAUnEventoDeUnComplejoPolideportivo() throws IndicadorAreaException, BuscarEventoException, AreaComplejoException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoPolideportivo1, evento);
		
		assertTrue(sede.agregarUnEventoConUnAreaODesignarUnAreaAUnEvento(AreasComplejo.ESQUINA_NO, evento, complejoPolideportivo1));
		assertEquals(sede.obtenerAreaDeEvento(evento), AreasComplejo.ESQUINA_NO);
	}
	
	@Test
	public void queSePuedaAgregarUnComisarioJuezAUnEvento() throws IndicadorAreaException, BuscarEventoException, ComisarioException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoPolideportivo1, evento);
		
		Integer dniComisario = 12345567;
		Integer edad = 60;
		String nombre = "Carlos";
		
		Comisario comisarioJuez = new ComisarioJuez(dniComisario, edad, nombre);
		sede.agregarComisario(comisarioJuez);
		
		assertTrue(sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioJuez));
	}
	
	@Test (expected = ComisarioException.class)
	public void queAlAgregarUnComisarioJuezInexistenteLanceUnaExcepcionComisarioException() throws IndicadorAreaException, BuscarEventoException, ComisarioException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoPolideportivo1, evento);
		
		Integer dniComisario = 12345567;
		Integer edad = 60;
		String nombre = "Carlos";
		
		Comisario comisarioJuez = new ComisarioJuez(dniComisario, edad, nombre);
		
		sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioJuez);
	}
	
	@Test
	public void queSePuedaCalcularElTotalDeParticipantesDeLosEventosDeUnComplejoSimple() throws IndicadorAreaException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoSimple complejoSimple = new ComplejoSimple(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoSimple);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoSimple, evento);
		
		LocalDate fechaEvento2 = LocalDate.of(2024, 9, 3);
		Integer id2 = 12345;
		Integer duracion2 = 90;
		Integer numeroDeParticipantes2 = 20;
		
		Evento evento2 = new Evento(fechaEvento2, id2, duracion2, numeroDeParticipantes2);
		sede.agregarEvento(complejoSimple, evento2);
		
		Integer cantidadEsperada = 35;
		Integer cantidadRecibida = sede.calcularElTotalDeParticipantesDeLosEventosDeUnComplejo(complejoSimple);
		
		assertEquals(cantidadEsperada, cantidadRecibida);
	}
	
	@Test
	public void queSePuedaCalcularElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico() throws IndicadorAreaException, BuscarEventoException, ComisarioException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoPolideportivo1, evento);
		
		Integer dniComisario = 12345567;
		Integer edad = 60;
		String nombre = "Carlos";
		
		Comisario comisarioObservador = new ComisarioObservador(dniComisario, edad, nombre);
		sede.agregarComisario(comisarioObservador);
		sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioObservador);
		
		Integer dniComisario2 = 12345067;
		Integer edad2 = 70;
		String nombre2 = "Juan";
		Comisario comisarioObservador2 = new ComisarioObservador(dniComisario2, edad2, nombre2);
		sede.agregarComisario(comisarioObservador2);
		sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioObservador2);
		
		Double cantidadEsperada = 65.0;
		Double cantidadRecibida = sede.obtenerElPromedioDeEdadDeLosComisariosObservadoresDeUnEventoEspecifico(complejoPolideportivo1, evento);
		
		assertEquals(cantidadEsperada, cantidadRecibida);
	}

	
	@Test
	public void queSePuedaObtenerUnaListaDeComisariosJuecesDeUnEventoEspecificoSinRepeticiones() throws IndicadorAreaException, BuscarEventoException, ComisarioException {
		Sede sede = new Sede();
		
		String nombreComplejo = "Complejo1";
		Integer areaOcupada = 300;
	
		ComplejoPolideportivo complejoPolideportivo1 = new ComplejoPolideportivo(nombreComplejo, areaOcupada);
		
		sede.agregarComplejoDeportivo(complejoPolideportivo1);
		sede.agregarAreaDefinidaAComplejoDeportivo(complejoPolideportivo1, AreasComplejo.ESQUINA_NO);
		
		LocalDate fechaEvento = LocalDate.of(2024, 9, 2);
		Integer id = 1234;
		Integer duracion = 90;
		Integer numeroDeParticipantes = 15;
		
		Evento evento = new Evento(fechaEvento, id, duracion, numeroDeParticipantes);
		
		sede.agregarEvento(complejoPolideportivo1, evento);
		
		Integer dniComisario = 12345567;
		Integer edad = 60;
		String nombre = "Carlos";
		
		Comisario comisarioJuez = new ComisarioJuez(dniComisario, edad, nombre);
		
		Integer dniComisario2 = 1234567;
		Integer edad2 = 70;
		String nombre2 = "Juan";
		
		Comisario comisarioJuez2 = new ComisarioJuez(dniComisario2, edad2, nombre2);
		
		sede.agregarComisario(comisarioJuez);
		sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioJuez);
		
		sede.agregarComisario(comisarioJuez2);
		sede.agregarComisarioAEvento(complejoPolideportivo1, evento, comisarioJuez2);
		
		Set<Comisario>comisarios = sede.obtenerLosComisariosDeUnEvento(complejoPolideportivo1, evento);
		
		assertEquals(2, comisarios.size());
		
	}
}
