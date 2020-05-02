package accesodatos;

import java.io.File;
import java.io.FileReader;
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
     * Metodo que retorna el objeto AccesoBD para que las clases lo puedan usar
     *
     * @return objeto AccesoBD
     * @throws SQLException
     * @throws Exception
     */
    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        Scanner x;
        String driver = "", conexion = "";
        //File filePath = new File("Quartino_Enzo_textobd.txt").getAbsoluteFile();
        File file = new File("Quartino_Enzo_textobd.txt");
        if(file.exists()==false){
            file.createNewFile();
        }

        //x = new Scanner(new FileReader( filePath));
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
