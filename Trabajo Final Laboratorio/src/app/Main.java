package app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.jar.JarException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


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

	public static void main(String[] args) {
		
		scan = new Scanner(System.in);
		
		Colegio SanAgustin = new Colegio();
		
		/*
		
		Profesor profe1 = new Profesor(70000,"MEDIFE","23514645","00123300","Matematica",1);
		
		Profesor profe2 = new Profesor(8000,"OAM","23514645","00124300","Fisica",4);
		
		Profesor profe3 = new Profesor(8000,"OAM","23514645","00124300","Fisica",4);
		
		Profesor profe4 = new Profesor("Agustin", "Quagliarella", "39826712", "Argentino", "CORRIENTES 2210", 70000, "OSDE", "123456", "00124500", "Biologia", 7);
		
		Profesor profe5 = new Profesor("Agustin", "Quagliarella", "39826712", "Argentino", "CORRIENTES 2210", 70000, "OSDE", "123456", "00124500", "Biologia", 7);

		
		Profesor profe6 = new Profesor("Agustin", "Quagliarella", "39826712", "Argentino", "CORRIENTES 2210", 70000, "OSDE", "123456", "00124500", "Biologia", 7);

		
		Profesor profe7 = new Profesor("Agustin", "Quagliarella", "39826712", "Argentino", "CORRIENTES 2210", 70000, "OSDE", "123456", "00124500", "Biologia", 7);

		
		Profesor profe8 = new Profesor("Agustin", "Quagliarella", "39826712", "Argentino", "CORRIENTES 2210", 70000, "OSDE", "123456", "00124500", "Biologia", 7);

		
		listaEmpleadosColegio.agregarElemento(profe8);
		listaEmpleadosColegio.agregarElemento(profe7);
		listaEmpleadosColegio.agregarElemento(profe6);
		listaEmpleadosColegio.agregarElemento(profe5);
		listaEmpleadosColegio.agregarElemento(profe4);
		
		
		listaEmpleadosColegio.agregarElemento(profe1);
		listaEmpleadosColegio.agregarElemento(profe2);
		listaEmpleadosColegio.agregarElemento(profe3);
		*/
		
		
		//String json = devolverJSON(listaEmpleadosColegio);
		
		
		//System.out.println(" "+json);
		
		//JSONtoJava(json);
		
		//JsonUtiles pruebaDeLectura = new JsonUtiles();
		
		//System.out.println(pruebaDeLectura.leer()); 
		
		
		
		Menu(SanAgustin);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void JSONtoJava(String json) {
		
		
		try {
			
			JSONObject jsonObject = new JSONObject(json);
			
			JSONArray vector = jsonObject.getJSONArray("Profesores");
			int i = 0;
		
			
			while(i < vector.length()) {
				
				JSONObject profe = vector.getJSONObject(i);
				
				
				System.out.println(profe.get("Materia"));
				System.out.println(profe.get("Nombre"));
				System.out.println(profe.get("Apellido"));
				System.out.println(profe.get("Telefono"));
				System.out.println(profe.get("NroAsociado"));
				System.out.println(profe.get("ObraSocial"));
				System.out.println(profe.get("Sueldo"));
				System.out.println(profe.get("Direccion"));
				System.out.println(profe.get("Nacionalidad"));
				System.out.println(profe.get("CursosAcargo"));
				
				i++;
				
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static String devolverJSON(ListaEmpleados listaEmpleados){
		
		String jsonToString = "";
		
		JsonUtiles jsonArchivo = new JsonUtiles();
		
		try {
			
			JSONObject unObjeto = new JSONObject();
			
			JSONArray misProfesores = new JSONArray();
			
			int i = 0;
			
			while(i < listaEmpleados.cantidadEmpleados()){
				
				if(listaEmpleados.getEmpleado(i) instanceof Profesor) {
					
					Profesor aux = (Profesor) listaEmpleados.getEmpleado(i);
					
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
					
				}
				i++;
			}
			
			unObjeto.put("Profesores", misProfesores);
			
			jsonArchivo.grabar(misProfesores);
		
			
			jsonToString = unObjeto.toString();
	            
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonToString;
	}
	
	
	
	public static boolean superLogin(String usuario, String contrase�a)  {
		boolean flag = false;
		
        try {
            flag = login(usuario,contrase�a);
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
	
	public static boolean login(String usuario, String contrase�a) throws PasswordIncorrectException,NullPointerException {
		boolean flag = false;
		
        if(usuario == null || contrase�a == null) {
            throw new NullPointerException("nfldmlk");
        }
        
        if(usuario.isEmpty() || contrase�a.isEmpty()) {
            throw new PasswordIncorrectException("password incorrect",contrase�a);
        }
        
        if((usuario.compareTo("admin") == 0) && (contrase�a.compareTo("admin") == 0)) {
        	flag = true;
        	System.out.println("BIENVENIDO !!!");
        }else {
        	System.out.println("El usuario o la contrase�a son incorrectos");
        }
        
        return flag;
    }
	
	
	public static void Menu(Colegio SanAgustin) {
		
		
		
		String usuario;
		String contra;
		int opc1,opc2;
		
		
		Scanner scan = new Scanner(System.in);
		
		
		ArrayList<String> materias = new ArrayList<String>();
		
		materias.add("Matematica");
		
		Profesor profe1 = new Profesor("Agustin", "Quagliarella", "39826712", 70000, "OSDE", "123456", "00124500", "Biologia", 7);

		Alumno alumno1 = new Alumno("Jose", "Garcia", "38265333", 123456789, "2235135789", "5to", "B",materias);
		
		Administrativo administrativo1 = new Administrativo(500000,"OSDE","223545545","001989800","gestion contable");
		
		
		do {
			System.out.println("Usuario: ");
			usuario = scan.next();
			System.out.println("contrase�a: ");
			contra = scan.next();
		}while(superLogin(usuario,contra) == false);
		
		
		do {
		
			System.out.println("\n   ///// MENU /////   \n");
			
			System.out.println("1. Administrar la lista de empleados \n");
			System.out.println("2. Administrar la lista de alumnos \n");
			System.out.println("3. Leer listado de  profesores json del archivo\n");
			System.out.println("4. Salir");
			
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
						System.out.println("8. Salir \n");
						
						System.out.println("Digite la opcion que desea realizar: ");
						opc2 = scan.nextInt();
						
						
						switch(opc2) {
							case 1:
								String control1 = "s";
								while(control1 == "s") {
									SanAgustin.getListaE().agregarEmpleado(profe1);
									System.out.println("Se agrego un empleado correctamente \n");
									System.out.println("Desea agregar otro? s/n: ");
									control1 = scan.next();
								}
								break;
								
							case 2:
								String control2 = "s";
								while(control2 == "s") {
									SanAgustin.getListaE().eliminarEmpelado(profe1);
									System.out.println("Se eliminar un empleado correctamente \n");
									System.out.println("Desea eliminar otro? s/n: ");
									control2 = scan.next();
								}
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
								break;
						}
						
					}while(opc2 != 8);
					break;
					
				case 2:
					
					do {
						System.out.println("\n   ///// MENU /////   \n");
						
						System.out.println("1. Agregar un alumno a la lista \n");
						System.out.println("2. Quitar un  alumno de la lista \n");
						System.out.println("3. Ver la cantidad de alumnos \n");
						System.out.println("4. Imprimir listado de alumnos \n");
						System.out.println("5. Limpiar lista de alumnos \n");
						System.out.println("6. Salir\n");
						
						System.out.println("Digite la opcion que desea realizar: ");
						opc2 = scan.nextInt();
					
					}while(opc2 != 6);
					
					switch(opc2) {
					
						case 1:
							SanAgustin.getListaA().agregar(alumno1);
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
							
							
					}
				case 3:
					JsonUtiles pruebaDeLectura = new JsonUtiles();
					
					System.out.println(pruebaDeLectura.leer()); 
					break;
					
					
					
			}
			
		}while(opc1 != 4);
		System.out.println("El programa ha finalizado");
		
		
	}
	
	

}