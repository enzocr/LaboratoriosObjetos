/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.*;

/**
 * Clase AccesoBD
 *
 * @author Enzo Quartino Zamora Clase que maneja el acceso a la base de datos.
 */
public class AccesoBD {
    //atributos del objeto

    private Connection conn = null;
    private Statement st;

    /**
     * Constructor que recibe parametros para abrir hacer una conexion valida
     *
     * @param driver
     * @param conexion
     * @throws SQLException
     * @throws Exception
     */
    public AccesoBD(String driver, String conexion) throws SQLException, Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(conexion);//driver manager retorna conexion
        st = conn.createStatement();
    }

    /**
     * Metodo que ejecuta una sentencia en la base de datos
     *
     * @param query consulta que sera ejecutada en la base de datos
     * @throws java.sql.SQLException
     *
     */
    public void ejecutarSQL(String query)
            throws SQLException, Exception {
        st.execute(query);
    }

    /**
     * Metodo que ejecuta una sentencia en la base de datos y devuelve un
     * ResultSet con los resultados
     *
     * @param query sentencia que sera ejecutada en la base de datos
     * @param retorno booleana que indica que se desea un resultado de la
     * consulta
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet ejecutarSQL(String query,
            boolean retorno)
            throws SQLException, Exception {
        ResultSet rs;
        rs = st.executeQuery(query);
        return rs;
    }

}
