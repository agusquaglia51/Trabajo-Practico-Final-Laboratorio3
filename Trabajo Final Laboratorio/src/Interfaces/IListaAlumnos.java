package Interfaces;

import modelado.Alumno;

public interface IListaAlumnos {
		
		public int contar();
		public String listado();
		public void quitar(Alumno alumno);
		public void agregar(Alumno alumno);
}

