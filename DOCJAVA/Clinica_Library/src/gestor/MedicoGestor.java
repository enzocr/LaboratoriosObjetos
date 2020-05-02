package gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import objetos.Persona;
import objetos.Medico;
import java.util.ArrayList;
import multis.MultiMedico;
import multis.MultiPaciente;

/**
 *
 * @author enzoq
 */
public class MedicoGestor {

    protected ArrayList<Medico> listaMedicos;

    public MedicoGestor() {
        this.listaMedicos = new ArrayList<>();
    }

    public MedicoGestor(ArrayList<Medico> listaMedicos) {
        this.listaMedicos = new ArrayList<>();
    }

    public void registrarMedico(String codigo, String nombre, String email,
            String especialidad, String telefono, String cedula) throws ClassNotFoundException, SQLException {
        Medico medico;
        medico = (new MultiMedico()).registrarMedico(codigo, nombre, email, especialidad, telefono, cedula);
        listaMedicos.add(medico);
    }

    public Persona buscarPersonaMedico(String pId) throws Exception {
        Persona encontrada = null;
        encontrada = (new MultiMedico()).buscar(pId);
        return encontrada;
    }

    public Medico buscarMedicoCodigo(String pId) {
        Medico encontrada = null;
        for (Medico elMedico : listaMedicos) {
            if (elMedico.getCodigoMedico().equals(pId)) {
                encontrada = elMedico;
            }
        }
        return encontrada;
    }

    

    public String[] getMedicos() {
        int size = this.listaMedicos.size();
        String[] medicos = new String[size];
        int i = 0;
        for (Medico elMedico : listaMedicos) {
            medicos[i] = elMedico.toString();
            i++;

        }

        return medicos;
    }

}
