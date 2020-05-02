/*Nombre del programa: Ventas
Descripción:Haga Modelaje, Algoritmo y Programa en Java para:
1. Suponga que trabaja en un almacén y necesita guardar los
valores de las ventas de cada día hábil de la semana. Para esto
usted tiene un arreglo con las ventas de cada día de la semana,
suponga que sólo hay 6 días hábiles. Haga un programa que
calcule el total de ventas de la semana.
2. Modifique el programa del punto 1, para que ahora también
imprima todas las ventas de la semana.
3. Modifique el programa del punto 1, para que ahora también
imprima la mayor venta de la semana.
4. Modifique el programa del punto 1, para que ahora también
averigüe si hay alguna venta de la semana que fue mayor o
igual a $500, e imprima el día correspondiente a esa venta.
Fecha de creación:07/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:07/07/2017
 */
package ejercicios;

import java.io.*;


public class Ventas {
    
    static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir=System.out;

   
    public static void main(String[] args)throws IOException {
        
        int sumaVentas=0;
        int[]ventas=new int[6];
        
        for(int cont=0; cont<6;cont++){
            imprimir.println("Digite el total de la venta del dia "+(cont+1+" :"));
            ventas[cont]=Integer.parseInt(leer.readLine());
            sumaVentas=sumaVentas+ventas[cont];
            
            imprimir.println("El total de ventas es: "+sumaVentas);
            
        for(int cont1=0;cont1<6;cont1++){
        
        if(ventas[cont1]>=500){imprimir.println("El dia "+(cont1+1)+" se vendieron mas de 500 dolares");}
        else{}
        
        
        
        
        
        }
                 
  
            
        
        
        }
      
    }
    
}
