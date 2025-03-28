package fp.universidad.tipos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.utiles.Checkers;

public class Alumno extends Persona {
	
	private Set<Asignatura> asignaturas;
	
	//Constructores

	public Alumno(String dni, String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		super(dni, nombre, apellidos, email, fechaNacimiento);
		checkAlumno();
		this.asignaturas = new HashSet<Asignatura>();
	}
	
	public Alumno(String s) {
		super(parseDni(s), parseNombre(s), parseApellidos(s), parseEmail(s), parseFechaNacimiento(s));
		checkAlumno();
		this.asignaturas = new HashSet<Asignatura>();
	}
	
    private static String parseDni(String s) {
        String[] trozos = s.split(",");
        if (trozos.length != 5) {
            throw new IllegalArgumentException("Cadena con formato no válido");
        }
        return trozos[0].trim();
    }
    
    private static String parseNombre(String s) {
    	String[] trozos = s.split(",");
    	return trozos[1].trim();
    }
    
    private static String parseApellidos(String s) {
    	String[] trozos = s.split(",");
    	return trozos[2].trim();
    }
    
    private static LocalDate parseFechaNacimiento(String s) {
    	String[] trozos = s.split(",");
    	String[] ddmmyyyy = trozos[3].split("/");
    	Checkers.check("Cadena con formato no válido", ddmmyyyy.length == 3);
    	return LocalDate.of(Integer.valueOf(ddmmyyyy[2]), Integer.valueOf(ddmmyyyy[1]), Integer.valueOf(ddmmyyyy[0]));
    }
    
    private static String parseEmail(String s) {
    	String[] trozos = s.split(",");
    	return trozos[4].trim();
    }

	//Checkers
	
	private void checkAlumno() {
		String numeros = this.getDni().substring(0, 8);
	    char letra = this.getDni().charAt(8);
		Checkers.check("El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula", 
	    		(numeros.chars().allMatch(Character::isDigit) && Character.isUpperCase(letra)));
		Checkers.check("El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula", 
				this.getDni().length() == 9);
		Checkers.check("El email debe terminar en '@alum.us.es'", 
				this.getEmail().endsWith("@alum.us.es"));
		Checkers.check("El mombre no puede estar vacío", 
				!this.getNombre().isEmpty());
		Checkers.check("Fecha no válida: No puedes haber nacido mañana payasete", 
				!(this.getFechaNacimiento().isAfter(LocalDate.now())));	
	}
	
	//Getters y setters
	
	public char getCurso() {
		int res = 0;
		for (Asignatura a : asignaturas) {
			if (a.curso() > res) {
				res = a.curso();
			}
		}
		return String.valueOf(res).charAt(0);
	}
	
	//To string
	
	public String toString() {
		return "(" + getCurso() + "º) " + this.getDni() + " - " + this.getApellidos() + ", " + this.getNombre() + " - " + this.getFechaNacimiento();
	}	
	
	//Funcionalidades
	
	public void matriculaAsignatura(Asignatura a) {
		if (this.asignaturas.contains(a)) {
			throw new IllegalArgumentException("La asignatura ya está matriculada en el alumno");
		} else {
			this.asignaturas.add(a);
		}
	}
	
	public void eliminaAsignatura(Asignatura a) {
		if (this.asignaturas.contains(a)) {
			this.asignaturas.remove(a);
		} else {
			throw new IllegalArgumentException("La asignatura ya está matriculada en el alumno");
		}
	}
	
	public boolean estaMatriculadoEn(Asignatura a) {
		if (this.asignaturas.contains(a)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

}
