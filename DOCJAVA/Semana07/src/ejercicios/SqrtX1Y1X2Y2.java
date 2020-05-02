/*Nombre del programa: SQRT DE X1Y1 YX2Y2
Descripción:Dados un punto (X1, Y1) y otro punto (X2, Y2), use la
función sqrt de la librería Math para calcular la distancia
entre los dos puntos. Para esto Ud. debe definir la función
que calcule la distancia y usarla desde un main.
x/k! + x2/k! + x3/k! + ...+ xn/k!
Fecha de creación:29/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:29/06/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class SqrtX1Y1X2Y2 {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {
        double x1, y1;
        double x2, y2;
        double distancia;

        imprimir.println("Digite X1");
        x1 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite Y1");
        y1 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite X2");
        x2 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite Y2");
        y2 = Integer.parseInt(leer.readLine());

        distancia = calcularDistancia(x1, y1, x2, y2);
        imprimirResultado(distancia);
    }//fin main

    static double calcularDistancia(double px1, double py1, double px2, double py2) {
        double distanciaTotal, distancia1, distancia2;

        distancia1 = Math.sqrt((px1) + (py1));
        distancia2 = Math.sqrt((px2) + (py2));
        distanciaTotal = distancia1 - distancia2;

        return distanciaTotal;

    }

    static void imprimirResultado(double pdistancia) throws IOException {
        imprimir.println("La distancia entre ambos puntos es de " + pdistancia);

    }

}
