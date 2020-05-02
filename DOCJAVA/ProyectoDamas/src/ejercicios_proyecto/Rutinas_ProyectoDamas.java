/*Nombre del programa: Rutinas_ProyectoDamas
Descripción: Creacion de validaciones y calculos de la aplicacion
de damas chinas.
Fecha de creación:09/08/2017
Autor: Enzo Quartino Zamora, John Hewitt, Mariano Monge, Lindsay Rodriguez
Fecha de modificación:16/08/2017
Modificado por: Enzo Quartino Zamora, John Hewitt,
Mariano Monge, Lindsay Rodriguez

***La aplicacion es semifuncional



*/


package ejercicios_proyecto;

import java.io.*;

public class Rutinas_ProyectoDamas {

    static String juego[][] = new String[8][8];
    static int contadorB = 12, contadorN = 12;

    public static int verificarEmpateDamas() {
        int damasN = 0, damasB=0;
        for (int i = 0; i < 8; i++) {
            if ("N".equals(juego[0][i])) {
                damasN += 1;
          
            }
            if("B".equals(juego[7][i])){
                damasB+=1;
            }

        }
        if(damasB>damasN){
            return 1;
        }
        if(damasN>damasB){
            return 2;
        }
        
        return 3;
    }

    public static int movimientosB() {
        int fichas = 0, moverse = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ("B".equals(juego[i][j])) {
                    fichas = fichas + 1;

                    if (validarB(i, j) == -1) {
                        limpiarTablero();
                        moverse = moverse + 1;

                    }

                }
            }

        }
        if (moverse == fichas) {
            return -1;
        } else {
            limpiarTablero();
        }

        return 1;

    }

    public static int movimientosN() {
        int fichas = 0, moverse = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ("N".equals(juego[i][j])) {
                    fichas = fichas + 1;

                    if (validarN(i, j) == -1) {
                        limpiarTablero();
                        moverse = moverse + 1;

                    }

                }
            }

        }
        if (moverse == fichas) {
            return -1;
        } else {
            limpiarTablero();
        }
        return 1;

    }

    public static int contadorBlancas(int contadorB) {
        return contadorB;
    }

    public static int contadorNegras(int contadorN) {
        return contadorN;
    }

    public static void limpiarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (("1".equals(juego[i][j])) || (("2".equals(juego[i][j])))
                        || ("3".equals(juego[i][j]) || ("4".equals(juego[i][j])
                        || ("5".equals(juego[i][j]) || ("6".equals(juego[i][j])
                        || ("7".equals(juego[i][j]))))))) {
                    juego[i][j] = "_";
                }
            }

        }

    }

   
    public static void moverB(int pdecision, int pfila, int pcolumna) {
        if (pdecision == 1) {//izquierda
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila + 1][pcolumna - 1] = "B";
            //limpiarNumeros(pfila + 1, pcolumna - 1);
            limpiarTablero();
            if (pfila + 1 == 7) {
                contadorB = contadorB + 2;
                contadorBlancas(contadorB);
            }
        }
        if (pdecision == 2) {//derecha
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila + 1][pcolumna + 1] = "B";
            limpiarTablero();
            //limpiarNumeros(pfila + 1, pcolumna + 1);
            if (pfila + 1 == 7) {
                contadorB = contadorB + 2;
                contadorBlancas(contadorB);
            }

        }
        if (pdecision == 3) {//comer a la izquierda
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila + 1][pcolumna - 1] = "_";
            juego[pfila + 2][pcolumna - 2] = "B";
            limpiarTablero();
            //  limpiarNumeros(pfila + 2, pcolumna - 2);
            if (pfila + 2 == 7) {
                contadorB = contadorB + 2;
                contadorBlancas(contadorB);
            }
            contadorN--;
            contadorNegras(contadorN);
        }
        if (pdecision == 4) {//comer a la derecha
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila + 1][pcolumna + 1] = "_";
            juego[pfila + 2][pcolumna + 2] = "B";
            limpiarTablero();
            // limpiarNumeros(pfila + 2, pcolumna + 2);
            if (pfila + 2 == 7) {
                contadorB = contadorB + 2;
                contadorBlancas(contadorB);
            }

            contadorN--;
            contadorNegras(contadorN);
        }

    }

    public static int validarB(int pfila, int pcolumna) {

        if (pfila == 7) {
            return -1;
        }

        if (pcolumna == 2 || pcolumna == 3 || pcolumna == 4 || pcolumna == 5) {
            if (pfila == 6) {
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))//ULTIMAS
                        && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }
                if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }
                if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {

                    juego[pfila + 1][pcolumna - 1] = "1";
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;
                }
            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {

                juego[pfila + 2][pcolumna - 2] = "3";
                juego[pfila + 2][pcolumna + 2] = "4";
                return 1;

            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                juego[pfila + 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                juego[pfila + 2][pcolumna + 2] = "4";
                return 1;

            }
            if (("B".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 2][pcolumna + 2] = "4";
                return 1;

            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna + 2]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 2][pcolumna - 2] = "3";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna - 2]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 2][pcolumna + 2] = "4";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))
                    && ("N".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 2][pcolumna + 2] = "4";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))
                    && ("N".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 2][pcolumna - 2] = "3";

                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 1][pcolumna - 1] = "1";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 1][pcolumna + 1] = "2";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 1][pcolumna + 1] = "2";

                return 1;

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 1][pcolumna - 1] = "1";

                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {

                juego[pfila + 1][pcolumna - 1] = "1";
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;
            }

        }
        if (pcolumna == 0) {
            if (pfila == 6) {

                if ("B".equals(juego[pfila + 1][pcolumna + 1])) {
                    return -1;

                }
                if ("N".equals(juego[pfila + 1][pcolumna + 1])) {
                    return -1;

                }
            }

            if (("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 2][pcolumna + 2] = "4";
                return 1;

            }

            if ("_".equals(juego[pfila + 1][pcolumna + 1])) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;
            }

        }
        if (pcolumna == 1) {
            if (pfila == 6) {

                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }
                if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }

                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    juego[pfila + 1][pcolumna + 1] = "2";

                    return 1;
                }

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                juego[pfila + 2][pcolumna + 2] = "4";
                return 1;

            }
            if (("B".equals(juego[pfila + 1][pcolumna - 1])
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2])))) {

                juego[pfila + 2][pcolumna + 2] = "4";

                return 1;

            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1])
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna + 2])))) {

                juego[pfila + 2][pcolumna + 2] = "4";

                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1])
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna + 2])))) {

                juego[pfila + 1][pcolumna - 1] = "1";

                return 1;

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila + 2][pcolumna + 2]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }

            if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                juego[pfila + 1][pcolumna + 1] = "2";

                return 1;
            }

        }

        if (pcolumna == 6) {
            if (pfila == 6) {
                if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {

                    return -1;
                }
                if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    juego[pfila + 1][pcolumna + 1] = "2";

                    return 1;
                }

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                juego[pfila + 2][pcolumna - 2] = "3";
                return 1;

            }

            if (("N".equals(juego[pfila + 1][pcolumna - 1])
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2])))) {

                juego[pfila + 2][pcolumna - 2] = "3";

                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1])
                    && ("B".equals(juego[pfila + 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2])))) {

                juego[pfila + 2][pcolumna - 2] = "3";

                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila + 2][pcolumna - 2]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila + 2][pcolumna - 2]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("B".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                juego[pfila + 1][pcolumna - 1] = "1";
                juego[pfila + 1][pcolumna + 1] = "2";

                return 1;
            }

        }
        if (pcolumna == 7) {
            if (pfila == 6) {
                if ("_".equals(juego[pfila + 1][pcolumna - 1])) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;
                }
                if ("B".equals(juego[pfila + 1][pcolumna - 1])) {
                    return -1;

                }
                if ("N".equals(juego[pfila + 1][pcolumna - 1])) {
                    return -1;

                }
            }
            if (("N".equals(juego[pfila + 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila + 2][pcolumna - 2]))) {

                juego[pfila + 2][pcolumna - 2] = "3";
                return 1;

            }
            if ("_".equals(juego[pfila + 1][pcolumna - 1])) {
                juego[pfila + 1][pcolumna - 1] = "1";
                return 1;
            }

        }

        return -1;

    }

    public static void limpiarFichaActual(int pfila, int pcolumna) {
        juego[pfila][pcolumna] = "_";

    }

    public static void moverN(int pdecision, int pfila, int pcolumna) {
        if (pdecision == 1) {//izquierda
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila - 1][pcolumna - 1] = "N";
           
            limpiarTablero();
            if (pfila - 1 == 0) {
                contadorN = contadorN + 2;
                contadorNegras(contadorN);
            }

        }
        if (pdecision == 2) {//derecha
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila - 1][pcolumna + 1] = "N";
            
            limpiarTablero();
            if (pfila - 1 == 0) {
                contadorN = contadorN + 2;
                contadorNegras(contadorN);
            }

        }
        if (pdecision == 3) {//comer a la izquierda
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila - 1][pcolumna - 1] = "_";
            juego[pfila - 2][pcolumna - 2] = "N";
         
            limpiarTablero();
            if (pfila - 2 == 0) {
                contadorN = contadorN + 2;
                contadorNegras(contadorN);
            }
            contadorB--;
            contadorBlancas(contadorB);
        }
        if (pdecision == 4) {//comer a la derecha
            limpiarFichaActual(pfila, pcolumna);
            juego[pfila - 1][pcolumna + 1] = "_";
            juego[pfila - 2][pcolumna + 2] = "N";
            limpiarTablero();
            //limpiarNumeros(pfila - 2, pcolumna + 2);
            if (pfila - 2 == 0) {
                contadorN = contadorN + 2;
                contadorNegras(contadorN);
            }
            contadorB--;
            contadorBlancas(contadorB);

        }
    }

    public static int validarN(int pfila, int pcolumna) {
        if (pfila == 0) {
            return -1;
        }
        if (2 <= pcolumna && pcolumna <= 5) {

            if (pfila == 1) {

                if (("_".equals(juego[pfila - 1][pcolumna - 1]))//ULTIMAS
                        && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }
                if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }
                if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {

                    juego[pfila - 1][pcolumna - 1] = "1";
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;
                }
            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {

                juego[pfila - 2][pcolumna - 2] = "3";
                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna + 2]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 2][pcolumna - 2] = "3";

                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna - 2]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 2][pcolumna + 2] = "4";

                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 2][pcolumna - 2]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 2][pcolumna + 2] = "4";

                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))
                    && ("B".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 2][pcolumna - 2] = "3";

                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 1][pcolumna - 1] = "1";

                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";

                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 1][pcolumna - 1] = "1";

                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";

                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))//ULTIMAS
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {

                juego[pfila - 1][pcolumna - 1] = "1";
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;
            }

        }
        if (pcolumna == 0) {
            if (pfila == 1) {
                if (("N".equals(juego[pfila - 1][pcolumna + 1]))) {

                    return -1;

                }
                if (("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }

                if (("B".equals(juego[pfila - 1][pcolumna + 1]))) {

                    return -1;

                }

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1])
                    && ("_".equals(juego[pfila - 2][pcolumna + 2])))) {

                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }
            if ("_".equals(juego[pfila - 1][pcolumna + 1])) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;
            }

        }
        if (pcolumna == 1) {
            if (pfila == 1) {

                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }

                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    juego[pfila + 1][pcolumna + 1] = "2";

                    return 1;
                }

            }
            if (("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }
            if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {

                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna + 2]))) {

                juego[pfila - 2][pcolumna + 2] = "4";
                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna + 2]))) {
                juego[pfila - 1][pcolumna - 1] = "1";

                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 2][pcolumna + 2]))) {

                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {

                juego[pfila - 1][pcolumna - 1] = "1";
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;
            }

        }
        if (pcolumna == 6) {
            if (pfila == 1) {

                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("B".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }
                if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna - 1] = "1";
                    return 1;

                }

                if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                    juego[pfila - 1][pcolumna + 1] = "2";
                    return 1;

                }

                if (("_".equals(juego[pfila + 1][pcolumna - 1]))
                        && ("_".equals(juego[pfila + 1][pcolumna + 1]))) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    juego[pfila + 1][pcolumna + 1] = "2";

                    return 1;
                }

            }

            if (("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {

                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {

                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("N".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";

                return 1;

            }
            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))
                    && ("B".equals(juego[pfila - 2][pcolumna - 2]))) {
                juego[pfila - 1][pcolumna + 1] = "2";

                return 1;

            }
            if (("N".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("N".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }

            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("B".equals(juego[pfila - 1][pcolumna + 1]))) {
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;

            }
            if (("_".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 1][pcolumna + 1]))) {

                juego[pfila - 1][pcolumna - 1] = "1";
                juego[pfila - 1][pcolumna + 1] = "2";
                return 1;
            }

        }

        if (pcolumna == 7) {
            if (pfila == 1) {
                if ("_".equals(juego[pfila - 1][pcolumna - 1])) {
                    juego[pfila + 1][pcolumna - 1] = "1";
                    return 1;
                }
                if ("B".equals(juego[pfila - 1][pcolumna - 1])) {
                    return -1;

                }
                if ("N".equals(juego[pfila - 1][pcolumna - 1])) {
                    return -1;

                }
            }

            if (("B".equals(juego[pfila - 1][pcolumna - 1]))
                    && ("_".equals(juego[pfila - 2][pcolumna - 2]))) {

                juego[pfila - 2][pcolumna - 2] = "3";
                return 1;

            }
            if ("_".equals(juego[pfila - 1][pcolumna - 1])) {//
                juego[pfila - 1][pcolumna - 1] = "1";
                return 1;
            }

        }

        return -1;

    }

    public static int comprobarB(int pfila, int pcolumna) {
        if ("B".equals(juego[pfila][pcolumna])) {

            return 1;
        } else {
            return -1;
        }

    }

    public static int comprobarN(int pfila, int pcolumna) throws IOException {
        if ("N".equals(juego[pfila][pcolumna])) {

            return 1;
        } else {
            return -1;
        }

    }

    static String imprimirFichasR() {

        String despliegue = "";

        despliegue += "    0  1  2  3  4  5  6  7    \n";

        despliegue += "0   " + juego[0][0] + "  " + juego[0][1] + "  " + juego[0][2] + "  " + juego[0][3] + "  " + juego[0][4] + "  " + juego[0][5] + "  " + juego[0][6] + "  " + juego[0][7] + "   0\n";
        despliegue += "1   " + juego[1][0] + "  " + juego[1][1] + "  " + juego[1][2] + "  " + juego[1][3] + "  " + juego[1][4] + "  " + juego[1][5] + "  " + juego[1][6] + "  " + juego[1][7] + "   1\n";
        despliegue += "2   " + juego[2][0] + "  " + juego[2][1] + "  " + juego[2][2] + "  " + juego[2][3] + "  " + juego[2][4] + "  " + juego[2][5] + "  " + juego[2][6] + "  " + juego[2][7] + "   2\n";
        despliegue += "3   " + juego[3][0] + "  " + juego[3][1] + "  " + juego[3][2] + "  " + juego[3][3] + "  " + juego[3][4] + "  " + juego[3][5] + "  " + juego[3][6] + "  " + juego[3][7] + "   3\n";
        despliegue += "4   " + juego[4][0] + "  " + juego[4][1] + "  " + juego[4][2] + "  " + juego[4][3] + "  " + juego[4][4] + "  " + juego[4][5] + "  " + juego[4][6] + "  " + juego[4][7] + "   4\n";
        despliegue += "5   " + juego[5][0] + "  " + juego[5][1] + "  " + juego[5][2] + "  " + juego[5][3] + "  " + juego[5][4] + "  " + juego[5][5] + "  " + juego[5][6] + "  " + juego[5][7] + "   5\n";
        despliegue += "6   " + juego[6][0] + "  " + juego[6][1] + "  " + juego[6][2] + "  " + juego[6][3] + "  " + juego[6][4] + "  " + juego[6][5] + "  " + juego[6][6] + "  " + juego[6][7] + "   6\n";
        despliegue += "7   " + juego[7][0] + "  " + juego[7][1] + "  " + juego[7][2] + "  " + juego[7][3] + "  " + juego[7][4] + "  " + juego[7][5] + "  " + juego[7][6] + "  " + juego[7][7] + "   7\n";

        despliegue += "    0  1  2  3  4  5  6  7    \n";

        return despliegue;
    }

    public static void inicializarTablero() throws IOException {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (i == 3 || i == 4) {
                    juego[i][j] = "_";
                }
                if (i == 0) {
                    if (j % 2 == 0) {
                        juego[i][j] = "B";
                    } else {
                        juego[i][j] = "_";
                    }

                }
                if (i == 1) {
                    if (j % 2 == 0) {
                        juego[i][j] = "_";
                    } else {
                        juego[i][j] = "B";
                    }
                }
                if (i == 2) {
                    if (j % 2 == 0) {
                        juego[i][j] = "B";

                    } else {
                        juego[i][j] = "_";
                    }
                }
                if (i == 5) {
                    if (j % 2 == 0) {
                        juego[i][j] = "_";

                    } else {
                        juego[i][j] = "N";
                    }

                }
                if (i == 6) {
                    if (j % 2 == 0) {
                        juego[i][j] = "N";
                    } else {
                        juego[i][j] = "_";
                    }

                }
                if (i == 7) {
                    if (j % 2 == 0) {
                        juego[i][j] = "_";
                    } else {
                        juego[i][j] = "N";
                    }
                }
            }
        }
    }
}
