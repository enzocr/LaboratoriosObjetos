
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino
 */
public class Manager extends PersonaFisica {

    private ArrayList<Empleado> listaEmpleados;

    public Manager() {
        super();
    }

    public Manager(String nombre, String apellido, char genero, String iD) {
        super(apellido, genero, iD, nombre);
    }

    public void agregarEmpleado(Empleado tmpEmpleado) {
        //valida si el array list esta inicializado y si es asi agrega el empleado
        if (isNullLista() == false) {
            this.listaEmpleados.add(tmpEmpleado);
        }
    }

    public boolean isNullLista() {
        if (this.listaEmpleados == null) {
            this.listaEmpleados = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

}
