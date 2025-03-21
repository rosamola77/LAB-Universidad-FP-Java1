package fp.universidad.tipos;

import java.util.LinkedList;
import java.util.List;
import fp.utiles.Ficheros;

public class FactoriaUniversidad {
	
	public static Espacio creaEspacio(String s) {
		return new Espacio(s);
	}
	
	public static List<Espacio> leeEspacios(String path) {
		
		List<Espacio> res = new LinkedList<>();
		List<String> espacios = Ficheros.leeFichero("Error en la lectura", path);
		
		for (String espacio : espacios) {
			res.add(FactoriaUniversidad.creaEspacio(espacio));
		}
		
		return res;
	}
	
	public static Despacho creaDespacho(String s) {
		return new Despacho(s);
	}
	
	public static List<Despacho> leeDespachos(String path) {
		
		List<Despacho> res = new LinkedList<>();
		List<String> despachos = Ficheros.leeFichero("Error en la lectura", path);
		
		for (String despacho : despachos) {
			res.add(FactoriaUniversidad.creaDespacho(despacho));
		}
		
		return res;
		
	}
	
	public static Alumno creaAlumno(String s) {
		return new Alumno(s);
	}
	
	public static List<Alumno> leeAlumnos(String path) {
		
		List<Alumno> res = new LinkedList<>();
		List<String> alumnos = Ficheros.leeFichero("Error en la lectura", path);
		
		alumnos.remove(0);
		
		for (String alumno : alumnos) {
			res.add(FactoriaUniversidad.creaAlumno(alumno));
		}
		
		return res;
	}
	
	public static Asignatura creaAsignatura(String s) {
		return new Asignatura(s);
	}
	
	public static List<Asignatura> leeAsignaturas(String path) {
		
		List<Asignatura> res = new LinkedList<>();
		List<String> asignaturas = Ficheros.leeFichero("Error en la lectura", path);
		
		for (String asignatura : asignaturas) {
			res.add(FactoriaUniversidad.creaAsignatura(asignatura));
		}
		
		return res;
	}
	
	public static Nota creaNota(String s) {
		return new Nota(s);
	}
	
	public static List<Nota> leeNotas(String path) {
		List<Nota> res = new LinkedList<>();
		List<String> notas = Ficheros.leeFichero("Error en la lectura", path);
		
		for (String nota : notas) {
			res.add(FactoriaUniversidad.creaNota(nota));
		}
		
		return res;
	}
	
}
