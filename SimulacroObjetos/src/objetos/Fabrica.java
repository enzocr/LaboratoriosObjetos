/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author enzoq
 */
public class Fabrica {

    protected String nombre;
    protected ArrayList<Direccion> listaDirecciones;
    protected int identificacion;

    public Fabrica() {

    }

    public Fabrica(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Direccion> getListaDirecciones() {
        return listaDirecciones;
    }

    public void agregarDireccion(Direccion direccion) {
        if (listaInitiate() == false) {
            listaDirecciones.add(direccion);
        }
    }

    public boolean listaInitiate() {
        if (listaDirecciones == null) {
            this.listaDirecciones = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Fabrica{" + "nombre=" + nombre + '}';
    }

}
