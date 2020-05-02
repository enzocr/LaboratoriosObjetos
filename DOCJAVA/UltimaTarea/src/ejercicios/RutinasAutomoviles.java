/*Nombre del programa: Rutinas Automoviles
Descripción: Rutinas matrices de automoviles
Fecha de creación:28/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:28/07/2017
Modificado por: 
 */


package ejercicios;

import java.io.*;

public class RutinasAutomoviles {

    private static int matrizCantCarros[][] = new int[4][10];
    private static int matrizPrecioCarro[][] = new int[4][10];

    public static void matrizNumCarros(int pcantCarros, int pmodelo, int panio) {
        matrizCantCarros[pmodelo][panio] = pcantCarros;

    }

    public static void matrizPrecioCarros(int pmodelo, int pprecio, int panio) {

        matrizPrecioCarro[pmodelo][panio] = pprecio;

    }

    public static int mejorAnio() {

        int i, indice = 0;
        int mayorCantidadCarros = 0;
        int carrosAnio;

        for (i = 0; i <4; i++) {

            carrosAnio = calcularCarrosVendidos(i);

            if (carrosAnio > mayorCantidadCarros) {

                mayorCantidadCarros = carrosAnio;
                indice = i+1;
            }
        }

        return indice;
    }

    public static int mayorPrecioUltimoAnio() {
        int i;
        int modelo=0;
        for (i = 0; i <4; i++) {
            if (matrizPrecioCarro[i][9] > matrizPrecioCarro[modelo][9]) {
                modelo = i;

            }

        }
        return modelo+1;
    }

    public static int menorPrecioPrimerAnio() {
        int i;
        int modelo = 0;
        for (i = 0; i <4; i++) {
            if (matrizPrecioCarro[i][1] < matrizPrecioCarro[modelo][1]) {
                modelo = i;

            }

        }
        return modelo+1;

    }

    public static int calcularCarrosVendidos(int pmodelo) {
        int cantidadCarros, total = 0;

        for (int j =0; j < 10; j++) {

            cantidadCarros = matrizCantCarros[pmodelo][j];
            total += cantidadCarros;
        }

        return total;
    }

    public static double  promedioUno() {
        double total = 0;
        int precio;
        for (int i = 0; i < 10; i++) {
            precio = matrizPrecioCarro[0][i];
            total += precio;

        }
        return total/10;

    }
}
