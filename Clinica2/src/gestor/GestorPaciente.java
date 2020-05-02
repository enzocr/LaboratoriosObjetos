/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import multis.MultiMedico;
import multis.MultiPaciente;
import objetos.Medico;
import objetos.Paciente;
import objetos.Persona;

/**
 *
 * @author enzoq
 */
public class GestorPaciente {

    public void registrarPaciente(String nombre, String telefono, String identificacion, String email, String clave,
            String direccion, LocalDate fechaNacimiento, String tipoSangre, String numeroExpediente) throws Exception {
        Paciente elPaciente;
        elPaciente = (new MultiPaciente()).crear(nombre, telefono, identificacion, email, clave, direccion,
                fechaNacimiento, tipoSangre, numeroExpediente);

    }

    public Paciente buscarPersonaPaciente(String pId) throws Exception {
        Paciente encontrada = null;

        encontrada = (new MultiPaciente()).buscarPaciente(pId);
        return encontrada;
    }

    public Paciente buscarPacienteNombre(String nombre) throws Exception {
        Paciente encontrado = null;
        encontrado = (new MultiPaciente()).buscarPacienteNombre(nombre);
        return encontrado;
    }

    public Paciente buscarPacienteClave(String clave) throws Exception {
        Paciente encontrada = null;

        encontrada = (new MultiPaciente()).buscarPacienteClave(clave);
        return encontrada;
    }

    public ArrayList<Paciente> getPacientes() throws Exception {
        
        
        ArrayList<Paciente> listaPacientes = (new MultiPaciente()).getPacientes();

        return listaPacientes;

    }
    
}
