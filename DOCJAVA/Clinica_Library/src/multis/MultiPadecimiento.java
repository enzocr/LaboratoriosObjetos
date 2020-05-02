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
import objetos.Expediente;
import objetos.Paciente;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class MultiPadecimiento {

    public Padecimiento crear(String iD, String nombre, String descripcion) throws ClassNotFoundException, SQLException {
        Padecimiento padecimiento;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_registrar_padecimiento] '" + iD + "','"
                + nombre + "','"
                + descripcion + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            padecimiento = new Padecimiento(iD, nombre, descripcion);

        } catch (SQLException ex) {
            throw ex;
        }
        return padecimiento;
    }
}
