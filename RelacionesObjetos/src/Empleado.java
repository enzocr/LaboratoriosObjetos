
/**
 *
 * @author enzoq
 */
public class Empleado extends PersonaFisica {

    private String puesto;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido, char genero, String iD) {
        super(apellido, genero, iD, nombre);
    }
}
