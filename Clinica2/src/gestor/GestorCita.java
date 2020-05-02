/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import multis.MultiCita;
import objetos.Cita;

/**
 *
 * @author enzoq
 */
public class GestorCita {
    
    protected ArrayList<Cita>listaCitas;

    public String buscarCitaNumeroCita(String numeroString) throws Exception {
        String encontrada = null;

        encontrada = (new MultiCita()).buscarCitaNumero(numeroString);
        return encontrada;
    }

}
