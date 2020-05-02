package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Video {

    /**
     * Tipo del video: DVD o Cinta
     */
    protected String tipo;
    /**
     * Nombre del DVD o Cinta
     */
    protected String titulo;
    /**
     * ID del DVD o Cinta
     */
    protected String iD;

    /**
     * Crea objetos vacios
     *
     */
    public Video() {
        tipo = "";
        titulo = "";
        iD = "";
    }

    public Video(String tipo, String titulo, String iD) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.iD = iD;
    }

    /**
     * Retorna el tipo del video
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * fija el parametro tipo en el atributo tipo de la Clase Video
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna el nombre del video
     *
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * fija el parametro titulo en el atributo titulo de la Clase Video
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna el iD del video
     *
     * @return iD/
     */
    public String getiD() {
        return iD;
    }

    /**
     * fija el parametro iD en el atributo iD de la Clase Video
     *
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *
     * @return video
     */
    @Override
    public String toString() {
        return "Tipo de video: " + tipo + "\n"
                + "Titulo del video: " + titulo + "\n"
                + "ID del video: " + iD;
    }

}
