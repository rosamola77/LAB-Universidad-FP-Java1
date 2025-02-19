package fp.universidad.tipos;

public record Nota(Asignatura asignatura, int cursoAcademico, Convocatoria convocatoria, double valor, boolean matricula) {
	
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
	
	public Calificacion getCalificacion(double valor, boolean matricula) {
		
		if (valor < 5 && valor >= 0) {
            return Calificacion.SUSPENSO;
        } else if (valor < 7) {
            return Calificacion.APROBADO;
        } else if (valor < 9) {
            return Calificacion.NOTABLE;
        } else if (valor <= 10) {
        	if (matricula == true) {
        		return Calificacion.MATRICULA_DE_HONOR;
        	} else {
        		return Calificacion.SOBRESALIENTE;
        	}
            
        } else {
            throw new IllegalArgumentException(
					"Nota inválida");
        }
	}

	public String toString() {
		return asignatura.toString() + ", " + cursoAcademico + "-" + ((cursoAcademico % 100) + 1) + ", " + convocatoria + ", " + valor + ", " + getCalificacion(valor, matricula);
	}
	
	
	
}
