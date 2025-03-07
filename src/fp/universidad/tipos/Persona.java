package fp.universidad.tipos;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public class Persona implements Comparable<Persona> {
	
	//INICIAL
	
	private String dni, nombre, apellidos, email;
	private LocalDate fechaNacimiento;
	
	//Constructores
	
	public Persona(String dni, String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		super();
		checkPersona(dni, email, nombre, fechaNacimiento);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.email = "";
		checkPersona(dni, email, nombre, fechaNacimiento);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;

	}
	
	//Checkers
	
	private void checkPersona(String dni, String email, String nombre, LocalDate fecha) {
		String numeros = dni.substring(0, 8);
	    char letra = dni.charAt(8);
		Checkers.check("El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula", 
	    		(numeros.chars().allMatch(Character::isDigit) && Character.isUpperCase(letra)));
		Checkers.check("El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula", 
				dni.length() == 9);
		Checkers.check("El email debe contener una '@'", 
				email.contains("@"));
		Checkers.check("El mombre no puede estar vacío", 
				!nombre.isEmpty());
		Checkers.check("Fecha no válida: No puedes haber nacido mañana payasete", 
				!(fecha.isAfter(LocalDate.now())));	
	}
	
	//Getters y setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return LocalDate.now().getYear() - fechaNacimiento.getYear();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//Tostring
	
	public String toString() {
		return dni + " - " + apellidos + ", " + nombre + " - " + 
				fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonthValue() + "/" + fechaNacimiento.getYear();
	}	
	
	//Hashcode y equals
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(dni, other.dni)
				&& Objects.equals(nombre, other.nombre);
	}
	
	public int hashCode() {
		return Objects.hash(apellidos, dni, nombre);
	}	
	
	//CompareTo
	
	public int compareTo(Persona o) {
		int r = apellidos.compareTo(o.getApellidos());
		if (r == 0) {
			r = nombre.compareTo(o.getNombre());
			 if (r == 0) {
					r = dni.compareTo(o.getDni());
			 }
		}
		return r;
	}

}
