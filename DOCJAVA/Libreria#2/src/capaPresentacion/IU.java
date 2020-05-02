
package IU;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Logica capa= new Logica();

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
        } while (opc != 4);
    }

    /**
     * muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Registrar Cliente");
        out.println("2.  Registrar Usuario");
        out.println("3.  Listar Herencia");
        out.println("4.  Salir");

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

                break;

            case 2:

                break;

            case 3:

                break;
            case 4:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

}
