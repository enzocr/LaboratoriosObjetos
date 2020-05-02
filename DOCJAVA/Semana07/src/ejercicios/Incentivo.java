/*
Nombre del programa: Incentivo
Descripción: En una fábrica de mesas se les da un incentivo
a los trabajadores. Si producen entre 11 y 25
mesas el incentivo es un 5% del salario, si
producen más de 25 es de un 10%. Diseñe e
implemente una función que recibe la cantidad
de mesas y el salario, y retorna el monto del
incentivo.
Fecha de creación:22/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:22/06/2017

 */
package ejercicios;

import java.io.*;

public class Incentivo {

   static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
   static PrintStream imprimir=System.out;
    
    public static void main(String[] args) throws IOException{
        int salario=0, mesas=0;
        double incentivo=0;
        
        imprimir.println("Digitar salario");
        salario=Integer.parseInt(leer.readLine());
        
        imprimir.println("Digitar cantidad de mesas");
        mesas=Integer.parseInt(leer.readLine());
        
        incentivo=calcularIncentivo(salario, mesas);
        imprimirResultado(incentivo);
        
        
    }//fin main
 
    static double calcularIncentivo(int psalario, int pmesas){
        double elIncentivo=0;
        
        if(pmesas<11){elIncentivo=0;}
            else if(11<pmesas && pmesas<25){elIncentivo=psalario*0.05;}
            else{elIncentivo=psalario*0.10;}
        
        return elIncentivo;
            
    
    }
    
    static void imprimirResultado (double pincentivo) throws IOException{
    
        imprimir.println("El incentivo sera de "+pincentivo+" colones");
        
    }
    
    
    
}
