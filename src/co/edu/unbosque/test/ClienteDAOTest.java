package co.edu.unbosque.test;
import org.junit.Test;
import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.persistence.ClienteDAO;

class ClienteDAOTest {
	
	private ClienteDAO cliente;
	
	public ClienteDAOTest() {
		cliente = new ClienteDAO(2);
	}
	
	private void setUp() {
		cliente.eliminarArchivo();
		cliente.agregarCliente(new Cliente("Prueba1", 123, "Barcelona", 987, "gmail.com"));
		cliente.agregarCliente(new Cliente("Prueba2", 124, "Madrid", 986, "hotmail.com"));
	}
	
	
	@Test
	public void agregarCliente() {
		setUp();
		assert cliente.buscarCliente("Prueba1") == true : "El cliente se ha registrado exitosamente.";
		assert cliente.buscarCliente("Prueba2") == true : "El cliente se ha registrado exitosamente.";
		assert cliente.buscarCliente("Prueba3") == false : "No existe un cliente con este nombre.";
	}
	
	
	@Test
	public void eliminarCliente() {
		setUp();
		cliente.eliminarCliente("Prueba1");
		assert cliente.buscarCliente("Prueba1") == false : "El cliente se ha eliminado correctamente.";
	}
	
	
	@Test
	public void modificarCliente() {
		setUp();
		cliente.modificarCliente("Prueba2", new Cliente("Modificado", 125, "Valencia", 985, "outlook.com"));
		assert cliente.buscarCliente("Prueba2") == false : "El cliente se ha modificado.";
		assert cliente.buscarCliente("Modificado") == true : "El cliente se ha modificado exitosamente.";
	}
}