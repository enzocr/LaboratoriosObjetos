package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Profesores extends Usuarios {

    /**
     *Declaracion del tipo de contrato del profesor
     */
    protected String tipoContrato;

    /**
     *Declaracion de la fecha de contratacion del profesor
     */
    protected LocalDate fechaContratacion;
    
    /**
     *Creacion de un constructor por defecto
     */
    public Profesores() {
        super();
    }

    /**
     *Creacion de un constructor por defecto
     * @param tipoContrato
     * @param fechaContratacion
     */
    public Profesores(String tipoContrato, LocalDate fechaContratacion) {
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    /**
     *Inicializacion de atributos del profesor
     * @param iD
     * @param nombre
     * @param apellido
     * @param tipoContrato
     * @param fechaContratacion
     */
    public Profesores(String iD, String nombre, String apellido, String tipoContrato, LocalDate fechaContratacion) {
        super(iD, nombre, apellido);
        this.tipoContrato = tipoContrato;
        this.fechaContratacion = fechaContratacion;
    }

    /**
     *Retorna tipo de contrato del profesor
     * @return tipoContrato
     */
    public String getTipoContrato() {
        return tipoContrato;
    }

    /**
     *Fija el tipo de contrato del profesor
     * @param tipoContrato
     */
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    /**
     *Retorna la fecha de contratacion del profesor
     * @return fechaContratacion
     */
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    /**
     *Fija la fecha de contratacion del profesor
     * @param fechaContratacion
     */
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
/**
 * 
 * @return atributos del profesor como String's 
 */
    @Override
    public String toString() {
        return "**********Profesores**********\n"
                + "ID: " + iD + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido + "\n"
                + "Tipo de Contrato: " + tipoContrato + "\n"
                + "Fecha de Contratacion: " + fechaContratacion;
    }

}
