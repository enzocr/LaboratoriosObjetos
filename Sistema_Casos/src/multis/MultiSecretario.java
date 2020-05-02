package multis;

import accesodatos.Conector;
import objetos.Secretario;

/**
 *
 * @author enzoq
 */
public class MultiSecretario {

    public Secretario crearSecretario() throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Secretario secretario = null;
        String query;
        query = "INSERT INTO Secretario "
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);
        query = "SELECT IDENT_CURRENT ('Secretario') AS nuevoNumero;";
//		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            secretario = new Secretario();
        } else {
            throw new java.sql.SQLException("Error en la Base de Datos.");
        }
        rs.close();
        return secretario;
    }

    public Secretario buscarSecretarioCedula(String cedula) throws java.sql.SQLException, Exception {
        Secretario secretario = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Secretario "
                + "WHERE cedula='" + cedula + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            secretario = new Secretario();
        } else {
            throw new Exception("El secretario no está registrado en el sistema.");
        }
        rs.close();
        return secretario;
    }

}
