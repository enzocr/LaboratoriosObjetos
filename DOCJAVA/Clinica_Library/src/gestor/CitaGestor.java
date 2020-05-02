package gestor;

import objetos.Medico;
import objetos.Paciente;
import objetos.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import multis.MultiCita;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enzoq
 */
public class CitaGestor {

    protected ArrayList<Cita> listaCitas;

    public CitaGestor() {
        //      this.listaCitas = new ArrayList<>();
    }

    public CitaGestor(ArrayList<Cita> listaCitas) {
//        this.listaCitas = new ArrayList<>();
    }

    public ArrayList<Cita> getListaCitas() {
        if (this.listaCitas == null) {
            this.listaCitas = new ArrayList<>();
        }
        return listaCitas;
    }

    public void crearCita(Paciente p, Medico m, String descripcion, String resultado) throws Exception {

        Cita cita;
        cita = m.crearCita(p, m, descripcion, resultado, resultado);
    }

   
    public boolean isNullLista() {
        if (this.listaCitas == null) {
            this.listaCitas = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    public Cita buscarCita(int pId) {
        Cita encontrada = null;

        for (Cita laCita : listaCitas) {
            if (laCita.getiD() == pId) {
                encontrada = laCita;
            }
        }
        return encontrada;
    }

    public String[] getCitas() {
        int size = this.listaCitas.size();
        String[] personas = new String[size];
        int i = 0;
        for (Cita miCita : listaCitas) {

            personas[i] = miCita.toString();
            i++;

        }

        return personas;
    }

}
