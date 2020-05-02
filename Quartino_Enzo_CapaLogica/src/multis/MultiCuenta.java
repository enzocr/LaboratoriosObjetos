package multis;

import accesodatos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.Moneda;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class MultiCuenta {

    /**
     * Recibe atributos de Cuenta, la ingresa a la base de datos y devuelve
     * su instancia
     * @param numeroCuenta
     * @param cliente
     * @param moneda
     * @return objeto cuenta
     * @throws Exception
     */
    public Cuenta crearCuenta(String numeroCuenta, Cliente cliente, Moneda moneda)
            throws Exception {
        int saldo = 0;
        String query;
        Cuenta cuenta = null;
        ResultSet rs;
        query = "SELECT * From Cliente, Moneda "
                + "WHERE nombre_completo= '" + cliente.getNombreCompleto() + "'"
                + " and nombre_moneda= '" + moneda.getNombreMoneda() + "'";

        String query2;
        rs = Conector.getConector().ejecutarSQL(query, true);

        if (rs.next()) {
            query2 = "Insert into Cuenta(numero_cuenta, saldo, id_cliente, id_moneda)"
                    + "VALUES('" + numeroCuenta + "','" + saldo + "','" + rs.getString("id_cliente") + "','"
                    + rs.getString("id_moneda") + "')";
            cuenta = new Cuenta(numeroCuenta, saldo, cliente, moneda);
            Conector.getConector().ejecutarSQL(query2);
        }

        return cuenta;
    }

    /**
     * Busca el numero de cuenta recibido en la base de datos, si lo encuentra
     * devuelve la instancia de este, si no, un objeto vacio
     * @param numeroCuenta
     * @return objeto cuenta
     * @throws SQLException
     * @throws Exception
     */
    public Cuenta buscarCuenta(String numeroCuenta) throws SQLException, Exception {
        String query;
        Cuenta cuenta = null;
        Moneda moneda = null;
        Cliente cliente = null;
        ResultSet rs;
        query = "SELECT * "
                + "FROM Moneda as mo "
                + "INNER JOIN Cuenta as cu on cu.id_moneda = mo.id_moneda "
                + "INNER JOIN Cliente as cl on cu.id_cliente = cl.id_cliente "
                + " WHERE cu.numero_cuenta= '" + numeroCuenta + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

    
            if (rs.next()) {
                cliente = new Cliente(rs.getString("identificacion"), rs.getString("nombre_completo"),
                        rs.getString("nombre_usuario"), rs.getString("clave"));

                moneda = new Moneda(rs.getString("nombre_moneda"), rs.getInt("tipo_de_cambio"));

                cuenta = new Cuenta(rs.getString("numero_cuenta"), rs.getInt("saldo"), cliente, moneda);
                cuenta.setSaldo(rs.getInt("saldo"));
            }
            
        return cuenta;
    }

    /**
     * Recibe la cuenta en la que se hizo un deposito y se le actualiza
     * el saldo en la base de datos
     * @param cuenta
     * @throws Exception
     */
    public void actualizarCuentaDepositada(Cuenta cuenta) throws Exception  {
        String query;
        query = "UPDATE Cuenta "
                + "SET saldo += '" + cuenta.getSaldo() + "' "
                + "WHERE numero_cuenta = '" + cuenta.getNumeroCuenta() + "'";
        try {
            Conector.getConector().ejecutarSQL(query);
        } catch (Exception ex) {
            throw new Exception ("NO EXISTE ESTA CUENTA EN LA BASE DE DATOS");
        }
    }

    /**
     * Recibe la cuenta de la que se realizo un retiro y se le actualiza
     * el saldo en la base de datos
     * @param cuenta
     * @throws Exception
     */
    public void actualizarCuentaRetirada(Cuenta cuenta) throws Exception  {
        String query;
        query = "UPDATE Cuenta "
                + "SET saldo -= '" + cuenta.getSaldo() + "' "
                + "WHERE numero_cuenta = '" + cuenta.getNumeroCuenta() + "'";
        try {
            Conector.getConector().ejecutarSQL(query);
        } catch (Exception ex) {
             throw new Exception ("NO EXISTE ESTA CUENTA EN LA BASE DE DATOS");
        }
    }

    /**
     * Recibe un cliente y devuelve todas las cuentas que este cliente tiene,
     * si no tiene devuelve un ArrayList vacio
     * @param cliente
     * @return ArrayLis<Cuenta> listaCuentas
     * @throws Exception
     */
    public ArrayList<Cuenta> listarCuentas(Cliente cliente) throws Exception {
        String query;
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        Cuenta cuenta = null;
        Moneda moneda = null;
        ResultSet rs;

        query = "SELECT * FROM Cuenta "
                + "INNER JOIN Moneda on Moneda.id_moneda = Cuenta.id_moneda "
                + "INNER JOIN Cliente on Cliente.id_cliente = Cuenta.id_cliente "
                + "WHERE identificacion = '" + cliente.getIdentificacion() + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {

            moneda = new Moneda(rs.getString("nombre_moneda"), rs.getInt("tipo_de_cambio"));

            cuenta = new Cuenta(rs.getString("numero_cuenta"), rs.getInt("saldo"), cliente, moneda);
            cuenta.setSaldo(rs.getInt("saldo"));
            listaCuentas.add(cuenta);
        }
        rs.close();
        return listaCuentas;
    }

}
