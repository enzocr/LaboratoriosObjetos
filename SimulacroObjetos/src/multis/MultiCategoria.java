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
import objetos.Categoria;
import objetos.Direccion;

/**
 *
 * @author enzoq
 */
public class MultiCategoria {

    public Categoria crearCategoria(String nombre, double descuento) throws Exception {
        String query;
        Categoria categoria= null;
        query = "INSERT INTO Categoria(nombre_categoria, descuento) VALUES('" + nombre + "','"
                + descuento + "')";
        try {
            Conector.getConector().ejecutarSQL(query);
             categoria = new Categoria(nombre, descuento);

        } catch (Exception e) {
            throw e;

        }
        return categoria;
    }

    public Categoria buscarCategoria(String nombre) throws SQLException, Exception {
        String query;
        Categoria categoria = null;
        ResultSet rs;
        query = "SELECT * FROM Categoria WHERE nombre_categoria= '" + nombre + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                categoria = new Categoria(rs.getString("nombre_categoria"), rs.getFloat("descuento"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return categoria;
    }

    public ArrayList<Categoria> listarCategorias() throws Exception {
        String query;
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        Categoria categoria = null;
        ResultSet rs;
        query = "SELECT * FROM Categoria";
        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
            categoria = new Categoria(rs.getString("nombre_categoria"), rs.getFloat("descuento"));
            listaCategorias.add(categoria);
        }
        rs.close();
        return listaCategorias;
    }

}
