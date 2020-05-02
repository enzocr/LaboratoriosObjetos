/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import AccesoDatos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Direccion;
import objetos.Fabrica;

/**
 *
 * @author enzoq
 */
public class MultiDireccion {

    public Direccion creaDireccionCliente(Cliente cliente, int num, String calle, String canton, String provincia) throws SQLException, Exception {
        String query;
        Direccion direccion = null;
        ResultSet rs;
        query = "SELECT * From Cliente  WHERE nombre =  '" + cliente.getNombre() + "'   ";

        String query2;

        rs = Conector.getConector().ejecutarSQL(query, true);

        if (rs.next()) {
            query2 = "Insert into Direccion(numero, calle, canton, provincia, id_cliente)"
                    + "VALUES('" + num + "','" + calle + "','" + canton + "',"
                    + "'" + provincia + "','" + rs.getString("id_cliente") + "')";
            
            Conector.getConector().ejecutarSQL(query2);
        }

        return direccion;
    }
    public Direccion creaDireccionFabrica(Fabrica fabrica, int num, String calle, String canton, String provincia) throws SQLException, Exception {
        String query;
        Direccion direccion = null;
        ResultSet rs;
        query = "SELECT * From Cliente  WHERE nombre =  '" + fabrica.getNombre() + "'   ";

        String query2;

        rs = Conector.getConector().ejecutarSQL(query, true);

        if (rs.next()) {
            query2 = "Insert into Direccion(numero, calle, canton, provincia, id_fabrica)"
                    + "VALUES('" + num + "','" + calle + "','" + canton + "',"
                    + "'" + provincia + "','" + rs.getString("id_fabrica") + "')";
            Conector.getConector().ejecutarSQL(query2);
        }

        return direccion;
    }


    public Direccion buscarDireccion(String nombre) throws SQLException, Exception {
        String query;
        Direccion direccion = null;
        ResultSet rs;
        query = "SELECT * FROM Direccion WHERE nombre= '" + nombre + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {

                direccion = new Direccion(rs.getInt("numero"), rs.getString("calle"), rs.getString("canton"),
                        rs.getString("provincia"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return direccion;
    }

    public ArrayList<Direccion> listarDirecciones() throws Exception {
        String query;
        ArrayList<Direccion> listaDirecciones = new ArrayList<>();
        Direccion direccion = null;
        ResultSet rs;
        query = "SELECT * FROM Direccion";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
            direccion = new Direccion(rs.getInt("numero"), rs.getString("calle"), rs.getString("canton"),
                    rs.getString("provincia"));

            listaDirecciones.add(direccion);

        }
        rs.close();
        return listaDirecciones;
    }

}
