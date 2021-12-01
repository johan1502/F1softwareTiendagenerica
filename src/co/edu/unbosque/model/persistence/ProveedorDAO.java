package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Proveedor;

public class ProveedorDAO {

    private Persistencia persistencia;
    private static File archivo;
    private LinkedList<Proveedor> lista;

    public ProveedorDAO(int opcion) {
        persistencia = new Persistencia();
        lista = new LinkedList<>();
        opcionArchivo(opcion);
    }

    private void opcionArchivo(int opcion) {
        if (opcion == 1)
            archivo = new File("BDArchivos/Proveedores.bin");
        else
            archivo = new File("BDTest/ProveedorTest.bin");
    }

    public void agregarProveedor(Proveedor proveedor) {
        persistencia.agregarDato(proveedor, archivo);
    }

    public String mostrarProveedor() {
        lista = persistencia.lecturaArchivo(archivo);
        String contenido = "LISTA DE CLIENTES:\n";
        for (int i = 0; i < lista.size(); i++) {
            contenido += lista.get(i) + "\n\n";
        }
        return contenido;
    }


    public boolean buscarProveedor(String buscar) {
        lista = persistencia.lecturaArchivo(archivo);
        for (int i = 0; i < lista.size(); i++) {
            if (buscar.compareToIgnoreCase(lista.get(i).getNombre()) == 0) return true;
        }
        return false;
    }

    public Proveedor buscarProveedor2(int nit) {
        lista = persistencia.lecturaArchivo(archivo);
        Proveedor proveedorExistente = null;
        for (Proveedor proveedor : lista) {
            if (proveedor.getNIT() == nit) {
                proveedorExistente = proveedor;
            }
        }
        return proveedorExistente;
    }

    public void eliminarProveedor(String eliminar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarProveedor(eliminar)) {
            archivo.delete();
            lista.removeIf(x -> (x.getNombre().compareToIgnoreCase(eliminar)) == 0);
            for (Proveedor i : lista) {
                agregarProveedor(i);
            }
        }
    }

    public void modificarProveedor(String buscar, Proveedor modificar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarProveedor(buscar)) {
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
            for (Proveedor i : lista) {
                agregarProveedor(i);
            }
        }
    }

    public LinkedList<Proveedor> list() {
        return persistencia.lecturaArchivo(archivo);
    }

    public void eliminarArchivo() {
        archivo.delete();
        if (!archivo.exists())
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        ProveedorDAO.archivo = archivo;
    }

    public LinkedList<Proveedor> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Proveedor> lista) {
        this.lista = lista;
    }
}