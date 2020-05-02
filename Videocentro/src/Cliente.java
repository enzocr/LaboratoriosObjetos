
import java.util.ArrayList;

/**
 *
 * @author enzoq
 */
public class Cliente extends PersonaFisica {

    protected String provincia;
    protected String canton;
    protected String distrito;
    protected ArrayList<CarroCompras> listaPedidos;

    public Cliente() {
        super();
    }

    public Cliente(String iD, String nombre, String apellidos, String telefono, String provincia,
            String canton, String distrito, String direccion) {
        super(iD, nombre, apellidos, direccion, telefono);
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;

    }

    public void crearPedido(CarroCompras carro) {
        if (isNullLista() == false) {
            listaPedidos.add(carro);
        }

    }

    public boolean isNullLista() {
        if (this.listaPedidos == null) {
            this.listaPedidos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    public ArrayList<CarroCompras> getListaPedidos() {
        return listaPedidos;
    }

    @Override
    public String toString() {
        return "Cliente\n"
                + "ID: " + iD + "\n"
                + "Nombre: " + nombre + " " + apellidos + "\n"
                + "Direccion: " + direccion + "\n"
                + "Telefono: " + telefono + "\n"
                + "provincia=" + provincia + "\n"
                + ", canton=" + canton + "\n"
                + ", distrito=" + distrito + "\n";
    }

}
