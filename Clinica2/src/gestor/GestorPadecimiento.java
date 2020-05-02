/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import multis.MultiPadecimiento;
import objetos.Padecimiento;

/**
 *
 * @author enzoq
 */
public class GestorPadecimiento {

    protected ArrayList<Padecimiento> listaPadecimientos;

    public GestorPadecimiento() {
        this.listaPadecimientos = new ArrayList<>();
    }

    public GestorPadecimiento(ArrayList<Padecimiento> listaPadecimientos) {
        this.listaPadecimientos = new ArrayList<>();
    }

    public ArrayList<Padecimiento> getListaPadecimientos() {
        return listaPadecimientos;
    }

    public void agregarPadecimiento(String iD, String nombre, String descripcion) throws Exception {

        Padecimiento padecimiento;
        padecimiento = (new MultiPadecimiento()).crear(iD, nombre, descripcion);
        listaPadecimientos.add(padecimiento);

    }

    public Padecimiento buscarPadecimientoIdentificacion(String pId) throws Exception {
        Padecimiento encontrada = null;

        encontrada = (new MultiPadecimiento()).buscarPadecimiento(pId);
        return encontrada;
    }
     public Padecimiento buscarPadecimientoNombre(String nombre) throws Exception {
        Padecimiento encontrada = null;

        encontrada = (new MultiPadecimiento()).buscarPadecimientoNombre(nombre);
        return encontrada;
    }

}
