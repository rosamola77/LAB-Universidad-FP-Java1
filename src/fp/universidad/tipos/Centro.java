package fp.universidad.tipos;

import java.util.*;

import fp.utiles.Checkers;

public class Centro implements Comparable<Centro>{
	
	//INICIAL

	private String nombre, direccion;
	private int plantas, sotanos;
	private Set<Espacio> espacios;
	
	//Constructores
	
	public Centro(String nombre, String direccion, int plantas, int sotanos) {
		checkCentro(plantas, sotanos);
		this.nombre = nombre;
		this.direccion = direccion;
		this.plantas = plantas;
		this.sotanos = sotanos;
		this.espacios = new HashSet<Espacio>();
	}
	
	//Checkers
	
	private void checkCentro(int plantas, int sotanos) {
		Checkers.check("Los centros deben tener al menos una planta y cero sótanos", !(plantas < 1 && sotanos < 0));
	}
	
	//Getters y setters
	
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
	
	public HashSet<Espacio> getDespachos() {
		HashSet<Espacio> res = new HashSet<>();
		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				res.add(e);
			}
		}
		return res;
	}
	
	public HashSet<Despacho> getDespachos(Departamento d) {
		HashSet<Despacho> res = new HashSet<>();
		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				((Despacho) e).getProfesores().retainAll(d.getProfesores());
				if (((Despacho) e).getProfesores() == null || ((Despacho) e).getProfesores().size() > 0) {
					res.add((Despacho) e);
				}
			}
		}
		return res;
	}

	public Set<Profesor> getProfesores() {
		Set<Profesor> res = new HashSet<>();
		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				res.addAll(((Despacho) e).getProfesores());
			}
		}
		return res;
	}
	
	public Set<Profesor> getProfesores(Departamento d) {
		Set<Profesor> res = new HashSet<>();
		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				res.addAll(((Despacho) e).getProfesores());
			}
		}
		res.retainAll(d.getProfesores());
		return res;
	}
	
	//ToString
	
	public String toString() {
		return nombre;
	}	
	
	//Hashcode y equals
	
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
	
	//CompareTo
	
	public int compareTo(Centro c) {
		int r = nombre.compareTo(c.nombre);
		return r;
	}	
	
	//Funcionalidades
	
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
	
	public ArrayList<Integer> getConteosEspacios() {
		Integer[] res = {0, 0, 0, 0, 0};
		for (Espacio e : espacios) {
			switch (e.getTipo()) {
			case TEORIA:
				res[0]++;
				break;
			case LABORATORIO:
				res[1]++;
				break;
			case SEMINARIO:
				res[2]++;
				break;
			case EXAMEN:
				res[3]++;
				break;
			case OTRO:
				res[4]++;
				break;
			default:
				break;
			}
		}
		ArrayList<Integer> array = new ArrayList<>();
		for (Integer n : res) {
			array.add(n);
		}
		return array;
	}
	
	public Espacio getEspacioMayorCapacidad() {
        if (espacios == null || espacios.isEmpty()) {
            throw new IllegalArgumentException("La lista de espacios está vacía o es nula.");
        }

        Espacio maxEspacio = null;

        for (Espacio e : espacios) {
            if (e.getCapacidad() > maxEspacio.getCapacidad()) {
                maxEspacio = e;
            }
        }
        return maxEspacio;
    }

}
