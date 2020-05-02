package multis;

import AccesoDatos.Conector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Carrera;
import objetos.Estudiante;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class MultiEstudiante {

    public Estudiante insertarEstudiante(String nombre, String apellido, String telefono, char genero, String identificacion) throws Exception {
        String query;
        Estudiante estudiante = null;
        query = "INSERT INTO Estudiante(nombre, apellido, telefono, genero, identificacion) VALUES('" + nombre + "','"
                + apellido + "','"
                + telefono + "','"
                + genero + "','"
                + identificacion + "')";
        try {
            Conector.getConector().ejecutarSQL(query);
            estudiante = new Estudiante(nombre, apellido, telefono, genero, identificacion);
        } catch (Exception e) {
            throw e;

        }
        return estudiante;
    }

    public Estudiante buscarEstudiante(String identificacion) throws SQLException, Exception {
        String query;
        Estudiante estudiante = null;
        ResultSet rs;
        query = "SELECT * FROM Estudiante WHERE identificacion= '" + identificacion + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {

                estudiante = new Estudiante(rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"),
                        rs.getString("genero").charAt(0), rs.getString("identificacion"));

            }
        } catch (SQLException ex) {
            throw ex;
        }
        return estudiante;

    }

    public ArrayList<Estudiante> listarEstudiante() throws Exception {
        String query;
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        Estudiante estudiante = null;
        ResultSet rs;
        query = "SELECT * FROM Estudiante";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {

            estudiante = new Estudiante(rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"),
                    rs.getString("genero").charAt(0), rs.getString("identificacion"));

            listaEstudiantes.add(estudiante);

        }
        rs.close();
        return listaEstudiantes;
    }

    public int agregarCarrera(Estudiante e, Carrera c) throws Exception {

        String query;
        ResultSet rs;
        query = "Select * FROM Estudiante as e, Carrera as c WHERE e.nombre= '" + e.getNombre()
                + "'and c.codigo= '" + c.getCodigo() + "'";

        String query2;
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            query2 = "INSERT INTO estudianteXcarrera(id_estudiante, id_carrera)"
                    + "VALUES('" + rs.getString("id_estudiante") + "','" + rs.getString("id_carrera") + "')";
            Conector.getConector().ejecutarSQL(query2);
            return 1;
        }
       else return 2;
    }

}
