package iu;

import gestor.*;
import objetos.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor gestor = new Gestor();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            int opc;

            do {
                mostrarMenu();
                opc = leerOpcion();
                ejecutarAccion(opc);
            } while (opc != 20);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1. Registrar Cliente");
        out.println("2. Buscar Cliente");
        out.println("3. Listar Cliente");
        out.println("4. Registrar Fabrica");
        out.println("5. Buscar Fabrica");
        out.println("6. Listar Fabricas");
        out.println("7. Registrar Categoria");
        out.println("8. Buscar Categoria");
        out.println("9. Listar Categorias");
        out.println("10. Registrar Articulos");
        out.println("11. Buscar Articulos");
        out.println("12. Listar Articulos");
    }

    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    public static void ejecutarAccion(int pOpcion) throws Exception {

        switch (pOpcion) {

            case 1:
                registrarCliente();
                break;
            case 2:
                buscarCliente();
                break;
            case 3:
                listarClientes();
                break;
            case 4:
                registrarFabrica();
                break;
            case 5:
                buscarFabrica();
                break;
            case 6:
                listarFabricas();
                break;
            case 7:
                registrarCategoria();
                break;
            case 8:
                buscarCategoria();
                break;
            case 9:
                listarCategorias();
                break;
            case 10:
                registrarArticulo();
                break;
            case 11:
                buscarArticulo();
                break;
            case 12:
                listarArticulos();
                break;
            case 13: break;    
            default:
                out.println("Opcion invalida");

        }

    }

    public static void registrarCliente() throws Exception {
        String nombre;
        int decision;
        Cliente clienteRegistrado = null;
        out.println("Digite el nombre del cliente a registrar");
        nombre = in.readLine();
        clienteRegistrado = gestor.registrarCliente(nombre);
        do {
            out.println("Numero de calle");
            int numCalle = Integer.parseInt(in.readLine());
            out.println("Nombre de calle");
            String nombreCalle = in.readLine();
            out.println("Canton en el que se encuentra la calle");
            String canton = in.readLine();
            out.println("Provincia en el que se encuentra la calle");
            String provincia = in.readLine();
            gestor.agregarDireccionCliente(clienteRegistrado, numCalle, nombreCalle, canton, provincia);

            out.println("Desea agregar otra direccion? SI(1) NO(2)");
            decision = Integer.parseInt(in.readLine());

        } while (decision != 2);

    }

    public static Cliente buscarCliente() throws Exception {
        String nombre;
        out.println("Digite el nombre del cliente que desea buscar");
        nombre = in.readLine();
        Cliente cliente = gestor.buscarCliente(nombre);
        if (cliente != null) {
            out.println(cliente.toString());
        } else {
            out.println("No existe cliente en el sistema");
        }
        return cliente;

    }

    public static void listarClientes() throws Exception {
        ArrayList<Cliente> lista = gestor.listarClientes();

        for (Cliente cliente : lista) {
            out.println(cliente.toString());
        }

    }

    public static void registrarFabrica() throws Exception {
        String nombre;
        int decision;
        Fabrica fabricaRegistrada = null;
        out.println("Digite el nombre del cliente a registrar");
        nombre = in.readLine();
        fabricaRegistrada = gestor.crearFabrica(nombre);
        do {
            out.println("Numero de calle");
            int numCalle = Integer.parseInt(in.readLine());
            out.println("Nombre de calle");
            String nombreCalle = in.readLine();
            out.println("Canton en el que se encuentra la calle");
            String canton = in.readLine();
            out.println("Provincia en el que se encuentra la calle");
            String provincia = in.readLine();
            gestor.agregarDireccionFabrica(fabricaRegistrada, numCalle, nombreCalle, canton, provincia);

            out.println("Desea agregar otra direccion? SI(1) NO(2)");
            decision = Integer.parseInt(in.readLine());

        } while (decision != 2);
    }

    public static Fabrica buscarFabrica() throws Exception {
        String nombre;
        out.println("Digite el nombre de la fabrica que desea buscar");
        nombre = in.readLine();
        Cliente cliente = gestor.buscarCliente(nombre);
        Fabrica fabrica = gestor.buscarFabrica(nombre);
        if (fabrica != null) {
            out.println(fabrica.toString());
        } else {
            out.println("No existe fabrica en el sistema");
        }
        return fabrica;

    }

    public static void listarFabricas() throws Exception {
        ArrayList<Fabrica> lista = gestor.listarFabricas();

        for (Fabrica fabrica : lista) {
            out.println(fabrica.toString());
        }

    }

    public static void registrarCategoria() throws Exception {
        String nombre;
        double descuento;
        out.println("Digite el nombre de la categoria");
        nombre = in.readLine();
        out.println("Digite descuento que se la aplicara a esta categoria");
        descuento = Double.parseDouble(in.readLine());
        gestor.crearCategoria(nombre, descuento);

    }

    public static Categoria buscarCategoria() throws Exception {
        String nombre;
        out.println("Digite el nombre de la categoria que desea buscar");
        nombre = in.readLine();
        Categoria categoria = gestor.buscarCategoria(nombre);
        if (categoria != null) {
            out.println(categoria.toString());
        } else {
            out.println("No existe dicha categoria");
        }
        return categoria;
    }

    public static void listarCategorias() throws Exception {
        ArrayList<Categoria> lista = gestor.listarCategorias();

        for (Categoria categoria : lista) {
            out.println(categoria.toString());
        }

    }

    public static void registrarArticulo() throws Exception {

        out.println("Digitar nombre del articulo");
        String descripcion = in.readLine();
        out.println("Digite precio del articulo");
        double precio = Double.parseDouble(in.readLine());
        listarCategorias();
        out.println("Digite el nombre de la categoria del articulo");
        String articulo = in.readLine();
        Categoria categoria = gestor.buscarCategoria(articulo);
        if (categoria != null) {
            String nombreFabrica;
            listarFabricas();
            out.println("Digite el nombre de fabrica que distribuyen el producto");
            nombreFabrica = in.readLine();
            Fabrica fabrica = gestor.buscarFabrica(nombreFabrica);
            if (fabrica != null) {

            }
            gestor.crearArticulo(descripcion, precio, categoria);
        } else {
            out.println("No existe dicha categoria");
        }

    }

    public static Articulo buscarArticulo() throws Exception {
        String descripcion;
        out.println("Digite nombre del articulo a buscar");
        descripcion = in.readLine();
        Articulo articulo = gestor.buscarArticulo(descripcion);
        if (articulo != null) {
            out.println(articulo.toString());
        } else {
            out.println("No existe dicho articulo");
        }

        return articulo;
    }

    public static void listarArticulos() throws Exception {
        ArrayList<Articulo> lista = gestor.listarArticulos();

        for (Articulo articulo : lista) {
            out.println(articulo.toString());
        }

    }

}
