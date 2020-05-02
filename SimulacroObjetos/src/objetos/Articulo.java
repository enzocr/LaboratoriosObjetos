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
public class Articulo {

    protected String descripcion;
    protected double precio;
    protected Categoria categoria;
    protected ArrayList<Fabrica> listaFabricas;
   

    public Articulo() {

    }

    public Articulo(String descripcion, double precio, Categoria categoria) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Fabrica> getListaFabricas() {
        return listaFabricas;
    }

  
    public void agregarFabrica(Fabrica fabrica) {
        if (listaInitiate() == false) {
            listaFabricas.add(fabrica);
        }
    }

    public boolean listaInitiate() {
        if (listaFabricas == null) {
            this.listaFabricas = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Articulo{" + "descripcion=" + descripcion + ", precio=" + precio + ", categoria=" + categoria.getNombre()+"descuento: "+categoria.getDescuento()+'}';
    }

    
}
