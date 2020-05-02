package objetos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Expediente {

    protected int iD;
    protected LocalDate fechaNacimiento;
    protected String tipoSangre;
    protected ArrayList<Padecimiento> listaPadecimientos;
    protected Cita cita;

    public Expediente(int iD, LocalDate fechaNacimiento, String tipoSangre, Cita cita) {
        this.iD = iD;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.cita = cita;

    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
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

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
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

        query = "UPDATE Expediente "
                + "SET id_padecimiento=" + p.getiD() + ", "
                + "WHERE identificacion='" + e.getiD() + "';";
        try {
            String connectionUrl = "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);

        } catch (SQLException ex) {
            throw ex;
        }

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

    public String getPadecimientosExp() {
        String p = "";
        if (isNullLista() == false) {

            for (Padecimiento pad : listaPadecimientos) {
                p += pad.toString() + "  \n ";

            }
        }

        return p;

    }

    @Override
    public String toString() {
        return "Expediente{"
                + "iD=" + iD
                + ", fechaNacimiento=" + fechaNacimiento
                + ", tipoSangre=" + tipoSangre
                + ", cita=" + cita
                + getPadecimientosExp()
                + '}';
    }

}
