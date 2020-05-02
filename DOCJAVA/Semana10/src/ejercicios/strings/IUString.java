/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.strings;

import java.io.*;

public class IUString {
    
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;	// variables objetos in y out para

   
    public static void main(String[] args) throws IOException  {
        
        
        
        int tam;
        imprimir.println("Digite el tama;o del arreglo");
        tam=Integer.parseInt(leer.readLine());
        
        
        RutinaString.leerArreglo(tam);
        
        imprimir.println(RutinaString.imprimirArreglo(tam));
        
        RutinaString.imprimirMayus(tam);
        
        //hablarle aqui al usuario
        RutinaString.buscarPosicion(tam);
        
        
        
        
        
    }
    
}
