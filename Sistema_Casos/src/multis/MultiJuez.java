package multis;

import accesodatos.Conector;
import java.time.LocalDate;
import objetos.Caso;
import objetos.Historial;
import objetos.Juez;

/**
 *
 * @author enzoq
 */
public class MultiJuez {

    public Juez crearJuez(String sala, String clave, String nombreUsuario, String cedula, String primerNombre,
            String segundoNombre, String primerApellido, String segundoApellido, String telefono) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Juez juez = null;
        String query;
        query = "INSERT INTO Historial "
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);
        query = "SELECT IDENT_CURRENT ('Querellante') AS nuevoNumero;";
//		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            juez = new Juez();
        } else {
            throw new java.sql.SQLException("Error en la Base de Datos.");
        }
        rs.close();
        return juez;
    }

    public Juez buscarJuezUsuario(String nombreUsuario) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Juez juez = null;
        String query;
        query = "INSERT INTO Juez"
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);
        query = "SELECT IDENT_CURRENT ('Juez') AS nuevoNumero;";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            juez = new Juez();
        } else {
            throw new java.sql.SQLException("Error en la Base de Datos.");
        }
        rs.close();
        return juez;
    }

    public Juez buscarJuezClave(String clave) throws java.sql.SQLException, Exception {
        Juez juez = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Juez "
                + "WHERE cedula='" + clave + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            juez = new Juez();
        } else {
            throw new Exception("El Juez no está registrado en el sistema.");
        }
        rs.close();
        return juez;
    }

}
