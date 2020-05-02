package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino
 */
public class Videos extends Materiales {

    /**
     *Declaracion del formato del video
     */
    protected String formato;

    /**
     *Declaracion de la duracion del video
     */
    protected String duracion;

    /**
     *Declaracion del idioma del video
     */
    protected String idioma;

    /**
     *Declaracion del director del video
     */
    protected String director;

    /**
     *Creacion de un constructor por defecto
     */
    public Videos() {
        super();
    }

    /**
     *Inicializacion de atributos del video
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param formato
     * @param duracion
     * @param idioma
     * @param director
     */
    public Videos(String iD, LocalDate fechaCompra, boolean restringido, String tema,
            String formato, String duracion, String idioma, String director) {
        super(iD, fechaCompra, restringido, tema);
        this.formato = formato;
        this.duracion = duracion;
        this.idioma = idioma;
        this.director = director;
    }

    /**
     *Retorna formato del videos
     * @return formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     *Fija formato del video
     * @param formato
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     *Retorna duracion del video
     * @return duracion
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     *Fija la duracion del video
     * @param duracion
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     *Retorna idioma del video
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     *Fija idioma del video
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     *Retorna director del video
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     *Fija director del video
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }
/**
 * 
 * @return atributos del video, como String's 
 */
    @Override
    public String toString() {
        return ""
                + "**********Videos**********\n"
                + "ID: " + iD + "\n"
                + "Fecha de Compra: " + fechaCompra + "\n"
                + "Restringido: " + restringido + "\n"
                + "Tema: " + tema + "\n"
                + "Formato: " + formato + "\n"
                + "Duracion: " + duracion + "\n"
                + "Idioma: " + idioma + "\n"
                + "Director: " + director;
    }

}
