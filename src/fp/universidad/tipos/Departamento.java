package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Departamento implements Comparable<Departamento> {
	
	//INICIAL
	
	private String nombre;
	private Set<Asignatura> asignaturas;
	private Set<Profesor> profesores;
	
	//Constructores
	
	public Departamento(String nombre) {
		
		this.nombre = nombre;
		this.asignaturas = new HashSet<>();
		this.profesores = new HashSet<>();
		
	}
	
	//Getters y Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}
	
	//Tostring
	
	public String toString() {
		return nombre;
	}
	
	//Hashcode y equals
	
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Departamento)) {
			return false;
		}
		Departamento other = (Departamento) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//CompareTo
	
	public int compareTo(Departamento d) {
		return this.nombre.compareTo(d.nombre);
	}
	
	//Funcionalidades
	


	public void nuevoProfesor(Profesor p) {
		profesores.add(p);
	}
	
	public void eliminaProfesor(Profesor p) {
		profesores.remove(p);
	}
	
	public void nuevaAsignatura(Asignatura a) {
		asignaturas.add(a);
	}
	
	public void eliminaAsignatura(Asignatura a) {
		asignaturas.remove(a);
	}
	
	public void borraTutorias() {
		for (Profesor p : this.profesores) {
			p.borraTutorias();
		}
	}
	
	public void borraTutorias(TipoCategoria t) {
		for (Profesor p : this.profesores) {
			if (p.getCategoria() == t) {
				p.borraTutorias();
			}
		}
	}
	
}
