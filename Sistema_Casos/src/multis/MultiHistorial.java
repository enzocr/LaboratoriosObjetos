package multis;

import accesodatos.Conector;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Caso;
import objetos.Historial;

/**
 *
 * @author enzoq
 */
public class MultiHistorial {

    public Historial crearHistorial(LocalDate fecha, String estado, Caso caso) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Historial historial = null;
        String query;
        query = "INSERT INTO Historial "
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);
        query = "SELECT IDENT_CURRENT ('Querellante') AS nuevoNumero;";
//		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            historial = new Historial();
        } else {
            throw new java.sql.SQLException("Error en la Base de Datos.");
        }
        rs.close();
        return historial;
    }

    public Historial buscarHistorial(int numeroCaso) throws java.sql.SQLException, Exception {
        Historial historial = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Historial "
                + "WHERE numeroCaso='" + numeroCaso + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            historial = new Historial();
        } else {
            throw new Exception("El Historial no está registrado en el sistema.");
        }
        rs.close();
        return historial;
    }

    public ArrayList<Historial> buscarHistorialCaso(int numeroCaso) throws java.sql.SQLException, Exception {
        ArrayList<Historial> historialCasos = new ArrayList<>();
        Historial historial = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Caso "
                + "WHERE numeroCaso='" + numeroCaso + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        while (rs.next()) {
            historial = new Historial();
            historialCasos.add(historial);
        }

        rs.close();
        return historialCasos;
    }

}
