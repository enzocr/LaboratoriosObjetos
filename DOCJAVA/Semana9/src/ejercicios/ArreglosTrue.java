/*Nombre del programa: Arreglos True or False
Descripción:Haga una función que reciba dos arreglos de enteros y que retorne
true si los arreglos son iguales o false si no. Pruébela en un
programa (diferente al del ejercicio 1).
Fecha de creación:09/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:09/07/2017
Modificado por: */
package ejercicios;

import java.io.*;

public class ArreglosTrue {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {

        int arreglos1[];
        int arreglos2[];
        int tam1;
        int tam2;
        int a1, a2;
        boolean resultado = false;
        int resultadoA = 0;

        imprimir.println("Tama;o del arreglo 1?");
        tam1 = Integer.parseInt(leer.readLine());

        imprimir.println("Tama;o del arreglo 2?");
        tam2 = Integer.parseInt(leer.readLine());

        if (tam1 == tam2) {
            arreglos1 = new int[tam1];

            arreglos2 = new int[tam2];

            leerArreglos1(arreglos1);

            leerArreglos2(arreglos2);
            
            resultadoA = calcularArreglos(arreglos1, arreglos2);
            if (resultadoA > 0) {
                resultado=true;
                imprimir.println(true);
            } else {
                resultado=false;
                imprimir.println(false);
            }

        } else {
            resultado=false;
            imprimir.println(false);
        }

    }

    static void leerArreglos1(int parreglos1[]) throws IOException {
        int i;
        for (i = 0; i < parreglos1.length; i++) {
            imprimir.print("Digite el numero del arreglo 1: ");
            parreglos1[i] = Integer.parseInt(leer.readLine());
        }
    }

    static void leerArreglos2(int parreglos2[]) throws IOException {
        int i;
        for (i = 0; i < parreglos2.length; i++) {
            imprimir.print("Digite el numero del arreglo 2: ");
            parreglos2[i] = Integer.parseInt(leer.readLine());
        }
    }

    static int calcularArreglos(int parreglos1[], int parreglos2[]) throws IOException {
        int i;
        for (i = 0; i < (parreglos2.length) || i < (parreglos1.length); i++) {
            if (parreglos1[i] == parreglos2[i]) {return 1;
            } else {
                return -1;
            }

        }
        return 1;

    }

}
