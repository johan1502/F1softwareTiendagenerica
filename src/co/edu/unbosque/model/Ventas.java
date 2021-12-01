package co.edu.unbosque.model;
import java.io.Serializable;

public class Ventas implements Serializable {

	private static final long serialVersionUID = -9179369980709301872L;
	private int numeroProducto;
	private int cedulaCliente;
	private double precioUnidad;
	private double valorIva;
	private double total;
	
	public Ventas() {}
	
	public Ventas(int numero, int cedula, double precio, double iva, double tota) {
		numeroProducto = numero;
		cedulaCliente = cedula;
		precioUnidad = precio;
		valorIva = iva;
		total = tota;
	}
	
	public String toString() {
		return "Codigo del producto: " + numeroProducto + "\n" + 
	           "Cedula cliente: " + cedulaCliente + "\n" + 
			   "Precio por unidad: " + precioUnidad + "\n" + 
	           "Valor von iva: " + valorIva + "\n" +
			   "Total: " + total;
	}

	public int getNumeroProducto() {
		return numeroProducto;
	}

	public void setNumeroProducto(int numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public double getValorIva() {
		return valorIva;
	}

	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
}