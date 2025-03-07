package fp.universidad.tipos;

import java.time.LocalDate;
import fp.utiles.Checkers;

public record Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos, int curso) implements Comparable<Asignatura> {
	
		//INICIAL
	
		public Asignatura {
			checkAsignatura(nombre, codigo, creditos);
		}
		
		//Constructor alternativo
		
		public Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos) {
			this(nombre, tipo, codigo, creditos, LocalDate.now().getYear());
		}
		
		//Checkers
		
		private void checkAsignatura(String nombre, int codigo, float creditos) {
			Integer c = codigo;
			Checkers.check("El nombre no puede estar vacío", !nombre.equals("") || !nombre.equals(null));
			Checkers.check("El número de creditos tiene que ser mayor que 0", creditos >= 0);
			Checkers.check("El código debe estar formado por siete dígitos", c.toString().length() == 7);
			
		}
		
		//Getters y setters
		
		public String getAcrónimo() {
			//TODO
			return null;
		} 
		
		//Tostring
		
		public String toString() {
			return "(" + codigo + ") " + nombre;
		}
		
		//Hashcode y equals
		
		public int hashCode() {
			return Integer.valueOf(codigo).hashCode();
		}

		public boolean equals(Object o) {
	    	if (o instanceof Asignatura) {
	    		Asignatura a = (Asignatura) o;
	    		if (codigo == a.codigo) {
	    			return true;
	    		} else {
	    			return false;
	    		}
	    	} else {
	    		return false;
	    	}
		}
		
		//CompareTo
		
		public int compareTo(Asignatura o) {
			int r = Integer.valueOf(codigo).compareTo(Integer.valueOf(o.codigo));
			return r;
		}

}
