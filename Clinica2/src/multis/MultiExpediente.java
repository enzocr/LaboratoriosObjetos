/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Cita;
import objetos.Expediente;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class MultiExpediente {

    protected ArrayList<String> expedientes;

    /**
     *
     * @param pnumeroExpediente
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public String buscarExpediente(String pnumeroExpediente) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;

        String expObjeto = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[buscar_expediente]'" + pnumeroExpediente + "'";
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
                Object objeto = rs.getObject(i);
                expObjeto = String.valueOf(objeto);
                if (isNullLista() == false) {
                    expedientes.add(expObjeto);
                }
                rs.close();
            }
            return expObjeto;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isNullLista() {
        if (this.expedientes == null) {
            this.expedientes = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    public void agregarPadecimientoAexpediente(Padecimiento p, Expediente e) throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            throw ex;
        }
        Connection conn = null;
        Statement stmt = null;
        String query;

        query = "[dbo].[pa_agregar_padecimiento_a_expediente]  '" + p.getIdentificacion() + "','"
                + e.getNumeroExpediente() + "'";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=Clinica2;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);

        } catch (SQLException ex) {
            throw ex;
        }

    }

    public ArrayList<String> getExpedientes() {
        return expedientes;
    }

}
