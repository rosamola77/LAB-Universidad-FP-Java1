package fp.universidad.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import fp.utiles.Checkers;

public class Profesor extends Persona {
	
	//INICIAL
	
	private TipoCategoria categoria;
	private HashSet<Tutoria> tutorias;
	
	//Constructores
	
	public Profesor(String dni, String nombre, String apellidos, String email, LocalDate fechaNacimiento,
			TipoCategoria categoria) {
		super(dni, nombre, apellidos, email, fechaNacimiento);
		checkProfesor();
		this.categoria = categoria;
		this.tutorias = new HashSet<Tutoria>();
	}
	
	//Checkers
	
	private void checkProfesor() {
		Checkers.check("La edad de un profesor no puede ser menor que 18", getEdad() >= 18);
	}
	
	//Getters y setters
	
	public TipoCategoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(TipoCategoria categoria) {
		this.categoria = categoria;
	}
	
	public HashSet<Tutoria> getTutorias() {
		return tutorias;
	}
	
	//Tostring
	
	public String toString() {
		return this.getDni() + " - " + this.getApellidos() + ", " + this.getNombre() + " - " + 
				this.getFechaNacimiento().getDayOfMonth() + "/" + this.getFechaNacimiento().getMonthValue() + "/" + this.getFechaNacimiento().getYear() + 
				" (" + this.getCategoria() + ")";
	}	
	
	//Funcionalidades
	
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
	
	public void borraTutorias() {
		this.tutorias.clear();
	}
	
}
