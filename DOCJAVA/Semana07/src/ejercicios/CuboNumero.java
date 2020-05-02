/*Nombre del programa: CuboNumero
Descripción:Haga una función que calcule el cubo de un número. Pruébela en un main.
Fecha de creación:22/06/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:22/06/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;


public class CuboNumero {
    
    static BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
    static PrintStream imprimir=System.out;

   
    public static void main(String[] args) throws IOException{
       int num=0;
       int cubo=0;
       
       imprimir.println("Digite el numero");
       num=Integer.parseInt(leer.readLine());
       
       cubo=calcularCubo(num);
       
       imprimirResultado(cubo);
       
    }
    
    static int calcularCubo (int pnum){
        int elCubo=0;
        elCubo=pnum*pnum*pnum;
        
        return elCubo;
    
    
    }
    
    static void  imprimirResultado (int pcubo)throws IOException{
    
        imprimir.println("El cubo del numero es "+pcubo);
    }
    
}
