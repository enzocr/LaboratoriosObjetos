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
public class MultiMedico {

    public void agregarCita(Paciente p, Medico m, String descripcion, String resultado, String numeroCita) throws Exception {
        Cita cita = null;
        LocalDate fecha = LocalDate.now();
        cita = (new MultiCita()).crear(fecha, p, m, descripcion, resultado, numeroCita);

        m.agregarCita(cita);
        p.getExpediente().getListaCitas().add(cita);
    }

    public Medico registrarMedico(String codigo, String especialidad, String nombre_completo,
            String identificacion, String telefono, String email, String clave) throws ClassNotFoundException, SQLException {
        Medico elMedico;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_registrar_persona_medico] '" + nombre_completo + "','"
                + identificacion + "','"
                + telefono + "','"
                + email + "','"
                + clave + "','"
                + codigo + "','"
                + especialidad + "'";

        String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            elMedico = new Medico(codigo, especialidad, nombre_completo,
                    identificacion, telefono, email, clave);
        } catch (SQLException ex) {
            throw ex;
        }
        return elMedico;
    }

    public Medico buscarMedicoIdentificacion(String pidentificacion) throws
            java.sql.SQLException, Exception {
        Medico medico = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

     //   query = "[dbo].[buscar_medico]'" + pidentificacion + "'";
     query="SELECT medico.codigo, medico.especialidad, persona.nombre_completo, persona.identificacion,"
             + " persona.telefono, persona.email, persona.clave "
             + "FROM Persona as as persona "
             + "INNER JOIN Medico as medico "
             + "ON medico.id_persona = persona.id_persona "
             + "WHERE persona.identificacion ='"+pidentificacion+"'";
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

                medico = new Medico(rs.getString("codigo"),
                        rs.getString("especialidad"),
                        rs.getString("nombre_completo"),
                        rs.getString("identificacion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("clave")
                );

            }
        } catch (Exception e) {
            throw e;
        }

        rs.close();
        return medico;

    }

    public Medico buscarClaveMedico(String clave) throws
            java.sql.SQLException, Exception {
        Medico claveMedico = null;

        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

        query = "[dbo].[buscar_clave_medico]'" + clave + "'";
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
                claveMedico = new Medico(rs.getString("codigo"),
                        rs.getString("especialidad"),
                        rs.getString("nombre_completo"),
                        rs.getString("identificacion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("clave"));
            }
            return claveMedico;
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Medico> getMedicos() throws ClassNotFoundException, SQLException {
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        Medico medico = null;
        java.sql.ResultSet rs;
        String query;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;

       // query = "[dbo].[medicos_registrados]()";
       query = "SELECT  codigo, especialidad, nombre_completo, identificacion, telefono, email, clave/n"
               + "From Medico";
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
                medico = new Medico(rs.getString("codigo"),
                        rs.getString("especialidad"),
                        rs.getString("nombre_completo"),
                        rs.getString("identificacion"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("clave"));
                listaMedicos.add(medico);
            }
            return listaMedicos;
        } catch (Exception e) {
            throw e;
        }

    }

}
