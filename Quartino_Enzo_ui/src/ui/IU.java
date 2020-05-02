package ui;

import objetos.Movimiento;
import objetos.Moneda;
import objetos.Cuenta;
import objetos.Cliente;
import gestor.Gestor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    //se crean instancias estaticas que seran usadas por los metodos
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor gestor = new Gestor();

    /**
     * Main de la aplicacion
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            int opc;
            do {
                mostrarMenu();
                opc = leerOpcion();
                ejecutarAccion(opc);
            } while (opc != 3);

        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    /**
     * Imprime menu de la aplicacion
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1. INICIAR SESION");
        out.println("2. REGISTRARSE");
        out.println("3. SALIR");
        out.println("");

    }

    /**
     * Metodo estatico que devuelve la accion escogida por el usuario
     *
     * @return opcion
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     * Recibe como parametro la opcion digitada por el usuario y la ejecuta en
     * un switch
     *
     * @param pOpcion
     * @throws Exception
     */
    public static void ejecutarAccion(int pOpcion) throws Exception {

        switch (pOpcion) {

            case 1:
                sesionIniciada();
                break;
            case 2:
                datosCliente();
                break;
            case 3:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    /**
     * Metodo que le permite al usuario iniciar sesion y desglosa opciones para
     * realizar
     *
     * @throws Exception
     */
    public static void sesionIniciada() throws Exception {
        out.println("Digite nombre de usuario");
        int accion;
        String usuario = in.readLine();
        Cliente clienteUsuario = gestor.buscarClienteUsuario(usuario);
        if (clienteUsuario != null) {
            do {
                out.println("Digite clave");
                String clave = in.readLine();
                if (clienteUsuario.getClave().equals(clave)) {
                    listarCuentasPersonales(clienteUsuario);
                    out.println("1. CREAR CUENTA\n"
                            + "2. REALIZAR DEPOSITO\n"
                            + "3. REALIZAR TRANSACCION\n"
                            + "4. VER DETALLE MOVIMIENTO DE CUENTA\n");

                    int decision = Integer.parseInt(in.readLine());
                    if (decision == 1) {
                        listarMonedas();
                        out.println("De cual moneda desea que sea la cuenta? \n"
                                + "Por favor ingresar las iniciales de la moneda");
                        String nombreMoneda = in.readLine();
                        Moneda moneda = gestor.buscarMoneda(nombreMoneda);
                        if (moneda != null) {
                            datosCuenta(clienteUsuario, moneda);
                        }

                    }
                    if (decision == 2) {
                        out.println("Digite el numero de cuenta a la cual desea depositar");
                        String numeroCuenta = in.readLine();
                        Cuenta cuenta = gestor.buscarCuenta(numeroCuenta);
                        if (cuenta != null) {

                            realizarDeposito(cuenta);
                            out.println("ACTUALIZACION CUENTAS PROPIAS");
                            listarCuentasPersonales(clienteUsuario);

                        }
                    }

                    if (decision == 3) {
                        int decisionTransaccion;
                        out.println("1. TRANSACCION A UNA CUENTA PROPIA\n"
                                + "2. TRANSACCION A TERCEROS\n");
                        decisionTransaccion = Integer.parseInt(in.readLine());

                        if (decisionTransaccion == 1) {
                            out.println("Digite numero de cuenta de la cual desea retirar dinero para la "
                                    + "transaccion");
                            String numeroCuentaEmisora = in.readLine();
                            Cuenta cuentaEmisora = gestor.buscarCuenta(numeroCuentaEmisora);
                            if (cuentaEmisora != null) {
                                out.println("Digite numero de cuenta a la cual desea trasladarle dinero");
                                String numeroCuentaReceptora = in.readLine();
                                Cuenta cuentaReceptora = gestor.buscarCuenta(numeroCuentaReceptora);
                                if (cuentaReceptora != null) {
                                    int monto;
                                    out.println("Digite monto a depositar");
                                    monto = Integer.parseInt(in.readLine());

                                    realizarTransferenciaRetiro(cuentaEmisora, cuentaReceptora, monto);
                                    realizarTransferenciaDeposito(cuentaReceptora, cuentaEmisora, monto);
                                    out.println("ACTUALIZACION CUENTAS PROPIAS");
                                    listarCuentasPersonales(clienteUsuario);

                                }
                            }
                        }

                        if (decisionTransaccion == 2) {
                            int decisionAjena;
                            out.println("1. AGREGAR CUENTA FAVORITA\n"
                                    + "2. DEPOSITAR CUENTA AJENA\n");
                            decisionAjena = Integer.parseInt(in.readLine());

                            if (decisionAjena == 1) {
                                listarClientes();
                                out.println("Digite numero de identificacion del dueño de las cuentas "
                                        + "que va a agregar");
                                String identificacionAjena = in.readLine();
                                Cliente clienteAjeno = gestor.buscarClienteIdentificacion(identificacionAjena);
                                if (clienteAjeno != null) {
                                    for (Cuenta ajena : listarCuentasPersonales(clienteAjeno)) {
                                        gestor.registrarCuentaFavorita(clienteUsuario, ajena);
                                    }

                                    out.println("CUENTAS AGREGADAS A FAVORITAS");
                                }
                            }

                            if (decisionAjena == 2) {
                                out.println("Digite numero de cuenta ajena a la que desea depositar");

                                String numeroCuentaAjena = in.readLine();
                                Cuenta cuentaAjena = gestor.buscarCuentaFavorita(clienteUsuario, numeroCuentaAjena);
                                if (cuentaAjena != null) {
                                    out.println("Cual cuenta personal va a usar? ");
                                    String numCuentaPersonal = in.readLine();
                                    Cuenta cuentaPersonal = gestor.buscarCuenta(numCuentaPersonal);
                                    if (cuentaPersonal != null) {
                                        int monto;

                                        out.println("Digite monto a depositar");
                                        monto = Integer.parseInt(in.readLine());

                                        realizarTransferenciaDeposito(cuentaAjena, cuentaPersonal, monto);
                                        realizarTransferenciaRetiro(cuentaPersonal, cuentaAjena, monto);
                                        out.println("ACTUALIZACION CUENTAS PROPIAS");
                                        listarCuentasPersonales(clienteUsuario);

                                        out.println("TRANSFERENCIA REALIZADA");
                                    }

                                }

                            }
                        }

                    }
                    if (decision == 4) {
                        out.println("Digite el numero de cuenta para ver movimiento");
                        String numeroCuentaMovimiento = in.readLine();
                        Cuenta cuentaMovimiento = gestor.buscarCuenta(numeroCuentaMovimiento);
                        if (cuentaMovimiento != null) {
                            out.println("Movimientos de la cuenta: " + cuentaMovimiento.getNumeroCuenta());
                            movimientoCuenta(cuentaMovimiento);
                        }
                    }
                } else {
                    out.println("CLAVE INCORRECTA");
                }
                out.println("Desea realizar otra accion? SI(1) NO (2)");
                accion = Integer.parseInt(in.readLine());
            } while (accion != 2);
        }

    }

    /**
     * Recibe cuenta a ser consultada por movimientos Metodo estatico que
     * devuelve los movimientos de una cuenta
     *
     * @param cuenta
     * @throws Exception
     */
    public static void movimientoCuenta(Cuenta cuenta) throws Exception {
        ArrayList<Movimiento> lista;
        lista = gestor.listarMovimientoCuenta(cuenta);
        for (Movimiento m : lista) {
            out.println(m.toString());
        }

    }

    /**
     * Registra un cliente y lo devuelve
     *
     * @return Objeto cliente
     * @throws Exception
     */
    public static Cliente datosCliente() throws Exception {
        Cliente cliente = null;

        String identificacion, nombreCompleto, nombreUsuario, clave;
        out.println("Ingrese identificacion");
        identificacion = in.readLine();
        Cliente clienteID = gestor.buscarClienteIdentificacion(identificacion);
        if (clienteID == null) {
            out.println("Ingrese nombre y apellidos");
            nombreCompleto = in.readLine();
            out.println("Digite su nombre de usuario");
            nombreUsuario = in.readLine();
            out.println("Ingrese clave");
            clave = in.readLine();
            cliente = gestor.registrarCliente(identificacion, nombreCompleto, nombreUsuario, clave);
        } else {
            throw new Exception("CLIENTE YA REGISTRADO");
        }

        return cliente;
    }

    /**
     * Registra una cuenta y la devuelve
     *
     * @param cliente
     * @param moneda
     * @return objeto cuenta
     * @throws Exception
     */
    public static Cuenta datosCuenta(Cliente cliente, Moneda moneda) throws Exception {
        String numeroCuenta;
        Cuenta cuenta = null;
        out.println("Ingresar numero a nueva cuenta");
        numeroCuenta = in.readLine();
        Cuenta nueva = gestor.buscarCuenta(numeroCuenta);
        if (nueva == null) {
            cuenta = gestor.crearCuenta(numeroCuenta, cliente, moneda);
            realizarDeposito(cuenta);
            out.println("CUENTA CREADA");
        } else {
            throw new Exception("CUENTA CON ESE NUMERO YA EXISTE");
        }

        return cuenta;
    }

    /**
     * Recibe cuenta a la cual se desea hacer un deposito
     *
     * @param cuenta
     * @return Movimiento deposito
     * @throws Exception
     */
    public static Movimiento realizarDeposito(Cuenta cuenta) throws Exception {
        Movimiento deposito = null;
        int monto;
        out.println("Digite monto a depositar");
        monto = Integer.parseInt(in.readLine());
        deposito = gestor.registrarDeposito(monto, cuenta);

        return deposito;
    }

    /**
     * Recibe cuenta a la que se le hace el deposito y de la cual se hizo un
     * retiro Recibe monto a ser depositado y retirado
     *
     * @param cuentaReceptora
     * @param cuentaEmisora
     * @param monto
     * @return Movimiento deposito
     * @throws Exception
     */
    public static Movimiento realizarTransferenciaDeposito(Cuenta cuentaReceptora, Cuenta cuentaEmisora, int monto)
            throws Exception {

        Movimiento deposito;
        deposito = gestor.registrarTransferenciaDeposito(cuentaEmisora, cuentaReceptora, monto);
        return deposito;

    }

    /**
     * Recibe cuenta a la que se le hace el deposito y de la cual se hizo un
     * retiro Recibe monto a ser depositado y retirado
     *
     * @param cuentaEmisora
     * @param cuentaReceptora
     * @param monto
     * @return Movimiento retiro
     * @throws Exception
     */
    public static Movimiento realizarTransferenciaRetiro(Cuenta cuentaEmisora, Cuenta cuentaReceptora, int monto)
            throws Exception {
        Movimiento retiro;
        retiro = gestor.registrarTransferenciaRetiro(cuentaEmisora, monto);
        return retiro;
    }

    /**
     * Recibe cliente del cual se quiere saber las cuentas personales y devuelve
     * e imprime dichas cuentas
     *
     * @param cliente
     * @return ArrayList <Cuenta> lista
     * @throws Exception
     */
    public static ArrayList<Cuenta> listarCuentasPersonales(Cliente cliente) throws Exception {
        ArrayList<Cuenta> lista;
        try {
            lista = gestor.listarCuentas(cliente);
        } catch (Exception ex) {
            throw ex;
        }

        for (Cuenta cuenta : lista) {
            out.println("Numero Cuenta: " + cuenta.getNumeroCuenta() + " Tipo Moneda: " + cuenta.getMoneda().getNombreMoneda()
                    + " Saldo: " + cuenta.getSaldo());
        }
        return lista;
    }

    /**
     * Recibe cliente del cual se quiere saber las cuentas personales y devuelve
     * e imprime dichas cuentas
     *
     * @param cliente
     * @return ArrayList <Cuenta> lista
     * @throws Exception
     */
    public static ArrayList<Cliente> listarClientes() throws Exception {
        ArrayList<Cliente> lista;
        try {
            lista = gestor.listarClientes();
        } catch (Exception ex) {
            throw ex;
        }

        for (Cliente cliente : lista) {
            out.println("Identificacion Cliente: " + cliente.getIdentificacion());
        }
        return lista;
    }

    /**
     * Lista monedas registradas en la base de datos
     *
     * @throws Exception
     */
    public static void listarMonedas() throws Exception {
        ArrayList<Moneda> lista;
        try {
            lista = gestor.listarMonedas();
        } catch (Exception ex) {
            throw ex;
        }
        for (Moneda moneda : lista) {
            out.println(moneda.toString());
        }
    }

}
