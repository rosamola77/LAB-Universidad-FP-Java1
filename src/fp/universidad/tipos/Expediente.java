package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expediente {
	
	private List<Nota> notas;
	
	public Expediente() {
		super();
		this.notas = new ArrayList<Nota>();
	}
	
	public double calcularMedia(List<Nota> notas) {
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

	public List<Nota> getNotas() {
		return notas;
	}
	
	void nuevaNota(Nota n) {
		if (this.notas.contains(n)) {
			this.notas.remove(n);
			this.notas.add(n);
		} else {
		this.notas.add(n);
		}
	}
	
}
