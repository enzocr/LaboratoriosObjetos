/*Nombre del programa: Rutinas juego gato
Descripción: Rutinas del juego gato
Fecha de creación:29/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:29/07/2017
Modificado por: */
package ejercicios;

import java.io.*;

public class RutinasGato {

    private static final int gato[][] = new int[3][3];

    private static final char[][] juego = new char[3][3];
    static int turnos = 0;

    public static int buscarJugada(int pfila, int pcolumna) {

        if ('X' == juego[pfila][pcolumna] || 'O' == juego[pfila][pcolumna]) {
            return -1;

        } else {
            return 1;

        }

    }

    public static int buscarEmpate() {
        int empate = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (comprobarX() == -1) {
                    empate += 1;
                }
                if (comprobarO() == - 1) {
                    empate += 1;
                }
            }
        }
        if(empate==16){
            return -1;
        }
        
        
        return 1;
    }

    public static void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                juego[i][j] = '_';
            }
        }
    }

    public static void agregaPosicionX(int pfila, int pcolumna) {

        juego[pfila][pcolumna] = 'X';

    }

    public static void agregaPosicionO(int pfila, int pcolumna) {

        juego[pfila][pcolumna] = 'O';

    }

    public static int confirmar(int fila, int columna) {

        if ('X' == juego[fila][columna] || 'O' == juego[fila][columna]) {
            return -1;

        } else {
            return 1;

        }

    }

    static int comprobarX() {

        if (juego[0][0] == 'X' && juego[0][1] == 'X' && juego[0][2] == 'X') {
            return 1;

        }
        if (juego[1][0] == 'X' && juego[1][1] == 'X' && juego[1][2] == 'X') {
            return 1;

        } else if (juego[2][0] == 'X' && juego[2][1] == 'X' && juego[2][2] == 'X') {
            return 1;

        }
        if (juego[0][0] == 'X' && juego[1][0] == 'X' && juego[2][0] == 'X') {
            return 1;

        }
        if (juego[0][1] == 'X' && juego[1][1] == 'X' && juego[2][1] == 'X') {
            return 1;

        }
        if (juego[0][2] == 'X' && juego[1][2] == 'X' && juego[2][2] == 'X') {
            return 1;

        }

        if (juego[0][0] == 'X' && juego[1][1] == 'X' && juego[2][2] == 'X') {
            return 1;

        }
        if (juego[0][2] == 'X' && juego[1][1] == 'X' && juego[2][0] == 'X') {
            return 1;

        }
        return -1;

    }

    static int comprobarO() {

        if (juego[0][0] == 'O' && juego[0][1] == 'O' && juego[0][2] == 'O') {
            return 1;

        }
        if (juego[1][0] == 'O' && juego[1][1] == 'O' && juego[1][2] == 'O') {
            return 1;

        } else if (juego[2][0] == 'O' && juego[2][1] == 'O' && juego[2][2] == 'O') {
            return 1;

        }
        if (juego[0][0] == 'O' && juego[1][0] == 'O' && juego[2][0] == 'O') {
            return 1;

        }
        if (juego[0][1] == 'O' && juego[1][1] == 'O' && juego[2][1] == 'O') {
            return 1;

        }
        if (juego[0][2] == 'O' && juego[1][2] == 'O' && juego[2][2] == 'O') {

        }

        if (juego[0][0] == 'O' && juego[1][1] == 'O' && juego[2][2] == 'O') {
            return 1;

        }
        if (juego[0][2] == 'O' && juego[1][1] == 'O' && juego[2][0] == 'O') {
            return 1;

        }
        return -1;

    }

    public static String imprimir() {
        String despliegue = "";

        despliegue += "            0   1   2\n";
        despliegue += "        0   " + juego[0][0] + " | " + juego[0][1] + " | " + juego[0][2] + "   0\n";
        despliegue += "           ----------- \n";
        despliegue += "        1   " + juego[1][0] + " | " + juego[1][1] + " | " + juego[1][2] + "   1\n";
        despliegue += "           ----------- \n";
        despliegue += "        2   " + juego[2][0] + " | " + juego[2][1] + " | " + juego[2][2] + "   2\n";
        despliegue += "            0   1   2\n";

        return despliegue;

    }

}
