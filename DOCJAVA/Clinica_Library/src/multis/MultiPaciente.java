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
import objetos.Expediente;
import objetos.Paciente;
import objetos.Persona;

/**
 *
 * @author enzoq
 */
public class MultiPaciente {

    public Paciente crear(String cedula, String nombre, String direccion, String email, String telefono,
            String clave, int idExp, String tipoSangre, LocalDate fechaNac, Cita cita) throws SQLException, ClassNotFoundException, Exception {
        Paciente elPaciente = null;
        Expediente expediente = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_registrar_persona_paciente] '" + direccion + "','"
                + email + "','"
                + cedula + "','"
                + nombre + "','"
                + telefono + "','"
                + fechaNac + "','"
                + tipoSangre + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);

            expediente = new Expediente(idExp, fechaNac, tipoSangre, cita);

            elPaciente = new Paciente(cedula, nombre, direccion, email, telefono, clave, expediente);

        } catch (SQLException ex) {
            throw ex;
        }
        return elPaciente;
    }

    public String buscarPaciente(String pidentificacion) throws
            java.sql.SQLException, Exception {
        String pacienteObjeto = null;
        Persona persona = null;
        Paciente paciente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "SELECT nombre_completo, identificacion, telefono "
                + "FROM Persona "
                + "WHERE identificacion='" + pidentificacion + "';";
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
                int i = 1;
                Object pacienteObjeo = rs.getObject(i);
                pacienteObjeto = String.valueOf(pacienteObjeo);

                rs.close();
            }
            return pacienteObjeto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Persona buscarPacienteCorreo(String pcorreo) throws
            java.sql.SQLException, Exception {

        Persona persona = null;
        Paciente paciente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "SELECT * "
                + "FROM Paciente "
                + "WHERE correo='" + pcorreo + "';";
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
                int i = 1;
                Object pacienteObjeto = rs.getObject(i);
                paciente = (Paciente) pacienteObjeto;
                rs.close();
            }
            return paciente;
        } catch (Exception e) {
            throw e;
        }

    }

}
