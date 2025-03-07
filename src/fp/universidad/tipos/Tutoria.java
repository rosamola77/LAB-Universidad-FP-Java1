package fp.universidad.tipos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import fp.utiles.Checkers;

import java.time.Duration;
import java.time.DayOfWeek;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, int duracion) implements Comparable<Tutoria> {
	
	//INICIAL
	
	public Tutoria {
		checkTutoria(dia, duracion);
	}
	
	//Constructores alternativos
	
	public Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
		this(dia, horaInicio, horaFin, (Duration.between(horaInicio, horaFin).toMinutesPart()));
	}

	public Tutoria(DayOfWeek dia, LocalTime horaInicio, int duracion) {
		this(dia, horaInicio, horaInicio.plusMinutes(duracion), duracion);
	}
	
	//Checkers
	
    private void checkTutoria(DayOfWeek dia, int duracion) {
    	if (duracion < 15) {
    		throw new IllegalArgumentException(
					"La tutoría debe de ser de al menos 15 minutos");
    	}
    	Checkers.check("Día inválido, tutorías solo disponibles entre semana", 
    			dia != DayOfWeek.SATURDAY || dia != DayOfWeek.SUNDAY);
    	Checkers.check("La tutoría debe de ser de al menos 15 minutos", 
    			duracion >= 15);
    }
    
    //Coger la inicial de la semana
    
    private char traducirDia(DayOfWeek dia) {
    	return switch(dia) {
    		case MONDAY -> 'L';
    		case TUESDAY -> 'M';
    		case WEDNESDAY -> 'X';
    		case THURSDAY -> 'J';
    		case FRIDAY -> 'V';
    			default -> '?';
    		};
    	
    }
    
    //Getters y setters
    
    public char getDia(DayOfWeek dia) {
        return traducirDia(dia);
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public int getDuracion() {
        return duracion;
    }
    
    //Tostring
    
    public String toString() {
        return getDia(dia) + " " + getHoraInicio().truncatedTo(ChronoUnit.MINUTES) + "-" + getHoraFin().truncatedTo(ChronoUnit.MINUTES);
    }
    
    //Hashcode y equals
    
	public int hashCode() {
		return dia.hashCode() + horaInicio.hashCode()*31;
	}
	
    public boolean equals(Object o) {
    	if (o instanceof Tutoria) {
    		Tutoria t = (Tutoria) o;
    		if (dia == t.dia && horaInicio == t.horaInicio) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
    
    //CompareTo
    
	public int compareTo(Tutoria o) {
    	int r = dia.compareTo(o.dia);
    	if (r == 0) {
    		r = horaInicio.compareTo(o.horaInicio);
    	}
    	return r;
    }

}