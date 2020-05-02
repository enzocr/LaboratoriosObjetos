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
public class MultiCliente {

    /**
     * Recibe atributos del Cliente, los ingresa a la base de datos y devuelve
     * la instancia de este
     *
     * @param identificacion
     * @param nombreCompleto
     * @param nombreUsuario
     * @param clave
     * @return objeto cliente
     * @throws Exception
     */
    public Cliente crearCliente(String identificacion, String nombreCompleto, String nombreUsuario, String clave)
            throws Exception {
        String query;
        Cliente cliente = null;
        query = "INSERT INTO Cliente(identificacion, nombre_completo, nombre_usuario, clave)"
                + " VALUES('" + identificacion + "','" + nombreCompleto + "','" + nombreUsuario + "','" + clave + "')";
        try {
            Conector.getConector().ejecutarSQL(query);

            cliente = new Cliente(identificacion, nombreCompleto, nombreUsuario, clave);

        } catch (Exception e) {
            throw e;

        }

        return cliente;
    }

    /**
     * Recibe un nombre de usuario, lo busca en la base de datos y devuelve su
     * instancia o un objeto vacio si no lo encuentra
     *
     * @param usuario
     * @return objeto cliente
     * @throws SQLException
     * @throws Exception
     */
    public Cliente buscarClienteUsuario(String usuario) throws SQLException, Exception {
        String query;
        Cliente cliente = null;;
        ResultSet rs;
        query = "SELECT * FROM Cliente WHERE nombre_usuario= '" + usuario + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                cliente = new Cliente(rs.getString("identificacion"), rs.getString("nombre_completo"),
                        rs.getString("nombre_usuario"), rs.getString("clave"));

            }
        } catch (SQLException ex) {
            throw ex;
        }
        return cliente;
    }

    /**
     * Recibe una identificacion de un cliente, lo busca en la base de datos,
     * devuelve su instancia si lo encuentra, si no devuelve un objeto vacio
     *
     * @param identificacion
     * @return objeto cliente
     * @throws SQLException
     * @throws Exception
     */
    public Cliente buscarClienteIdentificacion(String identificacion) throws SQLException, Exception {
        String query;
        Cliente cliente = null;;
        ResultSet rs;
        query = "SELECT * FROM Cliente WHERE identificacion= '" + identificacion + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        if (rs.next()) {
            cliente = new Cliente(rs.getString("identificacion"), rs.getString("nombre_completo"),
                    rs.getString("nombre_usuario"), rs.getString("clave"));
        }

        return cliente;
    }

    /**
     * Recibe cliente que quiere agregar la cuenta recibida y la agrega a la
     * lista de favoritas
     *
     * @param cliente
     * @param cuenta
     * @return objeto cuenta
     * @throws Exception
     */
    public Cuenta agregarCuentaFavorita(Cliente cliente, Cuenta cuenta) throws Exception {
        String query;
        ResultSet rs;
        Cuenta cuentaFavorita = null;
        query
                = "SELECT * FROM Cliente, Cuenta "
                + " WHERE identificacion= '" + cliente.getIdentificacion() + "' and numero_cuenta= '" + cuenta.getNumeroCuenta() + "'";
        String query2;

        rs = Conector.getConector().ejecutarSQL(query, true);

        if (rs.next()) {
            query2 = "Insert into Favoritas(id_cliente, id_cuenta)"
                    + "VALUES('" + rs.getInt("id_cliente") + "','" + rs.getInt("id_cuenta") + "')";
            cliente.agregarCuentaAListaFavoritas(cuentaFavorita);
            Conector.getConector().ejecutarSQL(query2);
        }
        return cuentaFavorita;
    }

    /**
     * Busca el numero de cuenta recibido como parametro, lo busca en la lista
     * de cuentas favoritas si lo encuentra devuelve la instancia de la cuenta y
     * si no, devuelve un objeto vacio
     *
     * @param cliente
     * @param numeroCuenta
     * @return objeto cuenta
     * @throws SQLException
     * @throws Exception
     */
    public Cuenta buscarCuentaFavorita(Cliente cliente, String numeroCuenta) throws SQLException, Exception {
        String query;
        Cuenta cuenta = null;
        Moneda moneda = null;

        ResultSet rs;

        query = "SELECT * "
                + " FROM Favoritas"
                + " INNER JOIN Cuenta ON Cuenta.id_cuenta = Favoritas.id_cuenta"
                + " INNER JOIN Moneda ON Moneda.id_moneda = Cuenta.id_moneda "
                + " INNER JOIN Cliente ON Cliente.id_cliente = Favoritas.id_cliente "
                + " WHERE Cuenta.numero_cuenta = '" + numeroCuenta + "'"
                + " and Cliente.identificacion= '" + cliente.getIdentificacion() + "' ";

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
        } else {
            throw new Exception("CUENTA NO REGISTRADA EN FAVORITAS");
        }

        return cuenta;
    }

    /**
     * Devuelve todos los clientes registrados en la base de datos
     * @return AttayList<Cliente> listaClientes
     * @throws Exception
     */
    public ArrayList<Cliente> listarClientes() throws Exception {
        String query;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente = null;
        ResultSet rs;
        

        query = "SELECT * FROM Cliente ";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {

            cliente = new Cliente(rs.getString("identificacion"), rs.getString("nombre_completo"),
            rs.getString("nombre_usuario"), rs.getString("clave"));
            listaClientes.add(cliente);
        }
        rs.close();
        return listaClientes;
    }

}
