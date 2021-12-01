package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPropiedades extends JPanel {

    private JLabel label;

    private JPanel campos;

    private JPanel botones;

    private JTextField nombreTienda;

    private JTextField tipoComercio;

    private JTextField nitTienda;

    private JTextField ciudadTienda;

    private JTextField valorIVA;

    private JTextField tasaInteres;

    private JTextField nombreBanco;

    private JTextField numeroCuentaBanco;

    private JTextField nombreGerenteTienda;

    private JButton aplicarCambios;

    private JButton regresar;

    public PanelPropiedades() {
        setLayout(new BorderLayout());
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        campos = new JPanel(new GridLayout(9,2));

        label = new JLabel("Nombre: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        nombreTienda = new JTextField();
        campos.add(nombreTienda);

        label = new JLabel("Tipo de comercio: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        tipoComercio = new JTextField();
        campos.add(tipoComercio);

        label = new JLabel("NIT: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        nitTienda = new JTextField();
        campos.add(nitTienda);

        label = new JLabel("Ciudad: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        ciudadTienda = new JTextField();
        campos.add(ciudadTienda);

        label = new JLabel("Valor de IVA: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        valorIVA = new JTextField();
        campos.add(valorIVA);

        label = new JLabel("Tasa de interés: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        tasaInteres = new JTextField();
        campos.add(tasaInteres);

        label = new JLabel("Banco: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        nombreBanco = new JTextField();
        campos.add(nombreBanco);

        label = new JLabel("Número de cuenta: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        numeroCuentaBanco = new JTextField();
        campos.add(numeroCuentaBanco);

        label = new JLabel("Nombre del gerente: ", SwingConstants.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setForeground(Color.BLACK);
        campos.add(label);

        nombreGerenteTienda = new JTextField();
        campos.add(nombreGerenteTienda);

        label = new JLabel("INGRESE LAS PROPIEDADES PARA LA TIENDA", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(Color.BLACK);
        add(label, BorderLayout.NORTH);

        add(campos, BorderLayout.CENTER);

        botones = new JPanel(new GridLayout());

        aplicarCambios = new JButton("Aplicar Cambios");
        aplicarCambios.setFont(new Font("Arial", Font.BOLD, 14));
        aplicarCambios.setBackground(new Color(108, 255, 69));
        aplicarCambios.setForeground(Color.BLACK);
        aplicarCambios.setActionCommand("PROPIEDADES_APLICAR_CAMBIOS");
        botones.add(aplicarCambios);

        regresar = new JButton("Regresar");
        regresar.setFont(new Font("Arial", Font.BOLD, 14));
        regresar.setBackground(new Color(255, 69, 69));
        regresar.setForeground(Color.BLACK);
        regresar.setActionCommand("PROPIEDADES_REGRESAR");
        botones.add(regresar);

        add(campos, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }

    public JButton getAplicarCambios() {
        return aplicarCambios;
    }

    public void setAplicarCambios(JButton aplicarCambios) {
        this.aplicarCambios = aplicarCambios;
    }

    public JTextField getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(JTextField nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public JTextField getTipoComercio() {
        return tipoComercio;
    }

    public void setTipoComercio(JTextField tipoComercio) {
        this.tipoComercio = tipoComercio;
    }

    public JTextField getNitTienda() {
        return nitTienda;
    }

    public void setNitTienda(JTextField nitTienda) {
        this.nitTienda = nitTienda;
    }

    public JTextField getCiudadTienda() {
        return ciudadTienda;
    }

    public void setCiudadTienda(JTextField ciudadTienda) {
        this.ciudadTienda = ciudadTienda;
    }

    public JTextField getValorIVA() {
        return valorIVA;
    }

    public void setValorIVA(JTextField valorIVA) {
        this.valorIVA = valorIVA;
    }

    public JTextField getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(JTextField tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public JTextField getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(JTextField nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public JTextField getNumeroCuentaBanco() {
        return numeroCuentaBanco;
    }

    public void setNumeroCuentaBanco(JTextField numeroCuentaBanco) {
        this.numeroCuentaBanco = numeroCuentaBanco;
    }

    public JTextField getNombreGerenteTienda() {
        return nombreGerenteTienda;
    }

    public void setNombreGerenteTienda(JTextField nombreGerenteTienda) {
        this.nombreGerenteTienda = nombreGerenteTienda;
    }

    public JButton getRegresar() {
        return regresar;
    }

    public void setRegresar(JButton regresar) {
        this.regresar = regresar;
    }
}
