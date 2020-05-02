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
import objetos.Direccion;
import objetos.Fabrica;

/**
 *
 * @author enzoq
 */
public class MultiFabrica {

    public Fabrica crearFabrica(String nombre) throws Exception {
        String query;
        Fabrica fabrica = null;
        query = "INSERT INTO Fabrica(nombre) VALUES('" + nombre + "')";
        try {
            Conector.getConector().ejecutarSQL(query);
            fabrica = new Fabrica(nombre);
        } catch (Exception e) {
            throw e;

        }
        return fabrica;
    }

    public Fabrica buscarFabrica(String nombre) throws SQLException, Exception {
        String query;
        Fabrica fabrica = null;
        ResultSet rs;
        query = "SELECT * FROM Fabrica WHERE nombre= '" + nombre + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                fabrica = new Fabrica(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return fabrica;
    }

    public ArrayList<Fabrica> listarFabricas() throws Exception {
        String query;
        ArrayList<Fabrica> listaFabricas = new ArrayList<>();
        Fabrica fabrica = null;
        ResultSet rs;
        query = "SELECT * FROM Fabrica";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
            fabrica = new Fabrica(rs.getString("nombre"));

            listaFabricas.add(fabrica);

        }
        rs.close();
        return listaFabricas;
    }

}
