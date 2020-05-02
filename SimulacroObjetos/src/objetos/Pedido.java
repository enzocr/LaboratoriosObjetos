/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author enzoq
 */
public class Pedido {

    protected LocalDate fechaRecepcion;
    protected LocalDate fechaEntrega;
    protected Cliente cliente;
    protected Direccion direccion;
    protected float precioOriginal;
    protected float precioFinal;
    protected ArrayList<Articulo> listaArticulos;
    

    public Pedido() {

    }

    public Pedido(LocalDate fechaRecepcion, LocalDate fechaEntrega,
            Cliente cliente, Direccion direccion, float precioOriginal, float precioFinal) {
        this.fechaRecepcion = fechaRecepcion;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.direccion = direccion;
        this.precioOriginal = precioOriginal;
        this.precioFinal = precioFinal;

    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public float getPrecioOriginal() {
        return precioOriginal;
    }

    public void setPrecioOriginal(float precioOriginal) {
        this.precioOriginal = precioOriginal;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void agregarArticulos(Articulo articulo) {
        if (listaInitiate() == false) {
            listaArticulos.add(articulo);
        }
    }

    public boolean listaInitiate() {
        if (listaArticulos == null) {
            this.listaArticulos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
