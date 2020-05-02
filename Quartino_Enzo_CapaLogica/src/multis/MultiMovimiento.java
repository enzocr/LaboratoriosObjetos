package multis;

import accesodatos.Conector;
import java.sql.ResultSet;
import java.time.LocalDate;
import objetos.Cuenta;
import objetos.Moneda;
import objetos.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class MultiMovimiento {

    /**
     * Recibe atributos del Movimiento, los registra en la base de datos y
     * devuelve el movimiento
     *
     * @param tipoTransferencia
     * @param monto
     * @param fecha
     * @param cuenta
     * @return Movimiento deposito
     * @throws Exception
     */
    public Movimiento crearDeposito(String tipoTransferencia, int monto, LocalDate fecha, Cuenta cuenta) throws Exception {
        String query, query2;
        Movimiento deposito = null;
        Moneda moneda;
        ResultSet rs;
        String sql;
        query = "SELECT * "
                + "FROM Cuenta, Moneda "
                + "WHERE numero_cuenta=  '" + cuenta.getNumeroCuenta()
                + "' and nombre_moneda= '" + cuenta.getMoneda()
                        .getNombreMoneda() + "' ";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            query2 = "INSERT INTO Movimiento(tipo_de_transferencia, monto, fecha, id_moneda, id_cuenta) "
                    + "VALUES('" + tipoTransferencia + "','" + monto + "','" + fecha + "',"
                    + "'" + rs.getInt("id_moneda") + "','" + rs.getInt("id_cuenta") + "')";

            moneda = new Moneda(rs.getString("nombre_moneda"), rs.getInt("tipo_de_cambio"));

            deposito = new Movimiento(tipoTransferencia, monto, fecha, moneda, cuenta);
            sql = "SELECT max(id_movimiento) AS codigo from Movimiento;";

            rs = Conector.getConector().ejecutarSQL(sql, true);
            if (rs.next()) {
                deposito.setCodigo(rs.getInt("codigo"));
            }
            Conector.getConector().ejecutarSQL(query2);
        }

        return deposito;

    }

    /**
     * Recibe atributos del Movimiento, los registra en la base de datos y
     * devuelve el movimiento
     *
     * @param tipoTransferencia
     * @param monto
     * @param fecha
     * @param cuentaReceptora
     * @return Movimiento transferencia
     * @throws Exception
     */
    public Movimiento crearTransferenciaDeposito(String tipoTransferencia, int monto, LocalDate fecha,
            Cuenta cuentaReceptora)
            throws Exception {
        String query, query2;
        Movimiento transferencia = null;

        ResultSet rs;
        query = "SELECT * "
                + "FROM Cuenta as cu "
                + "INNER JOIN Moneda as mo ON mo.tipo_de_cambio = '" + cuentaReceptora.getMoneda().getTipoCambio() + "' "
                + "INNER JOIN Movimiento as mv  ON mv.id_cuenta = cu.id_cuenta "
                + "WHERE cu.numero_cuenta=  '" + cuentaReceptora.getNumeroCuenta() + "'  ";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            query2 = "INSERT INTO Movimiento(tipo_de_transferencia, monto, fecha, id_moneda, id_cuenta)"
                    + "VALUES('" + tipoTransferencia + "','" + monto + "','" + fecha + "',"
                    + "'" + rs.getInt("id_moneda") + "','" + rs.getInt("id_cuenta") + "')";

            transferencia = new Movimiento(tipoTransferencia, monto, fecha, cuentaReceptora.getMoneda(), cuentaReceptora);
            transferencia.setCodigo(rs.getInt("id_movimiento"));

            Conector.getConector().ejecutarSQL(query2);

        } else {
            throw new Exception("NO SE PUDO REALIZAR EL DEPOSITO");
        }

        return transferencia;

    }

    /**
     * Recibe atributos del Movimiento, los registra en la base de datos y
     * devuelve el movimiento
     *
     * @param tipoTransferencia
     * @param monto
     * @param fecha
     * @param cuentaEmisora
     * @return Movimiento transferencia
     * @throws Exception
     */
    public Movimiento crearTransferenciaRetiro(String tipoTransferencia, int monto, LocalDate fecha,
            Cuenta cuentaEmisora)
            throws Exception {
        String query, query2;
        Movimiento transferencia = null;

        ResultSet rs;
        query = "SELECT * "
                + "FROM Cuenta as cu "
                + "INNER JOIN Moneda as mo ON mo.tipo_de_cambio = '" + cuentaEmisora.getMoneda().getTipoCambio() + "' "
                + "INNER JOIN Movimiento as mv  ON mv.id_cuenta = cu.id_cuenta "
                + "WHERE cu.numero_cuenta=  '" + cuentaEmisora.getNumeroCuenta() + "'  ";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            query2 = "INSERT INTO Movimiento(tipo_de_transferencia, monto, fecha, id_moneda, id_cuenta)"
                    + "VALUES('" + tipoTransferencia + "','" + monto + "','" + fecha + "',"
                    + "'" + rs.getInt("id_moneda") + "','" + rs.getInt("id_cuenta") + "')";

            transferencia = new Movimiento(tipoTransferencia, monto, fecha, cuentaEmisora.getMoneda(), cuentaEmisora);
            transferencia.setCodigo(rs.getInt("id_movimiento"));

            Conector.getConector().ejecutarSQL(query2);

        } else {
            throw new Exception("NO SE PUDO REALIZAR EL RETIRO");
        }

        return transferencia;

    }

    /**
     * Devuelve un ArrayList de los movimientos, de la cuenta recibida como
     * parametro, en la base de datos
     *
     * @param cuenta
     * @return ArrayList <Movimiento> lista
     * @throws Exception
     */
    public ArrayList<Movimiento> listarMovimientoCuenta(Cuenta cuenta) throws Exception {
        String query;
        ArrayList<Movimiento> lista = new ArrayList<>();
        Movimiento movimiento = null;
        ResultSet rs;
//        query = "SELECT * "
//                + "FROM Moneda as mo "
//                + "INNER JOIN Cuenta as cu on cu.id_moneda = mo.id_moneda "
//                + "INNER JOIN Cliente as cl on cu.id_cliente = cl.id_cliente "
//                + " INNER JOIN Movimiento as mov on cu.id_cuenta = mov.id_cuenta"
//                + " WHERE cu.numero_cuenta= '" + cuenta.getNumeroCuenta() + "'";
        query = "SELECT *  FROM Movimiento as m"
                + " INNER JOIN Cuenta as cu ON cu.id_cuenta = m.id_cuenta"
                + " WHERE numero_cuenta= '" + cuenta.getNumeroCuenta() + "'  ";
        rs = Conector.getConector().ejecutarSQL(query, true);

        while (rs.next()) {
            movimiento = new Movimiento(rs.getString("tipo_de_transferencia"), rs.getInt("monto"),
                    LocalDate.now(), cuenta.getMoneda(), cuenta);

            movimiento.setCodigo(rs.getInt("id_movimiento"));

            lista.add(movimiento);
        }
        return lista;

    }

}
