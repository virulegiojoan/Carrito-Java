package containers;

import java.util.ArrayList;

import models.Articulo;

public class ContenedorArticulos {
	private ArrayList<Articulo> listaArticulos;
	
	
	

	public ContenedorArticulos() {
		this.listaArticulos = new ArrayList<Articulo>();
	}
	
	
	
	public void agregar(Articulo articulo) {
		this.listaArticulos.add(articulo);
	}
	
	public void mostrar() {
		for (Articulo articulo : listaArticulos) {
			System.out.println(articulo);
		}
	}
	
	public boolean borrarPorCodigo(String codigo) {
		Articulo articuloAEliminar = buscarPorCodigo(codigo);
		if(articuloAEliminar != null) {
			listaArticulos.remove(articuloAEliminar);
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public Articulo buscarPorCodigo(String codigo) {
		Articulo articuloBuscado = null;
		
		for (Articulo articulo : listaArticulos) {
			if(articulo.getCodigo().equals(codigo)) {
				articuloBuscado = articulo;
				break;
			}
		}
		return articuloBuscado;
	}
	
	public void agregarPreSeteados(Articulo preArticulo) {
		listaArticulos.add(preArticulo);
	}
	
	
	
}
