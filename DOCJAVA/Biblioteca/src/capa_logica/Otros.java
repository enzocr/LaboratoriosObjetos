package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Otros extends Materiales {

    /**
     *Declaracion de descripcion de Otro tipo de material
     */
    protected String descripcion;

    /**
     *Creacion de un constructor por defecto
     */
    public Otros() {
        super();
    }

    /**
     *Inicializacion de atributos de otro material
     * @param descripcion
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     */
    public Otros(String descripcion, String iD, LocalDate fechaCompra, boolean restringido, String tema) {
        super(iD, fechaCompra, restringido, tema);
        this.descripcion = descripcion;
    }

    /**
     *Retorna descripcion de otro tipo de material
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *FIja la descripcion de otro tipo de material
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return atributos de otro material, como String's
     */
    @Override
    public String toString() {
        return ""
                + "**********Otros**********/n"
                + "ID: " + iD + "\n"
                + "Fecha de Compra: " + fechaCompra + "\n"
                + "Restringido: " + restringido + "\n"
                + "Tema: " + tema + "\n"
                + "Descripcion: " + descripcion;
    }

}
