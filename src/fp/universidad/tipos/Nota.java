package fp.universidad.tipos;

import java.util.Objects;

import fp.utiles.Checkers;

public record Nota(Asignatura asignatura, int cursoAcademico, TipoConvocatoria convocatoria, float valor, boolean matricula) implements Comparable<Nota>{
	
	//INICIAL
	
	public Nota {
		checkNota(valor, matricula);
	}
	
	//Constructor alternativo
	
	public Nota(String s) {
		this(parseAsignatura(s), parseCursoAcademico(s), parseConvocatoria(s), parseValor(s), parseMatricula(s));
		checkNota(valor, matricula);
	}
	
	//Parsers
	
	private static Asignatura parseAsignatura(String s) {
		String[] trozos = s.split(",");
        if (trozos.length != 5) {
            throw new IllegalArgumentException("Cadena con formato no válido");
        }
        return FactoriaUniversidad.creaAsignatura(trozos[0].trim());
	}
	
	private static Integer parseCursoAcademico(String s) {
		String[] trozos = s.split(",");
		return Integer.valueOf(trozos[1].trim());
	}
	
	private static TipoConvocatoria parseConvocatoria(String s) {
		String[] trozos = s.split(",");
		return TipoConvocatoria.valueOf(trozos[2].trim());
	}
	
	private static Float parseValor(String s) {
		String[] trozos = s.split(",");
		return Float.valueOf(trozos[3].trim());
	}
	
	private static Boolean parseMatricula(String s) {
		String[] trozos = s.split(",");
		return Boolean.valueOf(trozos[4].trim());
	}
	
	//Checkers
	
	private void checkNota(double nota, boolean matricula) {
		Checkers.check("Nota fuera del rango permitido", 
				!(nota <= 0 && nota >= 10));
		Checkers.check("No se puede tener matrícula de honor con una nota menor de 9", 
				!(nota < 9 && matricula == true));
	}
	
	//Getters y setters
	
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
	
	//Hashcode y equals
	
	public int hashCode() {
		return Objects.hash(asignatura, convocatoria, cursoAcademico);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Nota))
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura) && convocatoria == other.convocatoria
				&& cursoAcademico == other.cursoAcademico;
	}
	
	//Compareto
	
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
	
	//Tostring
	
	public String toString() {
		return asignatura.toString() + ", " + cursoAcademico + "-" + ((cursoAcademico % 100) + 1) + ", " + convocatoria + ", " + valor + ", " + getCalificacion(valor, matricula);
	}

}
