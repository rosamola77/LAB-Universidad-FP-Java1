package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 12.0f);
		Asignatura asignatura2 = new Asignatura("Circuitos", TipoAsignatura.PRIMER_CUATRIMESTRE, 1679267, 6.0f);
		Asignatura asignatura3 = new Asignatura("Estadística", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 6493587, 1.5f);
		Asignatura asignatura4 = new Asignatura("Administración de Empresas", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3265987, 4.5f);
		
		System.out.println(asignatura1.toString());
		System.out.println(asignatura1.compareTo(asignatura2));
		System.out.println(asignatura3.hashCode());
		System.out.println(asignatura1.equals(asignatura3));
		System.out.println(asignatura4.tipo());
	}

}
