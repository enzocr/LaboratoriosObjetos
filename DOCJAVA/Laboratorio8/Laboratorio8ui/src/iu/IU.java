package iu;

import capaLogica.Logica;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * Pedidios se pueden hacer por tel ccorreo fax catalogo para cada mes catalogo
 * se almacena en una matriz generar ordenes generar pedidos
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Logica capa = new Logica();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 8);
    }

    /**
     * muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Ingresar Cliente");
        out.println("2.  Ingresar Camiseta");
        out.println("3.  Crear Catalogo");
        out.println("4.  Imprimir Catalogo");
        out.println("5.  Crear Orden");
        out.println("6.  Imprimir ordenes");
        out.println("7.  Buscar Orden");
        out.println("8.  Salir");

        out.println();
    }

    /**
     * La opcion escogida por el cliente es parseada y se retorna
     *
     * @return la opcion escogida por el cliente o administrador
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     *
     * @param pOpcion recibe opcion digitada por el usuario y la usa en el
     * switch
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                ingresarCliente();
                break;

            case 2:
                ingresarCamiseta();
                break;

            case 3:
                crearCatalogo();
                break;

            case 4:
                imprimirCatalogo();
                break;

            case 5:
                crearOrden();
                break;

            case 6:
                imprimirOrdenes();
                break;

            case 7:
                buscarOrden();
                break;

            case 8:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    public static void ingresarCliente() throws IOException {
        String nombre;
        out.println("Digite el nombre y apellido del cliente");
        nombre = in.readLine();
        capa.agregarCliente(nombre);
    }

    public static void ingresarCamiseta() throws IOException {
        String iD, color, tam, descripcion, precio;
        out.println("Digite el iD de la camiseta");
        iD = in.readLine();
        out.println("Digite el color de la camiseta");
        color = in.readLine();
        out.println("Digite el tama;o de la camiseta");
        tam = in.readLine();
        out.println("Digite la descripcion de la camiseta");
        descripcion = in.readLine();
        out.println("Digite el precio de la camiseta");
        precio = in.readLine();

        capa.agregarCamiseta(iD, color, tam, descripcion, precio);

    }

    public static void crearCatalogo() throws IOException {
        LocalDate nombre;
        String decision;
        int salir;
        nombre = LocalDate.now();

        do {
            for (String camisa : capa.getCamisas()) {

                out.println(camisa);
            }
            out.println("Digite el iD de la camisa que desea Ingresar");
            decision = in.readLine();
            for (int i = 0; i < capa.getListaCamisas().size(); i++) {
                if (capa.comprobarIdCamisa(decision) == -1) {
                    capa.agregarCatalogo(nombre, decision, i);
                } else {
                    out.println("No existe esta camisa");
                }
            }

            out.println("Desea salir? Si(1) No(2)");
            salir = Integer.parseInt(in.readLine());
        } while (salir != 1);

    }

    public static void imprimirCatalogo() throws IOException {

        for (String catalogo : capa.getCatalogos()) {

            out.println(catalogo);

        }

    }

    public static void crearOrden() throws IOException {
        String iD, tipo;
        LocalDate fechaOrden = LocalDate.now();
        String cantCamisas, precioCamisa;
        out.println("Digite el iD de la orden");
        iD = in.readLine();
        out.println("Tipo de orden");
        tipo = in.readLine();

        out.println("La fecha de la orden es: " + fechaOrden);
        out.println("Cantidad de camisas que desea ordenar");
        cantCamisas = in.readLine();
        out.println("Precio de la camisa");
        precioCamisa = in.readLine();

        capa.agregarOrden(iD, tipo, fechaOrden, precioCamisa, cantCamisas);

    }

    public static void imprimirOrdenes() {

        for (String orden : capa.getOrdenes()) {

            out.println(orden);

        }
    }

    public static void buscarOrden() throws IOException {

        String iD;
        out.println("Digite el Id de la orden");
        iD = in.readLine();

        for (String orden : capa.getOrdenes()) {
            if (capa.comprobarIdOrden(iD) == -1) {
                out.println(orden);
            } else {
                out.println("No existe esa orden");
            }

        }

    }
}
