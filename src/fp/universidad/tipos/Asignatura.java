package fp.universidad.tipos;

import java.time.LocalDate;

public record Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos, int curso) {
	
		public Asignatura {
			checkAsignatura(nombre, codigo, creditos);
		}
		
		public Asignatura(String nombre, TipoAsignatura tipo, int codigo, float creditos) {
			this(nombre, tipo, codigo, creditos, LocalDate.now().getYear());
		}

		private void checkAsignatura(String nombre, int codigo, float creditos) {
			
			if (nombre.equals("") || nombre.equals(null)) {
				throw new IllegalArgumentException(
						"El nombre no puede estar vacío");
			}
			
			if (creditos <= 0) {
				throw new IllegalArgumentException(
						"El número de creditos tiene que ser mayor que 0");
			}
			
			Integer c = codigo;
			
			if (c.toString().length() != 7) {
				throw new IllegalArgumentException(
						"El código debe estar formado por siete dígitos");
			}
			
			
		}

		public String getAcrónimo() {
			//TODO
			return null;
		} 

		public String toString() {
			return "(" + codigo + ") " + nombre;
		}
		
		public boolean equals(Asignatura o) {
			if (this.codigo == o.codigo) {
				return true;
			} else {
				return false;
			}
		}
		
		

}
