/*Nombre del programa: Notas
Descripción:Suponga que tiene que guardar en un arreglo de reales las notas del
curso de Programación 1, pero no se sabe con anterioridad
cuántos estudiantes hay en el curso. Usted debe:
1. Declarar un arreglo de reales llamado notas.
2. Preguntarle al usuario cuántos alumnos tiene el curso y reservar
el espacio en memoria para ello.
3. Leer el arreglo notas.
4. Imprimir el arreglo notas.
5. Calcular el promedio de las notas del curso e imprimirlo.
6. Calcular la mayor nota e imprimir la nota y el estudiante que la
obtuvo (el estudiante corresponde al índice de la mayor nota).
Fecha de creación:06/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:06/07/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class Notas {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;
    
    static double sumaNotas;

    public static void main(String[] args) throws IOException {

        double[] notas;
        int alumnos;
        
        

        imprimir.println("Cuantos alumnos tiene el curso?");
        alumnos = Integer.parseInt(leer.readLine());

        notas = new double[alumnos];

        leerNotas(notas);

        imprimirNotas(notas);

        sumaNotas=sumaNotas(notas); imprimir.println("La suma total de las notas es de: "+sumaNotas);
        
        promedioNotas(notas);
        
        calcularMayor(notas);
        
       
       

    }

    static void leerNotas(double notas[]) throws IOException {
        int i;
        for (i = 0; i < notas.length; i++) {
            imprimir.println("Digite la nota");
            notas[i] = Double.parseDouble(leer.readLine());
        }

    }

    static void imprimirNotas(double notas[]) throws IOException {
        int i;
        for (i = 0; i < notas.length; i++) {
            imprimir.println(notas[i]);
           
        }

    }

    static double sumaNotas(double notas[]) throws IOException {
        int i;
        double sumaNotas=0;
        for (i = 0; i < notas.length; i++) {

            sumaNotas = sumaNotas + notas[i] ;
            
        }
        return sumaNotas;

    }
    
    static void  promedioNotas(double notas[])throws IOException{
       
        double promedio;
        promedio=sumaNotas/notas.length;
        imprimir.println("El promedio de las notas es: "+promedio);
    }
    
    static void calcularMayor(double notas[])throws IOException{
       int i; int k; double temporal;

        for (i = notas.length - 1; i > 0; i--) { //Controla los recorridos

            for (k = 0; k < i; k++) { //Va comparando

                if (notas[k] > notas[k + 1]) {
                    temporal = notas[k]; // intercambia
                    notas[k] = notas[k + 1];
                    notas[k + 1] = temporal;
                }

            }
        } imprimir.println("La nota mayor es: "+notas[notas.length-1]);
       
       }
   
       
    
    }

    
    

