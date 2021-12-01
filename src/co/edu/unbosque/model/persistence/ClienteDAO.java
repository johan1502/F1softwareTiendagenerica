package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import co.edu.unbosque.model.Cliente;

public class ClienteDAO {

    private Persistencia persistencia;
    private static File archivo;
    private LinkedList<Cliente> lista;

    public ClienteDAO(int opcion) {
        persistencia = new Persistencia();
        lista = new LinkedList<>();
        opcionArchivo(opcion);
    }

    private void opcionArchivo(int opcion) {
        if (opcion == 1)
            archivo = new File("BDArchivos/Clientes.bin");
        else
            archivo = new File("BDTest/ClienteTest.bin");
    }

    public void agregarCliente(Cliente cliente) {
        persistencia.agregarDato(cliente, archivo);
    }

    public String mostrarClientes() {
        lista = persistencia.lecturaArchivo(archivo);
        String contenido = "LISTA DE CLIENTES:\n";
        for (int i = 0; i < lista.size(); i++) {
            contenido += lista.get(i) + "\n\n";
        }
        return contenido;
    }


    public boolean buscarCliente(String buscar) {
        lista = persistencia.lecturaArchivo(archivo);
        for (int i = 0; i < lista.size(); i++) {
            if (buscar.compareToIgnoreCase(lista.get(i).getNombre()) == 0) return true;
        }
        return false;
    }

    public Cliente buscarCliente2(Long cedula) {
        lista = persistencia.lecturaArchivo(archivo);
        Cliente clienteExistente = null;
        for (Cliente cliente : lista) {
            if (cedula == cliente.getCedula()) {
                clienteExistente = cliente;
            }
        }
        return clienteExistente;
    }

    public void eliminarCliente(String eliminar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarCliente(eliminar)) {
            archivo.delete();
            lista.removeIf(x -> (x.getNombre().compareToIgnoreCase(eliminar)) == 0);
            for (Cliente i : lista) {
                agregarCliente(i);
            }
        }
    }

    public void modificarCliente(String buscar, Cliente modificar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarCliente(buscar)) {
            archivo.delete();
            try {
                archivo.createNewFile();
            } catch (IOException e) {
            }
            int index = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombre().compareToIgnoreCase(buscar) == 0) index = i;
            }
            lista.set(index, modificar);
            for (Cliente i : lista) {
                agregarCliente(i);
            }
        }
    }

    public void eliminarArchivo() {
        archivo.delete();
        if (!archivo.exists())
            try {
                archivo.createNewFile();
            } catch (IOException e) {
            }
    }


    public LinkedList<Cliente> list() {
        return persistencia.lecturaArchivo(archivo);
    }

    public Persistencia getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(Persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public static File getArchivo() {
        return archivo;
    }

    public static void setArchivo(File archivo) {
        ClienteDAO.archivo = archivo;
    }

    public LinkedList<Cliente> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Cliente> lista) {
        this.lista = lista;
    }
}