package fp.universidad.tipos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, int duracion) implements Comparable<Tutoria> {
	
	public Tutoria {
		checkTutoria(dia, duracion);
	}

	public Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
		this(dia, horaInicio, horaFin, (int) Duration.between(horaInicio, horaFin).toMinutes());
	}

	public Tutoria(DayOfWeek dia, LocalTime horaInicio, int duracion) {
		this(dia, horaInicio, horaInicio.plusMinutes(duracion), duracion);
	}

	private static final Map<DayOfWeek, Character> DIA_INICIAL_MAP = new HashMap<>();
    static {
        DIA_INICIAL_MAP.put(DayOfWeek.MONDAY, 'L');
        DIA_INICIAL_MAP.put(DayOfWeek.TUESDAY, 'M');
        DIA_INICIAL_MAP.put(DayOfWeek.WEDNESDAY, 'X');
        DIA_INICIAL_MAP.put(DayOfWeek.THURSDAY, 'J');
        DIA_INICIAL_MAP.put(DayOfWeek.FRIDAY, 'V');
    }

    private void checkTutoria(DayOfWeek dia, int duracion) {
    	if (dia != DayOfWeek.SATURDAY || dia != DayOfWeek.SUNDAY) {
    		throw new IllegalArgumentException(
					"Día inválido, tutorías solo disponibles entre semana");
    	}
    	if (duracion < 15) {
    		throw new IllegalArgumentException(
					"La tutoría debe de ser de al menos 15 minutos");
    	}
    }
    
    private char traducirDia(DayOfWeek dia) {
        return DIA_INICIAL_MAP.getOrDefault(dia, '?');
    }

    public char getDia() {
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
    
    public boolean equals(Tutoria o) {
    	if (dia == o.dia && this.horaInicio == o.horaInicio) {
    		return true;
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
        return DIA_INICIAL_MAP.get(dia) + " " + getHoraInicio().truncatedTo(ChronoUnit.MINUTES) + "-" + getHoraFin().truncatedTo(ChronoUnit.MINUTES);
    }
}