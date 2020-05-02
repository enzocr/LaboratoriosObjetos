/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author enzoq
 */
public class Expediente {

    protected LocalDate fechaNacimiento;
    protected String tipoSangre;
    protected String numeroExpediente;
    protected ArrayList<Padecimiento> listaPadecimientos;
    protected ArrayList<Cita> listaCitas;

    public Expediente() {

    }

    public Expediente(LocalDate fechaNacimiento, String tipoSangre, String numeroExpediente) {
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public ArrayList<Padecimiento> getListaPadecimientos() {
        return listaPadecimientos;
    }

    public void setListaPadecimientos(ArrayList<Padecimiento> listaPadecimientos) {
        this.listaPadecimientos = listaPadecimientos;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    @Override
    public String toString() {
        return "Expediente{" + "fechaNacimiento=" + fechaNacimiento + ", tipoSangre=" + tipoSangre + ", numeroExpediente=" + numeroExpediente + ", listaPadecimientos=" + listaPadecimientos + '}';
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

    public void agregarPadecimientoExpediente(Padecimiento p) {
        if (isNullLista() == false) {
            listaPadecimientos.add(p);
        }
    }

    public boolean isNullLista() {
        if (this.listaPadecimientos == null) {
            this.listaPadecimientos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
