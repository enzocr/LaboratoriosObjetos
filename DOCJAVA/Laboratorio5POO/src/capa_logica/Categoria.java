package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Categoria {

    private String iD;
    private String nombre;
    private String descripcion;

    /**
     *Se crea un constructor por defecto
     */
    public Categoria() {

    }

    /**
     *Se inicializan los atributos por defecto
     * @param iD
     * @param nombre
     * @param descripcion
     */
    public Categoria(String iD, String nombre, String descripcion) {
        this.iD = iD;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }

    /**
     *Retorna iD de la Categoria
     * @return iD
     */
    public String getiD() {
        return iD;
    }

    /**
     *Fija valor al atributo iD
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *Retorna el nombre de la categoria
     * @return nombew
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Fija el valor al atributo nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Retorna la descripcion de la Categoria
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *Fija el valor al atributo descripcion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return arreglo de los atributos del objeto
     */
    @Override
    public String toString() {
        return "ID: " + iD + " \n"
                + "Nombre: " + nombre + " \n"
                + "Descripcion: " + descripcion;
    }

}
