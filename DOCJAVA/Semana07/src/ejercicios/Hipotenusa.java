/*
Nombre del programa: Hipotenusa
Descripción: Haga una función que dado dos lados de
un triángulo, calcule la hipotenusa.
Pruébela en un main.
Fecha de creación:22/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:22/06/2017

 */
package ejercicios;

import java.io.*;

public class Hipotenusa {
    
    static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir=System.out;

    public static void main(String[] args)throws IOException {
        double lado1=0.0, lado2=0.0;
        double hipotenusa=0;
        
        imprimir.println("Cuanto mide el lado 1?");
        lado1=Integer.parseInt(leer.readLine());
        
        imprimir.println("Cuanto mide el lado 2?");
        lado2=Integer.parseInt(leer.readLine());
        
        hipotenusa=calcularHipo(lado1, lado2);
        imprimirResultado(hipotenusa);
       
    }//fin main
    
    static double calcularHipo (double plado1, double plado2){
        
      double hipo=0;
      hipo=Math.hypot(plado1, plado2);
      
      return hipo;
}
    
    static void imprimirResultado (double phipotenusa) throws IOException{
    
    imprimir.println("La hipotenusa del trangulo es "+phipotenusa);
    
    }
}
