package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.Proveedor;
import co.edu.unbosque.view.Mensaje;
import co.edu.unbosque.view.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {

    private Mensaje view;
    private Modelo model;
    private Ventana ventana;

    public Controller() {
        view = new Mensaje();
        model = new Modelo();
        ventana = new Ventana();
        asignarOyentes();

        ventana.setTitle(model.getPropiedades().getNombreTienda());
        //funcionar();
    }

    private void funcionar() {
        try {
            int menu = 0;
            do {
                menu = view.leerDato("TIENDA GENERICA" +
                        "\n Selecciona la opcion a realizar" +
                        "\n 1. Ingresar" +
                        "\n 2. Ver lista" +
                        "\n 3. Modificar cliente" +
                        "\n 4. Eliminar cliente" +
                        "\n11. Consulta de notas.");


                switch (menu) {
                    case 1:
                        model.agregarCliente(new Cliente("Andres", menu, null, menu, null));
                        break;


                    case 2:
                        model.agregarCliente(new Cliente("Xavi", menu, null, menu, null));
                        break;

                    case 3:
                        model.agregarCliente(new Cliente("Luis", 3, "Barcelona", 9876, "gmail.com"));
                        break;

                    case 4:
                        view.mostrarInformacion(model.mostrarClientes());
                        break;

                    case 5:
                        model.eliminarCliente("Xavi");
                        break;

                    case 6:
                        model.modificarCliente("Luis", new Cliente("Luis suarez", menu, null, menu, null));
                        break;

                    case 7:
                        model.agregarProducto(new Producto("Pasta", 1, menu, menu, 4500));
                        break;

                    case 8:
                        model.agregarProducto(new Producto("Carne", 2, menu, menu, 9800));
                        break;

                    case 10:
                        model.eliminarProducto("Pasta");
                        break;

                    case 11:
                        view.mostrarInformacion(model.mostrarClientes());
                        break;

                    case 12:
                        // model.documentoListaClientes();
                        break;

                    case 16:
                        compraVentas();
                        break;

                    case 17:
                        model.establecerPropiedades("Generica", "Ropa", "1222a", "BOGOTA", "19", "", "", "", "");
                        break;

                    case 18:
                        view.mostrarInformacion("" + model.ventasCliente());
                        break;

                    case 19:
                        view.mostrarInformacion(model.detalleVentasCliente());
                        break;

                    case 20:
                        view.mostrarInformacion(model.mostrarCheques());
                        break;
                }
            } while (menu != 0);
        } catch (NumberFormatException mal) {
            view.errorMessage("Estimado usuario no debes ingresar letras ni simbolos dentro del menu :(");
        }
    }


    private void compraVentas() {
        int menu = 0, cantidad;
        int cedula = 3;
        double compra = 0;
        double iva = model.IVA();
        String factura = "TIENDA GENERICA\n------------------------------------\nCliente:" + model.nombreCliente(cedula) + "\n-------------------------------\n";
        try {
            do {
                menu = view.leerDato("Ingresa el producto a comprar.\n" + model.mostrarProductos() + "\nIngresa -1 para totalizar\n");
                if (menu != -1) {
                    cantidad = view.leerDato("Ingresa la cantidad a comprar.");
                    compra += model.comprarProducto(menu, cantidad);
                    factura += model.comprarProductoString(menu, cantidad) + "\n";
                    model.escrituraDetalleArchivo(cedula, menu, cantidad, compra, model.comprarProducto(menu, cantidad));
                }
            } while (menu != -1);
            factura += "\nCedula del cliente:" + cedula +
                    "\n---------------------TOTAL Net: " + compra +
                    "\n---------------------IVA: " + ((compra * iva) / 100) +
                    "\n---------------------TOTAL bruto: " + (compra + ((compra * iva) / 100));

            System.out.println(factura);
            model.escrituraCheque(factura);
            model.escribirArchivoVentas(0, cedula, compra, ((compra * iva) / 100), (compra + ((compra * iva) / 100)));
        } catch (NumberFormatException mal) {
            mal.printStackTrace();
        }
    }


    public void asignarOyentes() {
        ventana.getPanelGestion().getGestionClientes().addActionListener(this);
        ventana.getPanelGestion().getGestionProveedores().addActionListener(this);
        ventana.getPanelGestion().getGestionProductos().addActionListener(this);
        ventana.getPanelGestion().getPropiedades().addActionListener(this);

        ventana.getPanelAccionesProveedores().getAgregar().addActionListener(this);
        ventana.getPanelAccionesProveedores().getBuscar().addActionListener(this);
        ventana.getPanelAccionesProveedores().getModificar().addActionListener(this);
        ventana.getPanelAccionesProveedores().getEliminar().addActionListener(this);
        ventana.getPanelAccionesProveedores().getRegresar().addActionListener(this);

        ventana.getPanelAccionesProductos().getAgregar().addActionListener(this);
        ventana.getPanelAccionesProductos().getBuscar().addActionListener(this);
        ventana.getPanelAccionesProductos().getModificar().addActionListener(this);
        ventana.getPanelAccionesProductos().getEliminar().addActionListener(this);
        ventana.getPanelAccionesProductos().getRegresar().addActionListener(this);

        ventana.getPanelAccionesClientes().getAgregar().addActionListener(this);
        ventana.getPanelAccionesClientes().getBuscar().addActionListener(this);
        ventana.getPanelAccionesClientes().getModificar().addActionListener(this);
        ventana.getPanelAccionesClientes().getEliminar().addActionListener(this);
        ventana.getPanelAccionesClientes().getRegresar().addActionListener(this);

        ventana.getAgregarProveedores().getAgregar().addActionListener(this);

        ventana.getBuscarProveedores().getBuscar().addActionListener(this);
        ventana.getBuscarProveedores().getEliminar().addActionListener(this);

        ventana.getModificarProveedores().getModificar().addActionListener(this);
        ventana.getModificarProveedores().getNitCombo().addActionListener(this);

        ventana.getAgregarProductos().getAgregar().addActionListener(this);

        ventana.getBuscarProductos().getBuscar().addActionListener(this);
        ventana.getBuscarProductos().getEliminar().addActionListener(this);

        ventana.getModificarProductos().getModificar().addActionListener(this);
        ventana.getModificarProductos().getCodigoProductoCombo().addActionListener(this);

        ventana.getAgregarClientes().getAgregar().addActionListener(this);

        ventana.getBuscarClientes().getBuscar().addActionListener(this);
        ventana.getBuscarClientes().getEliminar().addActionListener(this);

        ventana.getModificarClientes().getModificar().addActionListener(this);
        ventana.getModificarClientes().getCedulaCombo().addActionListener(this);

        ventana.getPanelPropiedades().getAplicarCambios().addActionListener(this);
        ventana.getPanelPropiedades().getRegresar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        System.out.println(comando);

        if (comando.contains("GESTIONAR") || comando.contains("REGRESAR")) {
            ventana.getPanelPropiedades().setVisible(false);
            ventana.getPanelAccionesClientes().setVisible(false);
            ventana.getPanelAccionesProveedores().setVisible(false);
            ventana.getPanelAccionesProductos().setVisible(false);
            ventana.getPanelGestion().setVisible(false);

            ventana.getAgregarClientes().setVisible(false);
            ventana.getBuscarClientes().setVisible(false);
            ventana.getModificarClientes().setVisible(false);

            ventana.getAgregarProveedores().setVisible(false);
            ventana.getBuscarProveedores().setVisible(false);
            ventana.getModificarProveedores().setVisible(false);

            ventana.getAgregarProductos().setVisible(false);
            ventana.getBuscarProductos().setVisible(false);
            ventana.getModificarProductos().setVisible(false);

            switch (comando) {
                case "GESTIONAR_PROPIEDADES":
                    ventana.getPanelPropiedades().setVisible(true);

                    String nombreTienda = model.getPropiedades().getNombreTienda();
                    String tipoComercio = model.getPropiedades().getTipoComercio();
                    String nit = model.getPropiedades().getNit();
                    String ciudad = model.getPropiedades().getCiudad();
                    String iva = model.getPropiedades().getValorIva();
                    String tasa = model.getPropiedades().getTasaInteres();
                    String banco = model.getPropiedades().getBanco();
                    String numeroCuenta = model.getPropiedades().getNumeroCuenta();
                    String gerente = model.getPropiedades().getNombreGerente();

                    ventana.getPanelPropiedades().getNombreTienda().setText(nombreTienda);
                    ventana.getPanelPropiedades().getTipoComercio().setText(tipoComercio);
                    ventana.getPanelPropiedades().getNitTienda().setText(nit);
                    ventana.getPanelPropiedades().getCiudadTienda().setText(ciudad);
                    ventana.getPanelPropiedades().getValorIVA().setText(iva);
                    ventana.getPanelPropiedades().getTasaInteres().setText(tasa);
                    ventana.getPanelPropiedades().getNombreBanco().setText(banco);
                    ventana.getPanelPropiedades().getNumeroCuentaBanco().setText(numeroCuenta);
                    ventana.getPanelPropiedades().getNombreGerenteTienda().setText(gerente);
                    break;
                case "GESTIONAR_CLIENTES":
                    ventana.getPanelAccionesClientes().setVisible(true);
                    break;
                case "GESTIONAR_PROVEEDORES":
                    ventana.getPanelAccionesProveedores().setVisible(true);
                    break;
                case "GESTIONAR_PRODUCTOS":
                    ventana.getPanelAccionesProductos().setVisible(true);
                    break;
                case "CLIENTES_REGRESAR":
                case "PROVEEDORES_REGRESAR":
                case "PRODUCTOS_REGRESAR":
                case "PROPIEDADES_REGRESAR":
                    ventana.getPanelGestion().setVisible(true);
                    break;
            }
        } else if (comando.contains("CLIENTES")) {
            if (comando.contains("ACCION")) {
                ventana.getAgregarClientes().setVisible(false);
                ventana.getBuscarClientes().setVisible(false);
                ventana.getModificarClientes().setVisible(false);
            }

            String seleccion;
            Cliente cliente;
            long cedula;
            String nombre;
            String direccion;
            int telefono;
            String correo;

            switch (comando) {
                case "ACCION_AGREGAR_CLIENTES":
                    ventana.getAgregarClientes().setVisible(true);
                    break;
                case "ACCION_BUSCAR_CLIENTES":
                case "ACCION_ELIMINAR_CLIENTES":
                    ventana.getBuscarClientes().setVisible(true);
                    ventana.getBuscarClientes().getCedulaCombo().removeAllItems();
                    for (Cliente clienteLista : model.getCliente().list()) {
                        ventana.getBuscarClientes().getCedulaCombo().addItem(String.valueOf(clienteLista.getCedula()));
                    }
                    break;
                case "ACCION_MODIFICAR_CLIENTES":
                    ventana.getModificarClientes().setVisible(true);
                    ventana.getModificarClientes().getCedulaCombo().removeAllItems();
                    for (Cliente clienteLista : model.getCliente().list()) {
                        ventana.getModificarClientes().getCedulaCombo().addItem(String.valueOf(clienteLista.getCedula()));
                    }
                    break;
                case "CLIENTES_AGREGAR":
                    try {
                        cedula = Long.parseLong(ventana.getAgregarClientes().getCedula().getText());
                        nombre = ventana.getAgregarClientes().getNombre().getText();
                        direccion = ventana.getAgregarClientes().getDireccion().getText();
                        telefono = Integer.parseInt(ventana.getAgregarClientes().getTelefono().getText());
                        correo = ventana.getAgregarClientes().getCorreo().getText();

                        cliente = new Cliente(nombre, cedula, direccion, telefono, correo);
                        model.agregarCliente(cliente);
                        view.mostrarInformacion("El cliente ha sido agregado correctamente.");
                    } catch (NullPointerException | NumberFormatException ex) {
                        view.mostrarInformacion("No olvide llenar todos los campos.");
                    }
                    break;
                case "CLIENTES_BUSCAR":
                    seleccion = (String) ventana.getBuscarClientes().getCedulaCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            try {
                                cliente = model.getCliente().buscarCliente2(Long.parseLong(seleccion));

                                ventana.getBuscarClientes().getNombre().setText(cliente.getNombre());
                                ventana.getBuscarClientes().getDireccion().setText(cliente.getDireccion());
                                ventana.getBuscarClientes().getTelefono().setText(String.valueOf(cliente.getTelefono()));
                                ventana.getBuscarClientes().getCorreo().setText(cliente.getNombre());
                            } catch (NullPointerException ex) {
                                view.mostrarInformacion("El cliente especificado ya no existe.");
                                ventana.getBuscarClientes().getCedulaCombo().removeItem(seleccion);
                                ventana.getBuscarClientes().getNombre().setText("");
                                ventana.getBuscarClientes().getDireccion().setText("");
                                ventana.getBuscarClientes().getTelefono().setText("");
                                ventana.getBuscarClientes().getCorreo().setText("");
                            }
                        }
                    }
                    break;
                case "CLIENTES_MODIFICAR":
                    try {
                        cedula = Long.parseLong((String) Objects.requireNonNull(ventana.getModificarClientes().getCedulaCombo().getSelectedItem()));
                        nombre = ventana.getModificarClientes().getNombre().getText();
                        direccion = ventana.getModificarClientes().getDireccion().getText();
                        telefono = Integer.parseInt(ventana.getModificarClientes().getTelefono().getText());
                        correo = ventana.getModificarClientes().getCorreo().getText();

                        cliente = new Cliente(nombre, cedula, direccion, telefono, correo);
                        model.getCliente().modificarCliente(nombre, cliente);
                        view.mostrarInformacion("El cliente se ha modificado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún cliente para modificar.");
                    }
                    break;
                case "CLIENTES_ELIMINAR":
                    try {
                        cedula = Long.parseLong((String) Objects.requireNonNull(ventana.getBuscarClientes().getCedulaCombo().getSelectedItem()));
                        nombre = ventana.getBuscarClientes().getNombre().getText();

                        model.eliminarCliente(nombre);
                        view.mostrarInformacion("El cliente se ha eliminado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún cliente para eliminar.");
                    }
                    break;
                case "MODIFICAR_CLIENTES_COMBOBOX":
                    seleccion = (String) ventana.getModificarClientes().getCedulaCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            cliente = model.getCliente().buscarCliente2(Long.parseLong(seleccion));
                            ventana.getModificarClientes().getNombre().setText(cliente.getNombre());
                            ventana.getModificarClientes().getDireccion().setText(cliente.getDireccion());
                            ventana.getModificarClientes().getTelefono().setText(String.valueOf(cliente.getTelefono()));
                            ventana.getModificarClientes().getCorreo().setText(cliente.getNombre());
                        }
                    }
                    break;
            }
        } else if (comando.contains("PROVEEDORES")) {
            if (comando.contains("ACCION")) {
                ventana.getAgregarProveedores().setVisible(false);
                ventana.getBuscarProveedores().setVisible(false);
                ventana.getModificarProveedores().setVisible(false);
            }

            String seleccion;
            Proveedor proveedor;
            int nit;
            String nombre;
            String direccion;
            int telefono;
            String ciudad;

            switch (comando) {
                case "ACCION_AGREGAR_PROVEEDORES":
                    ventana.getAgregarProveedores().setVisible(true);
                    break;
                case "ACCION_BUSCAR_PROVEEDORES":
                case "ACCION_ELIMINAR_PROVEEDORES":
                    ventana.getBuscarProveedores().setVisible(true);
                    ventana.getBuscarProveedores().getNitCombo().removeAllItems();
                    for (Proveedor proveedorLista : model.getProveedor().list()) {
                        ventana.getBuscarProveedores().getNitCombo().addItem(String.valueOf(proveedorLista.getNIT()));
                    }
                    break;
                case "ACCION_MODIFICAR_PROVEEDORES":
                    ventana.getModificarProveedores().setVisible(true);
                    ventana.getModificarProveedores().getNitCombo().removeAllItems();
                    for (Proveedor proveedorLista : model.getProveedor().list()) {
                        ventana.getModificarProveedores().getNitCombo().addItem(String.valueOf(proveedorLista.getNIT()));
                    }
                    break;
                case "PROVEEDORES_AGREGAR":
                    try {
                        nit = Integer.parseInt(ventana.getAgregarProveedores().getNit().getText());
                        nombre = ventana.getAgregarProveedores().getNombreProveedor().getText();
                        direccion = ventana.getAgregarProveedores().getDireccion().getText();
                        telefono = Integer.parseInt(ventana.getAgregarProveedores().getTelefono().getText());
                        ciudad = ventana.getAgregarProveedores().getCiudad().getText();

                        proveedor = new Proveedor(nombre, nit, direccion, telefono, ciudad);
                        model.agregarProveedor(proveedor);
                        view.mostrarInformacion("El proveedor ha sido agregado correctamente.");
                    } catch (NullPointerException | NumberFormatException ex) {
                        view.mostrarInformacion("No olvide llenar todos los campos.");
                    }
                    break;
                case "PROVEEDORES_BUSCAR":
                    seleccion = (String) ventana.getBuscarProveedores().getNitCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            try {
                                proveedor = model.getProveedor().buscarProveedor2(Integer.parseInt(seleccion));

                                ventana.getBuscarProveedores().getNombreProveedor().setText(proveedor.getNombre());
                                ventana.getBuscarProveedores().getDireccion().setText(proveedor.getDireccion());
                                ventana.getBuscarProveedores().getTelefono().setText(String.valueOf(proveedor.getTelefono()));
                                ventana.getBuscarProveedores().getCiudad().setText(proveedor.getCuidad());
                            } catch (NullPointerException ex) {
                                view.mostrarInformacion("El proveedor especificado ya no existe.");
                                ventana.getBuscarProveedores().getNitCombo().removeItem(seleccion);
                                ventana.getBuscarProveedores().getNombreProveedor().setText("");
                                ventana.getBuscarProveedores().getDireccion().setText("");
                                ventana.getBuscarProveedores().getTelefono().setText("");
                                ventana.getBuscarProveedores().getCiudad().setText("");
                            }
                        }
                    }
                    break;
                case "PROVEEDORES_MODIFICAR":
                    try {
                        nit = Integer.parseInt((String) Objects.requireNonNull(ventana.getModificarProveedores().getNitCombo().getSelectedItem()));
                        nombre = ventana.getModificarProveedores().getNombreProveedor().getText();
                        direccion = ventana.getModificarProveedores().getDireccion().getText();
                        telefono = Integer.parseInt(ventana.getModificarProveedores().getTelefono().getText());
                        ciudad = ventana.getModificarProveedores().getCiudad().getText();

                        proveedor = new Proveedor(nombre, nit, direccion, telefono, ciudad);
                        model.getProveedor().modificarProveedor(nombre, proveedor);
                        view.mostrarInformacion("El proveedor se ha modificado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún proveedor para modificar.");
                    }
                    break;
                case "PROVEEDORES_ELIMINAR":
                    try {
                        nit = Integer.parseInt((String) Objects.requireNonNull(ventana.getBuscarProveedores().getNitCombo().getSelectedItem()));
                        nombre = ventana.getBuscarProveedores().getNombreProveedor().getText();

                        model.eliminarProveedor(nombre);
                        view.mostrarInformacion("El proveedor se ha eliminado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún proveedor para eliminar.");
                    }
                    break;
                case "MODIFICAR_PROVEEDORES_COMBOBOX":
                    seleccion = (String) ventana.getModificarProveedores().getNitCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            proveedor = model.getProveedor().buscarProveedor2(Integer.parseInt(seleccion));
                            ventana.getModificarProveedores().getNombreProveedor().setText(proveedor.getNombre());
                            ventana.getModificarProveedores().getDireccion().setText(proveedor.getDireccion());
                            ventana.getModificarProveedores().getTelefono().setText(String.valueOf(proveedor.getTelefono()));
                            ventana.getModificarProveedores().getCiudad().setText(proveedor.getCuidad());
                        }
                    }
                    break;
            }
        } else if (comando.contains("PRODUCTOS")) {
            if (comando.contains("ACCION")) {
                ventana.getAgregarProductos().setVisible(false);
                ventana.getBuscarProductos().setVisible(false);
                ventana.getModificarProductos().setVisible(false);
            }

            String seleccion;
            Producto producto;
            long codigo;
            String nombre;
            int nit;
            double compra;
            double venta;

            switch (comando) {
                case "ACCION_AGREGAR_PRODUCTOS":
                    ventana.getAgregarProductos().setVisible(true);
                    break;
                case "ACCION_BUSCAR_PRODUCTOS":
                case "ACCION_ELIMINAR_PRODUCTOS":
                    ventana.getBuscarProductos().setVisible(true);
                    ventana.getBuscarProductos().getCodigoProductoCombo().removeAllItems();
                    for (Producto productoLista : model.getProducto().list()) {
                        ventana.getBuscarProductos().getCodigoProductoCombo().addItem(String.valueOf(productoLista.getCodigo()));
                    }
                    break;
                case "ACCION_MODIFICAR_PRODUCTOS":
                    ventana.getModificarProductos().setVisible(true);
                    ventana.getModificarProductos().getCodigoProductoCombo().removeAllItems();
                    for (Producto productoLista : model.getProducto().list()) {
                        ventana.getModificarProductos().getCodigoProductoCombo().addItem(String.valueOf(productoLista.getCodigo()));
                    }
                    break;
                case "PRODUCTOS_AGREGAR":
                    try {
                        codigo = Long.parseLong(ventana.getAgregarProductos().getCodigoProducto().getText());
                        nombre = ventana.getAgregarProductos().getNombre().getText();
                        nit = Integer.parseInt(ventana.getAgregarProductos().getNitProveedor().getText());
                        compra = Double.parseDouble(ventana.getAgregarProductos().getPrecioCompra().getText());
                        venta = Double.parseDouble(ventana.getAgregarProductos().getPrecioVenta().getText());

                        producto = new Producto(nombre, codigo, nit, compra, venta);
                        model.agregarProducto(producto);
                        view.mostrarInformacion("El producto ha sido agregado correctamente.");
                    } catch (NullPointerException | NumberFormatException ex) {
                        view.mostrarInformacion("No olvide llenar todos los campos.");
                    }
                    break;
                case "PRODUCTOS_BUSCAR":
                    seleccion = (String) ventana.getBuscarProductos().getCodigoProductoCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            try {
                                producto = model.getProducto().buscarProducto2(Long.parseLong(seleccion));

                                ventana.getBuscarProductos().getNombre().setText(producto.getNombreProducto());
                                ventana.getBuscarProductos().getNombre().setText(String.valueOf(producto.getNombreProducto()));
                                ventana.getBuscarProductos().getNitProveedor().setText(String.valueOf(producto.getNitProveedor()));
                                ventana.getBuscarProductos().getPrecioCompra().setText(String.valueOf(producto.getPrecioCompra()));
                                ventana.getBuscarProductos().getPrecioVenta().setText(String.valueOf(producto.getPrecioVenta()));
                            } catch (NullPointerException ex) {
                                view.mostrarInformacion("El producto especificado ya no existe.");
                                ventana.getBuscarProductos().getCodigoProductoCombo().removeItem(seleccion);
                                ventana.getBuscarProductos().getNombre().setText("");
                                ventana.getBuscarProductos().getNitProveedor().setText("");
                                ventana.getBuscarProductos().getPrecioCompra().setText("");
                                ventana.getBuscarProductos().getPrecioVenta().setText("");
                            }
                        }
                    }
                    break;
                case "PRODUCTOS_MODIFICAR":
                    try {
                        codigo = Long.parseLong((String) Objects.requireNonNull(ventana.getModificarProductos().getCodigoProductoCombo().getSelectedItem()));
                        nombre = ventana.getModificarProductos().getNombre().getText();
                        nit = Integer.parseInt(ventana.getModificarProductos().getNitProveedor().getText());
                        compra = Double.parseDouble(ventana.getModificarProductos().getPrecioCompra().getText());
                        venta = Double.parseDouble(ventana.getModificarProductos().getPrecioVenta().getText());

                        producto = new Producto(nombre, codigo, nit, compra, venta);
                        model.getProducto().modificarProducto(nombre, producto);
                        view.mostrarInformacion("El producto se ha modificado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún producto para modificar.");
                    }
                    break;
                case "PRODUCTOS_ELIMINAR":
                    try {
                        codigo = Long.parseLong((String) Objects.requireNonNull(ventana.getBuscarProductos().getCodigoProductoCombo().getSelectedItem()));
                        nombre = ventana.getBuscarProductos().getNombre().getText();

                        model.eliminarProducto(nombre);
                        view.mostrarInformacion("El producto se ha eliminado correctamente.");
                    } catch (NullPointerException ex) {
                        view.mostrarInformacion("No existe ningún producto para eliminar.");
                    }
                    break;
                case "MODIFICAR_PRODUCTOS_COMBOBOX":
                    seleccion = (String) ventana.getModificarProductos().getCodigoProductoCombo().getSelectedItem();

                    if (seleccion != null) {
                        if (!seleccion.equals("")) {
                            producto = model.getProducto().buscarProducto2(Long.parseLong(seleccion));
                            ventana.getModificarProductos().getNombre().setText(producto.getNombreProducto());
                            ventana.getModificarProductos().getNitProveedor().setText(String.valueOf(producto.getNitProveedor()));
                            ventana.getModificarProductos().getPrecioCompra().setText(String.valueOf(producto.getPrecioCompra()));
                            ventana.getModificarProductos().getPrecioVenta().setText(String.valueOf(producto.getPrecioVenta()));
                        }
                    }
                    break;
            }
        } else if (comando.equals("PROPIEDADES_APLICAR_CAMBIOS")) {
            String nombreTienda = ventana.getPanelPropiedades().getNombreTienda().getText();
            String tipoComercio = ventana.getPanelPropiedades().getTipoComercio().getText();
            String nit = ventana.getPanelPropiedades().getNitTienda().getText();
            String ciudad = ventana.getPanelPropiedades().getCiudadTienda().getText();
            String iva = ventana.getPanelPropiedades().getValorIVA().getText();
            String tasa = ventana.getPanelPropiedades().getTasaInteres().getText();
            String banco = ventana.getPanelPropiedades().getNombreBanco().getText();
            String numeroCuenta = ventana.getPanelPropiedades().getNumeroCuentaBanco().getText();
            String gerente = ventana.getPanelPropiedades().getNombreGerenteTienda().getText();

            model.establecerPropiedades(nombreTienda, tipoComercio, nit, ciudad, iva, tasa, banco, numeroCuenta, gerente);
            ventana.setTitle(model.getPropiedades().getNombreTienda());
            view.mostrarInformacion("Las propiedades han sido modificadas con éxito.");
        }
    }
}