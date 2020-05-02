/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import accesodatos.Conector;
import objetos.Querellante;
import objetos.Secretario;

/**
 *
 * @author enzoq
 */
public class MultiQuerellante {

    public Querellante crearQuerellante() throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Querellante querellante = null;
        String query;
        query = "INSERT INTO Querellante "
                + "()"
                + "VALUES ('" + 1 + "'," + 2 + ",'" + 3 + "');";
        Conector.getConector().ejecutarSQL(query);
        query = "SELECT IDENT_CURRENT ('Querellante') AS nuevoNumero;";
//		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            querellante = new Querellante();
        } else {
            throw new java.sql.SQLException("Error en la Base de Datos.");
        }
        rs.close();
        return querellante;
    }

    public Querellante buscarQuerellanteCedula(String cedula) throws java.sql.SQLException, Exception {
        Querellante querellante = null;
        java.sql.ResultSet rs;
        String query;
        query = "SELECT * "
                + "FROM Querellante "
                + "WHERE cedula='" + cedula + "';";
        rs = Conector.getConector().ejecutarSQL(query, true);
        if (rs.next()) {
            querellante = new Querellante();
        } else {
            throw new Exception("El Querellante no está registrado en el sistema.");
        }
        rs.close();
        return querellante;
    }

}
