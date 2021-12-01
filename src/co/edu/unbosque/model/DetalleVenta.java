package co.edu.unbosque.model;
import java.io.Serializable;

public class DetalleVenta implements Serializable {

	private static final long serialVersionUID = -7296041316627149051L;
	private int cedula;
	private int codigo;
	private int cantidad;
	private double precio;
	private double venta;
	
	public DetalleVenta() {}

	public DetalleVenta(int cedula, int codigo, int cantidad, double precio, double venta) {
		this.cedula = cedula;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.venta = venta;
	}
	
	public String toString() {
		return "Codigo: " + codigo + "\n" + 
	           "Cantidad: " + cantidad + "\n" +
			   "Precio: " + precio + "\n" +
	           "Venta: " + venta;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
}
