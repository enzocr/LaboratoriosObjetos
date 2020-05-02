/*
Nombre del programa: Minimo y maximo
Descripción:una función que retorne el máximo entre dos números y otra que retorne el
mínimo entre dos números. Pruébelas en un main.
Fecha de creación:22/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:22/06/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;//libreria

public class Maximosyminimos {
    
    //variables globales
        //se usan en varias rutinas y al igual que estas, deben ser static
        static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        static PrintStream imprimir=System.out;

    public static void main(String[] args) throws IOException {
      
        //Variables de entrada
        int num1 = 0, num2 = 0;
        //Variables de salida
        int mayor = 0, menor = 0;

        imprimir.println("Digite el primer numero");
        num1 = Integer.parseInt(leer.readLine());

        imprimir.println("Digite el segundo numero");
        num2 = Integer.parseInt(leer.readLine());

        //Rutina con dos parametros actuales
        mayor = calcularElMayor(num1, num2);
        menor = calcularElMenor(num1, num2);
        //Procedimiento  que no se asigna a variable
        imprimirResultado(mayor, menor);

    }//fin del main

    static int calcularElMayor(int pnum1, int pnum2) {
        //Se reciben dos parametros formales
        int elMayor = 0;
        if (pnum1 > pnum2) {
            elMayor = pnum1;
        } else {
            elMayor = pnum2;
        }
        return elMayor;

    }

    static int calcularElMenor(int pnum1, int pnum2) {
        int elMenor = 0;
        if (pnum1 < pnum2) {
            elMenor = pnum1;
        } else {
            elMenor = pnum2;
        }

        return elMenor;

    }

    static void imprimirResultado(int pmayor, int pmenor) throws IOException {
        
        
        imprimir.println("El valor mayor es "+pmayor+" y el valor menor es "+pmenor);

    }//fin imprimir resultado

}//fin del programa
