package Interfaces;

import modelado.Alumno;

public interface IListaAlumnos {
		
		public int contar();
		public String listado();
		void quitar(Alumno alumno);
		void agregar(Alumno alumno);
}

