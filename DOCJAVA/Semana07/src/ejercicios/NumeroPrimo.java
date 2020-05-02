/*Utilice la función que dice si un número entero es primo o
no, para imprimir los números primos desde 1-100, en un
programa en Java.
 */
package ejercicios;

import java.io.*;

public class NumeroPrimo {

    public static void main(String[] args) throws IOException {

        int num = 1;

        int resultado = 0;

        while (num <= 100) {
            resultado = calcularNum(num++);
            if (resultado != 0) {
                System.out.print(resultado + "-");

            }

        }
    }//fin main

    static int calcularNum(int pnum) {
        int cont = 1;
        int pcontPrimos = 0;

        while (cont <= pnum) {
            if (pnum % cont == 0) {
                pcontPrimos = pcontPrimos + 1;
                cont = cont + 1;
            } else {
                cont = cont + 1;
            }

        }
        if (pcontPrimos == 2) {
            return pnum;
        } else {
            return 0;

        }
    }
}
