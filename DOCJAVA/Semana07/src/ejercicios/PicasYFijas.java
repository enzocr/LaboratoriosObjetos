/*
 */
package ejercicios;

import java.io.*;

public class PicasYFijas {

   
    public static void main(String[] args)throws IOException {
       
        double num=0.0;
        
        BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
        PrintStream imprimir=System.out;
       
        imprimir.println("jjjj");
        num=Integer.parseInt(leer.readLine());
        
        
        num=Math.round(num);
        
        
        imprimir.println(num);
    }
    
}
