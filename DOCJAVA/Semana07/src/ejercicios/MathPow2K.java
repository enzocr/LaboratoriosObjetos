/*Nombre del programa: Potencia Y Exponentes de numeros 2.0 K
Descripción:Use las funciones factorial y pow para calcular el resultado
de la siguiente serie en un programa principal:
x/k! + x2/k! + x3/k! + ...+ xn/k!
Fecha de creación:29/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:29/06/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class MathPow2K {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;
    static double k;

    public static void main(String[] args) throws IOException {
        double x, cont = 1;
        double num, factK;
        double resultado = 0;
        char salir = ' ';

        imprimir.println("Digite K");
        k = Integer.parseInt(leer.readLine());

        imprimir.println("Digite X");
        x = Integer.parseInt(leer.readLine());

        do {
            num = calcularNum(x, cont);
            factK = calcularK(k);

            resultado = resultado + (num / factK);

            imprimir.println("Desea salir por "+(cont)+"da vez");
            salir = leer.readLine().charAt(0);
            
            cont = cont + 1;

        } while (salir != 'S');
        imprimirResultado(resultado);

    }//fin main

    static double calcularNum(double px, double pcont) {
        double elNum;

        elNum = Math.pow(px, pcont);
        return elNum;
    }

    static double calcularK(double pk) {
        double contK = 1;
        double factorial = 1;
        while (contK <= pk) {
            factorial = factorial * contK;
            contK = contK + 1;
        }return factorial;

    }
    
    static void imprimirResultado(double presultado)throws IOException{
        imprimir.println("El resultado es " + presultado);
    
    }

}
