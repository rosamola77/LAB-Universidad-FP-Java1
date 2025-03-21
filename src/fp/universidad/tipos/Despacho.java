package fp.universidad.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public class Despacho extends Espacio {
	
	//INICIAL
	
	private Set<Profesor> profesores;

	//Constructores
	
	public Despacho(String nombre, int capacidad, int planta, Set<Profesor> profesores) {
		super(nombre, capacidad, planta, TipoEspacio.OTRO);
		checkDespacho();
		this.profesores = profesores;
	}

	public Despacho(String nombre, int capacidad, int planta, Profesor profesor) {
		super(nombre, capacidad, planta, TipoEspacio.OTRO);
		this.profesores = new HashSet<Profesor>();
		checkDespacho();
		profesores.add(profesor);
	}
	
	public Despacho(String nombre, int capacidad, int planta) {
		super(nombre, capacidad, planta, TipoEspacio.OTRO);
		this.profesores = new HashSet<Profesor>();
	}
	
	public Despacho(String s) {
        super(parseNombre(s), parsePlanta(s), parseCapacidad(s), TipoEspacio.OTRO);
        this.profesores = new HashSet<Profesor>();
    }
	
    private static String parseNombre(String s) {
        String[] trozos = s.split(",");
        if (trozos.length != 3) {
            throw new IllegalArgumentException("Cadena con formato no válido");
        }
        return trozos[0].trim();
    }

    private static int parsePlanta(String s) {
        String[] trozos = s.split(",");
        return Integer.parseInt(trozos[1].trim());
    }

    private static int parseCapacidad(String s) {
        String[] trozos = s.split(",");
        return Integer.parseInt(trozos[2].trim());
    }
	
	//Checkers
	
	private void checkDespacho() {
		Checkers.check("El número de profesores supera la capacidad indicada", this.getCapacidad() >= this.profesores.size());	 
	}
	
	// Restricción a los setters respecto a su superclase
	
	public void setTipo() {
		throw new UnsupportedOperationException("No se puede cambiar el tipo de un despacho");
	}
	
}
