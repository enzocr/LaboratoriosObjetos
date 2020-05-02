/*
Nombre del programa: Rutinas Cenfo
Descripción: Administracion de matrices de Estudiantes Cenfo
Fecha de creación:28/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:28/07/2017
Modificado por: 
 */
package ejercicios;

import java.io.*;

public class RutinasCenfo {

    private static int matrizCursos[][] = new int[10][4];

    public static void agregarNotas(int pestudiante, int pcurso, int pnota) {

        matrizCursos[pestudiante][pcurso] = pnota;

    }

    public static double promedioEstudiante(int pestudiante) {
        int nota;
        double total = 0;

        for (int i = 0; i < 4; i++) {
            nota = matrizCursos[pestudiante][i];
            total = nota + total;

        }

        return total / 4;
    }

    public static int notaMayor() {
        double nota;
        int i = 0;
        double notaMayor = 0;
        while (i < 4) {
            nota = matrizCursos[i][1];
            if (notaMayor < nota) {
                notaMayor = nota;

            }
            i++;

        }
        return i;

    }

    public static String imprimirMatriz() {
        String datos="";

        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                datos += "Nota # "+j+" del estudiante "+i+": "+matrizCursos[i][j]+" , ";
            }
            datos += "\n";
        }

        return datos;

    }

}
