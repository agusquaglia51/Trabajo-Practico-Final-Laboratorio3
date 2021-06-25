package modelado;


public abstract class Persona {
    private String nombre;
    private String apellido;
    private String dni;

  
    
    public Persona()
    {
        super();
        nombre = "";
        apellido = "";
        dni = "";
    }
    
    
    
    public Persona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombreCompleto()
    {
        return nombre + " " + apellido;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)// throws ExcepcionDeCampoVacio
    {
        this.nombre = nombre;
    }
    
    public String getApellido()
    {
        return apellido;
    }
    
    public void setApellido(String apellido)// throws ExcepcionDeCampoVacio
    {
        this.apellido = apellido;
    }
    
    
    
    public String getDNI()
    {
        return dni; 
    }
    
  
    

    
   
    
    @Override
	public String toString() {
		return "Persona [nombre= " + nombre + ", apellido= " + apellido + ", dni= " + dni;
	}



	public boolean equals(Object obj)
    {
        boolean esIgual = false;
        
        if ( obj != null && obj instanceof Persona )
        {
            Persona aux = (Persona) obj; 
            
            if ( this.getDNI().equals(aux.getDNI()) )
                esIgual = true;
        }
        
        return esIgual;
    }
    
    
 
}
