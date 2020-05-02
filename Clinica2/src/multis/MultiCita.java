/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import objetos.Cita;
import objetos.Medico;
import objetos.Paciente;

/**
 *
 * @author enzoq
 */
public class MultiCita {

    public Cita crear(LocalDate fecha, Paciente p, Medico m, String descripcion, String resultado, String numeroCita)
            throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Cita cita = null;//

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;
        String query2;

        query = "[dbo].[pa_registrar_cita] '" + fecha + "','"
                + p.getIdentificacion() + "','"
                + m.getIdentificacion() + "','"
                + descripcion + "','"
                + resultado + "'";

        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            cita = new Cita(fecha, p, m, descripcion, resultado, numeroCita);
        } catch (SQLException ex) {
            throw ex;
        }
        query2 = "[dbo].[pa_agregar_cita_a_expediente] '" + cita.getNumeroCuenta() + "','"
                + p.getIdentificacion()+ "'";

        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query2);

        } catch (SQLException ex) {
            throw ex;
        }

        return cita;
    }

    public String buscarCitaNumero(String numCita) throws
            java.sql.SQLException, Exception {
        String citaObjeto=null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[pa_buscar_cita]'" + numCita + "'";
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
                int i = 1;
                Object pacienteObjeo = rs.getObject(i);
                citaObjeto = String.valueOf(pacienteObjeo);

                rs.close();
            }
            return citaObjeto;
        } catch (Exception e) {
            throw e;
        }
    }

}
