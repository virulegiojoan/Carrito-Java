package models;

public class Usuario {
	private String nombreUsuario;
	private String contraseña;
	public Billetera billetera;
	
	public Usuario(String nombreUsuario, String contraseña) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.billetera = new Billetera(0.0);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Billetera getBilletera() {
		return billetera;
	}

	public void setBilletera(Billetera billetera) {
		this.billetera = billetera;
	}
	
	
	
	
}
