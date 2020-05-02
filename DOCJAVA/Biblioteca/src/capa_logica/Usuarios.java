package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Usuarios {

    /**
     *Declaracion del iD del usuario
     */
    protected String iD;

    /**
     *Declaracion del nombre del usuario
     */
    protected String nombre;

    /**
     *Declaracion del apellido de un usuario
     */
    protected String apellido;

    /**
     *Creacion de un constructor por defecto
     */
    public Usuarios() {

    }

    /**
     *Inicializacion de atributos de un usuario
     * @param iD
     * @param nombre
     * @param apellido
     */
    public Usuarios(String iD, String nombre, String apellido) {
        this.iD = iD;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     *Retorna el iD del usuario
     * @return iD
     */
    public String getiD() {
        return iD;
    }

    /**
     *Fija iD del usuario
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *Retorna nombre del usuario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Fija nombre del usuario
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Retorna apellido del usuario
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *Fija apellido del usuario
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return atributos del usuario, como String's
     */
    @Override
    public String toString() {
        return "**********Usuarios**********\n"
                + "ID: " + iD + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido: " + apellido;
    }

}
