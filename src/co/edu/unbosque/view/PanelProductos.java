package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {

    private JLabel label;

    private JPanel botones;

    private JPanel campos;

    private JTextField codigoProducto;

    private JComboBox<String> codigoProductoCombo;

    private JTextField nombre;

    private JTextField nitProveedor;

    private JTextField precioCompra;

    private JTextField precioVenta;

    private JButton agregar;

    private JButton modificar;

    private JButton eliminar;

    private JButton buscar;

    private final String accion;

    public PanelProductos(String accion) {
        this.accion = accion;
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        campos = new JPanel(new GridLayout(5,2, 0, 3));

        label = new JLabel("Código: ");
        campos.add(label);

        if (accion.equals("AGREGAR")) {
            codigoProducto = new JTextField();
            campos.add(codigoProducto);
        } else {
            codigoProductoCombo = new JComboBox<>();
            codigoProductoCombo.setActionCommand(accion.toUpperCase() + "_PRODUCTOS_COMBOBOX");
            campos.add(codigoProductoCombo);
        }

        label = new JLabel("Nombre: ");
        campos.add(label);

        nombre = new JTextField();
        campos.add(nombre);

        label = new JLabel("NIT del proveedor: ");
        campos.add(label);

        nitProveedor = new JTextField();
        campos.add(nitProveedor);

        label = new JLabel("Precio de compra: ");
        campos.add(label);

        precioCompra = new JTextField();
        campos.add(precioCompra);

        label = new JLabel("Precio de venta: ");
        campos.add(label);

        precioVenta = new JTextField();
        campos.add(precioVenta);

        botones = new JPanel(new GridLayout());

        if (accion.equals("AGREGAR")) {
            agregar = new JButton("Agregar");
            agregar.setActionCommand("PRODUCTOS_AGREGAR");
            botones.add(agregar);
        } else if (accion.equals("BUSCAR")|| accion.equals("ELIMINAR")) {
            nombre.setEditable(false);
            nitProveedor.setEditable(false);
            precioCompra.setEditable(false);
            precioVenta.setEditable(false);

            buscar = new JButton("Buscar");
            buscar.setActionCommand("PRODUCTOS_BUSCAR");
            botones.add(buscar);

            eliminar = new JButton("Eliminar");
            eliminar.setActionCommand("PRODUCTOS_ELIMINAR");
            botones.add(eliminar);
        } else if (accion.equals("MODIFICAR")) {
            modificar = new JButton("Aplicar Cambios");
            modificar.setActionCommand("PRODUCTOS_MODIFICAR");
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

    public JTextField getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(JTextField codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public JComboBox<String> getCodigoProductoCombo() {
        return codigoProductoCombo;
    }

    public void setCodigoProductoCombo(JComboBox<String> codigoProductoCombo) {
        this.codigoProductoCombo = codigoProductoCombo;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(JTextField nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public JTextField getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(JTextField precioCompra) {
        this.precioCompra = precioCompra;
    }

    public JTextField getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(JTextField precioVenta) {
        this.precioVenta = precioVenta;
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
