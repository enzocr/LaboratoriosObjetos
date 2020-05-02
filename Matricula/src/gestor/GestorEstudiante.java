/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import objetos.Estudiante;
import java.sql.*;
import multis.MultiEstudiante;
import objetos.Carrera;

/**
 *
 * @author enzoq
 */
public class GestorEstudiante {

    public void registrarEstudiante(String nombre, String apellido, String identificacion, char genero, String telefono) throws Exception {

        new MultiEstudiante().insertarEstudiante(nombre, apellido, telefono, genero, identificacion);

    }

    public ArrayList<Estudiante> listarEstudiantes() throws Exception {
        ArrayList<Estudiante> listaEstudiantes;
        listaEstudiantes = new MultiEstudiante().listarEstudiante();
        return listaEstudiantes;
    }

    public Estudiante buscarEstudiante(String identificacion) throws Exception{
       Estudiante estudiante = (new MultiEstudiante()).buscarEstudiante(identificacion);
       return estudiante;
    }
    
    public int agregarCarrera(Estudiante e, Carrera c) throws Exception{
       if( new MultiEstudiante().agregarCarrera(e, c)==1){
           return 1;
       }
       else return 2;
    }
    public int eliminarEstudiante(int codigo) {
        return -1;
    }

}
