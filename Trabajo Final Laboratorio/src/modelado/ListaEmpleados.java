package modelado;

import java.util.ArrayList;

import Interfaces.IListaEmpleados;

public class ListaEmpleados implements IListaEmpleados{
    private ArrayList<Empleado> listado;
    
    public ListaEmpleados() {
        listado=new ArrayList<Empleado>();
    }

    public int cantidadEmpleados() {
    	return listado.size();
    }
    
    
    public Empleado getEmpleado(int i) {
    	return listado.get(i);
    }
    
    
    
    
	@Override
	public void agregarEmpleado(Empleado empleado) {
		listado.add(empleado);
	}
	
	@Override
	public void eliminarEmpelado(Empleado empleado) {
		listado.remove(empleado);
	}
	

	@Override
	public String listadoProfesores() {
		StringBuilder sb=new StringBuilder();
        for(int i=0;i<listado.size();i++) {
            if(listado.get(i) instanceof Profesor) {
                Profesor aux=(Profesor)listado.get(i);
                sb.append(aux.getNombreCompleto()+"\n");
            }
        }
        return sb.toString();
	}


	@Override
	public String listadoAdministrativos() {
		StringBuilder sb=new StringBuilder();
        for(int i=0;i<listado.size();i++) {
            if(listado.get(i) instanceof Administrativo) {
                Administrativo aux=(Administrativo)listado.get(i);
                sb.append(aux.getNombreCompleto()+"\n");
            }
        }
        return sb.toString();
	}

	@Override
	public String listadoTodosLosEmpleados() {
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<listado.size();i++) {
			Empleado aux = (Empleado)listado.get(i);
			sb.append(aux.getNombreCompleto()+"\n");
        }
        return sb.toString();
	}

	

	@Override
	public int contarProfesores() {
		 int cantidad=0;
	        for(int i=0;i<listado.size();i++) {
	            if(listado.get(i) instanceof Profesor) {
	                cantidad++;
	            }
	        }
	        return cantidad;
	}

	@Override
	public int contarAdministrativos() {
		int cantidad=0;
        for(int i=0;i<listado.size();i++) {
            if(listado.get(i) instanceof Administrativo) {
                cantidad++;
            }
        }
        return cantidad;
	}
	
	@Override
	public int contarEmpleados() {
		return listado.size();
	}

	@Override
	public boolean buscarEmpleado(Empleado empleado) {
		
		  boolean aux = false;
	       	if(empleado instanceof Profesor){
	            Profesor profeBuscado=(Profesor)empleado;
	            int i=0;
	            int flag=0;
	            while(i<listado.size()&&flag==0) {
	                if(listado.get(i) instanceof Profesor) {
	                    Profesor profeRecorrido=(Profesor)listado.get(i);
	                    if(profeBuscado.equals(profeRecorrido)) {
	                        aux = true;
	                        flag = 1;
	                    }
	                }
	                i++;
	            }
	        }
	        else if(empleado instanceof Administrativo) {
	            Administrativo administrativoBuscado=(Administrativo)empleado;
	            int i=0;
	            int flag=0;
	            while(i<listado.size()&&flag==0) {
	                if(listado.get(i) instanceof Administrativo) {
	                    Administrativo administrativoRecorrido=(Administrativo)listado.get(i);
	                    if(administrativoBuscado.equals(administrativoRecorrido)) {
	                    	aux = true;
	                        flag=1;
	                    }
	                }
	                i++;
	            }
	        }
	        
	    return aux;
	}

	
	
}
    
   