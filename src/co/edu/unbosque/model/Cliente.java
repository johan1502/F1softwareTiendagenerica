package co.edu.unbosque.model;

public final class Cliente extends Persona {

	private static final long serialVersionUID = -5970670115250220117L;
	private long cedula;
	private String correo;
		
	public Cliente(String nombre, long cedula, String direccion, int telefono, String correo) {
		super(nombre, direccion, telefono);
		this.cedula = cedula;
		this.correo = correo;
	}
	
	
	public String toString() {
		return "Nombre: " + super.nombre + "\n" + 
	           "Cedula: " + cedula + "\n" +
			   "Direccion: " + super.direccion + "\n" + 
	           "Telefono: " + super.telefono + "\n" +
			   "Correo: " + correo;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}