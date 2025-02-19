package fp.universidad.tipos.test;

import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Espacio e1 = new Espacio("H0.13", 120, 0, TipoEspacio.TEORIA);
		Espacio e2 = new Espacio("F1.33", 12, 1, TipoEspacio.LABORATORIO);
		Espacio e3 = new Espacio("A2.16", 100, 2, TipoEspacio.EXAMEN);
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		
	}

}
