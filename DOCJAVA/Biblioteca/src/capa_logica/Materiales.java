package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Materiales {

    /**
     *Declaracion de iD del material
     */
    protected String iD;

    /**
     *Declaracion de la fecha de compra del material
     */
    protected LocalDate fechaCompra;

    /**
     *Declaracion de la restriccion del material
     */
    protected boolean restringido;

    /**
     *Declaracion del tema del material
     */
    protected String tema;

    /**
     *Creacion de un constructor por defecto
     */
    public Materiales() {

    }

    /**
     *Inicializacion de los atributos del material
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     */
    public Materiales(String iD, LocalDate fechaCompra, boolean restringido, String tema) {
        this.iD = iD;
        this.fechaCompra = fechaCompra;
        this.restringido = restringido;
        this.tema = tema;
    }

    /**
     *Retorna iD del material
     * @return iD
     */
    public String getiD() {
        return iD;
    }

    /**
     *Fija el iD del material
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *Retorna la fecha de compra del material
     * @return fechaCompra
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     *Fija la fecha de compra del material
     * @param fechaCompra
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     *Devuelve true o false si el material es restringido o no
     * @return restringido
     */
    public boolean isRestringido() {
        return restringido;
    }

    /**
     *Fija true o false si el material es restringido o no
     * @param restringido
     */
    public void setRestringido(boolean restringido) {
        this.restringido = restringido;
    }

    /**
     *Retorna el tema del material
     * @return tema
     */
    public String getTema() {
        return tema;
    }

    /**
     *Fija el tema del material
     * @param tema
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     *
     * @return atributos del material como String's
     */
    @Override
    public String toString() {
        return "**********Materiales**********\n"
                + "ID: " + iD + "\n"
                + "Fecha de Contratacion: " + fechaCompra + "\n"
                + "Restringido: " + restringido + "\n"
                + "Tema: " + tema;
    }

}
