package models;

public class Empleado extends Usuario {
	private String categoria;

	public Empleado(String nombreUsuario, String contraseña, String categoria) {
		super(nombreUsuario, contraseña);
		this.categoria = "Empleado";
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
}
