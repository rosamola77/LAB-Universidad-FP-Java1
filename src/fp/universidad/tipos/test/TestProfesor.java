package fp.universidad.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.universidad.tipos.Profesor;
import fp.universidad.tipos.TipoCategoria;

public class TestProfesor {

	public static void main(String[] args) {
		
		Profesor p1 = new Profesor("82839573D", "Dixon", "Mayas", "dixonmayas@us.es", LocalDate.of(1980, 3, 20), TipoCategoria.TITULAR);
		Profesor p2 = new Profesor("32549816F", "Quepo", "John", "quepojohn@us.es", LocalDate.of(1976, 7, 12), TipoCategoria.CATEDRATICO);
		Profesor p3 = new Profesor("21659887X", "Lola", "Montero", "lolamontero@us.es", LocalDate.of(1999, 3, 7), TipoCategoria.INTERINO);
		
		p1.toString();
		
		p1.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 20, DayOfWeek.MONDAY);
		p1.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 35, DayOfWeek.FRIDAY);
		p2.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 45, DayOfWeek.THURSDAY);
		p2.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 15, DayOfWeek.TUESDAY);
		p3.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 25, DayOfWeek.WEDNESDAY);
		p3.nuevaTutoria(LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 30, DayOfWeek.TUESDAY);
		
		System.out.println(p1.getTutorias());
		p1.borraTutorias();
		System.out.println(p1.getTutorias());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		
	}

}
