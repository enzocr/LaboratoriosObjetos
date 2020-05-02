
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enzoq
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor capa = new Gestor();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 9);
    }

    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Registrar Proveedor");
        out.println("2.  Listar Proveedores");
        out.println("3.  Registrar Producto");
        out.println("4.  Registrar Cliente");
        out.println("5.  Listar Clientes");
        out.println("6.  Crear Carro de Compras");

        out.println();
    }

    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                registroProveedor();

                break;

            case 2:
                listarProveedores();
                break;

            case 3:
                datosProducto();
                break;
            case 4:
                datosCliente();
                break;

            case 5:
                listarClientes();

                break;

            case 6:
                crearCarroCompra();

                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;

            default:
                out.println("Opcion invalida");

        }

    }

    public static void registroProveedor() throws IOException {

        out.println("El proveedor es una Organizacion o una Persona?");
        int proveedor = Integer.parseInt(in.readLine());
        if (proveedor == 1) {
            out.println("---AGREGANDO ORGANIZACION PROVEEDORA");
            datosOrganizacion();
        }
        if (proveedor == 2) {
            out.println("---AGREGANDO PERSONA PROVEEDORA---");
            datosPersonaProveedora();
        }

    }

    public static void datosOrganizacion() throws IOException {

        out.println("Digite ID de la organizacion");
        String iD = in.readLine();
        out.println("Nombre de la organizacion");
        String nombre = in.readLine();
        out.println("Direccion Organizacion");
        String direccion = in.readLine();
        out.println("Telefono Organizacion");
        String telefono = in.readLine();
        out.println("identificacion representante");
        String idRep = in.readLine();
        out.println("Nombre representante");
        String nombreRep = in.readLine();
        out.println("Apellidos representante");
        String apellidos = in.readLine();
        out.println("Direccion representante");
        String direccionRep = in.readLine();
        out.println("Telefono representante");
        String telRep = in.readLine();

        capa.agregarOrganizacionProovedora(iD, nombre, direccion, telefono, idRep, nombreRep, apellidos, direccionRep, telRep);
    }

    public static void datosPersonaProveedora() throws IOException {
        out.println("identificacion Persona");
        String id = in.readLine();
        out.println("Nombre Persona");
        String nombre = in.readLine();
        out.println("Apellidos Persona");
        String apellidos = in.readLine();
        out.println("Direccion Persona");
        String direccion = in.readLine();
        out.println("Telefono Persona");
        String tel = in.readLine();
        capa.agregarPersonaProveedora(id, nombre, apellidos, direccion, tel);

    }

    public static void listarProveedores() {
        for (String proveedor : capa.getProveedores()) {
            out.println(proveedor);
        }
    }

    public static void datosProducto() throws IOException {

        out.println("Digite la descripcion del producto");
        String descripcion = in.readLine();
        out.println("Digite el precio del producto");
        int organic = Integer.parseInt(in.readLine());
        out.println("Digite si es FRUTA o VERDURA");
        String tipo = in.readLine();
        capa.agregarProducto(descripcion, organic, tipo);

    }

    public static void datosCliente() throws IOException {

        out.println("Digite ID del cliente");
        String iD = in.readLine();
        out.println("Nombre del Cliente");
        String nombre = in.readLine();
        out.println("Apellidos Persona");
        String apellidos = in.readLine();
        out.println("Telefono Organizacion");
        String telefono = in.readLine();
        out.println("Provincia cliente");
        String provincia = in.readLine();
        out.println("Canton cliente");
        String canton = in.readLine();
        out.println("Distrito cliente");
        String distrito = in.readLine();
        out.println("Direccion cliente");
        String direccion = in.readLine();

        capa.agregarPersonaCliente(iD, nombre, apellidos, telefono, provincia, canton, distrito, direccion);

    }

    public static void listarClientes() {
        for (String cliente : capa.getClientes()) {
            out.println(cliente);
        }
    }

    public static void crearCarroCompra() throws IOException {

        out.println("Digite ID de Cliente");
        String iD = in.readLine();
        Cliente cliente = capa.buscarCliente(iD);
        if (cliente == null) {
            out.println("El cliente no esta registrado, proceda a registrarlo");
            datosCliente();
        } else {
            CarroCompras carro = capa.inicializarCarro(cliente);
            int decisionFinal;
            do {
                out.println("MENU\n"
                        + "1.COMPRAR\n"
                        + "2. BUSCAR PRODUCTO");
                int opcion1 = Integer.parseInt(in.readLine());
                if (opcion1 == 1) {
                    opcionComprarCliente(cliente, carro);
                }
                if (opcion1 == 2) {
                    opcionBuscarProductoCliente(cliente, carro);
                }
                out.println("Desea realizar otra accion?\n"
                        + "1.Si\n"
                        + "2. No\n");
                decisionFinal = Integer.parseInt(in.readLine());
                if (decisionFinal == 1) {

                } else {

                    decisionFinal = -1;
                    cliente.crearPedido(carro);
                    out.println("Pedido realizado");
                }
            } while (decisionFinal > 0);
        }

    }

    public static void opcionComprarCliente(Cliente cliente, CarroCompras carro) throws IOException {

        for (Producto producto : capa.getProductos()) {
            out.println(producto.getCodigo() + producto.getDescripcion() + "\n");
        }
        out.println("Digite el codigo del producto que desea agregar al carro");
        int codigo = Integer.parseInt(in.readLine());
        Producto producto = capa.buscarProducto(codigo);
        if (producto == null) {
            out.println("Producto mal digitado o no existe");
        } else {

            int decisionFinal;
            do {

                out.println("1. Agregar Producto al Carro\n"
                        + "2. Ver informacion detallada del producto\n");
                int opcion = Integer.parseInt(in.readLine());
                if (opcion == 1) {
                    carro.agregarProducto(producto);

                }
                if (opcion == 2) {
                    out.println(producto.toString());
                    out.println("1.Agregar al carro\n"
                            + "2. No Agregar Al Carro\n");
                    int opcion1 = Integer.parseInt(in.readLine());
                    if (opcion1 == 1) {
                        carro.agregarProducto(producto);
                    }

                }
                out.println("Desea agregar otro producto?\n"
                        + "1.Si\n"
                        + "2. No\n");
                decisionFinal = Integer.parseInt(in.readLine());
                if (decisionFinal == 1) {

                } else {

                    decisionFinal = -1;
                }
            } while (decisionFinal > 0);

        }
        out.println(carro.toString());
    }

    public static void opcionBuscarProductoCliente(Cliente cliente, CarroCompras carro) throws IOException {

        int decision, decisionFinal;
        do {
            out.println("1. BUSCAR PRODUCTO POR NOMBRE \n"
                    + "2. BUSCAR PRODUCTO POR TIPO\n");
            decision = Integer.parseInt(in.readLine());
            if (decision == 1) {
                out.println("Digite nombre del producto que desea buscar");
                String nombre = in.readLine();
                Producto p = capa.buscarProductoPorNombre(nombre);
                if (p == null) {
                    out.println("Producto no existe o digito mal el nombre");
                } else {
                    out.println(p.toString());
                    out.println("Desea agregar el producto?"
                            + "1. Si\n"
                            + "2. No\n");
                    int opc = Integer.parseInt(in.readLine());
                    if (opc == 1) {
                        carro.agregarProducto(p);
                    }
                    if (opc == 2) {

                    }
                }

            }
            if (decision == 2) {
                out.println("Digite el tipo del producto que desea buscar");
                String tipo = in.readLine();
                Producto p = capa.buscarProductoPorTipo(tipo);
                if (p == null) {
                    out.println("Producto no existe o digito mal el tipo");
                } else {
                    out.println(p.toString());
                    out.println("Desea agregar el producto?"
                            + "1. Si\n"
                            + "2. No\n");
                    int opc = Integer.parseInt(in.readLine());
                    if (opc == 1) {
                        carro.agregarProducto(p);
                    }
                    if (opc == 2) {

                    }
                }

            }
            out.println("Desea buscar otro producto?\n"
                    + "1.Si\n"
                    + "2. No\n");
            decisionFinal = Integer.parseInt(in.readLine());
            if (decisionFinal == 1) {

            } else {

                decisionFinal = -1;
            }
        } while (decisionFinal > 0);
    }

    public static void verPedidos() throws IOException {
        out.println("1. Todos los Pedidos\n"
                + "2. Al Detalle");
        int decision = Integer.parseInt(in.readLine());
        if (decision == 1) {
            for (String carro : capa.getCarros()) {
                out.println(carro);
            }
        }
        if (decision == 2) {
            out.println("Digite ID cliente para ver sus pedidos");
            String iD = in.readLine();
            Cliente cliente = capa.buscarCliente(iD);
            if (cliente == null) {
                out.println("Cliente no existe o mal ingresado");
            } else {
                for (int i = 0; i < cliente.getListaPedidos().size(); i++) {
                    out.println(cliente.getListaPedidos().get(i)+"\n");
                }
            }

        }
    }

}
