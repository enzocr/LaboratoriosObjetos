/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import objetos.Carrera;
import java.sql.*;
import AccesoDatos.*;
import multis.MultiCarrera;

/**
 *
 * @author enzoq
 */
public class GestorCarrera {

    public void registrarCarrera(String nombre, String codigo) throws ClassNotFoundException, SQLException, Exception {

        new MultiCarrera().insertarCarrera(nombre, codigo);
    }

    public Carrera buscarCarrera(String codigo) throws Exception{
        Carrera carrera = (new MultiCarrera()).buscarCarrera(codigo);
    return carrera;
    }
    public ArrayList<Carrera> listarCarreras() throws Exception {
        ArrayList<Carrera> listaCarreras ;
        listaCarreras = new MultiCarrera().listarCarrera();

        return listaCarreras;
    }
  

    public int eliminarCarrera(int codigo) {
        return -1;
    }
}
