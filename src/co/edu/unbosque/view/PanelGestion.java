package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelGestion extends JPanel {

    private JButton propiedades;

    private JButton gestionClientes;

    private JButton gestionProveedores;

    private JButton gestionProductos;

    public PanelGestion() {
        setLayout(new GridLayout(2,2,2,2));
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes() {
        propiedades = new JButton("<html><p style=\"text-align:center;\">Propiedades<br>de Tienda</p></html>");
        propiedades.setActionCommand("GESTIONAR_PROPIEDADES");
        add(propiedades);

        gestionClientes = new JButton("<html><p style=\"text-align:center;\">Gestionar<br>Clientes</p></html>");
        gestionClientes.setActionCommand("GESTIONAR_CLIENTES");
        add(gestionClientes);

        gestionProveedores = new JButton("<html><p style=\"text-align:center;\">Gestionar<br>Proveedores</p></html>");
        gestionProveedores.setActionCommand("GESTIONAR_PROVEEDORES");
        add(gestionProveedores);

        gestionProductos = new JButton("<html><p style=\"text-align:center;\">Gestionar<br>Productos</p></html>");
        gestionProductos.setActionCommand("GESTIONAR_PRODUCTOS");
        add(gestionProductos);

    }

    public JButton getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(JButton propiedades) {
        this.propiedades = propiedades;
    }

    public JButton getGestionClientes() {
        return gestionClientes;
    }

    public void setGestionClientes(JButton gestionClientes) {
        this.gestionClientes = gestionClientes;
    }

    public JButton getGestionProveedores() {
        return gestionProveedores;
    }

    public void setGestionProveedores(JButton gestionProveedores) {
        this.gestionProveedores = gestionProveedores;
    }

    public JButton getGestionProductos() {
        return gestionProductos;
    }

    public void setGestionProductos(JButton gestionProductos) {
        this.gestionProductos = gestionProductos;
    }
}
