package fp.universidad.tipos;

import java.time.LocalDate;
import java.util.Objects;

import fp.utiles.Checkers;

public record Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos, int curso) implements Comparable<Asignatura> {
	
		public Asignatura {
			checkAsignatura(nombre, codigo, creditos);
		}
		
		public Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos) {
			this(nombre, tipo, codigo, creditos, LocalDate.now().getYear());
		}

		private void checkAsignatura(String nombre, int codigo, float creditos) {
			Integer c = codigo;
			Checkers.check("El nombre no puede estar vacío", !nombre.equals("") || !nombre.equals(null));
			Checkers.check("El número de creditos tiene que ser mayor que 0", creditos >= 0);
			Checkers.check("El código debe estar formado por siete dígitos", c.toString().length() == 7);
			
		}

		public String getAcrónimo() {
			//TODO
			return null;
		} 

		public String toString() {
			return "(" + codigo + ") " + nombre;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(codigo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Asignatura))
				return false;
			Asignatura other = (Asignatura) obj;
			return codigo == other.codigo;
		}

		public int compareTo(Asignatura o) {
			int r = Integer.valueOf(codigo).compareTo(Integer.valueOf(o.codigo));
			return r;
		}
		
		

}
