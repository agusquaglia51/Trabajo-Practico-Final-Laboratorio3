package modelado;



public class Empleado extends Persona{
	
	private float sueldo;
	private String obraSocial;
	private String telefono;
	private String nroAsociado;
	
	
	public Empleado() {
		// TODO Auto-generated constructor stub
		sueldo = 0;
		obraSocial = null;
		telefono = null;
		nroAsociado = null;
	}


	public Empleado(float sueldo, String obraSocial, String telefono, String nroAsociado) {
		super();
		this.sueldo = sueldo;
		this.obraSocial = obraSocial;
		this.telefono = telefono;
		this.nroAsociado = nroAsociado;
	}
	
	



	public Empleado(String nombre, String apellido, String dni, float sueldo, String obraSocial, String telefono,
			String nroAsociado) {
		super(nombre, apellido, dni);
		this.sueldo = sueldo;
		this.obraSocial = obraSocial;
		this.telefono = telefono;
		this.nroAsociado = nroAsociado;
	}


	

	
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNroAsociado() {
		return nroAsociado;
	}

	public void setNroAsociado(String nroAsociado) {
		this.nroAsociado = nroAsociado;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Empleado)) {
			return false;
		}
		Empleado other = (Empleado) obj;
		if (nroAsociado != other.nroAsociado) {
			return false;
		}
		return true;
	}
	
	
	

	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", obraSocial=" + obraSocial + ", telefono=" + telefono + ", nroAsociado="
				+ nroAsociado + "]"+ super.toString();
	}
	
	
	

	
}
