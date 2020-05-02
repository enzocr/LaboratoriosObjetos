package capa_logica;

/**
 *
 * @author Enzo Quartino
 */
public class Persona {

    /**
     *Se declara iD de la persona
     */
    protected String iD;

    /**
     *Se declara nombre de la persona
     */
    protected String nombre;

    /**
     *Se declaran apellidos de la persona
     */
    protected String apellidos;

    /**
     *Se declara la contrase;a de la persona
     */
    protected String password;

    /**
     *Se crea un constructor por defecto
     */
    public Persona() {

    }

    /**
     *Inicializa constructor y atributos de la persona
     * @param iD
     * @param nombre
     * @param apellidos
     * @param password
     */
    public Persona(String iD, String nombre, String apellidos, String password) {

        this.iD = iD;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
    }

    /**
     *Se retorna el iD de la persona
     * @return iD
     */
    public String getiD() {
        return iD;
    }

    /**
     *Fija el valor al atributo iD
     * @param iD
     */
    public void setiD(String iD) {
        this.iD = iD;
    }

    /**
     *Se retorna el nombre de la persona
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Fija el valor del atributo nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Retorna apellidos de la persona
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *Fija valor del atributo apellidos
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *Retorna contrase;a de la persona
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *Fija valor del atributo password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *Retorna como String's los atributos de la personas
     * @return  String's
     */
    @Override
    public String toString() {
        return "PERSONA= ID: " + iD
                + " Nombre: " + nombre
                + " Apellidos: " + apellidos
                + " Password: " + password;
    }

}
