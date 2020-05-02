/*Nombre del programa: Tres numeros y el minimo
Descripción: Haga una función que calcule el mínimo
de 3 números reales. Pruébela en un main
Fecha de creación:22/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:22/06/2017
main.
 */
package ejercicios;

import java.io.*;

public class TresNumerosMinimos {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {
        int num1 = 0, num2 = 0, num3 = 0;
        int numeroMenor=0;

        imprimir.println("Digite el num1");
        num1 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite el num2");
        num2 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite el num3");
        num3 = Integer.parseInt(leer.readLine());

        numeroMenor = calcularMenor(num1, num2, num3);
        imprimirResultado (numeroMenor);

    }//fin main

    static int calcularMenor(int pnum1, int pnum2, int pnum3) {
        int elMenor = 0;
        if (pnum1 < pnum2) {
            if (pnum1 < pnum3) {
                elMenor = pnum1;
            } else {
                elMenor = pnum3;
            }
        } else if (pnum2 < pnum3) {
            elMenor = pnum2;
        } else {
            elMenor = pnum3;
        }
        return elMenor;

    }

    static void imprimirResultado(int pMenor) throws IOException {

        imprimir.println("El numero menor es el " + pMenor);
    }

}
