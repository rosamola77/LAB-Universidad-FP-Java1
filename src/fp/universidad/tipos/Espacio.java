package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public class Espacio implements Comparable<Espacio>{
	
	//INICIAL

	private String nombre;
	private int capacidad;
	private int planta;
	private TipoEspacio tipo;
	
	//Constructores
	
	public Espacio(String nombre, final int planta, int capacidad, TipoEspacio tipo) {
		checkEspacio(capacidad);
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
		this.tipo = tipo;
	}
	
	public Espacio(String s) {
	    String[] trozos = s.split(","); 
	    
	    Checkers.check("Cadena con formato no válido", trozos.length == 4);
	    
	    String nombre = trozos[0].trim();
	    int planta = Integer.parseInt(trozos[1].trim());
	    int capacidad = Integer.parseInt(trozos[2].trim());
	    TipoEspacio tipo = TipoEspacio.valueOf(trozos[3].trim());
	    
	    this.nombre = nombre;
	    this.planta = planta;
	    this.capacidad = capacidad;
	    this.tipo = tipo;
	}
	
	//Checkers
	
	private void checkEspacio(int capacidad) {
		Checkers.check("La capacidad debe ser mayor que 0", capacidad > 0);
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
