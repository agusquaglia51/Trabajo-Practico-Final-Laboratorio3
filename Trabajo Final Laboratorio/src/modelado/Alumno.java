package modelado;

import java.util.ArrayList;

public class Alumno extends Persona{
	private int legajo;
	private String telefono;
	private String anio; //1 2 3 4 5 6
	private String curso; // A (ma�ana)		B (tarde)
	private int faltas;
	
	

	public Alumno(int legajo, String telefono, String anio, String curso, int faltas) {
		super();
		this.legajo = legajo;
		this.telefono = telefono;
		this.anio = anio;
		this.curso = curso;
		this.faltas = faltas;
	}
	
	
	
	
	public Alumno(String nombre, String apellido, String dni, int legajo, String telefono, String anio, String curso,
			int faltas) {
		super(nombre, apellido, dni);
		this.legajo = legajo;
		this.telefono = telefono;
		this.anio = anio;
		this.curso = curso;
		this.faltas = faltas;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	public int getFaltas() {
		return faltas;
	}


	public int getLegajo() {
		return legajo;
	}




	public int compareTo(Alumno a) {
        if(getLegajo() >a.getLegajo()) return 1;
        else if(getLegajo() < a.getLegajo())return -1;
        else return 0;
    }
	
	

	@Override
	public String toString() {
		return "Alumno [Legajo=" + legajo + ", Telefono=" + telefono + ", anio=" + anio + ", curso=" + curso
				+ ", faltas= " + faltas + "] "+super.toString();
	}
	
	
}
