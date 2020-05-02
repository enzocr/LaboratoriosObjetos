package laboratorio_1;

import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 2);
    }

    static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO----");
        out.println("1.  Empezar prediccion de ganancias");
        out.println("2.  Salir");

        out.println();
    }

    static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    public static void datosHato() throws IOException {
        int cantVacas, cantVacasCria;
        double area;
        String estacion;

        out.println("Ingresar la estacion");
        estacion = in.readLine();

        cantVacas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas vacas sin cria dispone?"));
        cantVacasCria = Integer.parseInt(JOptionPane.showInputDialog("Cuantas vacas con cria dispone?"));
        area = Integer.parseInt(JOptionPane.showInputDialog("Cuantas hectareas dispone?"));
        DecimalFormat formateador = new DecimalFormat("###,###.##");
        System.out.println(formateador.format(Rutinas.ganancias(estacion, cantVacas, cantVacasCria, area)));

    }

    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                datosHato();

                break;

            case 2:

                break;

            default:
                out.println("Opcion invalida");

        }

    }

}
