/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import multis.MultiCita;
import multis.MultiMedico;
import objetos.Cita;
import objetos.Medico;
import objetos.Paciente;

/**
 *
 * @author enzoq
 */
public class GestorMedico {

    protected ArrayList<Medico> listaMedicos;

    public GestorMedico() {

    }

    public void registrarMedico(String codigo, String especialidad, String nombre_completo,
            String identificacion, String telefono, String email, String clave) throws ClassNotFoundException, SQLException {
        Medico medico;
        medico = (new MultiMedico()).registrarMedico(codigo, especialidad, nombre_completo,
                identificacion, telefono, email, clave);

    }

    public Medico buscarMedicoIdentificacion(String pId) throws Exception {
        Medico encontrada = null;

        encontrada = (new MultiMedico()).buscarMedicoIdentificacion(pId);
        return encontrada;
    }

    public Medico buscarMedicoClave(String clave) throws Exception {
        Medico encontrado = null;
        encontrado = (new MultiMedico().buscarClaveMedico(clave));
        return encontrado;

    }

 
    
    
    public void agregarCita(Paciente p, Medico m, String descripcion, String resultado, String numeroCita) throws Exception {
        Cita cita = null;
        LocalDate fecha = LocalDate.now();
        cita = (new MultiCita()).crear(fecha, p, m, descripcion, resultado, numeroCita);

        m.agregarCita(cita);
        p.getExpediente().getListaCitas().add(cita);
    }

    public ArrayList<Medico> getMedicos() throws ClassNotFoundException, SQLException {
        
        ArrayList<Medico> listaMeds;
        listaMeds = (new MultiMedico()).getMedicos();

        return listaMeds;

    }

}
