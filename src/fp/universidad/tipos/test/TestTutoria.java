package fp.universidad.tipos.test;

import fp.universidad.tipos.Tutoria;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestTutoria {

	public static void main(String[] args) {
		Tutoria t1 = new Tutoria(DayOfWeek.MONDAY, LocalTime.now().truncatedTo(ChronoUnit.SECONDS), 20);
		Tutoria t2 = new Tutoria(DayOfWeek.TUESDAY, LocalTime.now().truncatedTo(ChronoUnit.SECONDS), LocalTime.now().plusMinutes(45));
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
	}

}
