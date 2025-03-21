package fp.universidad.tipos.test;

import fp.universidad.tipos.*;

public class TestNota {

	public static void main(String[] args) {

		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 12.0f);
		Asignatura asignatura2 = new Asignatura("Circuitos", TipoAsignatura.PRIMER_CUATRIMESTRE, 1679267, 6.0f);
		Asignatura asignatura3 = new Asignatura("Estadística", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 6493587, 1.5f);
		Asignatura asignatura4 = new Asignatura("Administración de Empresas", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3265987, 4.5f);

		Nota n1 = new Nota(asignatura1, 2024, TipoConvocatoria.PRIMERA, 10.0f, true);
		Nota n2 = new Nota(asignatura2, 2023, TipoConvocatoria.SEGUNDA, 7.3f, false);
		Nota n3 = new Nota(asignatura3, 2020, TipoConvocatoria.TERCERA, 5.1f, false);
		Nota n4 = new Nota(asignatura4, 2021, TipoConvocatoria.SEGUNDA, 8.54f, false);
		
		System.out.println(n1.toString());
		System.out.println(n2.equals(n2));
		System.out.println(n3.equals(n4));
		System.out.println(n4.toString());
	}

}
