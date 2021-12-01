package co.edu.unbosque.test;
import co.edu.unbosque.model.Proveedor;
import co.edu.unbosque.model.persistence.ProveedorDAO;
import org.junit.Test;

class ProveedorTest {

	private ProveedorDAO proveedor;
	
	public ProveedorTest() {
		proveedor = new ProveedorDAO(2);
	}
	
	private void setUp() {
		proveedor.eliminarArchivo();
		proveedor.agregarProveedor(new Proveedor("Jorge", 12334322, "calle 12-12 # 12", 12210, "Munich"));
		proveedor.agregarProveedor(new Proveedor("Carlos", 1231230, "calle 19-89 # 32", 12312, "Mexico"));
	}
	
	
	@Test
	public void agregarProveedorTest() {
		setUp();
		assert proveedor.buscarProveedor("Jorge") == true : "El proveedor se ha registrado correctamente.";
		assert proveedor.buscarProveedor("Carlos") == true : "El proveedor se ha registrado correctamente.";
	}
	
	
	@Test
	public void eliminarProveedorTest() {
		setUp();
		proveedor.eliminarProveedor("Jorge");
		assert proveedor.buscarProveedor("Jorge") == false : "El proveedor se ha eliminado correctamente.";
	}
	
	
	@Test
	public void modificarProveedorTest() {
		setUp();
		proveedor.modificarProveedor("Carlos", new Proveedor("Camilo", 123230, "calle 90-12 #18", 123120, "Bogota"));
		assert proveedor.buscarProveedor("Carlos") == false : "El proveedor se ha eliminado.";
		assert proveedor.buscarProveedor("Camilo") == true : "El proveedor se ha modificado exitosamente.";
	}	
}