package co.edu.unbosque.view;

import javax.swing.*;

public class Ventana extends JFrame {

    private PanelPropiedades panelPropiedades;

    private PanelGestion panelGestion;

    private PanelGestionAcciones panelAccionesClientes;

    private PanelGestionAcciones panelAccionesProveedores;

    private PanelGestionAcciones panelAccionesProductos;

    private PanelClientes agregarClientes;

    private PanelClientes buscarClientes;

    private PanelClientes modificarClientes;

    private PanelProveedores agregarProveedores;

    private PanelProveedores buscarProveedores;

    private PanelProveedores modificarProveedores;

    private PanelProductos agregarProductos;

    private PanelProductos buscarProductos;

    private PanelProductos modificarProductos;

    public Ventana() {
        setSize(600, 310);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        inicializarComponentes();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void inicializarComponentes() {
        panelPropiedades = new PanelPropiedades();
        panelPropiedades.setBounds(10, 10, 575, 265);
        getContentPane().add(panelPropiedades);

        panelGestion = new PanelGestion();
        panelGestion.setBounds(10, 10, 575, 265);
        getContentPane().add(panelGestion);

        panelAccionesClientes = new PanelGestionAcciones("Clientes");
        panelAccionesClientes.setBounds(0, 0, 610, 60);
        getContentPane().add(panelAccionesClientes);

        panelAccionesProveedores = new PanelGestionAcciones("Proveedores");
        panelAccionesProveedores.setBounds(0, 0, 610, 60);
        getContentPane().add(panelAccionesProveedores);

        panelAccionesProductos = new PanelGestionAcciones("Productos");
        panelAccionesProductos.setBounds(0, 0, 610, 60);
        getContentPane().add(panelAccionesProductos);

        agregarClientes = new PanelClientes("AGREGAR");
        agregarClientes.setBounds(0,80,610,195);
        getContentPane().add(agregarClientes);

        buscarClientes = new PanelClientes("BUSCAR");
        buscarClientes.setBounds(0,80,610,195);
        getContentPane().add(buscarClientes);

        modificarClientes = new PanelClientes("MODIFICAR");
        modificarClientes.setBounds(0,80,610,195);
        getContentPane().add(modificarClientes);

        agregarProveedores = new PanelProveedores("AGREGAR");
        agregarProveedores.setBounds(0,80,610,195);
        getContentPane().add(agregarProveedores);

        buscarProveedores = new PanelProveedores("BUSCAR");
        buscarProveedores.setBounds(0,80,610,195);
        getContentPane().add(buscarProveedores);

        modificarProveedores = new PanelProveedores("MODIFICAR");
        modificarProveedores.setBounds(0,80,610,195);
        getContentPane().add(modificarProveedores);

        agregarProductos = new PanelProductos("AGREGAR");
        agregarProductos.setBounds(0,80,610,195);
        getContentPane().add(agregarProductos);

        buscarProductos = new PanelProductos("BUSCAR");
        buscarProductos.setBounds(0,80,610,195);
        getContentPane().add(buscarProductos);

        modificarProductos = new PanelProductos("MODIFICAR");
        modificarProductos.setBounds(0,80,610,195);
        getContentPane().add(modificarProductos);
    }

    public PanelPropiedades getPanelPropiedades() {
        return panelPropiedades;
    }

    public void setPanelPropiedades(PanelPropiedades panelPropiedades) {
        this.panelPropiedades = panelPropiedades;
    }

    public PanelGestion getPanelGestion() {
        return panelGestion;
    }

    public void setPanelGestion(PanelGestion panelGestion) {
        this.panelGestion = panelGestion;
    }

    public PanelGestionAcciones getPanelAccionesClientes() {
        return panelAccionesClientes;
    }

    public void setPanelAccionesClientes(PanelGestionAcciones panelAccionesClientes) {
        this.panelAccionesClientes = panelAccionesClientes;
    }

    public PanelGestionAcciones getPanelAccionesProveedores() {
        return panelAccionesProveedores;
    }

    public void setPanelAccionesProveedores(PanelGestionAcciones panelAccionesProveedores) {
        this.panelAccionesProveedores = panelAccionesProveedores;
    }

    public PanelGestionAcciones getPanelAccionesProductos() {
        return panelAccionesProductos;
    }

    public void setPanelAccionesProductos(PanelGestionAcciones panelAccionesProductos) {
        this.panelAccionesProductos = panelAccionesProductos;
    }

    public PanelClientes getAgregarClientes() {
        return agregarClientes;
    }

    public void setAgregarClientes(PanelClientes agregarClientes) {
        this.agregarClientes = agregarClientes;
    }

    public PanelClientes getBuscarClientes() {
        return buscarClientes;
    }

    public void setBuscarClientes(PanelClientes buscarClientes) {
        this.buscarClientes = buscarClientes;
    }

    public PanelClientes getModificarClientes() {
        return modificarClientes;
    }

    public void setModificarClientes(PanelClientes modificarClientes) {
        this.modificarClientes = modificarClientes;
    }

    public PanelProveedores getAgregarProveedores() {
        return agregarProveedores;
    }

    public void setAgregarProveedores(PanelProveedores agregarProveedores) {
        this.agregarProveedores = agregarProveedores;
    }

    public PanelProveedores getBuscarProveedores() {
        return buscarProveedores;
    }

    public void setBuscarProveedores(PanelProveedores buscarProveedores) {
        this.buscarProveedores = buscarProveedores;
    }

    public PanelProveedores getModificarProveedores() {
        return modificarProveedores;
    }

    public void setModificarProveedores(PanelProveedores modificarProveedores) {
        this.modificarProveedores = modificarProveedores;
    }

    public PanelProductos getAgregarProductos() {
        return agregarProductos;
    }

    public void setAgregarProductos(PanelProductos agregarProductos) {
        this.agregarProductos = agregarProductos;
    }

    public PanelProductos getBuscarProductos() {
        return buscarProductos;
    }

    public void setBuscarProductos(PanelProductos buscarProductos) {
        this.buscarProductos = buscarProductos;
    }

    public PanelProductos getModificarProductos() {
        return modificarProductos;
    }

    public void setModificarProductos(PanelProductos modificarProductos) {
        this.modificarProductos = modificarProductos;
    }
}
