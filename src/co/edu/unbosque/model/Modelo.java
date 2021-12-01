package co.edu.unbosque.model;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import co.edu.unbosque.model.persistence.*;

public class Modelo {
	
	private Propiedades propiedades;              
	private ClienteDAO cliente;
	private ProductoDAO producto;
	private ProveedorDAO proveedor;
	private Persistencia persistencia;
	
	public Modelo() {
		propiedades = new Propiedades();
		cliente = new ClienteDAO(1);
		producto = new ProductoDAO(1);
		proveedor = new ProveedorDAO(1);
		persistencia = new Persistencia();
	}
	
	public void agregarCliente(Cliente ingresar) {
		cliente.agregarCliente(ingresar);
	}
	
	public String mostrarClientes() {
		return cliente.mostrarClientes();
	}
	
	public void modificarCliente(String nombreBuscar, Cliente modificar) {
		cliente.modificarCliente(nombreBuscar, modificar);
	}
	
	public void eliminarCliente(String nombreBuscar) {
		cliente.eliminarCliente(nombreBuscar);
	}
	
	public void agregarProducto(Producto ingresar) {
		producto.agregarProducto(ingresar);
	}
	
	public String mostrarProductos() {
		return producto.mostrarProductos();
	}
	
	public void modificarProducto(String nombreBuscar, Producto modificar) {
		producto.modificarProducto(nombreBuscar, modificar);
	}
	
	public void eliminarProducto(String nombreBuscar) {
		producto.eliminarProducto(nombreBuscar);
	}
	
	
	public void agregarProveedor(Proveedor ingresar) {
		proveedor.agregarProveedor(ingresar);
	}
	
	public String mostrarProveedores() {
		return proveedor.mostrarProveedor();
	}
	
	public void modificarProveedor(String nombreBuscar, Proveedor modificar) {
		proveedor.modificarProveedor(nombreBuscar, modificar);
	}
	
	public void eliminarProveedor(String nombreBuscar) {
		proveedor.eliminarProveedor(nombreBuscar);
	}
	
	public void escrituraVenta(Ventas venta) {
		persistencia.agregarDato(venta, new File("BDArchivos/Ventas.bin"));
	}
	
	public void escrituraDetalleVentas(DetalleVenta detalle) {
		persistencia.agregarDato(detalle, new File("BDArchivos/Detalle.bin"));
	}
	
	public String nombreCliente(int cedula) {
		LinkedList <Cliente> lista = cliente.list();
		for(int i = 0; i < lista.size(); i++) {
			if(cedula == lista.get(i).getCedula()) {
				return lista.get(i).getNombre();
			}
		}
		return null;
	}
	
	public double comprarProducto(int codigo, int numero) {
		LinkedList <Producto> lista = producto.list();
		for(int i = 0; i < lista.size(); i++) {
			if(codigo == lista.get(i).getCodigo()) {
				return lista.get(i).getPrecioVenta() * numero;
			}
		}
		return -1;
	}
	
	public String comprarProductoString(int codigo, int numero) {
		LinkedList <Producto> lista = producto.list();
		for(int i = 0; i < lista.size(); i++) {
			if(codigo == lista.get(i).getCodigo()) {
				return "Producto: " + lista.get(i).getNombreProducto() + "  " + lista.get(i).getPrecioVenta() + " * " + numero + " = " + comprarProducto(codigo, numero);
			}
		}
		return null;
	}
	
	public double IVA() {
		return propiedades.Iva();
	}
	
	public void escribirArchivoVentas(int numeroVenta, int cedula, double venta, double valorIva, double valorBruto) {
		escrituraVenta(new Ventas(numeroVenta, cedula, venta, valorIva, valorBruto));
	}
	
