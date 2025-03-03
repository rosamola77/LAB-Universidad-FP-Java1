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
		for (Nota nota : notas) {
			if (nota.valor() >= 5) {
				r = r + nota.valor();
			}
		}
		r = r / notas.size();
		return r;
	}
	
	public int hashCode() {
		return Objects.hash(notas);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Expediente)) {
			return false;
		}
		Expediente other = (Expediente) o;
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
