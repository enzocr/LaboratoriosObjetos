
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author enzoq
 */
public class Gestor {

    protected ArrayList<Persona> listaProveedores;
    protected ArrayList<Producto> listaProductos;
    protected ArrayList<Cliente> listaClientes;
    protected ArrayList<CarroCompras> listaCarros;

    static int codigoProducto = 0;
    static int codigoCompra = 0;

    public Gestor() {
        this.listaProveedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaCarros = new ArrayList<>();
    }

    public Gestor(ArrayList<Persona> listaProveedores, ArrayList<Producto> listaProductos, ArrayList<Cliente> listaClientes) {
        this.listaProveedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaCarros = new ArrayList<>();
    }

    public void agregarOrganizacionProovedora(String idOrg, String nombreOrg, String dirOrg, String telOrg, String idRep,
            String nombreRep, String apellidos, String dirRep, String telRep) {

        PersonaFisica representante = new PersonaFisica(idRep, nombreRep, apellidos, dirRep, telRep);

        Organizacion org = new Organizacion(idOrg, nombreOrg, dirOrg, telOrg, representante);
        listaProveedores.add(org);

    }

    public void agregarPersonaProveedora(String iD, String nombre, String apellidos, String direccion, String telefono) {
        PersonaFisica persona = new PersonaFisica(iD, nombre, apellidos, direccion, telefono);
        listaProveedores.add(persona);
    }

    public Persona buscarProveedor(String pId) {
        Persona encontrado = null;
        for (Persona laPersona : listaProveedores) {
            if (laPersona.getiD().equals(pId)) {
                encontrado = laPersona;
            }
        }
        return encontrado;
    }

    public String[] getProveedores() {
        int size = this.listaProveedores.size();
        String[] personas = new String[size];
        int i = 0;
        for (Persona miPersona : listaProveedores) {

            personas[i] = miPersona.toString();
            i++;

        }

        return personas;
    }

    public void agregarProducto(String descripcion, int organic, String tipo) {

        Producto producto = new Producto(codigoProducto, descripcion, organic, tipo);
        listaProductos.add(producto);
        codigoProducto++;

    }

    public Producto[] getProductos() {
        int size = this.listaProductos.size();
        Producto[] productos = new Producto[size];
        int i = 0;
        for (Producto miProducto : listaProductos) {

            productos[i] = miProducto;
            i++;

        }

        return productos;
    }

    public Producto buscarProducto(int codigo) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getCodigo() == codigo) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getDescripcion().equals(nombre)) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    public Producto buscarProductoPorTipo(String tipo) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getTipo().equals(tipo)) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    public void agregarPersonaCliente(String iD, String nombre, String apellidos, String telefono, String provincia,
            String canton, String distrito, String direccion) {

        Cliente cliente = new Cliente(iD, nombre, apellidos, telefono, provincia, canton, distrito, direccion);
        listaClientes.add(cliente);

    }

    public Cliente buscarCliente(String iD) {
        Cliente encontrado = null;
        for (Cliente elCliente : listaClientes) {
            if (elCliente.getiD().equals(iD)) {
                encontrado = elCliente;
            }
        }
        return encontrado;
    }

    public String[] getClientes() {
        int size = this.listaClientes.size();
        String[] clientes = new String[size];
        int i = 0;
        for (Cliente miCliente : listaClientes) {

            clientes[i] = miCliente.toString();
            i++;

        }

        return clientes;

    }

    public CarroCompras inicializarCarro(Cliente c) {
        CarroCompras carro = new CarroCompras(LocalDate.now(), codigoCompra, c);
        listaCarros.add(carro);
        return carro;
    }

    public String[] getCarros() {
        int size = this.listaCarros.size();
        String[] carros = new String[size];
        int i = 0;
        for (CarroCompras carro : listaCarros) {
            carros[i] = carro.toString();
            i++;

        }
        return carros;
    }

}
