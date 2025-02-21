package fp.universidad.tipos;

public record Nota(Asignatura asignatura, int cursoAcademico, TipoConvocatoria convocatoria, double valor, boolean matricula) implements Comparable<Nota>{
	
	public Nota {
		checkNota(valor, matricula);
	}
	
	private void checkNota(double nota, boolean matricula) {
		
		if (nota <= 0 && nota >= 10) {
			throw new IllegalArgumentException(
					"Nota fuera del rango permitido");
		}
		
		if (nota < 9 && matricula == true) {
			throw new IllegalArgumentException(
					"No se puede tener matrícula de honor con una nota menor de 9");
		}	
		
	}
	
	public TipoCalificacion getCalificacion(double valor, boolean matricula) {
		
		if (valor < 5 && valor >= 0) {
            return TipoCalificacion.SUSPENSO;
        } else if (valor < 7) {
            return TipoCalificacion.APROBADO;
        } else if (valor < 9) {
            return TipoCalificacion.NOTABLE;
        } else if (valor <= 10) {
        	if (matricula == true) {
        		return TipoCalificacion.MATRICULA_DE_HONOR;
        	} else {
        		return TipoCalificacion.SOBRESALIENTE;
        	}
            
        } else {
            throw new IllegalArgumentException(
					"Nota inválida");
        }
	}
	
	public boolean equals(Nota o) {
		if (this.cursoAcademico == o.cursoAcademico && 
				this.asignatura == o.asignatura && 
				this.convocatoria == o.convocatoria) {
			return true;
		} else {
			return false;
		}
	}
	
	public int compareTo(Nota o) {
		int r = Integer.valueOf(cursoAcademico).compareTo(Integer.valueOf(o.cursoAcademico));
		if (r == 0) {
			r = asignatura.compareTo(o.asignatura);
			if (r == 0) {
				r = convocatoria.compareTo(o.convocatoria);
			}
		}
		return r;
	}

	public String toString() {
		return asignatura.toString() + ", " + cursoAcademico + "-" + ((cursoAcademico % 100) + 1) + ", " + convocatoria + ", " + valor + ", " + getCalificacion(valor, matricula);
	}
	
	
	
}
