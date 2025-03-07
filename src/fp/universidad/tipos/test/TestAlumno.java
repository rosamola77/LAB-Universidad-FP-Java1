package fp.universidad.tipos.test;

import java.time.LocalDate;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.TipoAsignatura;

public class TestAlumno {

	public static void main(String[] args) {
		
		Alumno p1 = new Alumno("82839573D", "Dixon", "Mayas", "dixonmayas@alum.us.es", LocalDate.of(1980, 3, 20));
		Alumno p2 = new Alumno("32549816F", "Quepo", "John", "quepojohn@alum.us.es", LocalDate.of(1976, 7, 12));
		Alumno p3 = new Alumno("21659887X", "Lola", "Montero", "lolamontero@alum.us.es", LocalDate.of(1999, 3, 7));
		
		Asignatura asignatura1 = new Asignatura("Fundamentos de Programación", TipoAsignatura.ANUAL, 8537292, 12.0f);
		Asignatura asignatura2 = new Asignatura("Circuitos", TipoAsignatura.PRIMER_CUATRIMESTRE, 1679267, 6.0f);
		Asignatura asignatura3 = new Asignatura("Estadística", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 6493587, 1.5f);
		Asignatura asignatura4 = new Asignatura("Administración de Empresas", TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3265987, 4.5f);
		
		p1.matriculaAsignatura(asignatura1);
		p1.matriculaAsignatura(asignatura2);
		p1.matriculaAsignatura(asignatura3);
		p1.matriculaAsignatura(asignatura4);
		p2.matriculaAsignatura(asignatura1);
		p2.matriculaAsignatura(asignatura2);
		p2.matriculaAsignatura(asignatura3);
		p2.matriculaAsignatura(asignatura4);
		p3.matriculaAsignatura(asignatura1);
		p3.matriculaAsignatura(asignatura2);
		p3.matriculaAsignatura(asignatura3);
		p3.matriculaAsignatura(asignatura4);
		
		System.out.println(p1.getAsignaturas());
		System.out.println(p1.toString());
		p1.eliminaAsignatura(asignatura3);
		System.out.println(p1.getAsignaturas());
		p2.eliminaAsignatura(asignatura1);
		p2.eliminaAsignatura(asignatura4);
		System.out.println(p2.getAsignaturas());
		System.out.println(p2.toString());
		p3.eliminaAsignatura(asignatura1);
		System.out.println(p3.getAsignaturas());
		System.out.println(p3.toString());
		
	}

}