	public void escrituraDetalleArchivo(int cedula, int codigo, int cantidad, double precio, double venta) {
		escrituraDetalleVentas(new DetalleVenta(cedula, codigo, cantidad, precio, venta));
	}
	
	
	public String ventasCliente() {
		LinkedList <Cliente> lista = cliente.list();
		LinkedList <Ventas> venta = persistencia.lecturaArchivo(new File("BDArchivos/Ventas.bin"));
		String string = "Ventas por cliente:\n";
		int contador = 0;
		for(int i = 0; i < lista.size(); i++) {
			for(int j = 0; j < venta.size(); j++) {
				if(venta.get(i).getCedulaCliente() == lista.get(i).getCedula()) {
					contador++;
				}
			}
			string += lista.get(i).getNombre() + ", numero de ventas: " + contador + "\n";
		}
		return string;
	}
	

	public String detalleVentasCliente() {                // Detalle de compras por cliente.
		LinkedList <Cliente> lista = cliente.list();
		LinkedList <DetalleVenta> venta = persistencia.lecturaArchivo(new File("BDArchivos/Detalle.bin"));
		String string = "VENTAS DETALLA DEL CLIENTE:\n";
		for(int i = 0; i < lista.size(); i++) {
			string += lista.get(i).getNombre() + "\n";
			for(int j = 0; j < venta.size(); j++) {
				if(lista.get(i).getCedula() == lista.get(i).getCedula()) {
					string += venta.get(i).toString() + "\n";
				}
			}
		}
		return string;
	}
	
	public int compraProveedor() {         //Compras realizadas a un proveedor o distribuidora :)
		return proveedor.getLista().size();
	}
	
	public void escrituraCheque(String cheque) {
		persistencia.escrituraCheques(cheque, new File("BDArchivos/Cheques.bin"));
	}
	
	public String mostrarCheques() {
		return persistencia.lecturaCheque(new File("BDArchivos/Cheques.bin"));
	}
	
	/*public void documentoListaClientes() {
		try {
			Document documento = new Document();
			String destino = "Reportes/ListaClientes.pdf";
			
			PdfWriter.getInstance(documento, new FileOutputStream(destino));
			documento.open();
			
			Phrase header = new Phrase(mostrarClientes());
			documento.add(header);
			
			documento.close();
			
		} catch(Exception e) {}
	}
	
	public void documentoVentasCliente() {
		try {
			Document documento = new Document();
			String destino = "Reportes/VentasClientes.pdf";
			
			PdfWriter.getInstance(documento, new FileOutputStream(destino));
			documento.open();
			
			Phrase header = new Phrase(ventasCliente());
			documento.add(header);
			
			documento.close();
			
		} catch(Exception e) {}
	}
	
	public void documentoDetalleVentas() {
		try {
			Document documento = new Document();
			String destino = "Reportes/DetalleVentas.pdf";
			
			PdfWriter.getInstance(documento, new FileOutputStream(destino));
			documento.open();
			
			Phrase header = new Phrase(detalleVentasCliente());
			documento.add(header);
			
			documento.close();
			
		} catch(Exception e) {}
	}
	
	public void documentoCheques() {
		try {
			Document documento = new Document();
			String destino = "Reportes/Cheques.pdf";
			
			PdfWriter.getInstance(documento, new FileOutputStream(destino));
			documento.open();
			
			Phrase header = new Phrase(mostrarClientes());
			documento.add(header);
			
			documento.close();
		} catch(Exception r) {}
	}*/
	
	public void establecerPropiedades(String tienda, String comercio, String nit, String cuidad, String iva, String interes, String banco, String cuenta, String gerente) {
		propiedades.escribirPropiedades(tienda, comercio, nit, cuidad, iva, interes, banco, cuenta, gerente);
	}
	
	public String mostrarPropiedades() {
		return propiedades.mostrarPropiedades();
	}

	public ClienteDAO getCliente() {
		return cliente;
	}

	public ProductoDAO getProducto() {
		return producto;
	}

	public ProveedorDAO getProveedor() {
		return proveedor;
	}

	public Propiedades getPropiedades() {
		return propiedades;
	}
}