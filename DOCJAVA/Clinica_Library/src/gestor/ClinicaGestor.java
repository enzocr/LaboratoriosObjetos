package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.Clinica;

/**
 *
 * @author enzoq
 */
public class ClinicaGestor {

    public ClinicaGestor() {
    }

    public void agregarClinica(String nombre, String iD, String direccion, String telefono) throws SQLException, ClassNotFoundException {
        Clinica clinic = new Clinica();
        clinic.setDireccionClinica(direccion);
        clinic.setNombre(nombre);
        clinic.setTelefono(telefono);
        clinic.setiD(iD);

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
        query = "INSERT INTO Paciente(direccion, identificacion, nombre_completo, telefono, correo) VALUES('"
                + clinic.getDireccionClinica() + "','"
                + clinic.getNombre() + "','"
                + clinic.getTelefono()
                + "')";
        stmt = conn.createStatement();
        stmt.execute(query);

    }

}
