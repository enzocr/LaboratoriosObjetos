package multis;

import AccesoDatos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Carrera;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class MultiCarrera {

    public Carrera insertarCarrera(String nombre, String codigo) throws Exception {
        String query;
        Carrera carrera = null;
        query = "INSERT INTO Carrera(codigo, nombre) VALUES('" + codigo + "','"
                + nombre + "')";
        try {
            Conector.getConector().ejecutarSQL(query);
            carrera = new Carrera(nombre, codigo);
        } catch (Exception e) {
            throw e;

        }
        return carrera;
    }

    public Carrera buscarCarrera(String codigo) throws SQLException, Exception {
        String query;
        Carrera carrera = null;
        ResultSet rs;
        query = "SELECT * FROM Carrera WHERE codigo= '" + codigo + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                carrera = new Carrera(
                        rs.getString("nombre"),
                        rs.getString("codigo"));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return carrera;
    }

    public ArrayList<Carrera> listarCarrera() throws Exception {
        String query;
        ArrayList<Carrera> listaCarreras = new ArrayList<>();
        Carrera carrera = null;
        ResultSet rs;
        query = "SELECT * FROM Carrera";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
            carrera = new Carrera(
                    rs.getString("nombre"),
                    rs.getString("codigo"));
            listaCarreras.add(carrera);

        }
        rs.close();
        return listaCarreras;
    }

}
