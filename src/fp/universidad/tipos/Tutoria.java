package fp.universidad.tipos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import fp.utiles.Checkers;

import java.time.Duration;
import java.time.DayOfWeek;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, int duracion) implements Comparable<Tutoria> {
	
	public Tutoria {
		checkTutoria(dia, duracion);
	}

	public Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
		this(dia, horaInicio, horaFin, (Duration.between(horaInicio, horaFin).toMinutesPart()));
	}

	public Tutoria(DayOfWeek dia, LocalTime horaInicio, int duracion) {
		this(dia, horaInicio, horaInicio.plusMinutes(duracion), duracion);
	}

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
    
	public int hashCode() {
		return Objects.hash(dia, horaInicio);
	}

    public boolean equals(Object o) {
    	if (o instanceof Tutoria) {
    		Tutoria t = (Tutoria) o;
    		if (dia == t.dia && this.horaInicio == t.horaInicio) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
	public int compareTo(Tutoria o) {
    	int r = dia.compareTo(o.dia);
    	if (r == 0) {
    		r = horaInicio.compareTo(o.horaInicio);
    	}
    	return r;
    }

    public String toString() {
        return getDia(dia) + " " + getHoraInicio().truncatedTo(ChronoUnit.MINUTES) + "-" + getHoraFin().truncatedTo(ChronoUnit.MINUTES);
    }
}