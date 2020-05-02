package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import multis.MultiPaciente;

/**
 *
 * @author enzoq
 */
public class PacienteGestor {

    protected ArrayList<Paciente> listaPacientes;

    public PacienteGestor() {
        this.listaPacientes = new ArrayList<>();
    }

    public PacienteGestor(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = new ArrayList<>();
    }

    public void registrarPaciente(String cedula, String nombre, String direccion, String email, String telefono,
            String clave, int idExp, String tipoSangre, LocalDate fechaNac) throws Exception {
        Paciente elPaciente;
        Cita cita = null;

        elPaciente = (new MultiPaciente()).crear(cedula, nombre, direccion, email, telefono, clave, idExp, tipoSangre,
                fechaNac, cita);
        listaPacientes.add(elPaciente);

    }

    public String buscarPersonaPaciente(String pId) throws Exception {
        String encontrada = null;

        encontrada = (new MultiPaciente()).buscarPaciente(pId);
        return encontrada;
    }
   

    public String[] getPacientes() {
        int size = this.listaPacientes.size();
        String[] pacientes = new String[size];
        int i = 0;
        for (Paciente elPaciente : listaPacientes) {
            pacientes[i] = elPaciente.toString();
            i++;
        }
        return pacientes;
    }

    public Paciente buscarPaciente(String nombre) {

        Paciente encontrado = null;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getNombre().equals(nombre)) {
                encontrado = paciente;
            }
        }
        return encontrado;
    }

    public Persona buscarCorreoPaciente(String correo) throws Exception {
        Persona encontrado = null;
        encontrado= (new MultiPaciente()).buscarPacienteCorreo(correo);
        return encontrado;
    }

    public Paciente buscarClavePaciente(String clave) {
        Paciente encontrado = null;
        for (Paciente pac : listaPacientes) {
            if (pac.getClave().equals(clave)) {
                encontrado = pac;
            }

        }
        return encontrado;
    }

}
