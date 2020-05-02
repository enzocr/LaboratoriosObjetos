package capaLogica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author enzoq
 */
public class Camiseta {

    protected String iD;
    protected String color;
    protected String tam;
    protected String descripcion;
    protected String precio;

    public Camiseta() {

    }

    public Camiseta(String iD, String color, String tam, String descripcion, String precio) {
        this.iD = iD;
        this.color = color;
        this.tam = tam;
        this.descripcion = descripcion;

        this.precio = precio;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Camiseta{" + "iD=" + iD
                + ", color=" + color
                + ", tam=" + tam
                + ", descripcion=" + descripcion
                + ", precio=" + precio + '}';
    }

}
