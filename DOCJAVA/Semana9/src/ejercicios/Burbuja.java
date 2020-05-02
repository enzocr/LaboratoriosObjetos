/*Nombre del programa: Arreglo enteros y ejercicio burbuja visto en clase
Descripción:Haga Modelaje, Algoritmo y Programa en Java para:
1. Pruebe las funciones dadas en esta clase en un programa en Java
que lea un arreglo de enteros y calcule el promedio del arreglo (el
usuario decide cuántos elementos tiene el arreglo).
2. Haga un procedimiento que imprima un arreglo de enteros y
pruébelo en el programa del ejercicio 1.
3. Haga una función que calcule el mayor de un arreglo de enteros y
pruébela en el programa del ejercicio 1.
Fecha de creación:09/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:09/07/2017
Modificado por: 

 */
package ejercicios;

import java.io.*;
    
public class Burbuja {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {

        int arreglo[];

        int tam;
        
        double promedio;
        
        

        imprimir.println("Digite el tama;o del arreglo");
        tam = Integer.parseInt(leer.readLine());

        arreglo = new int[tam];

        leerArreglo(arreglo);

        ordenamientoBurbuja(arreglo);

        imprimirArreglo(arreglo);
        
        promedio=promedioArreglo(arreglo);imprimir.println("El promedio de los arreglos es: "+promedio);
        
        calcularMayor(arreglo);
    }

    static void leerArreglo(int a[]) throws IOException {
        int i;
        for (i=0;i<a.length;i++){
            System.out.print("Digite el numero");
            a[i]=Integer.parseInt(leer.readLine());
            
    }}

    static void ordenamientoBurbuja(int a[]) throws IOException {

        int i, k, temporal;

        for (i = a.length - 1; i > 0; i--) { //Controla los recorridos

            for (k = 0; k < i; k++) { //Va comparando

                if (a[k] > a[k + 1]) {
                    temporal = a[k]; // intercambia
                    a[k] = a[k + 1];
                    a[k + 1] = temporal;
                }

            }
        }
    }

    static void imprimirArreglo(int a[]){
        int i;
        
        for (i=0;i<a.length;i++){
           imprimir.println("El numero "+(i+1)+" es "+a[i]);
           
          
        }
        
    }
    
    static  double promedioArreglo(int a[]){
        int i;
        double sumaNotas=0;
        double promedio=0;
        for (i = 0; i < a.length; i++) {

            sumaNotas = sumaNotas + a[i] ;
            promedio=sumaNotas/(a.length);
            
        }
        return promedio;
    }
    
    static void calcularMayor(int a[])throws IOException{
        int i; int k; int temporal;

        for (i = a.length - 1; i > 0; i--) { //Controla los recorridos

            for (k = 0; k < i; k++) { //Va comparando

                if (a[k] > a[k + 1]) {
                    temporal = a[k]; // intercambia
                    a[k] = a[k + 1];
                    a[k + 1] = temporal;
                }

            }
        } imprimir.println("El numero mayor es: "+a[a.length-1]);
        
    }
}
