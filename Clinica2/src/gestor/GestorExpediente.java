/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.sql.SQLException;
import multis.*;

import objetos.Expediente;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class GestorExpediente {

    MultiExpediente multi = new MultiExpediente();

    public void agregarPadecimientoExpediente(Padecimiento p, Expediente e) throws SQLException, ClassNotFoundException {

        multi.agregarPadecimientoAexpediente(p, e);
        e.getListaPadecimientos().add(p);
    }

    public String buscarExpediente(String pId) throws Exception {
        String encontrada = null;

        encontrada = (new MultiExpediente()).buscarExpediente(pId);
        return encontrada;
    }
}
