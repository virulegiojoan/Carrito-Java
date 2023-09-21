package menus;

import java.util.Scanner;

import models.Usuario;

public class MenuBilletera {
	private Scanner sc;
	private Usuario usuario;

	public MenuBilletera(Scanner sc, Usuario usuario) {
		this.sc = sc;
		this.usuario = usuario;
	}

	public void iniciar() {
		System.out.println("Bienvenido al gestor de billetera virtual!");
		boolean continuar = true;
		while(continuar) {
			mostrarOpciones();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				agregarSaldo();
				break;
			case 2:
				transferirSaldo();
				break;
			case 3:
				removerSaldo();
				break;
			case 4:
				mostrarSaldo();
				break;
			case 0:
				continuar = false;
				break;
			default:
				break;
			}
		}
	}

	private void mostrarSaldo() {
		System.out.println("Su saldo es de: ");
		System.out.println(usuario.getBilletera().getSaldo());
	}

	private void removerSaldo() {
		System.out.println("Ingrese el monto a remover: ");
		Double montoARemover = sc.nextDouble();
		if(montoARemover > 0) {
			if(montoARemover <= usuario.getBilletera().getSaldo()) {
				Double nuevosaldo = usuario.getBilletera().getSaldo() - montoARemover;
				usuario.getBilletera().setSaldo(nuevosaldo);			
			}else {
				System.out.println("El monto a remover debe ser menor o igual al saldo en cuenta.");
			}
		}else {
			System.out.println("El monto a remover debe ser mayor a 0.");
		}
		
	}

	private void transferirSaldo() {
		System.out.println("Ingrese el monto a transferir: ");
		Double montoATransferir = sc.nextDouble();
		if(montoATransferir > 0) {
			if(montoATransferir <= usuario.getBilletera().getSaldo()) {
				Double nuevosaldo = usuario.getBilletera().getSaldo() - montoATransferir;
				usuario.getBilletera().setSaldo(nuevosaldo);			
			}else {
				System.out.println("El monto a transferir debe ser menor o igual al saldo en cuenta.");
			}
		}else {
			System.out.println("El monto a transferir debe ser mayor a 0.");
		}
	}

	private void agregarSaldo() {
		System.out.println("Ingrese el monto que desea cargar en la cuenta: ");
		Double montoACargar = sc.nextDouble();
		if(montoACargar > 0) {
			usuario.getBilletera().setSaldo(montoACargar);			
		}else {
			System.out.println("El monto debe ser mayor a 0.");
		}
	}

	private void mostrarOpciones() {
		System.out.println("Elija una opcion:");
		System.out.println("1-Agregar saldo.");
		System.out.println("2-Transferir saldo.");
		System.out.println("3-Remover saldo.");
		System.out.println("4-Mostrar saldo.");
		System.out.println("0-Salir.");
	}
}
