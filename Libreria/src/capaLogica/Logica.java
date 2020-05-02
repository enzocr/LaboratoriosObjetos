package capaLogica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Logica {

    /**
     * Declaracion de un array list de tipo Persona
     */
    protected ArrayList<Persona> listaProveedores;
    /**
     * Declaracion de un array list de tipo Producto
     */
    protected ArrayList<Producto> listaProductos;
    /**
     * Declaracion de un array list de tipo Cliente
     */
    protected ArrayList<Cliente> listaClientes;
    /**
     * Declaracion de un array list de tipo String
     */
    protected ArrayList<String> listaPedidos;

    /**
     * Creacion de un constructor vacio
     */
    public Logica() {
        this.listaProveedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
    }

    /**
     * Inicializacion del constructor
     *
     * @param listaProveedores
     * @param listaProductos
     * @param listaClientes
     * @param carritoCompras
     * @param listaPedidos
     */
    public Logica(ArrayList<Persona> listaProveedores, ArrayList<Producto> listaProductos,
            ArrayList<Cliente> listaClientes, ArrayList<String> carritoCompras, ArrayList<String> listaPedidos) {

        this.listaProveedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();

    }

    /**
     * Retorna la lista de proveedores
     *
     * @return listaProveedores
     */
    public ArrayList<Persona> getListaProveedores() {
        return listaProveedores;
    }

    /**
     * Retorna la lista de productos
     *
     * @return listaProveedores
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Retorna la lista de clientes
     *
     * @return listaProveedores
     */
    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Retorna la lista de pedidos
     *
     * @return listaProveedores
     */
    public ArrayList<String> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * Recibe como parametros los datos de un proveedor y se agregan a su
     * respectivo objeto
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
    public void agregarProveedorOrganizacion(String nombre, String direccion, String telefono, String iD, String nombreRep, String apRep,
            String dirRep, String telRep, String idRep) {

        Organizacion org = new Organizacion(nombre, direccion, telefono, iD, nombreRep, apRep, dirRep, telRep, idRep);
        listaProveedores.add(org);

    }

    /**
     * Recibe como parametros los datos de una persona fisica y se agregan a su
     * respectivo objeto
     *
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param telefono
     * @param iD
     */
    public void agregarProveedorPersonaFisica(String nombre, String apellidos, String direccion, String telefono, String iD) {
        PersonaFisica per = new PersonaFisica(iD, nombre, apellidos, direccion, telefono);
        listaProveedores.add(per);
    }

    /**
     * Retorna null si no encuentra el objeto consultado Retorna la instancia
     * del objeto si se encuentra
     *
     * @param pId
     * @return objeto tipo Persona
     */
    public Persona buscarProveedor(String pId) {
        Persona encontrada = null;
        for (Persona laPersona : listaProveedores) {
            if (laPersona.getiD().equals(pId)) {
                encontrada = laPersona;
            }
        }
        return encontrada;
    }

    /**
     * Guarda como un arreglo de Strings todas las instancias de los objetos
     * registrados
     *
     * @return personas
     */
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

    /**
     * Recibe como parametros los datos de un producto y se agregan a su
     * respectivo objeto
     *
     * @param codigo
     * @param descripcion
     * @param organic
     * @param notOrganic
     * @param tipo
     * @param nombre
     */
    public void agregarProducto(int codigo, String descripcion, int organic, int notOrganic, String tipo, String nombre) {
        Producto theProduct = new Producto(codigo, descripcion, organic, notOrganic, tipo, nombre);
        listaProductos.add(theProduct);

    }

    /**
     * Retorna null si no encuentra el objeto consultado Retorna la instancia
     * del objeto si se encuentra
     *
     * @param pId
     * @return encontrado
     */
    public Producto buscarProducto(int pId) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getCodigo() == pId) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    /**
     * Retorna null si no encuentra el objeto consultado Retorna la instancia
     * del objeto si se encuentra
     *
     * @param pTipo
     * @return encontrado
     */
    public Producto buscarProductoTipo(String pTipo) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getTipo().equals(pTipo)) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    /**
     * *Retorna null si no encuentra el objeto consultado Retorna la instancia
     * del objeto si se encuentra
     *
     * @param pNombre
     * @return encontrado
     */
    public Producto buscarProductoNombre(String pNombre) {
        Producto encontrado = null;
        for (Producto elProducto : listaProductos) {
            if (elProducto.getNombre().equals(pNombre)) {
                encontrado = elProducto;
            }
        }
        return encontrado;
    }

    /**
     * Guarda como un arreglo de Strings todas las instancias de los objetos
     * registrados
     *
     * @return arreglo de Strings
     */
    public String[] getProductos() {
        int size = this.listaProductos.size();
        String[] productos = new String[size];
        int i = 0;
        for (Producto product : listaProductos) {

            productos[i] = product.toString();
            i++;

        }

        return productos;
    }

    /**
     * * Recibe como parametros los datos de un producto y se agregan a su
     * respectivo objeto
     *
     * @param provincia
     * @param canton
     * @param distrito
     * @param direccionExacta
     * @param correo
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param telefono
     * @param iD
     */
    public void agregarCliente(String provincia, String canton, String distrito, String direccionExacta, String correo,
            String nombre, String apellidos, String direccion, String telefono, String iD) {

        Cliente miCliente = new Cliente(nombre, apellidos, direccion, telefono, iD, provincia,
                canton, distrito, direccionExacta, correo);

        listaClientes.add(miCliente);

    }

    /**
     **Retorna null si no encuentra el objeto consultado Retorna la instancia
     * del objeto si se encuentra
     *
     * @param pId
     * @return encontrada
     */
    public Persona buscarCliente(String pId) {

        Persona encontrada = null;

        for (Persona pers : listaClientes) {
            if (pers.getiD().equals(pId)) {
                encontrada = pers;
            }
        }
        return encontrada;
    }

    /**
     * Guarda como un arreglo de Strings todas las instancias de los objetos
     * registrados
     *
     * @return arreglo de Strings
     */
    public String[] getClientes() {
        int size = this.listaClientes.size();
        String[] clientes = new String[size];
        int i = 0;
        for (Persona cliente : listaClientes) {

            clientes[i] = cliente.toString();

            i++;
        }

        return clientes;
    }

    /**
     * Retorna un objeto de tipo pedido
     *
     * @param fecha
     * @return pr
     */
    public Pedido inicializarPedido(LocalDate fecha) {

        Pedido pr = new Pedido(fecha);
        return pr;

    }
//tengo el objeto cliente creo un pedido para ese pedido pido os productos que quiero luego finalizo
    
    
    

}
