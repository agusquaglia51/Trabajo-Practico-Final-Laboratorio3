package modelado;

public class Administrativo extends Empleado{
	
	private String departamentoDeTrabajo; // atencion y recepcion de padres, secretaria escolar, gestion contable


	
	public Administrativo(float sueldo, String obraSocial, String telefono, String nroAsociado,
			String departamentoDeTrabajo) {
		super(sueldo, obraSocial, telefono, nroAsociado);
		this.departamentoDeTrabajo = departamentoDeTrabajo;
	}
	

	public Administrativo(String nombre, String apellido, String dni, float sueldo, String obraSocial, String telefono,
			String nroAsociado, String departamentoDeTrabajo) {
		super(nombre, apellido, dni, sueldo, obraSocial, telefono, nroAsociado);
		this.departamentoDeTrabajo = departamentoDeTrabajo;
	}



	
	
	public String getDepartamentoDeTrabajo() {
		return departamentoDeTrabajo;
	}


	public void setDepartamentoDeTrabajo(String departamentoDeTrabajo) {
		this.departamentoDeTrabajo = departamentoDeTrabajo;
	}


	@Override
	public String toString() {
		return "Administrativo [departamentoDeTrabajo=" + departamentoDeTrabajo + "]"+super.toString();
	}
	
	
	
}
