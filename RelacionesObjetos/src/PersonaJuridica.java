
/**
 *
 * @author Enzo Quartino
 */
public class PersonaJuridica extends Persona {

    protected PersonaFisica representante;
    protected String razonSocial;

    public PersonaJuridica() {
        super();
        this.representante = new PersonaFisica();
    }

    public PersonaJuridica(String nombre, String iD, String nombreRepresentante) {
        super(nombre, iD);
        this.representante = new PersonaFisica();
        this.representante.nombre = nombreRepresentante;

    }

    public PersonaJuridica(String nombre, String iD, PersonaFisica representante) {
        super(nombre, iD);
        this.representante = representante;
    }

}
