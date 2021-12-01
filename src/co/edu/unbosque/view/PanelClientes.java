package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelClientes extends JPanel {

    private JLabel label;

    private JPanel botones;

    private JPanel campos;

    private JTextField cedula;

    private JComboBox<String> cedulaCombo;

    private JTextField nombre;

    private JTextField direccion;

    private JTextField telefono;

    private JTextField correo;

    private JButton agregar;

    private JButton modificar;

    private JButton eliminar;

    private JButton buscar;

    private final String accion;

    public PanelClientes(String accion) {
        this.accion = accion;
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        campos = new JPanel(new GridLayout(5,2, 0, 3));

        label = new JLabel("Cédula: ");
        campos.add(label);

        if (accion.equals("AGREGAR")) {
            cedula = new JTextField();
            campos.add(cedula);
        } else {
            cedulaCombo = new JComboBox<>();
            cedulaCombo.setActionCommand(accion.toUpperCase() + "_CLIENTES_COMBOBOX");
            campos.add(cedulaCombo);
        }

        label = new JLabel("Nombre: ");
        campos.add(label);

        nombre = new JTextField();
        campos.add(nombre);

        label = new JLabel("Dirección: ");
        campos.add(label);

        direccion = new JTextField();
        campos.add(direccion);

        label = new JLabel("Teléfono: ");
        campos.add(label);

        telefono = new JTextField();
        campos.add(telefono);

        label = new JLabel("Correo: ");
        campos.add(label);

        correo = new JTextField();
        campos.add(correo);

        botones = new JPanel(new GridLayout());

        if (accion.equals("AGREGAR")) {
            agregar = new JButton("Agregar");
            agregar.setActionCommand("CLIENTES_AGREGAR");
            botones.add(agregar);
        } else if (accion.equals("BUSCAR") || accion.equals("ELIMINAR")) {
            nombre.setEditable(false);
            direccion.setEditable(false);
            telefono.setEditable(false);
            correo.setEditable(false);

            buscar = new JButton("Buscar");
            buscar.setActionCommand("CLIENTES_BUSCAR");
            botones.add(buscar);

            eliminar = new JButton("Eliminar");
            eliminar.setActionCommand("CLIENTES_ELIMINAR");
            botones.add(eliminar);
        } else if (accion.equals("MODIFICAR")) {
            modificar = new JButton("Aplicar Cambios");
            modificar.setActionCommand("CLIENTES_MODIFICAR");
            botones.add(modificar);
        }

        campos.setBounds(20,0,540,160);
        add(campos);

        botones.setBounds(20,165,540,30);
        add(botones);
    }

    public JTextField getCedula() {
        return cedula;
    }

    public void setCedula(JTextField cedula) {
        this.cedula = cedula;
    }

    public JComboBox<String> getCedulaCombo() {
        return cedulaCombo;
    }

    public void setCedulaCombo(JComboBox<String> cedulaCombo) {
        this.cedulaCombo = cedulaCombo;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
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

    public JTextField getCorreo() {
        return correo;
    }

    public void setCorreo(JTextField correo) {
        this.correo = correo;
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
