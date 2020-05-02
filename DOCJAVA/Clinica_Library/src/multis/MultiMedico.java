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
import objetos.Medico;
import objetos.Persona;

/**
 *
 * @author enzoq
 */
public class MultiMedico {

    public Medico registrarMedico(String codigo, String nombre, String email,
            String especialidad, String telefono, String cedula) throws ClassNotFoundException, SQLException {
        Medico elMedico;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_registrar_persona_medico] '" + cedula + "','"
                + nombre + "','"
                + telefono + "','"
                + codigo + "','"
                + especialidad + "','"
                + email + "'";

        String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            elMedico = new Medico(codigo, nombre, email, especialidad, telefono, cedula);
        } catch (SQLException ex) {
            throw ex;
        }
        return elMedico;
    }

    public Persona buscar(String pidentificacion) throws
            java.sql.SQLException, Exception {
        Persona persona = null;

        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        /*
        query = "SELECT persona.identificacion, persona.nombre_completo, persona.telefono,"
                + "paciente.direccion, paciente.correo "
                + "FROM Persona as persona"
                + "INNER JOIN Paciente as paciente"
                + "ON persona.id_persona = paciente.id_persona "
                + "WHERE persona.identificacion='" + pidentificacion + "';";*/

        query = "[dbo].[m]'" + pidentificacion + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            throw ex;
        }
        try {
            if (rs.next()) {
                persona = new Persona(rs.getString("nombre_completo"),
                        rs.getString("identificacion"),
                        rs.getString("telefono"));

            }
        } catch (Exception e) {
            throw e;
        }

        rs.close();
        return persona;

    }

}
