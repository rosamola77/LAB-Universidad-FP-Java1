package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 0.5f);
		System.out.println(asignatura1.toString());
		
	}

}
