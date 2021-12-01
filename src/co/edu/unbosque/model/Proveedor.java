package co.edu.unbosque.model;

public final class Proveedor extends Persona {

	private static final long serialVersionUID = 2071122145785107090L;
	private int NIT;
	private String cuidad;
	
	public Proveedor() {}
	
	public Proveedor(String nombre, int nit, String direccion, int telefono, String cuida) {
		super(nombre, direccion, telefono);
		NIT = nit;
		cuidad = cuida;
	}
	
	public String toString() {
		return "Nombre: " + super.nombre + "\n" + 
	           "NIT: " + NIT + "\n" +
			   "Direccion: " + super.direccion + "\n" + 
	           "Telefono: " + super.telefono + "\n" +
			   "Cuidad: " + cuidad;
	}

	public int getNIT() {
		return NIT;
	}

	public void setNIT(int nIT) {
		NIT = nIT;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}