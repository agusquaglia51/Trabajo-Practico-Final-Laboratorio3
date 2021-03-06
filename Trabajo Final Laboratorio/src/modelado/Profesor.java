package modelado;

public class Profesor extends Empleado{
	
	private String materiaQueEnsenia;
	private int cantidadDeCursos;  
	

	public Profesor() {
		// TODO Auto-generated constructor stub
		materiaQueEnsenia = null;
		cantidadDeCursos = 0;
	}


	public Profesor(float sueldo, String obraSocial, String telefono, String nroAsociado, String materiaQueEnsenia,
			int cantidadDeCursos) {
		super(sueldo, obraSocial, telefono, nroAsociado);
		this.materiaQueEnsenia = materiaQueEnsenia;
		this.cantidadDeCursos = cantidadDeCursos;
	}
	
	
	public Profesor(String nombre, String apellido, String dni, float sueldo, String obraSocial, String telefono,
			String nroAsociado, String materiaQueEnsenia, int cantidadDeCursos) {
		super(nombre, apellido, dni, sueldo, obraSocial, telefono, nroAsociado);
		this.materiaQueEnsenia = materiaQueEnsenia;
		this.cantidadDeCursos = cantidadDeCursos;
	}





	public int getCantidadDeCursos() {
		return cantidadDeCursos;
	}

	public void setCantidadDeCursos(int cantidadDeCursos) {
		this.cantidadDeCursos = cantidadDeCursos;
	}
	
	

	public void setMateriaQueEnsenia(String materiaQueEnsenia) {
		this.materiaQueEnsenia = materiaQueEnsenia;
	}


	public String getMateriaQueEnsenia() {
		return materiaQueEnsenia;
	}

	@Override
	public String toString() {
		return "Profesor [materiaQueEnsenia=" + materiaQueEnsenia + ", cantidadDeCursos=" + cantidadDeCursos + "]"+super.toString();
	}
	
	
	
}
