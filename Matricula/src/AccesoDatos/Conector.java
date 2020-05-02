package AccesoDatos;

import java.io.File;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Conector {

    //atributos objeto
    private static AccesoBD conectorBD = null;

    /**
     * Metodo estatico que conecta con la base de datos por medio de un archivo
     * de texto del proyecto
     * @return instancia de clase AccesoBD
     * @throws SQLException
     * @throws Exception
     */
    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        Scanner x;
        String driver = "", conexion = "";
        File file = new File("base_datos_matricula.txt");
        x = new Scanner(file);

        
            while (x.hasNext()) {
                driver = x.next();
                conexion = x.next();
            }
        
        x.close();
        if (conectorBD == null) {
                        conectorBD = new AccesoBD(driver, conexion);
        }
        return conectorBD;

    }
}
