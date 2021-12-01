package co.edu.unbosque.model;
import java.io.Serializable;

public final class Producto implements Serializable {

	private static final long serialVersionUID = 4848205119849882954L;
	private String nombreProducto;
	private long codigo;
	private int nitProveedor;
	private double precioCompra;
	private double precioVenta;
	
	public Producto() {}
	
	public Producto(String nombre, long codig, int nit, double compra, double venta) {
		nombreProducto = nombre;
		codigo = codig;
		nitProveedor = nit;
		precioCompra = compra;
		precioVenta = venta;
	}
	
	public String toString() {
		return "Nombre del producto: " + nombreProducto + "\n" + 
	           "Codigo: " + codigo + "\n" + 
			   "NIT del proveedor: " + nitProveedor + "\n" + 
	           "Precio de compra: " + precioCompra + "\n" + 
			   "Precio de venta: " + precioVenta;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}