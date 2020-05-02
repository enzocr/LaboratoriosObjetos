package multis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AccesoDatos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Articulo;
import objetos.Categoria;

/**
 *
 * @author enzoq
 */
public class MultiArticulo {

    public Articulo crearArticulo(String descripcion, double precio, Categoria categoria) throws Exception {
        String query, query2;
        Articulo articulo = null;
        ResultSet rs;
        query = "SELECT * FROM Categoria WHERE nombre_categoria=  '" + categoria.getNombre() + "' ";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            query2 = "INSERT INTO Articulo(descripcion, precio, id_categoria)"
                    + " VALUES('" + descripcion + "','" + precio + "','"+rs.getString("id_categoria")+"')";
            Conector.getConector().ejecutarSQL(query2);
        }

        return articulo;
    }

    public Articulo buscarArticulo(String descripcion) throws SQLException, Exception {
        String query;
        Categoria categoria = null;
        Articulo articulo = null;
        ResultSet rs;
        query = "SELECT * FROM Categoria as c, Articulo as a WHERE a.descripcion= '" + descripcion
                + "' and c.id_categoria = a.id_categoria";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                categoria = new Categoria(rs.getString("nombre_categoria"), rs.getFloat("descuento"));
                articulo = new Articulo(rs.getString("descripcion"), rs.getFloat("precio"), categoria);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return articulo;
    }

    public ArrayList<Articulo> listarArticulos() throws Exception {
        String query;
        ArrayList<Articulo> listaArticulos = new ArrayList<>();
        Articulo articulo = null;
        Categoria categoria = null;
        ResultSet rs;
        query = "SELECT * FROM Articulo, Categoria";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
            categoria = new Categoria(rs.getString("nombre_categoria"), rs.getFloat("descuento"));
            articulo = new Articulo(rs.getString("descripcion"), rs.getFloat("precio"), categoria);
            listaArticulos.add(articulo);
        }
        rs.close();
        return listaArticulos;
    }

}
