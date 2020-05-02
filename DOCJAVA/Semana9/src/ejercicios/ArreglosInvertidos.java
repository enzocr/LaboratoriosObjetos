/*Nombre del programa: Arreglos Invertidos
Descripción:Haga una función (o procedimiento?) que invierta un arreglo de
enteros, sin usar un arreglo adicional. Pruébela en un programa
que lea el arreglo original y lo inverta e imprima el arreglo
invertido.
Fecha de creación:09/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:09/07/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class ArreglosInvertidos {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;
    static int tam;

    public static void main(String[] args) throws IOException {
        int arreglo[];

        imprimir.println("Digite el tama;o del arreglo");
        tam = Integer.parseInt(leer.readLine());

        arreglo = new int[tam];

        leerArreglo(arreglo);

        invertirArreglo(arreglo, tam);

    }

    static void leerArreglo(int parreglo[]) throws IOException {
        int i;
        for (i = 0; i < parreglo.length; i++) {
            imprimir.println("Digite el numero");
            parreglo[i] = Integer.parseInt(leer.readLine());
        }

    }

    static void invertirArreglo(int parreglo[], int tam) throws IOException {

        int i, k, temporal;
        int b=parreglo.length;
        for (i = 0, k=(tam-1); i< b-1; i++, k--) {
            
            
            temporal=parreglo[i];
            parreglo[i] = parreglo[k];
            parreglo[k]=temporal;
            
             imprimir.print(temporal+" - ");
             
              

        }
       
        
        
        
           
        

    }

}
