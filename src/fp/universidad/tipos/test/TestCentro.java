package fp.universidad.tipos.test;

import java.util.HashSet;
import java.util.Set;

import fp.universidad.tipos.Centro;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;

public class TestCentro {

	public static void main(String[] args) {
		
		Espacio e1 = new Espacio("H0.13", 120, 0, TipoEspacio.TEORIA);
		Espacio e2 = new Espacio("F1.33", 12, 1, TipoEspacio.LABORATORIO);
		Espacio e3 = new Espacio("A2.16", 100, 2, TipoEspacio.EXAMEN);
		
		Set<Espacio> espacios = new HashSet<Espacio>();
		espacios.add(e1);
		espacios.add(e2);
		espacios.add(e3);
		
		Centro c = new Centro("Escuela Técnica Superior de Ingeniería informática", "Av. Reina Mercedes S/N", 3, 1);
		
		System.out.println(c.equals(e3));
		System.out.println(c.equals(c));
		System.out.println(c.getDireccion());
		System.out.println(c.toString());
		System.out.println(c.getEspacioMayorCapacidad());
		System.out.println(c.getConteosEspacios());
		
	}

}
