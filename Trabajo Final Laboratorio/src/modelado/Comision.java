package modelado;

import java.util.ArrayList;

import Interfaces.IListaAlumnos;

public class Comision implements IListaAlumnos{
	
	private ArrayList<Alumno> comision;
	
	public Comision() {
		// TODO Auto-generated constructor stub
		comision = new ArrayList<Alumno>();
	}
	
	
	@Override
	public void quitar(Alumno alumno) {
		// TODO Auto-generated method stub
		comision.remove(alumno);
	}

	@Override
	public void agregar(Alumno alumno) {
		// TODO Auto-generated method stub
		comision.add(alumno);
	}

	@Override
	public int contar() {
		// TODO Auto-generated method stub
		return comision.size();
	}

	@Override
	public String listado() {
		StringBuilder sb=new StringBuilder();
		for(int i = 0; i < comision.size(); i++) {
			Alumno aux = (Alumno)comision.get(i);
			sb.append(aux.getNombreCompleto()+"\n");
        }
        return sb.toString();
	}

	
	
	
}
