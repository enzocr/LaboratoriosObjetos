/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import accesodatos.Conector;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Caso;
import objetos.Juez;
import objetos.Querellante;

/**
 *
 * @author enzoq
 */
public class MultiCaso {

    public Caso crearCaso(int numero, String descripcion, String estado, LocalDate fecha, Querellante querellante, Juez juez) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Caso caso = null;
        String query;
        query = "INSERT INTO Querellante "
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);

        caso = new Caso();

        return caso;
    }

    public Caso buscarCasoNumero(int numeroCaso) throws java.sql.SQLException, Exception {
        Caso caso = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Caso "
                + "WHERE numeroCaso='" + numeroCaso + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            caso = new Caso();
        } else {
            throw new Exception("El Caso no está registrado en el sistema.");
        }
        rs.close();
        return caso;
    }

    public ArrayList<Caso> buscarCasosJuez(String usuarioJuez) throws java.sql.SQLException, Exception {
        ArrayList<Caso> listaCasosDeJuez = new ArrayList<>();
        Caso caso = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Caso "
                + "WHERE numeroCaso='" + usuarioJuez + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        while (rs.next()) {
            caso = new Caso();
            listaCasosDeJuez.add(caso);
        }

        rs.close();
        return listaCasosDeJuez;
    }

}
