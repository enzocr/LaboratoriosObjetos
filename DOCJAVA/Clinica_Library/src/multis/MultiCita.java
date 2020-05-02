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
import java.time.LocalDate;
import java.util.Date;
import objetos.Cita;
import objetos.Medico;
import objetos.Paciente;

/**
 *
 * @author enzoq
 */
public class MultiCita {

    public Cita crear(LocalDate fecha, Paciente p, Medico m, String descripcion, String resultado)
            throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Cita cita = null;//returna

        int numeroCita = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            throw ex;
        }

        query = "[dbo].[pa_registrar_cita] '" + fecha + "','"
                + p.getiD() + "','"
                + m.getiD() + "','"
                + descripcion + "','"
                + resultado + "'";

        stmt = conn.createStatement();
        stmt.execute(query);
        rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            numeroCita = rs.getInt("id_cita");
            cita = new Cita(fecha, p, m, descripcion, resultado, numeroCita);
        } else {
            throw new java.sql.SQLException("Error en la BD.");
        }
        rs.close();

        return cita;
    }

}
