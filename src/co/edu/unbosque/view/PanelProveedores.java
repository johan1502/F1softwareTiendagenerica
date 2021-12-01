package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelProveedores extends JPanel {

    private JLabel label;

    private JPanel botones;

    private JPanel campos;

    private JTextField nit;

    private JComboBox<String> nitCombo;

    private JTextField nombreProveedor;

    private JTextField direccion;

    private JTextField telefono;

    private JTextField ciudad;

    private JButton agregar;

    private JButton modificar;

    private JButton eliminar;

    private JButton buscar;

    private final String accion;

    public PanelProveedores(String accion) {
        this.accion = accion;
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        campos = new JPanel(new GridLayout(5,2, 0, 3));

        label = new JLabel("NIT: ");
        campos.add(label);

        if (accion.equals("AGREGAR")) {
            nit = new JTextField();
            campos.add(nit);
        } else {
            nitCombo = new JComboBox<>();
            nitCombo.setActionCommand(accion.toUpperCase() + "_PROVEEDORES_COMBOBOX");
            campos.add(nitCombo);
        }

        label = new JLabel("Nombre: ");
        campos.add(label);

        nombreProveedor = new JTextField();
        campos.add(nombreProveedor);

        label = new JLabel("Dirección: ");
        campos.add(label);

        direccion = new JTextField();
        campos.add(direccion);

        label = new JLabel("Teléfono: ");
        campos.add(label);

        telefono = new JTextField();
        campos.add(telefono);

        label = new JLabel("Ciudad: ");
        campos.add(label);

        ciudad = new JTextField();
        campos.add(ciudad);

        botones = new JPanel(new GridLayout());

        if (accion.equals("AGREGAR")) {
            agregar = new JButton("Agregar");
            agregar.setActionCommand("PROVEEDORES_AGREGAR");
            botones.add(agregar);
        } else if (accion.equals("BUSCAR") || accion.equals("ELIMINAR")) {
            nombreProveedor.setEditable(false);
            direccion.setEditable(false);
            telefono.setEditable(false);
            ciudad.setEditable(false);

            buscar = new JButton("Buscar");
            buscar.setActionCommand("PROVEEDORES_BUSCAR");
            botones.add(buscar);

            eliminar = new JButton("Eliminar");
            eliminar.setActionCommand("PROVEEDORES_ELIMINAR");
            botones.add(eliminar);
        } else if (accion.equals("MODIFICAR")) {
            modificar = new JButton("Aplicar Cambios");
            modificar.setActionCommand("PROVEEDORES_MODIFICAR");
            botones.add(modificar);
        }

        campos.setBounds(20,0,540,160);
        add(campos);

        botones.setBounds(20,165,540,30);
        add(botones);
    }

    public JPanel getBotones() {
        return botones;
    }

    public void setBotones(JPanel botones) {
        this.botones = botones;
    }

    public JPanel getCampos() {
        return campos;
    }

    public void setCampos(JPanel campos) {
        this.campos = campos;
    }

    public JTextField getNit() {
        return nit;
    }

    public void setNit(JTextField nit) {
        this.nit = nit;
    }

    public JComboBox<String> getNitCombo() {
        return nitCombo;
    }

    public void setNitCombo(JComboBox<String> nitCombo) {
        this.nitCombo = nitCombo;
    }

    public JTextField getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(JTextField nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public JTextField getDireccion() {
        return direccion;
    }

    public void setDireccion(JTextField direccion) {
        this.direccion = direccion;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    public JTextField getCiudad() {
        return ciudad;
    }

    public void setCiudad(JTextField ciudad) {
        this.ciudad = ciudad;
    }

    public JButton getAgregar() {
        return agregar;
    }

    public void setAgregar(JButton agregar) {
        this.agregar = agregar;
    }

    public JButton getModificar() {
        return modificar;
    }

    public void setModificar(JButton modificar) {
        this.modificar = modificar;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public void setEliminar(JButton eliminar) {
        this.eliminar = eliminar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
    }
}
