/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;
import javax.swing.JOptionPane;

public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static void mostrarMenu() throws IOException {
        int opc;

        do {
            out.println();
            out.println("1.  Ingresar Video");
            out.println("2.  Listar Video");
            out.println("3.  Salir");
            out.println();
            opc = leerOpcion();
            out.println("La opcion ingresada fue " + opc);
            ejecutarAccion(opc);

        } while (opc != 3);

    }

    static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1://pedir la informacion del video para almacenarlo en el arreglo
                ingresarVideo();
                break;

            case 2://llama a la rutina que imprime la lista de videos
                imprimirVideos();

                break;
            case 3:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    public static void imprimirVideos() throws IOException {
        out.println("IMPRIMIENDO LISTA DE VIDEOS");
        for (int i = 0; i < CL.getVideos().length; i++) {
            out.println(CL.getVideos()[i]);
        }

    }

    public static void ingresarVideo() throws IOException {
        String nombre;
        int i = 0;
        while (i < 5) {
            out.println("Ingresar el nombre de la pelicula");
            nombre = in.readLine();
            //llamo al arreglo de la capa logica
            CL.registrarVideos(nombre);
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        mostrarMenu();
    }

}
