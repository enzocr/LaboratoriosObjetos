package capaLogica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class PersonaJuridica extends Persona {

    /**
     * Declaracion del atributo representante, de tipo Persona Fisica
     */
    protected PersonaFisica representante;

    /**
     * Creacion de constructor por defecto
     */
    public PersonaJuridica() {
        super();
        this.representante = new PersonaFisica();
    }

    /**
     * Inicializacion del constructor
     *
     * @param nombre
     * @param iD
     * @param nombreRepresentante
     * @param apellidosRepresentante
     * @param direccionRepresentante
     * @param telefonoRepresentante
     * @param identificacionRepresentante
     */
    public PersonaJuridica(String nombre, String iD, String nombreRepresentante, String apellidosRepresentante,
            String direccionRepresentante, String telefonoRepresentante, String identificacionRepresentante) {
        super(nombre, iD);
        this.representante = new PersonaFisica();
        this.representante.nombre = nombreRepresentante;
        this.representante.apellidos = apellidosRepresentante;
        this.representante.direccion = direccionRepresentante;
        this.representante.telefono = telefonoRepresentante;
        this.representante.iD = identificacionRepresentante;

    }

    /**
     * Retorna el atirbuto representante del obejeto Persona Juridica
     *
     * @return representante
     */
    public PersonaFisica getRepresentante() {
        return representante;
    }

    /**
     * Fija el representante del objeto Persona Juridica
     *
     * @param representante
     */
    public void setRepresentante(PersonaFisica representante) {
        this.representante = representante;
    }

    /**
     * Retorna instancia del objeto
     *
     * @return String
     */
    @Override
    public String toString() {
        return "PersonaJuridica{" + "representante=" + representante + '}';
    }

}
