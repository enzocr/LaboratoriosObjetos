/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import multis.MultiCita;

/**
 *
 * @author enzoq
 */
public class Medico extends Persona {

    protected String codigo;
    protected String especialidad;
    protected ArrayList<Cita> listaCitas;

    public Medico() {
        super();

    }

    public Medico(String codigo, String especialidad, String nombre_completo, 
            String identificacion, String telefono, String email, String clave) {
        super(nombre_completo, identificacion, telefono, email, clave);
        this.codigo = codigo;
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void agregarCita(Cita cita) throws Exception {

        if (isNullLista() == false) {
            listaCitas.add(cita);
        }

    }

    public boolean isNullLista() {
        if (this.listaCitas == null) {
            this.listaCitas = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
