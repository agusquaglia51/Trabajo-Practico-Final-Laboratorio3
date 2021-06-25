package modelado;

public class Colegio {
	
	private String nombre;
	private ListaEmpleados listaE;
	private HashMapAlumnos listaA;
	
	public Colegio() {
		// TODO Auto-generated constructor stub
	
		listaA = new HashMapAlumnos();
		listaE = new ListaEmpleados();
	}
	
	public Colegio(String nombre,ListaEmpleados listaE, HashMapAlumnos listaA) {
		super();
		this.nombre = nombre;
		this.listaE = listaE;
		this.listaA = listaA;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ListaEmpleados getListaE() {
		return listaE;
	}

	public void setListaE(ListaEmpleados listaE) {
		this.listaE = listaE;
	}

	public HashMapAlumnos getListaA() {
		return listaA;
	}

	public void setListaA(HashMapAlumnos listaA) {
		this.listaA = listaA;
	}
	
	
	
	
}
