package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class PersonaFisica extends Persona {

    /**
     * Declaracion del atributo String, apellidos
     */
    protected String apellidos;

    /**
     * Declaracion del atributo String, direccion
     */
    protected String direccion;

    /**
     * Declaracion del atributo String, telefono
     */
    protected String telefono;

    /**
     * Creacion de un constructor por defecto
     */
    public PersonaFisica() {
        super();
    }

    /**
     * Inicializacion del constructor
     *
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param telefono
     * @param iD
     */
    public PersonaFisica(String nombre, String apellidos, String direccion, String telefono, String iD) {
        super(nombre, iD);
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;

    }

    /**
     * Retorna los apellidos del objeto Persona Fisica
     *
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Fija los apellidos del objeto Persona Fisica
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Retorna la direccion del objeto Persona Fisica
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Fija la direccion del objeto Persona Fisica
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna el telefono del objeto Persona Fisica
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Fija el telefono del objeto Persona Fisica
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna instancia del objeto
     *
     * @return String
     */
    @Override
    public String toString() {
        return "***PersonaFisica***" + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellidos: " + apellidos + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n"
                + "Cedula de Identificacion: " + iD;

    }

}
