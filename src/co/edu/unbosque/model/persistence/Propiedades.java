package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {

    private static Properties propiedades;
    private static final String ARCHIVO = "./BDArchivos/config.properties";

    public Propiedades() {
        propiedades = new Properties();
    }

    public void escribirPropiedades(String tienda, String comercio, String nit, String cuidad, String iva, String interes, String banco, String cuenta, String gerente) {
        try {
            propiedades.setProperty("nombreTienda", tienda);
            propiedades.setProperty("tipoComercio", comercio);
            propiedades.setProperty("NITTienda", nit);
            propiedades.setProperty("cuidad", cuidad);
            propiedades.setProperty("iva", iva);
            propiedades.setProperty("tasaInteres", interes);
            propiedades.setProperty("bancoAsociado", banco);
            propiedades.setProperty("numeroCuenta", cuenta);
            propiedades.setProperty("gerenteTienda", gerente);
            propiedades.store(new FileOutputStream(ARCHIVO), null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo esta mal, revisa");
        }
    }


    public String mostrarPropiedades() {
        String contenido = "";
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
            propiedades.list(System.out);

            contenido += "\nNombre de la tienda: " + propiedades.getProperty("nombreTienda");
            contenido += "\nSector comercial: " + propiedades.getProperty("tipoComercio");
            contenido += "\nNIT del establecimiento: " + propiedades.getProperty("NITTienda");
            contenido += "\ncuidad: " + propiedades.getProperty("cuidad");
            contenido += "\nIVA: " + propiedades.getProperty("IVA");
            contenido += "\nInteres aplicado: " + propiedades.getProperty("tasaInteres");
            contenido += "\nBanco asociado: " + propiedades.getProperty("bancoAsociado");
            contenido += "\nNumero de cuenta: " + propiedades.getProperty("numeroCuenta");
            contenido += "\nGerente ejecutivo: " + propiedades.getProperty("gerenteTienda");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contenido;
    }

    public double Iva() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
            return Double.parseDouble(propiedades.getProperty("iva"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String getNombreTienda() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("nombreTienda");
    }

    public String getTipoComercio() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("tipoComercio");
    }

    public String getNit() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("NITTienda");
    }

    public String getCiudad() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("ciudad");
    }

    public String getValorIva() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("iva");
    }

    public String getTasaInteres() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("tasaInteres");
    }

    public String getBanco() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("bancoAsociado");
    }

    public String getNumeroCuenta() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("numeroCuenta");
    }

    public String getNombreGerente() {
        try {
            propiedades.load(new FileInputStream(ARCHIVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propiedades.getProperty("gerenteTienda");
    }


    public static Properties getPropiedades() {
        return propiedades;
    }

    public static void setPropiedades(Properties propiedades) {
        Propiedades.propiedades = propiedades;
    }

    public static String getArchivo() {
        return ARCHIVO;
    }
}