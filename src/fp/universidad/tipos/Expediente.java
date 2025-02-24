package fp.universidad.tipos;

import java.util.ArrayList;
import java.util.List;

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

	public List<Nota> getNotas() {
		return notas;
	}
	
	
	
}
