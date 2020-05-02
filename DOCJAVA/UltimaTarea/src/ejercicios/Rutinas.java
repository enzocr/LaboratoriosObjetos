/*
Nombre del programa: Rutinas Matriz filas y columnas
Descripción: Matriz Filas y columnas
Fecha de creación:27/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:27/07/2017
Modificado por: 
*/


package ejercicios;

import java.io.*;

public class Rutinas {

    static int matriz[][];
    static int indiceC = 0, indiceF = 0;

    public static void crearMatriz(int pfila, int pcolumna) {

        matriz = new int[pfila][pcolumna];
        indiceC = pfila;
        indiceF = pcolumna;

    }

    public static int cantFilas(){
        return matriz.length;
        
        
    }
    
    public static int cantColumnas(){
        return matriz[0].length;
        
        
    }
    
    
    public static void agregarMatriz(int pfila, int pcolumna, int pdato) {

        matriz[pfila][pcolumna] = pdato;

    }

    public static String imprimirMatriz() {
        String datos="";
        for (int i = 0; i < indiceF; i++) {
            for (int j = 0; j < indiceC; j++) {
                datos+=matriz[i][j] +" - ";
            }
            datos+="\n";
        }
        return datos;
    }
    
    

    public static double promedioFila(int pfilaP) {
        double total = 0;
        

        for (int j = 0; j < indiceC; j++) {
            total += matriz[pfilaP][j];
           
        }
        return total/indiceC;

    }

    public static double promedioColumna(int pcolumnaP) {
        double total = 0;
        for (int j = 0; j < indiceF; j++) {
            total += matriz[j][pcolumnaP];
        }
        return total/indiceF;

    }

    public static double promedioGeneral() {
        double total = 0;
        for (int i = 0; i < indiceF; i++) {
            for (int j = 0; j < indiceC; j++) {
                total += matriz[i][j];
            }
            

        }
        return total/(indiceC+indiceF);

    }
}
