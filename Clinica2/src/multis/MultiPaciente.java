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
import java.util.ArrayList;
import objetos.*;

/**
 *
 * @author enzoq
 */
public class MultiPaciente {

    protected ArrayList<Paciente> listaPacientes;

    public Paciente crear(String nombre, String telefono, String identificacion, String email, String clave,
            String direccion, LocalDate fechaNacimiento, String tipoSangre, String numeroExpediente) throws SQLException, ClassNotFoundException, Exception {
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

        query = "[dbo].[pa_registrar_persona_paciente] '" + nombre + "','"
                + identificacion + "','"
                + telefono + "','"
                + email + "','"
                + clave + "','"
                + direccion + "','"
                + fechaNacimiento + "','"
                + tipoSangre + "','"
                + numeroExpediente + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);

            expediente = new Expediente(fechaNacimiento, tipoSangre, numeroExpediente);

            elPaciente = new Paciente(direccion, expediente, nombre, identificacion, telefono, email, clave);

        } catch (SQLException ex) {
            throw ex;
        }
        return elPaciente;
    }

    public Paciente buscarPaciente(String pidentificacion) throws Exception {
        Paciente paciente = null;
        Expediente expediente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "SELECT persona.nombre_completo, persona.identificacion, persona.telefono, "
                + "persona.email, persona.clave, paciente.direccion, expediente.tipo_sangre, "
                + "expediente.fecha_nacimiento, expediente.numero_expediente "
                + "FROM Persona as persona "
                + " INNER JOIN Paciente as paciente "
                + "      ON persona.id_persona = paciente.id_persona"
                + " INNER JOIN Expediente as expediente "
                + " ON expediente.id_paciente = paciente.id_paciente "
                +  "WHERE persona.identificacion ='"+pidentificacion+"'";
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
                expediente = new Expediente(
                        LocalDate.now(), rs.getString("tipo_sangre"),
                        rs.getString("numero_expediente"));
                paciente = new Paciente(rs.getString("direccion"), expediente, rs.getString("nombre_completo"),
                        rs.getString("identificacion"), rs.getString("telefono"), rs.getString("email"),
                        rs.getString("clave"));
            }
            return paciente;
        } catch (Exception e) {
            throw e;
        }
    }

    public Paciente buscarPacienteNombre(String nombre) throws
            java.sql.SQLException, Exception {
        Paciente paciente = null;
        Expediente expediente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[buscar_paciente_nombre]'" + nombre + "'";
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
                expediente = new Expediente(
                        LocalDate.now(), rs.getString("tipo_sangre"),
                        rs.getString("numero_expediente"));
                paciente = new Paciente(rs.getString("direccion"), expediente, rs.getString("nombre_completo"),
                        rs.getString("identificacion"), rs.getString("telefono"), rs.getString("email"), rs.getString("clave"));
            }
            return paciente;
        } catch (Exception e) {
            throw e;
        }

    }

    public Paciente buscarPacienteClave(String clave) throws
            java.sql.SQLException, Exception {
        Paciente paciente = null;
        Expediente expediente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[buscar_clave_paciente]'" + clave + "'";
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
                expediente = new Expediente(
                        LocalDate.now(), rs.getString("tipo_sangre"),
                        rs.getString("numero_expediente"));
                paciente = new Paciente(rs.getString("direccion"), expediente, rs.getString("nombre_completo"),
                        rs.getString("identificacion"), rs.getString("telefono"), rs.getString("email"), rs.getString("clave"));
            }
            return paciente;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<Paciente> getPacientes() throws
            java.sql.SQLException, Exception {

        Paciente paciente = null;
        Expediente expediente = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[pacientes_registrados]";
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
                expediente = new Expediente(
                        LocalDate.now(), rs.getString("tipo_sangre"),
                        rs.getString("numero_expediente"));
                paciente = new Paciente(rs.getString("direccion"), expediente, rs.getString("nombre_completo"),
                        rs.getString("identificacion"), rs.getString("telefono"), rs.getString("email"), rs.getString("clave"));
                if (isNullLista() == false) {
                    listaPacientes.add(paciente);
                }
            }
            return listaPacientes;
        } catch (Exception e) {
            throw e;
        }

    }

    public boolean isNullLista() {
        if (listaPacientes == null) {
            listaPacientes = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
