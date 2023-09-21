package models;

public class Cliente extends Usuario {
	private String categoria;

	public Cliente(String nombreUsuario, String contraseña, String categoria) {
		super(nombreUsuario, contraseña);
		this.categoria = "Cliente";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
