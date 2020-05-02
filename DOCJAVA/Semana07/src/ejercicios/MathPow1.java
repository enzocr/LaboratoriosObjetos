/*Nombre del programa: Potencia Y Exponentes de numeros
Descripción:Use las funciones factorial y pow para calcular el resultado
de la siguiente serie en un programa principal:
x + x2/2! + x3/3! + ...+ xn/n!
Fecha de creación:28/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:28/06/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class MathPow1 {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {

        double x, num, fact;
        double cont = 1;
        double resultado = 0;
        char salir=' ';

        imprimir.println("Digite el numero X");
        x = Integer.parseInt(leer.readLine());
       

        do {
            num = calcularNum(x, cont);
            fact=calcularFact(cont);
            
            resultado = resultado + (num / fact);

            cont = cont + 1;
            
            imprimir.println("Desea salir?");
            salir=leer.readLine().charAt(0);

        }while(salir!='S');
        
        imprimirResultado(resultado);

    }//fin main

    static double calcularNum(double px, double pcont) {
        double elNum = 0;

        elNum = Math.pow(px, pcont);

        return elNum;
    }

    static double calcularFact(double pcont) {

        double fact=1, contf=1;
        
        
        while (pcont>=contf) {
             
            fact=fact*contf;
            contf=contf+1;
        }
        return fact;
    }

    static void imprimirResultado(double presultado) throws
            IOException {

        imprimir.println("El resultado es " + presultado);

    }

}//fin programa
