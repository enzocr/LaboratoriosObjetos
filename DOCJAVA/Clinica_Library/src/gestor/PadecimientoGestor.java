package gestor;


import objetos.Padecimiento;
import java.util.ArrayList;
import multis.MultiPadecimiento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enzoq
 */
public class PadecimientoGestor {

    protected ArrayList<Padecimiento> listaPadecimientos;

    public PadecimientoGestor() {
        this.listaPadecimientos = new ArrayList<>();
    }

    public PadecimientoGestor(ArrayList<Padecimiento> listaPadecimientos) {
        this.listaPadecimientos = new ArrayList<>();
    }

    public void agregarPadecimiento(String iD, String nombre, String descripcion) throws Exception{

        Padecimiento padecimiento;
        padecimiento = (new MultiPadecimiento()).crear(iD, nombre, descripcion);
        listaPadecimientos.add(padecimiento);

    }
     public Padecimiento buscarPadecimientoNombre(String nombre) {
        Padecimiento p = null;

        for (Padecimiento pad : listaPadecimientos) {
            if (pad.getNombre().equals(nombre)) {
                p = pad;
            }
        }
        return p;
    }

    public Padecimiento buscarPadecimientiId(String pId) {
        Padecimiento p = null;

        for (Padecimiento pad : listaPadecimientos) {
            if (pad.getiD().equals(pId)) {
                p = pad;
            }
        }
        return p;
    }

    public ArrayList<Padecimiento> getListaPadecimientos() {
        return listaPadecimientos;
    }

}
