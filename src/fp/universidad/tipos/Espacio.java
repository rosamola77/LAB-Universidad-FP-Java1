package fp.universidad.tipos;

import java.util.Objects;

public class Espacio implements Comparable<Espacio>{
	
	//INICIAL

	private String nombre;
	private int capacidad, planta;
	private TipoEspacio tipo;
	
	//Constructores
	
	public Espacio(String nombre, int capacidad, final int planta, TipoEspacio tipo) {
		checkEspacio(capacidad);
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
		this.tipo = tipo;
	}
	
	//Checkers
	
	private void checkEspacio(int capacidad) {
		if (capacidad <= 0) {
			throw new IllegalArgumentException(
					"La capacidad debe de ser mayor a 0");
		}
	}
	
	//Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPlanta() {
		return  planta;
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return nombre + " (planta " + planta + ")";
	}
	
	//Hashcode y equals
	
	public int hashCode() {
		return Objects.hash(nombre, planta);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Espacio))
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(nombre, other.nombre) && planta == other.planta;
	}

	//CompareTo
	
	public int compareTo(Espacio o) {
		int r = Integer.valueOf(planta).compareTo(Integer.valueOf(o.planta));
		if (r == 0) {
			r = nombre.compareTo(o.getNombre());
		}
		return r;
	}
	
}
