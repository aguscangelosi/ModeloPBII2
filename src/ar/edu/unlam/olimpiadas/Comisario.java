package ar.edu.unlam.olimpiadas;

import java.util.Objects;

public abstract class Comisario {

	private Integer dni;
	private Integer edad;
	private String nombre;
	
	
	public Comisario(Integer dni, Integer edad, String nombre) {
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
	}
	
	

	public Integer getDni() {
		return dni;
	}



	public Integer getEdad() {
		return edad;
	}



	public String getNombre() {
		return nombre;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comisario other = (Comisario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
	
	
	
}
