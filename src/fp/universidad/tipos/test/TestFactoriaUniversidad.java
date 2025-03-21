package fp.universidad.tipos.test;

import java.util.List;

import fp.universidad.tipos.Alumno;
import fp.universidad.tipos.Asignatura;
import fp.universidad.tipos.Despacho;
import fp.universidad.tipos.Espacio;
import fp.universidad.tipos.FactoriaUniversidad;
import fp.universidad.tipos.Nota;

public class TestFactoriaUniversidad {

	public static void main(String[] args) {
		
		List<Espacio> espaciosLeidos = FactoriaUniversidad.leeEspacios("C:\\Users\\alvar\\git\\LAB-Universidad-FP-Java1\\data\\espacios.csv");
		
//		for (Espacio e : espaciosLeidos) {
//			System.out.println(e.toString());
//		}
		
		List<Despacho> despachosLeidos = FactoriaUniversidad.leeDespachos("C:\\Users\\alvar\\git\\LAB-Universidad-FP-Java1\\data\\despachos.csv");
		
//		for (Despacho d : despachosLeidos) {
//			System.out.println(d.toString());
//		}
		
		List<Alumno> alumnosLeidos = FactoriaUniversidad.leeAlumnos("C:\\Users\\alvar\\git\\LAB-Universidad-FP-Java1\\data\\alumnos.csv");
		
//		for (Alumno a : alumnosLeidos) {
//		System.out.println(a.toString());
//		}
		
		List<Asignatura> asignaturasLeidos = FactoriaUniversidad.leeAsignaturas("C:\\Users\\alvar\\git\\LAB-Universidad-FP-Java1\\data\\asignaturas.txt");
		
//		for (Asignatura a : asignaturasLeidos) {
//		System.out.println(a.toString());
//		}
		
		List<Nota> notasLeidos = FactoriaUniversidad.leeNotas("C:\\Users\\alvar\\git\\LAB-Universidad-FP-Java1\\data\\notas.csv");
		
//		for (Nota n : notasLeidos) {
//		System.out.println(n.toString());
//		}
		
	}

}
