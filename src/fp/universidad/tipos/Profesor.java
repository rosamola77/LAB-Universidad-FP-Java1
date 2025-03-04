package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import fp.utiles.Checkers;

public class Profesor extends Persona {
	
	private TipoCategoria categoria;
	private HashSet<Tutoria> tutorias;

	public Profesor(String dni, String nombre, String apellidos, String email, LocalDate fechaNacimiento,
			TipoCategoria categoria) {
		super(dni, nombre, apellidos, email, fechaNacimiento);
		checkProfesor();
		this.categoria = categoria;
		this.tutorias = new HashSet<Tutoria>();
	}
	
	private void checkProfesor() {
		Checkers.check("La edad de un profesor no puede ser menor que 18", getEdad() >= 18);
	}

	public void nuevaTutoria(LocalTime horaInicio, int duracion, DayOfWeek dia) {
		Tutoria t = new Tutoria(dia, horaInicio, duracion);
		this.tutorias.add(t);
	}
	
	public void borraTutoria(LocalTime horaInicio, DayOfWeek dia) {
		for (Tutoria i : this.tutorias) {
			if (i.horaInicio() == horaInicio && i.dia() == dia) {
				this.tutorias.remove(i);
			}
		}
	}
	
	public TipoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TipoCategoria categoria) {
		this.categoria = categoria;
	}

	public HashSet<Tutoria> getTutorias() {
		return tutorias;
	}

	public void borraTutorias() {
		this.tutorias.clear();
	}
	
	public String toString() {
		return getDni() + " - " + getApellidos() + ", " + getNombre() + " - " + 
				getFechaNacimiento().getDayOfMonth() + "/" + getFechaNacimiento().getMonthValue() + "/" + getFechaNacimiento().getYear() + 
				" (" + getCategoria() + ")";
	}
	
}
