/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class MultiPadecimiento {

    public Padecimiento crear(String identificacion, String nombre, String descripcion) throws ClassNotFoundException, SQLException {
        Padecimiento padecimiento;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_registrar_padecimiento] '" + identificacion + "','"
                + nombre + "','"
                + descripcion + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            padecimiento = new Padecimiento(identificacion, nombre, descripcion);

        } catch (SQLException ex) {
            throw ex;
        }
        return padecimiento;
    }

    public Padecimiento buscarPadecimiento(String pidentificacion) throws
            java.sql.SQLException, Exception {
        Padecimiento padecimiento = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[buscar_padecimiento]'" + pidentificacion + "';";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            throw ex;
        }
        try {
            if (rs.next()) {
                padecimiento = new Padecimiento(rs.getString("identificacion"),
                        rs.getString("nombre"), rs.getString("descripcion"));
                rs.close();
            }
            return padecimiento;
        } catch (Exception e) {
            throw e;
        }
    }

    public Padecimiento buscarPadecimientoNombre(String nombre) throws
            java.sql.SQLException, Exception {
        Padecimiento padecimiento = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[buscar_padecimiento_nombre]'" + nombre + "';";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            throw ex;
        }
        try {
            if (rs.next()) {

                padecimiento = new Padecimiento(rs.getString("identificacion"), rs.getString("nombre"),
                        rs.getString("descripcion"));
                rs.close();
            }
            return padecimiento;
        } catch (Exception e) {
            throw e;
        }
    }

}
