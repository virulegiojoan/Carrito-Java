package menus;

import java.util.Scanner;

import containers.ContenedorArticulos;
import models.Articulo;
import models.Cliente;
import models.Empleado;

public class MenuLogin {
	private Scanner sc;
	private ContenedorArticulos articulos;
	private Empleado empleado = new Empleado("pepito420", "12345", "Empleado");
	private Cliente cliente = new Cliente("soyuncliente", "54321", "Cliente");
	
	public MenuLogin(Scanner sc, ContenedorArticulos articulos) {
		this.sc = sc;
		this.articulos = articulos;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ContenedorArticulos getArticulos() {
		return articulos;
	}

	public void setArticulos(ContenedorArticulos articulos) {
		this.articulos = articulos;
	}
	
	public void iniciarMLogin() {
		Articulo jabon = new Articulo("4", "Jabon", "baño", 150.0, 30);
		Articulo jamon = new Articulo("5", "Jamon", "Alimento", 200.0, 5);
		articulos.agregarPreSeteados(jamon);
		articulos.agregarPreSeteados(jabon);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Ingrese nombre de usuario: ");
			String nUsuario = sc.next();
			System.out.println("Ingrese contraseña: ");
			String password = sc.next();
			MenuAbm mAbm = new MenuAbm(sc, articulos);
			
			
			
			
			if (nUsuario.equals(empleado.getNombreUsuario()) && password.equals(empleado.getContraseña())) {
				MenuBilletera mBilleteraEmpleado = new MenuBilletera(sc, empleado);
				MenuCarrito mCarrito = new MenuCarrito(sc, articulos, empleado);
				boolean continuar2 = true;
				
				while(continuar2) {
					System.out.println("Elija una opcion: ");
					System.out.println("1-Ingresar al menu ABM.");
					System.out.println("2-Ingresar al menu Carrito.");
					System.out.println("3-Gestionar billetera.");
					System.out.println("0-Salir.");
					int opcion = sc.nextInt();
					switch (opcion) {
					case 1:
						mAbm.iniciarMAbm();
						break;
					case 2:
						mCarrito.iniciar();
						break;
					case 3:
						mBilleteraEmpleado.iniciar();
						break;
					case 0:
						continuar2 = false;
						break;
					default:
						break;
					}
				}
			}else if(nUsuario.equals(cliente.getNombreUsuario()) && password.equals(cliente.getContraseña())) {
				MenuBilletera mBilleteraCliente = new MenuBilletera(sc, cliente);
				MenuCarrito mCarrito = new MenuCarrito(sc, articulos, cliente);
				boolean continuar1 = true;
				
				while(continuar1) {
					System.out.println("Elija una opcion: ");
					System.out.println("1-Ingresar al carrito.");
					System.out.println("2-Gestionar billetera.");
					System.out.println("0-Salir.");
					int opcion = sc.nextInt();
					
					switch (opcion) {
					case 1:
						mCarrito.iniciar();					
						break;
					case 2:
						mBilleteraCliente.iniciar();
						break;
					case 0:
						continuar1 = false;
						break;
						
					default:
						break;
					}
				}
			}else {
				System.out.println("Error");
			}
		}
	}
}
