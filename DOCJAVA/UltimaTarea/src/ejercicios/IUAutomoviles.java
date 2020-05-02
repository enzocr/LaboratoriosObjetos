/*Nombre del programa: IUAutomoviles
Descripción: Interfaz automoviles
Fecha de creación:28/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:28/07/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class IUAutomoviles {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {
        int opc;
        boolean noSalir = true;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        } while (noSalir);
    }

    static void mostrarMenu() {

        imprimir.println();
        imprimir.println("1.  Digitar cantidad de autos vendidos en 10 a;os");
        imprimir.println("2.  Agregar precio carros en 10 a;os");
        imprimir.println("3.  Averiguar el modelo mas vendido");
        imprimir.println("4.  Averiguar cuantos carros vendio un modelo especifico");
        imprimir.println("5.  Modelo con menor precio en el primer a;o");
        imprimir.println("6.  Modelo con mayor precio en el ultimo a;o");
        imprimir.println("7.  Promedio precios del modelo #1");
        imprimir.println("8.  Salir");

    }

    static int leerOpcion() throws java.io.IOException {

        int opcion;

        imprimir.print("Seleccione su opcion: ");
        opcion = Integer.parseInt(leer.readLine());
        imprimir.println();

        return opcion;
    }

    static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        boolean noSalir = true;

        switch (popcion) {

            case 1: //Cantidad de carros vendidos en a;os
                guardarCantCarros();

                break;

            case 2:// Precio carros
                guardarPrecioCarros();

                break;

            case 3: //Modelo mas vendido
                imprimir.println("El modelo mas vendido es el: " + RutinasAutomoviles.mejorAnio());

                break;

            case 4: //Cantidad de autos vendidos para X modelo
                int modelo;
                imprimir.println("De cual modelo desea saber la cantidad total de autos vendidos");
                modelo = Integer.parseInt(leer.readLine());
                imprimir.println(RutinasAutomoviles.calcularCarrosVendidos(modelo));

                break;

            case 5://menor precio primer anio

                imprimir.println("El modelo con el menor precio en el primer a;o fue el # " + RutinasAutomoviles.menorPrecioPrimerAnio());

                break;

            case 6://Mayor precio ultimo a;o
                imprimir.println("El modelo con el mayor precio en el ultimo a;o fue el # " + RutinasAutomoviles.mayorPrecioUltimoAnio());

                break;

            case 7:
                imprimir.println("El modelo #1 tiene un promedio en sus precios de " + RutinasAutomoviles.promedioUno());
                break;

            case 8: //Salir de la aplicacion
                noSalir = false;

                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                imprimir.println("Opcion invalida");
                imprimir.println();
                break;
        }
        return noSalir;
    }

    static void guardarCantCarros() throws IOException {
        int carros;
        for (int i = 0; i <4; i++) {
            for (int j =0; j < 10; j++) {
                imprimir.println("Digite la cantidad de carros del modelo " + (i+1) + " vendidos en el a;o " + (j+1));
                carros= solicitarCantCarros();
                RutinasAutomoviles.matrizNumCarros(carros, i, j);

            }
        }

    }

    static void guardarPrecioCarros() throws IOException {
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <10; j++) {
                imprimir.println("Digite el precio del modelo " + (i+1) + " en el a;o " + (j+1));
                int precio = solicitarPrecioCarros();
                RutinasAutomoviles.matrizPrecioCarros(i, precio, j);

            }

        }
    }

    static int solicitarCantCarros() throws IOException {

        int cantCarros = Integer.parseInt(leer.readLine());
        return cantCarros;

    }

    static int solicitarPrecioCarros() throws IOException {
        int precioCarros = Integer.parseInt(leer.readLine());
        return precioCarros;
    }

}
