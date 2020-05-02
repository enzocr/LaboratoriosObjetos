package capa_logica;

import java.time.LocalDate;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Textos extends Materiales {

    /**
     *Declaracion del titulo del texto
     */
    protected String titulo;

    /**
     *Declaracion del autor del texto
     */
    protected String autor;

    /**
     *Declaracion de la fecha de publicacion del texto
     */
    protected LocalDate fechaPublicacion;

    /**
     *Declaracion del numero de paginas del texto
     */
    protected int numPaginas;

    /**
     *Declaracion del idioma del texto
     */
    protected String idioma;

    /**
     *Creacion de constructor por defecto
     */
    public Textos() {
        super();
    }

    /**
     *Inicializacion atributos del texto
     * @param iD
     * @param fechaCompra
     * @param restringido
     * @param tema
     * @param titulo
     * @param autor
     * @param fechaPublicacion
     * @param numPaginas
     * @param idioma
     */
    public Textos(String iD, LocalDate fechaCompra, boolean restringido, String tema, String titulo, String autor, LocalDate fechaPublicacion, int numPaginas,
            String idioma) {
        super(iD, fechaCompra, restringido, tema);
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.numPaginas = numPaginas;
        this.idioma = idioma;
    }

    /**
     *Retorna titulo del texto
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *Fija el titulo del texto
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *Retorna autor del titulo
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     *Fija el autor del titulo
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *Retorna fecha de publicacion del texto
     * @return fechaPublicacion
     */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     *Fija fecha de publicacion del texto
     * @param fechaPublicacion
     */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     *Retorna el numero de paginas del texto
     * @return numPaginas
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     *Fija el numero de paginas del texto
     * @param numPaginas
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     *Retorna idioma del texto
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     *Fija el idioma del texto
     * @param idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
/**
 * 
 * @return atributos del texto, como String's
 */
    @Override
    public String toString() {
        return ""
                + "**********Textos**********\n"
                + "ID: " + iD + "\n"
                + "Fecha de Compra: " + fechaCompra + "\n"
                + "Restringido: " + restringido + "\n"
                + "Tema: " + tema + "\n"
                + "Titulo: " + titulo + "\n"
                + "Autor: " + autor + "\n"
                + "Fecha de Publicacion: " + fechaPublicacion + "\n"
                + "Numero de Paginas: " + numPaginas + "\n"
                + "Idioma: " + idioma;
    }

}
