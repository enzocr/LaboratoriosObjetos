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

/**
 *
 * @author enzoq
 */
public class MultiCliente {

  public Cliente crearCliente(String nombre) throws Exception {
        String query;
        Cliente cliente = null;
        query = "INSERT INTO Cliente(nombre) VALUES('" + nombre + "')";
        try {
            Conector.getConector().ejecutarSQL(query);
            
            cliente = new Cliente(nombre);
            
        } catch (Exception e) {
            throw e;

        }        
        
        return cliente;
    }
 public Cliente buscarCliente(String nombre) throws SQLException, Exception {
        String query;
        Cliente cliente = null;;
        ResultSet rs;
        query = "SELECT * FROM Cliente WHERE nombre= '" + nombre + "'";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        try {
            if (rs.next()) {
                cliente= new Cliente(rs.getString("nombre"));
                
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return cliente;
    }
 
 public ArrayList<Cliente> listarClientes() throws Exception {
        String query;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente=null;
        ResultSet rs;
        query = "SELECT * FROM Cliente";

        try {
            rs = Conector.getConector().ejecutarSQL(query, true);
        } catch (Exception ex) {
            throw ex;
        }

        while (rs.next()) {
           
            cliente = new Cliente(rs.getString("nombre"));
            listaClientes.add(cliente);

        }
        rs.close();
        return listaClientes;
    }




    
}
