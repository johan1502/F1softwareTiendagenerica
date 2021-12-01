package co.edu.unbosque.test;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.persistence.ProductoDAO;
import org.junit.Test;

class ProductoTest {

	private ProductoDAO producto;
	
	public ProductoTest() {
		producto = new ProductoDAO(2);
	}
	
	private void setUp() {
		producto.eliminarArchivo();
		producto.agregarProducto(new Producto("Salsa", 1, 12358, 1900, 2500));
		producto.agregarProducto(new Producto("Pasta", 2, 12357, 3700, 5200));
	}
	
	
	@Test
	public void agregarProductoTest() {
		setUp();
		assert producto.buscarProducto("Salsa") == true : "El producto se ha registrado correctamente.";
		assert producto.buscarProducto("Pasta") == true : "El producto se ha registrado correctamente.";
	}
	
	
	@Test
	public void eliminarProductoTest() {
		setUp();
		producto.eliminarProducto("Salsa");
		assert producto.buscarProducto("Salsa") == false : "El producto se ha eliminado correctamente.";
	}
	
	
	@Test
	public void modificarProductoTest() {
		setUp();
		producto.modificarProducto("Pasta", new Producto("Espagueti", 1, 12357, 3900, 4500));
		assert producto.buscarProducto("Pasta") == false : "El producto se ha eliminado";
		assert producto.buscarProducto("Espagueti") == true : "El producto se ha modificado exitosamente.";
	}
}