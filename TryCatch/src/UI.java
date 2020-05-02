
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static int[] notas = new int[3];

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
     * Muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Llenar Arreglo ");
        out.println("2.  ");
        out.println("3.  ");
        out.println("4.  Salir");

        out.println();
    }

    /**
     * Parsea opcion digitada por el usuario y la retorna
     *
     * @return opcion
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     * Ejecuta un metodo, depende de la opcion escogida por el usuario
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                try {
                    out.println("El promedio es: " + llenarArreglo());
                } catch (NumberFormatException error) {
                    out.println(error.getMessage());
                }
                break;

            case 2:
           
                break;
            case 3:

                break;

            case 4:

        }
    }

    public static double llenarArreglo() throws IOException {
        int cantidad, num;
        double promedio;
        // int cantidad = notas.length;

        for (int i = 0; i < notas.length; i++) {

            out.println("Digite un numero");
            num = Integer.parseInt(in.readLine());
            notas[i] = num;

        }

        promedio = promedioArreglo();
        return promedio;
    }

    public static double promedioArreglo() {
        int promedio = 0;
        double cantidad = notas.length;

        for (int i = 0; i < cantidad; i++) {
            promedio += notas[i];
        }
        return promedio / cantidad;
    }

}
