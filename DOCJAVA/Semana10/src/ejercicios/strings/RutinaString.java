/*1. Suponga que tiene un arreglo de String’s en donde
guarda los nombres de varias personas:
a. Haga un procedimiento que lea un arreglo de String’s del
tamaño que el usuario decida
b. Haga un procedimiento que imprima un arreglo de
String’s.
c. Haga un procedimiento que cambie a Mayúsculas todos
los nombres guardados en el arreglo.
d. Haga una función que retorne la posición donde se
encuentra un nombre dado, o –1 si el nombre no se
encuentra en el arreglo.
e. Haga un programa principal donde se prueben las
anteriores funciones.
 */
package ejercicios.strings;

import java.io.*;

public class RutinaString {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;	// variables objetos in y out para

    static String arreglo[];

    static void leerArreglo(int ptam) throws IOException {
        arreglo = new String[ptam];
        int i;
        for (i = 0; i < arreglo.length; i++) {
            imprimir.println("Digite la palabra");
            arreglo[i] = (leer.readLine());

        }

    }

    static String imprimirArreglo(int ptam) throws IOException {
        int i;
        String datos = "";
        for (i = 0; i < arreglo.length; i++) {
            datos += arreglo[i] + "-";

        }
        return datos;

    }

    static void imprimirMayus(int ptam) throws IOException {
        int i;
        String datos = "";
        for (i = 0; i < arreglo.length; i++) {
            datos = arreglo[i].toUpperCase();
            imprimir.print(datos + " - ");

        }

    }

    static void buscarPosicion(int ptam) throws IOException {
        String posicion = "";
        int i = 0;
        imprimir.println("Digite la palabra a la cual desea encontrarle la posicion?");
        posicion = leer.readLine();
        for (i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(posicion)) {

                imprimir.println("El String " + posicion + " se encuentra en la posicion " + i);
            }

        }
    }
}
