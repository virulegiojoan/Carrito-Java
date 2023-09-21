package menus;

import java.util.Scanner;

import containers.ContenedorArticulos;
import models.Articulo;

public class MenuAbm {
	private Scanner sc;
	private ContenedorArticulos articulos;
	private boolean continuar = true;
	
	
	
	public MenuAbm(Scanner sc, ContenedorArticulos articulos) {
		this.sc = sc;
		this.articulos = articulos;
	}

	
	
	public void iniciarMAbm() {
		while (continuar) {
			mostrarOpciones();
			int opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				agregarArticulo();
				break;
			case 2:
				modificarArticulo();
				break;
			case 3:
				borrarArticulo();
				break;
			case 4:
				articulos.mostrar();
				break;
			case 0:
				continuar = false;
				break;

			default:
				break;
			}
		}
	}
	
	

	private void modificarArticulo() {
		System.out.println("Ingrese el codigo del articulo que desea modificar: ");
		String codigo = sc.next();
		Articulo articuloAModificar = articulos.buscarPorCodigo(codigo);
		if(articuloAModificar != null) {
			System.out.println("Ingrese nuevo nombre del articulo: ");
			String nombre = sc.next();
			System.out.println("Ingrese nueva descripcion del articulo: ");
			String descripcion = sc.next();
			System.out.println("Ingrese nuevo precio del articulo: ");
			Double precio = sc.nextDouble();
			if(precio > 0) {
				System.out.println("Ingrese nuevo stock del articulo: ");
				Integer stock = sc.nextInt();
				if(stock >= 0) {
					articuloAModificar.setNombre(nombre);
					articuloAModificar.setDescripcion(descripcion);
					articuloAModificar.setPrecio(precio);
					articuloAModificar.setStock(stock);
				}else {
					System.out.println("El stock debe ser mayor o igual a 0.");
				}
			}else {
				System.out.println("El precio debe ser mayor a 0.");
			}
		}else {
			System.out.println("No se encontró un articulo con dicho codigo.");
		}
		
	}

	private void borrarArticulo() {
		System.out.println("Ingrese el codigo del articulo que desea borrar: ");
		String codigo = sc.next();
		boolean respuesta = articulos.borrarPorCodigo(codigo);
		if(respuesta) {
			System.out.println("Se borro satisfactoriamente.");
		}else {
			System.out.println("No se existe un articulo con ese codigo.");
		}
		
	}

	private void agregarArticulo() {
		System.out.println("Ingrese codigo del articulo: ");
		String codigo = sc.next();
		if(articulos.buscarPorCodigo(codigo) == null) {
			System.out.println("Ingrese nombre del articulo: ");
			String nombre = sc.next();
			System.out.println("Ingrese descripcion del articulo: ");
			String descripcion = sc.next();
			System.out.println("Ingrese precio del articulo: ");
			Double precio = sc.nextDouble();
			if(precio > 0) {
				System.out.println("Ingrese stock del articulo: ");
				Integer stock = sc.nextInt();
				
				Articulo nuevoArticulo = new Articulo(codigo, nombre, descripcion, precio, stock);
				articulos.agregar(nuevoArticulo);
			}else {
				System.out.println("el precio debe ser mayor a 0.");
			}
		}else {
			System.out.println("El codigo ya existe, elija otro.");
		}
	}


	private void mostrarOpciones() {
		System.out.println("Elija un opcion: ");
		System.out.println("1-Agregar articulo.");
		System.out.println("2-Modificar articulo.");
		System.out.println("3-Eliminar articulo.");
		System.out.println("4-Mostrar listado articulos");
		System.out.println("0-Salir.");	
	}	
}
