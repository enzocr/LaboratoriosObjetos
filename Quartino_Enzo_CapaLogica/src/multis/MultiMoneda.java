package multis;

import accesodatos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Moneda;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class MultiMoneda {

    /**
     * Recibe el nombre/inicialies de una moneda, la busca en la base de datos
     * si la encuentra devuelve su instancia, si no, devuelve un objeto vacio
     * @param nombreMoneda
     * @return objeto moneda
     * @throws SQLException
     * @throws Exception
     */
    public Moneda buscarMoneda(String nombreMoneda) throws SQLException, Exception {
        String query;
        Moneda moneda = null;
        ResultSet rs;
        query = "SELECT * FROM Moneda WHERE nombre_moneda= '" + nombreMoneda + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

            if (rs.next()) {
                moneda = new Moneda(rs.getString("nombre_moneda"),
                        rs.getInt("tipo_de_cambio"));
            }
            else{
                throw new Exception("NO EXISTE ESTA MONEDA EN LA BASE DE DATOS");
            }
       
        return moneda;
    }

    /**
     * Devuelve todas las monedas registradas en la base de datos
     * @return ArrayList<Moneda> listaMonedas
     * @throws java.lang.Exception
     */
    public ArrayList<Moneda> listarMonedas() throws Exception {
        String query;
        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        Moneda moneda = null;
        ResultSet rs;
        query = "SELECT * FROM Moneda";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {

            moneda = new Moneda(rs.getString("nombre_moneda"),
                    rs.getInt("tipo_de_cambio"));
            listaMonedas.add(moneda);
        }
        rs.close();
        return listaMonedas;
    }

}
