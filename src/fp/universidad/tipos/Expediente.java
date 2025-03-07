package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expediente {
	
	//INICIAL
	
	private List<Nota> notas;
	
	//Constructor
	
	public Expediente() {
		this.notas = new ArrayList<Nota>();
	}
	
	//Calcular la media
	
	public double calcularMedia() {
		double r = 0.0;
		int aprobadas = 0;
		for (Nota nota : notas) {
			if (nota.valor() >= 5) {
				r = r + nota.valor();
				aprobadas++;
			}
		}
		r = r / aprobadas;
		return r;
	}
	
	//Getters y setters
	
	public List<Nota> getNotas() {
		return notas;
	}	
	
	//Tostring
	
	public String toString() {
		return notas.toString();
	}	
	
	//Hashcode y equals
	
	public int hashCode() {
		return Objects.hash(notas);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Expediente)) {
			return false;
		}
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}

	//Funcionalidades
	
	public void nuevaNota(Nota n) {
		if (this.notas.contains(n)) {
			this.notas.remove(n);
			this.notas.add(n);
		} else {
		this.notas.add(n);
		}
	}
	
}
