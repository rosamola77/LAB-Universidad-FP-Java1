package fp.universidad.tipos;

import java.time.LocalDate;

public class Persona implements Comparable<Persona> {
	
	private String dni, nombre, apellidos, email;
	private int edad;
	private LocalDate fechaNacimiento;
	
	public Persona(String dni, String nombre, String apellidos, String email, LocalDate fechaNacimiento) {
		super();
		checkPersona(dni, email);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.email = "";
		checkPersona(dni, email);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
		this.fechaNacimiento = fechaNacimiento;

	}
	
	private void checkPersona(String dni, String email) {
		if (dni.length() == 9) {
			String numeros = dni.substring(0, 8);
		    char letra = dni.charAt(8);
		    if (!(numeros.chars().allMatch(Character::isDigit) && Character.isUpperCase(letra))) {
		    	throw new IllegalArgumentException(
						"El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula");
		    } 
		} else {
			throw new IllegalArgumentException(
					"El DNI debe de ser exactamente ocho dígitos seguidos de una letra mayúscula");
		}
		if (email == "") {
			
		} else if (!(email.contains("@"))) {
			throw new IllegalArgumentException(
					"El email debe contener una '@'");
		}
		
	}
	
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
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int compareTo(Persona p) {
		int r = apellidos.compareTo(p.getApellidos());
		if (r == 0) {
			r = nombre.compareTo(p.getNombre());
		} else if (r == 0) {
			r = dni.compareTo(p.getDni());
		}
		return r;
	}

	public boolean equals(Persona o) {
		if (this.dni == o.dni && this.nombre == o.nombre && this.apellidos == o.apellidos) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return dni + " - " + apellidos + ", " + nombre + " - " + fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonthValue() + "/" + fechaNacimiento.getYear();
	}
	
	
}
