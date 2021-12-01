package co.edu.unbosque.model;
import java.io.Serializable;
public abstract class Persona implements Serializable {

	private static final long serialVersionUID = -1444001219446764622L;
	protected String nombre;
	protected String direccion;
	protected int telefono;
	
	public Persona() {}
	
	public Persona(String nombre, String direccion, int telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}	
}