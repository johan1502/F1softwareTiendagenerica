package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelGestionAcciones extends JPanel {

    private JButton agregar;

    private JButton buscar;

    private JButton modificar;

    private JButton eliminar;

    private JButton regresar;

    private final String comando;

    public PanelGestionAcciones(String comando) {
        this.comando = comando;
        setLayout(new FlowLayout());
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        agregar = new JButton("<html><p style=\"text-align:center;\">Agregar<br>" + comando + "</p></html>");
        agregar.setActionCommand("ACCION_AGREGAR_" + comando.toUpperCase());
        add(agregar);

        buscar = new JButton("<html><p style=\"text-align:center;\">Buscar<br>" + comando + "</p></html>");
        buscar.setActionCommand("ACCION_BUSCAR_" + comando.toUpperCase());
        add(buscar);

        modificar = new JButton("<html><p style=\"text-align:center;\">Modificar<br>" + comando + "</p></html>");
        modificar.setActionCommand("ACCION_MODIFICAR_" + comando.toUpperCase());
        add(modificar);

        eliminar = new JButton("<html><p style=\"text-align:center;\">Eliminar<br>" + comando + "</p></html>");
        eliminar.setActionCommand("ACCION_ELIMINAR_" + comando.toUpperCase());
        add(eliminar);

        regresar = new JButton("Regresar");
        regresar.setActionCommand(comando.toUpperCase() + "_REGRESAR");
        add(regresar);
    }

    public JButton getAgregar() {
        return agregar;
    }

    public void setAgregar(JButton agregar) {
        this.agregar = agregar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public void setBuscar(JButton buscar) {
        this.buscar = buscar;
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

    public JButton getRegresar() {
        return regresar;
    }

    public void setRegresar(JButton regresar) {
        this.regresar = regresar;
    }
}
