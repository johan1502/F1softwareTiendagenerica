package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.*;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Producto;

public class ProductoDAO {

    private Persistencia persistencia;
    private static File archivo;
    private LinkedList<Producto> lista;

    public ProductoDAO(int opcion) {
        persistencia = new Persistencia();
        lista = new LinkedList<Producto>();
        opcionArchivo(opcion);
    }

    private void opcionArchivo(int opcion) {
        if (opcion == 1)
            archivo = new File("BDArchivos/Productos.bin");
        else
            archivo = new File("BDTest/ProductoTest.bin");
    }

    public void agregarProducto(Producto producto) {
        persistencia.agregarDato(producto, archivo);
    }

    public String mostrarProductos() {
        lista = persistencia.lecturaArchivo(archivo);
        String contenido = "LISTA DE PRODUCTOS:\n";
        for (int i = 0; i < lista.size(); i++) {
            contenido += lista.get(i) + "\n\n";
        }
        return contenido;
    }


    public boolean buscarProducto(String buscar) {
        lista = persistencia.lecturaArchivo(archivo);
        for (int i = 0; i < lista.size(); i++) {
            if (buscar.compareToIgnoreCase(lista.get(i).getNombreProducto()) == 0) return true;
        }
        return false;
    }

    public Producto buscarProducto2(long codigo) {
        lista = persistencia.lecturaArchivo(archivo);
        Producto producto = null;
        for (Producto value : lista) {
            if (value.getCodigo() == codigo) {
                producto = value;
            }
        }
        return producto;
    }

    public void eliminarProducto(String eliminar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarProducto(eliminar)) {
            archivo.delete();
            lista.removeIf(x -> (x.getNombreProducto().compareToIgnoreCase(eliminar)) == 0);
            for (Producto i : lista) {
                agregarProducto(i);
            }
        }
    }

    public void modificarProducto(String buscar, Producto modificar) {
        lista = persistencia.lecturaArchivo(archivo);
        if (buscarProducto(buscar)) {
            archivo.delete();
            try {
                archivo.createNewFile();
            } catch (IOException e) {
            }
            int index = 0;
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombreProducto().compareToIgnoreCase(buscar) == 0) index = i;
            }
            lista.set(index, modificar);
            for (Producto i : lista) {
                agregarProducto(i);
            }
        }
    }

    public LinkedList<Producto> list() {
        return persistencia.lecturaArchivo(archivo);
    }

    public void eliminarArchivo() {
        archivo.delete();
        if (!archivo.exists())
            try {
                archivo.createNewFile();
            } catch (IOException e) {
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
        ProductoDAO.archivo = archivo;
    }

    public LinkedList<Producto> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Producto> lista) {
        this.lista = lista;
    }
}