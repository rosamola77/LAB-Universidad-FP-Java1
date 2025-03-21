package fp.universidad.tipos.test;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Expediente;
import fp.universidad.tipos.Nota;
import fp.universidad.tipos.TipoAsignatura;
import fp.universidad.tipos.TipoConvocatoria;

public class TestExpediente {

	public static void main(String[] args) {
		
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 12.0f);
		Asignatura asignatura2 = new Asignatura("Circuitos", TipoAsignatura.PRIMER_CUATRIMESTRE, 1679267, 6.0f);
		Asignatura asignatura3 = new Asignatura("Estadística", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 6493587, 1.5f);
		Asignatura asignatura4 = new Asignatura("Administración de Empresas", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3265987, 4.5f);

		Nota n1 = new Nota(asignatura1, 2024, TipoConvocatoria.PRIMERA, 10.0f, true);
		Nota n2 = new Nota(asignatura2, 2023, TipoConvocatoria.SEGUNDA, 7.3f, false);
		Nota n3 = new Nota(asignatura3, 2020, TipoConvocatoria.TERCERA, 5.1f, false);
		Nota n4 = new Nota(asignatura4, 2021, TipoConvocatoria.SEGUNDA, 8.54f, false);
		
		Expediente e1 = new Expediente();
		e1.nuevaNota(n1);
		e1.nuevaNota(n2);
		e1.nuevaNota(n3);
		e1.nuevaNota(n4);
		System.out.println(e1.calcularMedia());
		System.out.println(e1.equals(e1));
		System.out.println(e1.equals(n3));
		System.out.println(e1.toString());
		
	}

}
