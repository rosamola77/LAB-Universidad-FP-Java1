package fp.universidad.tipos.test;

import fp.universidad.tipos.*;

public class TestNota {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537942, 6);
		Nota n1 = new Nota(asignatura1, 2024, TipoConvocatoria.PRIMERA, 5, false);
		
		System.out.println(n1.toString());
	}

}
