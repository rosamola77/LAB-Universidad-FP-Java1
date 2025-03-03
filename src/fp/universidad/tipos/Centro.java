package fp.universidad.tipos;

import java.util.*;

public class Centro implements Comparable<Centro>{

	private String nombre, direccion;
	private int plantas, sotanos;
	private Set<Espacio> espacios;

	public Centro(String nombre, String direccion, int plantas, int sotanos) {
		checkCentro(plantas, sotanos);
		this.nombre = nombre;
		this.direccion = direccion;
		this.plantas = plantas;
		this.sotanos = sotanos;
		this.espacios = new HashSet<Espacio>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getPlantas() {
		return plantas;
	}

	public int getSotanos() {
		return sotanos;
	}

	public Set<Espacio> getEspacios() {
		return espacios;
	}
	
	public void nuevoEspacio(Espacio e) {
		if (e.getPlanta() <= (this.plantas - 1) && e.getPlanta() >= (- this.sotanos)) {
			this.espacios.add(e);
		} else {
			throw new IllegalArgumentException("Plana del espacio fuera del rango permitido");
		}
	}

	public void eliminaEspacio(Espacio e) {
		this.espacios.remove(e);
	}
	
	private void checkCentro(int plantas, int sotanos) {
		if (plantas < 1 && sotanos < 0) {
			throw new IllegalArgumentException("Los centros deben tener al menos una planta y cero sótanos");
		}
	}
	
	public int hashCode() {
		return Objects.hash(direccion, espacios, nombre, plantas, sotanos);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Centro))
			return false;
		Centro other = (Centro) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(espacios, other.espacios)
				&& Objects.equals(nombre, other.nombre) && plantas == other.plantas && sotanos == other.sotanos;
	}

	public int compareTo(Centro c) {
		int r = nombre.compareTo(c.nombre);
		return r;
	}

	public ArrayList<Integer> getConteosEspacios() {
		//TODO
		return null;
	}
	
	public HashSet<Espacio> getDespachos() {
		//TODO
		return null;
	}
	
	public HashSet<Despacho> getDespachos(Departamento d) {
		//TODO
		return null;
	}

	public HashSet<Profesores> getProfesores() {
		//TODO
		return null;
	}
	
	public HashSet<Profesores> getProfesores(Departamento d) {
		//TODO
		return null;
	}
	
	public Espacio getEspacioMayorCapacidad() {
		//TODO
		return null;
	}
	
}
