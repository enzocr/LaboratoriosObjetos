
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author enzoq
 */
public class CarroCompras {

    protected LocalDate fecha;
    protected ArrayList<Producto> listaProductos;
    protected int codigo;
    protected Cliente cliente;

    public CarroCompras() {

    }

    public CarroCompras(LocalDate fecha, int codigo, Cliente cliente) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto pr) {
        if (isNullLista() == false) {
            listaProductos.add(pr);
        }

    }

    public boolean isNullLista() {
        if (this.listaProductos == null) {
            this.listaProductos = new ArrayList<>();
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        
        String s = "";
        for (int i = 0; i < listaProductos.size(); i++) {
            s += listaProductos.get(i) + "\n";
        }

        return "CarroCompras ---" + "Fecha: " + fecha
                + s
                + cliente.toString() + "\n";
    }

}
