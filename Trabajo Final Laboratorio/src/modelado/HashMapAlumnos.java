package modelado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Interfaces.IListaAlumnos;


public class HashMapAlumnos implements IListaAlumnos{

	private HashMap<Integer,Alumno> mapa;
	
	
	public HashMapAlumnos() {
		mapa = new HashMap<>();
	}
	
	@Override
	public void agregar(Alumno alumno) {
		// TODO Auto-generated method stub
		if(!existe(alumno.getLegajo())) {
			mapa.put(alumno.getLegajo(), alumno);
		}
		
	}
	

	@Override
	public void quitar(Alumno alumno) {
		// TODO Auto-generated method stub
		mapa.remove(alumno.getLegajo());
	}

	@Override
	public int contar() {
		// TODO Auto-generated method stub
		return mapa.size();
	}
	
	public boolean existe(Integer clave) {
		return mapa.containsKey(clave);
	}
	
	public void limpiarMapa() {
		mapa.clear();
	}
	
	public Alumno getAlumno(int legajo) {
		return mapa.get(legajo);
	}
	

	
	public HashMap<Integer, Alumno> getMapa() {
		return mapa;
	}

	@Override
	public String listado() {
		// TODO Auto-generated method stub
		
		Iterator<Entry<Integer, Alumno>> it = mapa.entrySet().iterator();
		StringBuilder builder = new StringBuilder();
		
		while(it.hasNext()) {
			Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer, Alumno>)it.next();
			builder.append(entry.getKey()+" / "+entry.getValue().toString()+"\n");
		}
		return builder.toString();
	}

}
