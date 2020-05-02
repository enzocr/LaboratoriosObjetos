/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author enzoq
 */
public class Categoria {

    protected String nombre;
    protected double descuento;
    
    public Categoria() {

    }

    public Categoria(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
 
    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", descuento=" + descuento + '}';
    }

}
