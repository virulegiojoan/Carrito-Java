package menus;

import java.util.ArrayList;
import java.util.Scanner;

import containers.ContenedorArticulos;
import models.Articulo;
import models.Usuario;

public class MenuCarrito {
	private Scanner sc;
	private ContenedorArticulos articulos;
	private Usuario usuario;
	private ArrayList<Articulo> articulosCarrito;
	private Double precioFinal = 0.0;
	private boolean continuar = true;
	
	
	public MenuCarrito(Scanner sc, ContenedorArticulos articulos, Usuario usuario) {
		this.sc = sc;
		this.articulos = articulos;
		this.usuario = usuario;
		this.articulosCarrito = new ArrayList<Articulo>();
		
	}
	
	public void iniciar() {
		System.out.println("Bienvenido al carrito de compras!");
		while(continuar) {
			mostrarOpciones();
			int opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				agregarAlCarrito();
				break;
			case 2:
				mostrarCarrito();
				break;
			case 3:
				finalizarCompra();
				break;
			case 0:
				continuar = false;
				break;

			default:
				break;
			}
			
		}
	}


	

	private void finalizarCompra() {
		if(precioFinal <= usuario.getBilletera().getSaldo()) {
			Double saldoRestado = usuario.getBilletera().getSaldo() - precioFinal;
			usuario.getBilletera().setSaldo(saldoRestado);
			System.out.println("Compra realizada exitosamente.");
		}else {
			System.out.println("Saldo insuficiente.");
		}
		
	}

	private void mostrarCarrito() {
		for (Articulo articulo : articulosCarrito) {
			System.out.println(articulo);
		}
		
		System.out.println("precio final: " + precioFinal);
		
	}

	private void agregarAlCarrito() {
		articulos.mostrar();
		System.out.println("Ingrese el codigo del articulo que desee agregar al carrito: ");
		String codigo = sc.next();
		System.out.println("Ingrese la cantidad que desea agregar: ");
		int cantidad = sc.nextInt();
		Articulo guardarArticulo = articulos.buscarPorCodigo(codigo);
		if(guardarArticulo.getStock() > 0 && guardarArticulo.getStock() >= cantidad) {
			guardarArticulo.setCantidad(cantidad);
			articulosCarrito.add(guardarArticulo);
			articulos.buscarPorCodigo(codigo).setStock(articulos.buscarPorCodigo(codigo).getStock() - articulos.buscarPorCodigo(codigo).getCantidad());
			Double costoParcial = guardarArticulo.getPrecio() * guardarArticulo.getCantidad();
			precioFinal = precioFinal + costoParcial;
		}else {
			System.out.println("No hay la cantidad deseada.");
		}
	}

	private void mostrarOpciones() {
		System.out.println("Elija una opcion: ");
		System.out.println("1-Agregar articulo al carrito.");
		System.out.println("2-Mostrar carrito.");
		System.out.println("3-Finalizar compra.");
		System.out.println("0-Salir.");
	}
	
	public Articulo buscarPorCodigo(String codigo) {
		Articulo articuloBuscado = null;
		
		for (Articulo articulo : articulosCarrito) {
			if(articulo.getCodigo().equals(codigo)) {
				articuloBuscado = articulo;
				break;
			}
		}
		return articuloBuscado;
	}
	
	
}
