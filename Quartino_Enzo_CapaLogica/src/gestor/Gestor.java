package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import multis.*;
import objetos.*;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Gestor {

    /**
     * Recibe atributos del Cliente, lo crea y lo devuelve
     *
     * @param identificacion
     * @param nombreCompleto
     * @param nombreUsuario
     * @param clave
     * @return objeto cliente
     * @throws Exception
     */
    public Cliente registrarCliente(String identificacion, String nombreCompleto, String nombreUsuario, String clave)
            throws Exception {
        Cliente cliente = null;
        try {
            cliente = new MultiCliente().crearCliente(identificacion, nombreCompleto, nombreUsuario, clave);
        } catch (Exception ex) {
            throw ex;
        }
        return cliente;
    }

    /**
     * Recibe nombre del usuario del cliente, lo busca y lo devuelve o devuelve
     * objeto vacio
     *
     * @param usuario
     * @return objeto cliente
     * @throws Exception
     */
    public Cliente buscarClienteUsuario(String usuario) throws Exception {
        Cliente cliente = null;
        try {
            cliente = (new MultiCliente()).buscarClienteUsuario(usuario);
        } catch (Exception ex) {
            throw ex;
        }
        return cliente;
    }

    public Cliente buscarClienteIdentificacion(String identificacion) throws Exception {
        Cliente cliente = null;
        try {
            cliente = (new MultiCliente()).buscarClienteIdentificacion(identificacion);
        } catch (Exception ex) {
            throw ex;
        }
        return cliente;

    }

    /**
     * Recibe nombre de la moneda, la busca y lo devuelve o devuelve objeto
     * vacio
     *
     * @param nombreMoneda
     * @return objeto moneda
     * @throws Exception
     */
    public Moneda buscarMoneda(String nombreMoneda) throws Exception {
        Moneda moneda = null;
        try {
            moneda = (new MultiMoneda()).buscarMoneda(nombreMoneda);
        } catch (Exception ex) {
            throw ex;
        }
        return moneda;
    }

    /**
     * Devuelve monedas registradas en la base de datos
     *
     * @return lista
     * @throws Exception
     */
    public ArrayList<Moneda> listarMonedas() throws Exception {
        ArrayList<Moneda> lista;
        try {
            lista = (new MultiMoneda()).listarMonedas();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

    /**
     * Recibe atributos de una cuenta, la crea y devuelve
     *
     * @param numeroCuenta
     * @param cliente
     * @param moneda
     * @return objeto cuenta
     * @throws Exception
     */
    public Cuenta crearCuenta(String numeroCuenta, Cliente cliente, Moneda moneda) throws Exception {

        Cuenta cuenta = null;
        try {
            cuenta = (new MultiCuenta()).crearCuenta(numeroCuenta, cliente, moneda);
        } catch (Exception ex) {
            throw ex;
        }
        return cuenta;

    }

    /**
     * Recibe nombre de una cuenta, la busca y la devuelve o devuelve objeto
     * vacio
     *
     * @param numeroCuenta
     * @return objeto cuenta
     * @throws Exception
     */
    public Cuenta buscarCuenta(String numeroCuenta) throws Exception {
        Cuenta cuenta = null;
        try {
            cuenta = (new MultiCuenta()).buscarCuenta(numeroCuenta);
        } catch (Exception ex) {
            throw ex;
        }
        return cuenta;

    }

    /**
     * Recibe numero de cuenta que se desea buscar en la lista de favoritas si
     * la encuentra la devuelve o devuelve un objeto vacio
     *
     * @param cliente
     * @param numeroCuenta
     * @return cuenta
     * @throws Exception
     */
    public Cuenta buscarCuentaFavorita(Cliente cliente, String numeroCuenta) throws Exception {
        Cuenta cuenta = null;
        try {
            cuenta = (new MultiCliente()).buscarCuentaFavorita(cliente, numeroCuenta);
        } catch (Exception ex) {
            throw ex;
        }
        return cuenta;

    }

    /**
     * Recibe cliente del cual se desea saber las cuentas Devuelve un ArrayList
     * que contiene cuentas de Cliente especifico
     *
     * @param cliente
     * @return ArrayList lista
     * @throws Exception
     */
    public ArrayList<Cuenta> listarCuentas(Cliente cliente) throws Exception {
        ArrayList<Cuenta> lista;
        try {
            lista = new MultiCuenta().listarCuentas(cliente);
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

    public ArrayList<Cliente> listarClientes() throws Exception {
        ArrayList<Cliente> lista;
        try {
            lista = new MultiCliente().listarClientes();
        } catch (Exception ex) {
            throw ex;
        }
        return lista;
    }

    /**
     * Recibe cuenta a buscar movimientos Devuelve ArrayList de los movimientos
     * de una cuenta especifica
     *
     * @param cuenta
     * @return ArrayList lista
     * @throws Exception
     */
    public ArrayList<Movimiento> listarMovimientoCuenta(Cuenta cuenta) throws Exception {
        ArrayList<Movimiento> lista;
        lista = new MultiMovimiento().listarMovimientoCuenta(cuenta);
        return lista;
    }

    /**
     * Recibe atributos de un deposito a una cuenta, lo crea y lo devuelve
     *
     * @param monto
     * @param cuenta
     * @return Movimiento deposito
     * @throws Exception
     */
    public Movimiento registrarDeposito(int monto, Cuenta cuenta) throws Exception {
        Movimiento deposito = null;
        LocalDate fecha = LocalDate.now();
        String tipoTransferencia = "Deposito";

        try {
            actualizarCuentaDepositada(cuenta, monto);
            deposito = (new MultiMovimiento()).crearDeposito(tipoTransferencia, monto, fecha, cuenta);

        } catch (Exception ex) {
            throw ex;
        }

        return deposito;
    }

    /**
     * Recibe atributos de una cuenta destino y una cuenta origen y crea el
     * deposito, y lo devuelve
     *
     * @param cuentaEmisora
     * @param cuentaReceptora
     * @param monto
     * @return Movimiento deposito
     * @throws Exception
     */
    public Movimiento registrarTransferenciaDeposito(Cuenta cuentaEmisora, Cuenta cuentaReceptora, int monto) throws Exception {
        Movimiento deposito = null;
        double montoReal;
        LocalDate fecha = LocalDate.now();
        String tipoTransferencia = "Deposito";

        montoReal = calcularCambioMoneda(monto, cuentaEmisora.getMoneda().getNombreMoneda(),
                cuentaReceptora.getMoneda().getNombreMoneda());

        deposito = new MultiMovimiento().crearTransferenciaDeposito(tipoTransferencia, (int) montoReal,
                fecha, cuentaReceptora);

        actualizarCuentaDepositada(cuentaReceptora, (int) montoReal);

        return deposito;
    }

    /**
     * Recibe atributos de una cuenta destino y una cuenta origen y crea el
     * retiro, y lo devuelve
     *
     * @param cuentaEmisora
     * @param cuentaReceptora
     * @param monto
     * @return Movimiento retiro
     * @throws Exception
     */
    public Movimiento registrarTransferenciaRetiro(Cuenta cuentaEmisora, int monto) throws Exception {
        Movimiento retiro = null;
        LocalDate fecha = LocalDate.now();
        String tipoTransferencia = "Retiro";

        retiro = new MultiMovimiento().crearTransferenciaRetiro(tipoTransferencia, monto,
                fecha, cuentaEmisora);

        actualizarCuentaRetirada(cuentaEmisora, monto);

        return retiro;
    }

    /**
     * Recibe cuenta que recibe el deposito y actualiza su 
     *
     * @param cuentaReceptora
     * @param monto
     * @throws Exception
     */
    public void actualizarCuentaDepositada(Cuenta cuentaReceptora, int monto) throws Exception {
        cuentaReceptora.setSaldo(monto);
        new MultiCuenta().actualizarCuentaDepositada(cuentaReceptora);

    }

    /**
     * Recibe cuenta que realizo retiro y actualiza su saldo
     *
     * @param cuentaEmisora
     * @param monto
     * @throws Exception
     */
    public void actualizarCuentaRetirada(Cuenta cuentaEmisora, int monto) throws Exception {
        cuentaEmisora.setSaldo(monto);
        new MultiCuenta().actualizarCuentaRetirada(cuentaEmisora);
    }

    /**
     * Recibe Moneda de la cuenta destino, cuenta origen y monto
     * depositado/retirado Calcula monto Real haciendo el cambio de moneda y lo
     * devuelve
     *
     * @param monto
     * @param monE
     * @param monR
     * @return entero montoReal
     */
    public double calcularCambioMoneda(int monto, String monE, String monR) {
        double montoReal;
        if ((monE.equals("USD")) && (monR.equals("CRC"))) {
            montoReal = monto * 585;
            return montoReal;
        }
        if ((monE.equals("CRC")) && (monR.equals("USD"))) {
            montoReal = monto / 585;
            return montoReal;
        }
        if ((monE.equals("USD")) && (monR.equals("EUR"))) {
            montoReal = monto * 585 / 720;
            return montoReal;
        }
        if ((monE.equals("EUR")) && (monR.equals("USD"))) {
            montoReal = monto * 585 / 720;
            return montoReal;
        }
        if ((monE.equals("EUR")) && (monR.equals("CRC"))) {
            montoReal = monto * 720;
            return montoReal;
        }
        if ((monE.equals("CRC")) && (monR.equals("EUR"))) {
            montoReal = monto / 720;
            return montoReal;
        }
        if ((monE.equals("YEN")) && (monR.equals("CRC"))) {
            montoReal = monto * 820;
            return montoReal;
        }
        if ((monE.equals("CRC")) && (monR.equals("YEN"))) {
            montoReal = monto / 820;
            return montoReal;
        }
        if ((monE.equals("YEN")) && (monR.equals("USD"))) {
            montoReal = monto * 820 / 585;
            return montoReal;
        }
        if ((monE.equals("USD")) && (monR.equals("YEN"))) {
            montoReal = monto * 585 / 820;
            return montoReal;
        }
        if ((monE.equals("YEN")) && (monR.equals("EUR"))) {
            montoReal = monto * 820 / 720;
            return montoReal;
        }
        if ((monE.equals("EUR")) && (monR.equals("YEN"))) {
            montoReal = monto * 720 / 820;
            return montoReal;
        }
        if ((monE.equals(monR))) {
            montoReal = monto;
            return montoReal;
        } else {
            return 0;
        }

    }

    /**
     * Recibe cliente y cuenta ajena que el cliente quiere agregar a su lista de
     * cuentas favoritas devuelve objeto Favorita
     *
     * @param cliente
     * @param cuentaReceptora
     * @return objeto favorita
     * @throws Exception
     */
    public Cuenta registrarCuentaFavorita(Cliente cliente, Cuenta cuentaReceptora) throws Exception {
        Cuenta cuentaFavorita = null;

        try {
            cuentaFavorita = new MultiCliente().agregarCuentaFavorita(cliente, cuentaReceptora);
        } catch (Exception ex) {
            throw ex;
        }
        return cuentaFavorita;
    }

}
