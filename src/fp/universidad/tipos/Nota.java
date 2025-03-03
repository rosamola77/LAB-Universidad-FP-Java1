package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Nota(Asignatura asignatura, int cursoAcademico, TipoConvocatoria convocatoria, double valor, boolean matricula) implements Comparable<Nota>{
	
	public Nota {
		checkNota(valor, matricula);
	}
	
	private void checkNota(double nota, boolean matricula) {
		Checkers.check("Nota fuera del rango permitido", 
				!(nota <= 0 && nota >= 10));
		Checkers.check("No se puede tener matrícula de honor con una nota menor de 9", 
				!(nota < 9 && matricula == true));
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
	
	@Override
	public int hashCode() {
		return Objects.hash(asignatura, convocatoria, cursoAcademico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nota))
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura) && convocatoria == other.convocatoria
				&& cursoAcademico == other.cursoAcademico;
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
