/**
 *
 * @author Enzo Quartino Zamora
 */
public class Organizacion extends PersonaJuridica {

    protected String direccion;
    protected String telefono;
  

    public Organizacion() {
        super();
    }

    public Organizacion(String iD, String nombre, String direccion, String telefono, PersonaFisica representante) {
        super(iD, nombre, representante);
        this.direccion = direccion;
        this.telefono = telefono;
       
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public PersonaFisica getRepresentante() {
        return representante;
    }

    public void setRepresentante(PersonaFisica representante) {
        this.representante = representante;
    }
    

    @Override
    public String toString() {
        return "Organizacion{"
                + "Nombre: " + nombre + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n"
                + representante.toString() + "\n";
    }

}
