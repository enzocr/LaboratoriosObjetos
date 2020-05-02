package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Audios extends Materiales {

    /**
     * Declaracion del formato del audio
     */
    protected String formato;

    /**
     * Declaracion de la duracion del audio
     */
    protected String duracion;

    /**
     * Declaracion del idioma del audio
     */
    protected String idioma;

    /**
     * Creacion por defecto del constructor
     */
    public Audios() {
        super();
    }

    /**
     * Inicializacion de atributos del audio
     *
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param formato
     * @param duracion
     * @param idioma
     */
    public Audios(String iD, LocalDate fechaCompra, boolean restringido, String tema,
            String formato, String duracion, String idioma) {
        super(iD, fechaCompra, restringido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    /**
     * Retorna formato del audio
     *
     * @return formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Fija formato del audio
     *
     * @param formato
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Retorna duracion del audio
     *
     * @return duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Fija duracion del audio
     *
     * @param duracion
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Retorna idioma del audio
     *
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Fija el idioma del audio
     *
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Retorna atirbutos del audio
     *
     * @return atributos del audio, como String's
     */
    @Override
    public String toString() {
        return ""
                + "**********Audios**********\n"
                + "ID: " + iD + "\n"
                + "Fecha de Compra: " + fechaCompra + "\n"
                + "Restringido: " + restringido + "\n"
                + "Tema: " + tema + "\n"
                + "Formato: " + formato + "\n"
                + "Duracion: " + duracion + "\n"
                + "Idioma: " + idioma;
    }

}
