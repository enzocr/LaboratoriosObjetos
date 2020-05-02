package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Organizacion extends PersonaJuridica {

    /**
     * Declaracion del atributo String, direccion del objeto Organizacion/
     */
    protected String direccion;

    /**
     * Declaracion del atributo String, telefono del objeto Organizacion
     */
    protected String telefono;

    /**
     * Creacion de constructor vacio
     */
    public Organizacion() {
        super();
    }

    /**
     * Inicializacion del constructor
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param iD
     * @param nombreRep
     * @param apRep
     * @param dirRep
     * @param telRep
     * @param idRep
     */
    public Organizacion(String nombre, String direccion, String telefono, String iD, String nombreRep, String apRep,
            String dirRep, String telRep, String idRep) {

        super(nombre, iD, nombreRep, apRep, dirRep, telRep, idRep);
        this.direccion = direccion;
        this.telefono = telefono;

    }

    /**
     * Retorna la direccion del objeto Organizacion
     *
     * @return direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Fija la direccion del objeto Organizacion
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Retorna el telefono del objeto Organizacion
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Fija el telefono del objeto Organizacion
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *Retorna instancia del objeto
     * @return String
     */
    @Override
    public String toString() {
        return "***Organizacion***\n"
                + "Nombre: " + nombre + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n"
                + "Cedula Juridica: " + iD + "\n"
                + "Nombre Representante Legal: " + representante.nombre + "\n"
                + "Apellidos Representante Legal: " + representante.apellidos + "\n"
                + "Direccion Representante Legal: " + representante.direccion + "\n"
                + "Telefono Representante Legal: " + representante.telefono + "\n"
                + "Cedula de Indentidad del Representante Legal: " + representante.iD + "\n";

    }

}
