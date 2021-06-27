package modelado;

import java.util.ArrayList;

public class CajaDeObjetosPerdidos<P> {
	
	private ArrayList<P> lista;

	public CajaDeObjetosPerdidos() {
		lista = new ArrayList<P>();
	}
	
	public void agregar(P p) {
	     lista.add(p);
	}
	
	
	public void quitarObjeto(P p) {
		lista.remove(p);
	}

	public ArrayList<P> getLista() {
		return lista;
	}

	public void setLista(ArrayList<P> lista) {
		this.lista = lista;
	}
	
	
	
	

	
}
