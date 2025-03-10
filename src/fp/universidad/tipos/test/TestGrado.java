package fp.universidad.tipos.test;

import java.util.HashSet;
import java.util.Set;

import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Grado;
import fp.universidad.tipos.TipoAsignatura;

public class TestGrado {

	public static void main(String[] args) {
		
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 12.0f);
		Asignatura asignatura2 = new Asignatura("Circuitos", TipoAsignatura.PRIMER_CUATRIMESTRE, 1679267, 6.0f);
		Asignatura asignatura3 = new Asignatura("Estadística", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 6493587, 1.5f);
		Asignatura asignatura4 = new Asignatura("Administración de Empresas", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3265987, 4.5f);
		
		Set<Asignatura> obligatorias = new HashSet<Asignatura>();
		Set<Asignatura> optativas = new HashSet<Asignatura>();
		obligatorias.add(asignatura1);
		obligatorias.add(asignatura2);
		optativas.add(asignatura3);
		optativas.add(asignatura4);
		
		Grado g = new Grado("Grado en Ingeniería informática - Tecnologías Informáticas", obligatorias, optativas, 1.5f);
		System.out.println(g.equals(g));
		System.out.println(g.equals(asignatura1));
		System.out.println(g.creditosObligatorias());
		System.out.println(g.getMinCreditosOptativas());
		System.out.println(g.totalCreditosTitulo());
		System.out.println(g.getAsiganturas());
		System.out.println(g.toString());
		
	}
	
}
