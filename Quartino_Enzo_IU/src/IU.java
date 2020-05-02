
import capaLogica.Logica;
import capaLogica.Pedido;
import capaLogica.Persona;
import capaLogica.Producto;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Logica capa = new Logica();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 9);
    }

    /**
     * muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Registrar Proveedores");
        out.println("2.  Listar Proveedores");
        out.println("3.  Registrar Informacion del Producto");
        out.println("4.  Registrar Cliente");
        out.println("5.  Listar Clientes");

        out.println();
    }

    /**
     * La opcion escogida por el cliente es parseada y se retorna
     *
     * @return la opcion escogida por el cliente o administrador
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     *
     * @param pOpcion recibe opcion digitada por el usuario y la usa en el
     * switch
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                registrarProveedores();

                break;

            case 2:
                listarProveedores();

                break;

            case 3:
                registrarInfoProducto();

                break;
            case 4:
                registrarCliente();
                break;

            case 5:
                listarClientes();
                break;

            case 6:
                //crearCarroCompras();
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

    /**
     *Registra proveedor, enviando los datos agregados por un usuario a un 
     * metodo de la cap logica 
     *  
     * @throws IOException
     */
    public static void registrarProveedores() throws IOException {
        int decisionP;
        out.println("Desea registrar una Organizacion(1) o una Persona Fisica(2)?");
        decisionP = Integer.parseInt(in.readLine());
        if (decisionP == 1) {

            String nombre;
            String direccion, telefono, cedula, nombreRep, apRep, dirRep, telRep, idRep;

            out.println("Digite la cedula juridica de la organizaion");
            cedula = in.readLine();

            Persona laPersona;
            laPersona = capa.buscarProveedor(cedula);

            if (laPersona == null) {

                out.println("Digite el nombre de la Organizacion");
                nombre = in.readLine();
                out.println("Digite la direccion de la Organizacion");
                direccion = in.readLine();
                out.println("Digite el telefono de la Organizacion");
                telefono = in.readLine();
                out.println("Digite el nombre del representante");
                nombreRep = in.readLine();
                out.println("Digite los apellidos del representante");
                apRep = in.readLine();
                out.println("Digite la direccion del representante");
                dirRep = in.readLine();
                out.println("Digite el telefono del representante");
                telRep = in.readLine();
                out.println("Digite la identificacion del representante");
                idRep = in.readLine();

                capa.agregarProveedorOrganizacion(nombre, direccion, telefono, cedula, nombreRep, apRep, dirRep, telRep, idRep);
            } else {
                out.println("YA ESTA REGISTRADOA");
            }

        }
        if (decisionP == 2) {

            String nombre, apellidos, direccion, telefono, cedula;
            out.println("Digite la cedula de identificacion de la Persona");
            cedula = in.readLine();

            Persona laPersona2;
            laPersona2 = capa.buscarProveedor(cedula);

            if (laPersona2 == null) {
                out.println("Digite el nombre de la Persona");
                nombre = in.readLine();
                out.println("Digite los apellidos de la Persona");
                apellidos = in.readLine();
                out.println("Digite la direccion de la Persona");
                direccion = in.readLine();
                out.println("Digite el telefono de la Persona");
                telefono = in.readLine();

                capa.agregarProveedorPersonaFisica(nombre, apellidos, direccion, telefono, cedula);

            } else {
                out.println("YA ESTA REGISTRADA");
            }

        }

    }

    /**
     *Lista los proveedores registrados en el sistema
     */
    public static void listarProveedores() {

        for (String proveedor : capa.getProveedores()) {
            out.println(proveedor);
        }

    }

    /**
     *Registra los productor ingresados en el sistema por el proveedor y se envian
     * por parametro a un metodo en la capa logica
     * @throws IOException
     */
    public static void registrarInfoProducto() throws IOException {

        String descripcion;
        int notOrganic, organic, codigo;
        String tipo, nombre;

        out.println("Ingrese el codigo del producto");
        codigo = Integer.parseInt(in.readLine());
        Producto elProducto = capa.buscarProducto(codigo);

        if (elProducto == null) {
            out.println("Digite el nombre del producto");
            nombre = in.readLine();
            out.println("Ingrese la descripcion del producto");
            descripcion = in.readLine();
            out.println("Digite el precio del producto organico");
            organic = Integer.parseInt(in.readLine());
            out.println("Digite el preico del producto no organico");
            notOrganic = Integer.parseInt(in.readLine());
            out.println("Ingrese si es fruta o verdura");
            tipo = in.readLine();
            capa.agregarProducto(codigo, descripcion, organic, notOrganic, tipo, nombre);

        } else {
            out.println("Ya esta registrado este producto");
        }

    }

    /**
     *Registra los clientes ingresados en el sistema y se envian
     * por parametro a un metodo en la capa logica
     * @throws IOException
     */
    public static void registrarCliente() throws IOException {
        String provincia, canton, distrito, direccionExacta, correo, nombre, apellidos, direccion, telefono, iD;

        out.println("Digite la cedula de identificacion del cliente");
        iD = in.readLine();
        Persona miPersona = capa.buscarCliente(iD);
        if (miPersona == null) {

            out.println("Digite la provincia en la que vive el cliente");
            provincia = in.readLine();
            out.println("Digite el canton  en el que vive el cliente");
            canton = in.readLine();
            out.println("Digite el distrito en la que vive el cliente");
            distrito = in.readLine();
            out.println("Direccion exacta  en la que vive el cliente");
            direccionExacta = in.readLine();
            out.println("Digite el correo electronico del cliente");
            correo = in.readLine();
            out.println(" Digite el nombre del cliente");
            nombre = in.readLine();
            out.println("Digite los apellidos del cliente");
            apellidos = in.readLine();
            out.println("Digite la direccion del cliente");
            direccion = in.readLine();
            out.println("Digite el telefono del cliente");
            telefono = in.readLine();

            capa.agregarCliente(provincia, canton, distrito, direccionExacta, correo, nombre, apellidos, direccion, telefono, iD);

        } else {
            out.println("Cliente ya esta registrado");
        }

    }

    /**
     *Lista los clientes registrados en el sistema
     */
    public static void listarClientes() {

        for (String cliente : capa.getClientes()) {
            out.println(cliente);
        }

    }
    
    
    public static void crearCarroCompras() throws IOException {
        String iD;
        out.println("Ingrese el iD del cliente");
        iD = in.readLine();

        Persona c = capa.buscarCliente(iD);
        if (c == null) {
            out.println("Estimado usuario no esta registrado en el Sistema");

        } else {
            int decision;
            out.println("COMPRAR (1) BUSCAR PRODUCTO POR NOMBRE Y TIPO (2)");
            decision = Integer.parseInt(in.readLine());
            LocalDate fecha;
            fecha = LocalDate.now();
            Pedido pd = capa.inicializarPedido(fecha);
            Producto p;
            if (decision == 1) {
                for (String producto : capa.getProductos()) {
                    out.println(producto);
                  
                }
                
                int decision1;
                int salir = 1;

                do {
                    out.println("Digitar el nombre del producto del cual desea ver la informacion(1)\n"
                            + "Digitar el nombre del producto que desea agregar al carro(2)");
                    decision1 = Integer.parseInt(in.readLine());

                    if (decision1 == 1) {
                        String nombre;
                        out.println("Digite el nombre del producto que desea ver la informacion");
                        nombre = in.readLine();
                        p = capa.buscarProductoNombre(nombre);
                        if (p == null) {
                            out.println("Producto no existe");

                        } else {
                            out.println(p.toString());
                            out.println("Desea agregar este producto? Si(1) No(2)");
                            int choice = Integer.parseInt(in.readLine());
                            if (choice == 1) {

                                pd.agregarProducto(p);

                            }

                        }
                        out.println("Desea agregar otro producto? Si(1) No(2)");
                        salir = Integer.parseInt(in.readLine());

                    }
                    if (decision1 == 2) {
                        String nombre;

                        out.println("Digite el nombre del producto que desea ingresar al carro de compras");
                        nombre = in.readLine();
                         p = capa.buscarProductoNombre(nombre);
                        if (p == null) {
                            out.println("Producto no existe");

                        } else {

                        }
                        out.println("Desea agregar otro producto? Si(1) No(2)");
                        salir = Integer.parseInt(in.readLine());

                    }

                } while (salir != 2);
            }

            if (decision == 2) {
                int buscar;
                out.println("Buscar Producto por NOMBRE(1) o TIPO(2)");
                buscar = Integer.parseInt(in.readLine());

                if (buscar == 1) {

                    out.println("Digite el nombre del producto que desea buscar");
                    String nombre = in.readLine();
                     p = capa.buscarProductoNombre(nombre);
                    if (p == null) {
                        out.println("Producto no existe");
                    } else {
                        out.println(p.getNombre());
                        int decision2;
                        int salir = 1;

                        do {
                            out.println("Digitar el nombre del producto del cual desea ver la informacion(1)\n"
                                    + "Digitar el nombre del producto que desea agregar al carro(2)");
                            decision2 = Integer.parseInt(in.readLine());

                            if (decision2 == 1) {
                                String nombre0;
                                out.println("Digite el nombre del producto que desea ver la informacion");
                                nombre0 = in.readLine();
                                Producto p0 = capa.buscarProductoNombre(nombre0);
                                if (p0 == null) {
                                    out.println("Producto no existe");

                                } else {
                                    out.println(p0.toString());
                                    out.println("Desea agregar este producto? Si(1) No(2)");
                                    int choice = Integer.parseInt(in.readLine());
                                    if (choice == 1) {

                                    }

                                }
                                out.println("Desea agregar otro producto? Si(1) No(2)");
                                salir = Integer.parseInt(in.readLine());

                            }
                            if (decision2 == 2) {
                                String nombre1;

                                out.println("Digite el nombre del producto que desea ingresar al carro de compras");
                                nombre1 = in.readLine();
                                Producto p1 = capa.buscarProductoNombre(nombre1);
                                if (p1 == null) {
                                    out.println("Producto no existe");

                                } else {

                                }
                                out.println("Desea agregar otro producto? Si(1) No(2)");
                                salir = Integer.parseInt(in.readLine());

                            }

                        } while (salir != 2);
                    }

                }
                if (buscar == 2) {
                    out.println("Digite el tipo de produco que desea buscar");
                    String tipo = in.readLine();
                    
                            p = capa.buscarProductoTipo(tipo);
                    if (p == null) {
                        out.println("Producto no existe");
                    } else {
                        out.println(p.getNombre());
                        int decision3;
                        int salir3 = 1;

                        do {
                            out.println("Digitar el nombre del producto del cual desea ver la informacion(1)\n"
                                    + "Digitar el nombre del producto que desea agregar al carro(2)");
                            decision3 = Integer.parseInt(in.readLine());

                            if (decision3 == 1) {
                                String nombre2;
                                out.println("Digite el nombre del producto que desea ver la informacion");
                                nombre2 = in.readLine();
                                Producto p2 = capa.buscarProductoNombre(nombre2);
                                if (p2 == null) {
                                    out.println("Producto no existe");

                                } else {
                                    out.println(p.toString());
                                    out.println("Desea agregar este producto? Si(1) No(2)");
                                    int choice = Integer.parseInt(in.readLine());
                                    if (choice == 1) {

                                    }

                                }
                                out.println("Desea agregar otro producto? Si(1) No(2)");
                                salir3 = Integer.parseInt(in.readLine());

                            }
                            if (decision3 == 2) {
                                String nombre3;
                                out.println("Digite el nombre del producto que desea ingresar al carro de compras");
                                nombre3 = in.readLine();
                                Producto p3 = capa.buscarProductoNombre(nombre3);
                                if (p3 == null) {
                                    out.println("Producto no existe");

                                } else {

                                }
                                out.println("Desea agregar otro producto? Si(1) No(2)");
                                salir3 = Integer.parseInt(in.readLine());

                            }

                        } while (salir3 != 2);

                    }

                }

            }

        }

    }


}
