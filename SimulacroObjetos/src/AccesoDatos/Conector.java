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

    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        Scanner x;
        String driver = "", conexion = "";
        File file = new File("basedatos.txt");
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
