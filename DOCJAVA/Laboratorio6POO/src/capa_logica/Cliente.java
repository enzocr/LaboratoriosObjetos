package capa_logica;

/**
 *
 * @author Enzo Quartino
 */
public class Cliente extends Persona {

    /**
     *Se declara el atributo direccion del cliente
     */
    protected String direccion;

    /**
     *Se declara el atributo telefono1 del cliente
     */
    protected String telefono1;

    /**
     *Se declara el atributo telefono2 del cliente
     */
    protected String telefono2;

    /**
     *Se declara el atributo correo del cliente
     */
    protected String correo;

    /**
     *Se crea un constructor por defecto
     */
    public Cliente() {

        super();
    }

    /**
     *Se inicializan los atributos del cliente
     * @param iD
     * @param nombre
     * @param apellidos
     * @param password
     * @param direccion
     * @param telefono1
     * @param telefono2
     * @param correo
     */
    public Cliente(String iD, String nombre, String apellidos, String password, String direccion, String telefono1,
            String telefono2, String correo) {
        super(iD, nombre, apellidos, password);
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
    }

    /**
     *Retorna atributo direccion
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *Fija valor del atributo direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *Retorna atributo telefono1
     * @return telefono1
     */
    public String getTelefono1() {
        return telefono1;
    }

    /**
     *Fija valor del atributo telefono1
     * @param telefono1
     */
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    /**
     *Retorna atributo telefono2
     * @return telefono2
     */
    public String getTelefono2() {
        return telefono2;
    }

    /**
     *Fija valor del atributo telefono2
     * @param telefono2
     */
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    /**
     *Retorna atributo correo
     * @return correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *Fija valor del atributo correo 
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
/**
 * Retorna los atributos del cliente como String's
 * @return String's
 */
    @Override
    public String toString() {
        return "************CLIENTE************ \n "
                + "ID: " + iD + " \n "
                + "Nombre: " + nombre + " \n "
                + "Apellidos: " + apellidos + " \n "
                + "Password: " + password + " \n "
                + "Direccion: " + direccion + " \n "
                + "Telefono #1: " + telefono1 + " \n "
                + "Telefono #2: " + telefono2 + " \n "
                + "Correo: " + correo;
    }

}
