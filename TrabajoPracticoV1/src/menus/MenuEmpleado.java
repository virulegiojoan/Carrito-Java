/*package menus;

import java.util.Scanner;

public class MenuEmpleado {
	private Scanner sc;
	private MenuAbm mAbm;
	private MenuCarrito mCarrito;

	
	
	public MenuEmpleado(Scanner sc, MenuAbm mAbm, MenuCarrito mCarrito) {
		this.sc = sc;
		this.mAbm = mAbm;
		this.mCarrito = mCarrito;
	}



	public void iniciarMenu() {
		System.out.println("Elija una opcion: ");
		System.out.println("1-Ingresar al menu ABM.");
		System.out.println("2-Ingresar al menu Carrito.");
		System.out.println("3-Salir.");
		int opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			mAbm.iniciarMAbm();
			break;
		case 2:
			mCarrito.iniciar();
			break;
		default:
			break;
		}
		
	}
}
*/