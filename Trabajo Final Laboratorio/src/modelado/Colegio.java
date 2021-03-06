package modelado;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Excepciones.CursoIncorrectException;

public class Colegio {
	
	private String nombre;
	
	private ListaEmpleados listaE;
	private HashMapAlumnos listaA;
	
	private Comision comision1roA;
	private Comision comision1roB;
	private Comision comision2doA;
	private Comision comision2doB;
	private Comision comision3roA;
	private Comision comision3roB;
	private Comision comision4toA;
	private Comision comision4toB;
	private Comision comision5toA;
	private Comision comision5toB;
	private Comision comision6toA;
	private Comision comision6toB;
	
	
	
	

	public Colegio() {
		// TODO Auto-generated constructor stub
	
		nombre = "";
		listaA = new HashMapAlumnos();
		listaE = new ListaEmpleados();
		comision1roA = new Comision();
		comision1roB = new Comision();
		comision2doA = new Comision();
		comision2doB = new Comision();
		comision3roA = new Comision();
		comision3roB = new Comision();
		comision4toA = new Comision();
		comision4toB = new Comision();
		comision5toA = new Comision();
		comision5toB = new Comision();
		comision6toA = new Comision();
		comision6toB = new Comision();
		
	}
	
	public Colegio(String nombre,ListaEmpleados listaE, HashMapAlumnos listaA) {
		super();
		this.nombre = nombre;
		this.listaE = listaE;
		this.listaA = listaA;
	}
	
	

	public Colegio(String nombre, ListaEmpleados listaE, HashMapAlumnos listaA, Comision comision1roA,
			Comision comision1roB, Comision comision2doA, Comision comision2doB, Comision comision3roA,
			Comision comision3roB, Comision comision4toA, Comision comision4toB, Comision comision5toA,
			Comision comision5toB, Comision comision6toA, Comision comision6toB) {
		super();
		this.nombre = nombre;
		this.listaE = listaE;
		this.listaA = listaA;
		this.comision1roA = comision1roA;
		this.comision1roB = comision1roB;
		this.comision2doA = comision2doA;
		this.comision2doB = comision2doB;
		this.comision3roA = comision3roA;
		this.comision3roB = comision3roB;
		this.comision4toA = comision4toA;
		this.comision4toB = comision4toB;
		this.comision5toA = comision5toA;
		this.comision5toB = comision5toB;
		this.comision6toA = comision6toA;
		this.comision6toB = comision6toB;
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

	public Comision getComision1roA() {
		return comision1roA;
	}

	public void setComision1roA(Comision comision1roA) {
		this.comision1roA = comision1roA;
	}

	public Comision getComision1roB() {
		return comision1roB;
	}

	public void setComision1roB(Comision comision1roB) {
		this.comision1roB = comision1roB;
	}

	public Comision getComision2doA() {
		return comision2doA;
	}

	public void setComision2doA(Comision comision2doA) {
		this.comision2doA = comision2doA;
	}

	public Comision getComision2doB() {
		return comision2doB;
	}

	public void setComision2doB(Comision comision2doB) {
		this.comision2doB = comision2doB;
	}

	public Comision getComision3roA() {
		return comision3roA;
	}

	public void setComision3roA(Comision comision3roA) {
		this.comision3roA = comision3roA;
	}

	public Comision getComision3roB() {
		return comision3roB;
	}

	public void setComision3roB(Comision comision3roB) {
		this.comision3roB = comision3roB;
	}

	public Comision getComision4toA() {
		return comision4toA;
	}

	public void setComision4toA(Comision comision4toA) {
		this.comision4toA = comision4toA;
	}

	public Comision getComision4toB() {
		return comision4toB;
	}

	public void setComision4toB(Comision comision4toB) {
		this.comision4toB = comision4toB;
	}

	public Comision getComision5toA() {
		return comision5toA;
	}

	public void setComision5toA(Comision comision5toA) {
		this.comision5toA = comision5toA;
	}

	public Comision getComision5toB() {
		return comision5toB;
	}

	public void setComision5toB(Comision comision5toB) {
		this.comision5toB = comision5toB;
	}

	public Comision getComision6toA() {
		return comision6toA;
	}

	public void setComision6toA(Comision comision6toA) {
		this.comision6toA = comision6toA;
	}

	public Comision getComision6toB() {
		return comision6toB;
	}

	public void setComision6toB(Comision comision6toB) {
		this.comision6toB = comision6toB;
	}
	
	
	public float porcentajeProfesorCursos(int cantidadCursos) {
        int contador=0;
        
        int total = listaE.contarProfesores();
        float porcentaje = 0;
        int i = 0;
        while(i < listaE.cantidadEmpleados()) {
            if(listaE.getEmpleado(i) instanceof Profesor) {
                Profesor aux = (Profesor) listaE.getEmpleado(i);
                if(aux.getCantidadDeCursos() >= cantidadCursos) {
                    contador++;
                }

            }

            i++;
        }
        
        porcentaje = contador*100;
        porcentaje = porcentaje/total;
        
        return porcentaje;
    }

	
	
	
	
	public void ActualizarCondicionDeAlumnos(HashMapAlumnos listaA) {  //SI TIENE MAS DE 15 FALTAS CAMBIAR LA CONDICION A NO REGULAR
		
		HashMap<Integer, Alumno> mapa = listaA.getMapa();
		Iterator<Entry<Integer, Alumno>> it = mapa.entrySet().iterator();
		
		while(it.hasNext()) {
			
			Alumno aux = new Alumno();
			
			Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer, Alumno>)it.next();
			aux = entry.getValue();
			if(aux.getCondicion() != "no regular" && aux.getFaltas() >= 15) {
				aux.setCondicion("no regular");
			}
			entry.setValue(aux);
			
		}
	}
	
	public void CambiarAlumnoDeComision(int legajo, String curso) throws CursoIncorrectException {
		Alumno aux = new Alumno();
		aux = listaA.getAlumno(legajo);
		if(curso == "A" || curso == "B") {
			aux.setCurso(curso);
		}else {
			throw new CursoIncorrectException("El curso que ha ingresado no es valido", curso);
		}
		
	}
	
	public float porcentajeAlumnosFaltas(int faltas) {
        // TODO Auto-generated method stub

		int contador = 0;
        
        float porcentaje = 0;
		
		HashMap<Integer, Alumno> mapa = listaA.getMapa();
		
        Iterator<Entry<Integer, Alumno>> it = mapa.entrySet().iterator();
        
        int total = mapa.size();

        while(it.hasNext()) {
        	
            Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer, Alumno>)it.next();
            
            if(entry.getValue().getFaltas() >= faltas) {
                contador++;
            }
        }
        
        porcentaje=contador*100;
        porcentaje=porcentaje/total;
            
        
        return porcentaje;
    }
	
	
	
	
	
	
	public void CrearCursos() {
		
		HashMap<Integer, Alumno> mapa = listaA.getMapa();
		Iterator<Entry<Integer, Alumno>> it = mapa.entrySet().iterator();
		
		while(it.hasNext()) {
			
			Alumno aux = new Alumno();
			
			Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer, Alumno>)it.next();
			
			aux = entry.getValue();
			
			switch(aux.getAnio()) {
				case 1:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
				case 2:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
				case 3:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
				case 4:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
				case 5:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
				case 6:
					if(aux.getCurso() == "A") {
						comision1roA.agregar(aux);
					}else {
						comision1roB.agregar(aux);
					}
					break;
			}
				
		}
	}
	
	
	
}
