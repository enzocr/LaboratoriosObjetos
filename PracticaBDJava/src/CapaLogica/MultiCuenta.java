package CapaLogica;

import java.sql.*;
import java.util.Date;
import java.util.Vector;
import CapaAccesoBD.Conector;

public class MultiCuenta {

    public Cuenta crear(String pnumero, String pdescripcion, String pfechaVencimiento,
            double pmonto, String pidCliente) throws
            java.sql.SQLException, Exception {
        Cuenta cuenta = null;
        String sql;
        double saldo = pmonto;
        sql = "INSERT INTO TCuenta "
                + "VALUES ('" + pnumero + "','" + pdescripcion + "','" 
                + pfechaVencimiento + "'," + pmonto + "," + saldo + ",'" + pidCliente + "');";
        try {
            Conector.getConector().ejecutarSQL(sql);
           
            cuenta = new Cuenta(pnumero, pdescripcion, pfechaVencimiento, pmonto, saldo, pidCliente);
        } catch (Exception e) {
            throw new Exception("El número de cuenta ya está en el sistema.");
        }
        return cuenta;
    }

    public Cuenta buscar(String pnumero) throws
            java.sql.SQLException, Exception {
        Cuenta cuenta = null;
        java.sql.ResultSet rs;
        String sql;
        sql = "SELECT numero,descripcion,fechaVencimiento,monto,saldo,idCliente "
                + "FROM TCuenta "
                + "WHERE numero='" + pnumero + "';";
        rs = Conector.getConector().ejecutarSQL(sql, true);
        if (rs.next()) {
            cuenta = new Cuenta(
                    rs.getString("numero"),
                    rs.getString("descripcion"),
                    rs.getString("fechaVencimiento"),
                    rs.getDouble("monto"),
                    rs.getDouble("saldo"),
                    rs.getString("idCliente"));
        } else {
            throw new Exception("La cuenta no está registrada.");
        }
        rs.close();
        return cuenta;
    }

    public Vector buscarPorCliente(String pidCliente) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        String sql;
        Cuenta cuenta = null;
        Vector cuentas = null;
        sql = "SELECT * "
                + "FROM TCuenta "
                + "WHERE idCliente='" + pidCliente + "';";
        Conector.getConector().ejecutarSQL(sql);
        rs = Conector.getConector().ejecutarSQL(sql, true);
        cuentas = new Vector();
        while (rs.next()) {
            cuenta = new Cuenta(
                    rs.getString("numero"),
                    rs.getString("descripcion"),
                    rs.getString("fechaVencimiento"),
                    rs.getDouble("monto"),
                    rs.getDouble("saldo"),
                    rs.getString("idCliente"));
            cuentas.add(cuenta);
        }
        rs.close();
        return cuentas;
    }

    public void actualizar(Cuenta pcuenta) throws
            java.sql.SQLException, Exception {
        String sql;
        sql = "UPDATE TCuenta "
                + "SET saldo=" + pcuenta.getSaldo() + ", "
                + "descripcion='" + pcuenta.getDescripcion() + "', "
                + "fechaVencimiento='" + pcuenta.getFechaVencimiento() + "' "
                + "WHERE numero='" + pcuenta.getNumero() + "';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception e) {
            throw new Exception("La cuenta no está registrada.");
        }
    }

    public void borrar(Cuenta pcuenta) throws
            java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        String sql;
        sql = "DELETE FROM TCuenta "
                + "WHERE numero='" + pcuenta.getNumero() + "';";
        try {
            Conector.getConector().ejecutarSQL(sql);
        } catch (Exception e) {
            throw new Exception("La cuenta tiene abonos.");
        }
    }
}
