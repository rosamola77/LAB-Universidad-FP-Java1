package fp.universidad.tipos;

public class Espacio {
		
	private String nombre;
	private int capacidad, planta;
	private TipoEspacio tipo;
	
	public Espacio() {
		checkEspacio(capacidad);
	}

	public Espacio(String nombre, int capacidad, final int planta, TipoEspacio tipo) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
		this.tipo = tipo;
	}

	private void checkEspacio(int capacidad) {
		if (capacidad <= 0) {
			throw new IllegalArgumentException(
					"La capacidad debe de ser mayor a 0");
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPlanta() {
		return  planta;
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return nombre + " (planta " + planta + ")";
	}
	
	
	
}
