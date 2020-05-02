
import java.sql.*;

public class JDBCExample {

    public static void main(String args[]) {
        try {
            sqlServer();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void sqlServer() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            /* ESTA ES LA LINEA DE CÓDIGO PARA CUANDO SE USA AUTENTICACIÓN INTEGRADA (FAVOR VER NOTAS AL INICIO) 
            COMO SE VE SOLO BASTA CON EL NOMBRE DE LA BASE DE DATOS Y AGREGAR EL SIGUIENTE
            PARÁMETRO AL FINAL integratedsecurity = true*/
            String connectionUrl = "jdbc:sqlserver://;DatabaseName=dbAmigos;integratedsecurity = true";

            conn = DriverManager.getConnection(connectionUrl);

            Conector.getConector("com.microsoft.sqlserver.jdbc.SQLServerDriver", connectionUrl);

            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tamigo");
            while (rs.next()) {
                System.out.println(rs.getString("correo"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
