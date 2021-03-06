package app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.JarException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Excepciones.CursoIncorrectException;
import Excepciones.PasswordIncorrectException;
import modelado.ListaEmpleados;
import modelado.Profesor;
import modelado.Administrativo;
import modelado.Alumno;
import modelado.Colegio;
import modelado.Empleado;
import modelado.HashMapAlumnos;
import modelado.JsonUtiles;



public class Main {
	
	static Scanner scan;

	public static void main(String[] args) throws CursoIncorrectException {
		
		
		Colegio SanAgustin = new Colegio();
		
		
		Menu(SanAgustin);
		
		
		
	}
	
	
	
	
	
	public static String devolverJSON(Colegio colegio){
		
		String jsonToString = "";
		
		JsonUtiles jsonArchivo = new JsonUtiles();
		
		try {
			
			JSONObject unColegio = new JSONObject();
			
			JSONArray misProfesores = new JSONArray();
			
			JSONArray misAdministrativos = new JSONArray();
			
			
			unColegio.put("Nombre del Colegio", colegio.getNombre());
			
			
			int i = 0;
			
			while(i < colegio.getListaE().cantidadEmpleados()){
				
				if(colegio.getListaE().getEmpleado(i) instanceof Profesor) {
					
					Profesor aux = (Profesor) colegio.getListaE().getEmpleado(i);
					
					JSONObject unProfesor = new JSONObject();
					
					unProfesor.put("Nombre", aux.getNombre());
					unProfesor.put("Apellido", aux.getApellido());
					unProfesor.put("Sueldo", aux.getSueldo());
					unProfesor.put("ObraSocial", aux.getObraSocial());
					unProfesor.put("Telefono", aux.getTelefono());
					unProfesor.put("NroAsociado", aux.getNroAsociado());
					unProfesor.put("Materia", aux.getMateriaQueEnsenia());
					unProfesor.put("CursosAcargo", aux.getCantidadDeCursos());
					
					misProfesores.put(unProfesor);
					
				}else {
					
					Administrativo aux = (Administrativo) colegio.getListaE().getEmpleado(i);
					
					JSONObject unAdministrativo = new JSONObject();
					
					unAdministrativo.put("Nombre", aux.getNombre());
					unAdministrativo.put("Apellido", aux.getApellido());
					unAdministrativo.put("DNI ", aux.getDNI());
					unAdministrativo.put("Sueldo", aux.getSueldo());
					unAdministrativo.put("ObraSocial", aux.getObraSocial());
					unAdministrativo.put("Telefono", aux.getTelefono());
					unAdministrativo.put("NroAsociado", aux.getNroAsociado());
					unAdministrativo.put("Materia", aux.getDepartamentoDeTrabajo());
					
					misAdministrativos.put(unAdministrativo);
				}
				
				
				i++;
			}
			
			
			
			
			unColegio.put("Profesores", misProfesores);
			unColegio.put("Administrativos", misAdministrativos);
			
			jsonArchivo.grabar(unColegio);

		
			
			jsonToString = unColegio.toString();
	            
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonToString;
	}
	
	
	
	
	
	
	
	
	
	public static boolean superLogin(String usuario, String contrase?a)  {
		boolean flag = false;
		
        try {
            flag = login(usuario,contrase?a);
        } 
        catch (NullPointerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return flag;
    }
	
	public static boolean login(String usuario, String contrase?a) throws PasswordIncorrectException,NullPointerException {
		boolean flag = false;
		
        if(usuario == null || contrase?a == null) {
            throw new NullPointerException("nfldmlk");
        }
        
        if(usuario.isEmpty() || contrase?a.isEmpty()) {
            throw new PasswordIncorrectException("password incorrect",contrase?a);
        }
        
        if((usuario.compareTo("admin") == 0) && (contrase?a.compareTo("admin") == 0)) {
        	flag = true;
        	System.out.println("BIENVENIDO !!!");
        }else {
        	System.out.println("El usuario o la contrase?a son incorrectos");
        }
        
        return flag;
    }
	
	
	public static void Menu(Colegio SanAgustin) throws CursoIncorrectException {
		
		
		
		String usuario;
		String contra;
		int opc1, opc2, anio, legajo, cantidadFaltas = 0, cursosCargo = 0;
		String curso = "";
		
		scan = new Scanner(System.in);
		
		
		Profesor profe1 = new Profesor("Agustin", "Quagliarella", "39826712", 70000, "OSDE", "123456", "00124500", "Biologia", 7);
		Profesor profe2 = new Profesor("Juan", "Garcia", "35821712", 70000, "OSDE", "123654", "00123400", "Matematica", 5);

		Alumno alumno1 = new Alumno("Jose", "Garcia", "38265333", 123456789, "2235135789", 5, "B",10);
		Alumno alumno2 = new Alumno("Jose", "Perez", "38265333", 123451239, "2235135789", 6, "B",20);
		
		Administrativo administrativo1 = new Administrativo(500000,"OSDE","223545545","001989800","gestion contable");
		
		
		do {
			System.out.println("Usuario: ");
			usuario = scan.next();
			System.out.println("contrase?a: ");
			contra = scan.next();
		}while(superLogin(usuario,contra) == false);
		
		
		do {
		
			System.out.println("\n   ///// MENU /////   \n");
			
			System.out.println("1. Administrar empleados \n");
			System.out.println("2. Administrar alumnos \n");
			System.out.println("3. Mostrar json por pantalla y cargarlo a un archivo \n");
			System.out.println("4. Salir \n");
			
			System.out.println("Digite la opcion que desea realizar: \n");
			opc1 = scan.nextInt();
			
			switch(opc1) {
				case 1:
					
					do {
						System.out.println("\n   ///// MENU /////   \n");
						
						System.out.println("1. Agregar un empleado a la lista \n");
						System.out.println("2. Quitar un empelado de la lista \n");
						System.out.println("3. Ver la cantidad de profesores \n");
						System.out.println("4. Ver la cantidad de administrativos \n");
						System.out.println("5. Imprimir listado de profesores \n");
						System.out.println("6. Imprimir listado de administrativos \n");
						System.out.println("7. Buscar un empleado \n");
						System.out.println("8. Mostrar porcentaje de profesores con cierta cantidad de cursos a cargo \n");
						System.out.println("9. Salir \n");
						
						System.out.println("Digite la opcion que desea realizar: \n");
						opc2 = scan.nextInt();
						
						
						switch(opc2) {
							case 1:
								SanAgustin.getListaE().agregarEmpleado(profe1); //ESTO ESTA HARDCODEADO PARA PROBAR EL PROGRAMA
								SanAgustin.getListaE().agregarEmpleado(administrativo1);//ESTO ESTA HARDCODEADO PARA PROBAR EL PROGRAMA
								System.out.println("Se agrego un empleado correctamente \n");									
								break;
								
							case 2:
								SanAgustin.getListaE().eliminarEmpelado(profe1);
								System.out.println("Se elimino un empleado correctamente \n");
								break;
								
							case 3:
								System.out.println("La cantidad de profesores es de :" + SanAgustin.getListaE().contarProfesores() +"\n");
								break;
								
							case 4:
								System.out.println("La cantiada de administrativos es de: "+ SanAgustin.getListaE().contarAdministrativos()+"\n");
								break;
								
							case 5:
								System.out.println(SanAgustin.getListaE().listadoProfesores());
								break;
								
							case 6:
								System.out.println(SanAgustin.getListaE().listadoAdministrativos());
								break;
								
							case 7:
								String control3 = "s";
								while(control3 == "s") {
									System.out.println("El empleado se encuentra en la lista: " + SanAgustin.getListaE().buscarEmpleado(profe1));
									System.out.println("Desea buscar otro? s/n: ");
									control3 = scan.next();
								}
								break;
							
							case 8:
								System.out.println("Digite la cantidad de cursos a cargo: ");
								cursosCargo = scan.nextInt();
								System.out.println("El porcentaje de profesores con mas cantidad de cursos que la ingresada es: " + SanAgustin.porcentajeProfesorCursos(cursosCargo)+" % \n");
								break;
								
							case 9:
								break;
						}
						
					}while(opc2 != 9);
					break;
					
				case 2:
					
					do {
						System.out.println("\n   ///// MENU /////   \n");
						
						System.out.println("1. Agregar un alumno a la lista \n");
						System.out.println("2. Quitar un  alumno de la lista \n");
						System.out.println("3. Ver la cantidad de alumnos \n");
						System.out.println("4. Imprimir listado de alumnos \n");
						System.out.println("5. Limpiar lista de alumnos \n");
						System.out.println("6. Crear comisiones \n");
						System.out.println("7. Mostrar comision \n");
						System.out.println("8. Actualizar condicion de alumnos (si tienen mas de 15 faltas pasan a ser no regular) \n");
						System.out.println("9. Cambiar alumno de comision (A o B) \n");
						System.out.println("10. Mostrar el porcentaje de alumnos con cierta cantidad de faltas \n");

						System.out.println("11. Salir\n");
						
						System.out.println("Digite la opcion que desea realizar: ");
						opc2 = scan.nextInt();
					
					
					
						switch(opc2) {
						
							case 1:
								SanAgustin.getListaA().agregar(alumno1);//ESTO ESTA HARDCODEADO PARA PROBAR EL PROGRAMA
								SanAgustin.getListaA().agregar(alumno2);//ESTO ESTA HARDCODEADO PARA PROBAR EL PROGRAMA
								System.out.println("Se agrego un alumno correctamente \n");
								break;
							
							case 2:
								
								SanAgustin.getListaA().quitar(alumno1);
								System.out.println("Se quito un alumno correctamente \n");
		
								break;
								
							case 3:
								System.out.println("La cantidad de alumnos es de : "+SanAgustin.getListaA().contar()+"\n");
								break;
								
							case 4:
								System.out.println(SanAgustin.getListaA().listado());
								break;
								
							case 5:
								SanAgustin.getListaA().limpiarMapa();
								System.out.println("La lista se ha limpiado con exito! \n");
								break;
								
							case 6:
								SanAgustin.CrearCursos();
								System.out.println("Se han creado las comisiones! \n");
								break;
								
							case 7:
								System.out.println("Digite el anio que desea imprimir por pantalla: ");
								anio = scan.nextInt();
								
								switch(anio) {
									case 1:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision1roA().listado());
										}else {
											System.out.println(SanAgustin.getComision1roB().listado());
										}
										break;
										
									case 2:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision2doA().listado());
										}else {
											System.out.println(SanAgustin.getComision2doB().listado());
										}
										break;
										
									case 3:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision3roA().listado());
										}else {
											System.out.println(SanAgustin.getComision3roB().listado());
										}
										break;
										
									case 4:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision4toA().listado());
										}else {
											System.out.println(SanAgustin.getComision4toB().listado());
										}
										break;
									case 5:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision5toA().listado());
										}else {
											System.out.println(SanAgustin.getComision5toB().listado());
										}
										break;
										
									case 6:
										System.out.println("Digite el turno que desea ver, pulse 'A' para ver el turno ma?ana o 'B' para ver el turno tarde: ");
										curso = scan.nextLine();
										if(curso == "A") {
											System.out.println(SanAgustin.getComision6toA().listado());
										}else {
											System.out.println(SanAgustin.getComision6toB().listado());
										}
										break;
									}
								break;
								
							case 8:
								SanAgustin.ActualizarCondicionDeAlumnos(SanAgustin.getListaA());
								System.out.println("Se actualizo correctamente la condicion de la lista de alumnos \n");
								break;
								
							case 9:
								
								System.out.println("Digite el legajo del alumno: ");
								legajo = scan.nextInt();
								
								
								System.out.println("Digite la comision a la que desea cambiarse \n");
								System.out.println("Pulse 'A' para cambiarse a la comision A: \n");
								System.out.println("Pulse 'B' para cambiarse a la comision B: \n");
								curso = scan.next();
								SanAgustin.CambiarAlumnoDeComision(legajo,curso);
								SanAgustin.ActualizarCondicionDeAlumnos(SanAgustin.getListaA());
								break;
								
							case 10:
								
								System.out.println("Digite la cantidad de faltas: ");
								cantidadFaltas = scan.nextInt();
								System.out.println("El porcentaje de alumnos que supera esa cantidad de faltas es: " + SanAgustin.porcentajeAlumnosFaltas(cantidadFaltas)+ "% \n");
								break;
							
							case 11:
								break;
							}
					
					}while(opc2 != 11);
					break;
					
				case 3:
					String aux = devolverJSON(SanAgustin);
					System.out.println(aux); 
					break;
					
					
					
			}
			
		}while(opc1 != 4);
		System.out.println("El programa ha finalizado \n");
		
		
	}
	
	

}
