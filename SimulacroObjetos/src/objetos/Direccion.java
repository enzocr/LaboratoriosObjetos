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
public class Direccion {

    protected int numeroCalle;
    protected String nombreCalle;
    protected String canton;
    protected String provincia;

    public Direccion() {

    }

    public Direccion(int numeroCalle, String nombreCalle, String canton, String provincia) {
        this.numeroCalle = numeroCalle;
        this.nombreCalle = nombreCalle;
        this.canton = canton;
        this.provincia = provincia;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Direccion{" + "numeroCalle=" + numeroCalle + ", nombreCalle=" + nombreCalle + ", canton=" + canton + ", provincia=" + provincia + '}';
    }

    
}
