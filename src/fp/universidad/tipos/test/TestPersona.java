package fp.universidad.tipos.test;

import fp.universidad.tipos.Persona;
import java.time.LocalDate;

public class TestPersona {

	public static void main(String[] args) {

		Persona p1 = new Persona("94764022F", "Pablo", "Motos Burgos", "pablomotos@elhormiguero.es", LocalDate.of(1965, 8, 31));
		Persona p2 = new Persona("83757536D", "Guccio", "Gucci", LocalDate.of(1972, 2, 29));
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
	}

}
