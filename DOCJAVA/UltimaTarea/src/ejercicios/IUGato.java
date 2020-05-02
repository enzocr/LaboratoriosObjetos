
/*Nombre del programa: IU Gato
Descripción: Interfaz de juego gato
Fecha de creación:29/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:29/07/2017
Modificado por: */
package ejercicios;

import java.io.*;
import javax.swing.JOptionPane;

public class IUGato {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;
    static char juego[][] = new char[3][3];
    static boolean yaIngresado = false;

    public static void main(String[] args) throws IOException {

       inicializarTablero();
        imprimirTablero();
        int i;
        
        do {
            for (i = 0; i < 9; i++) {

                if (i % 2 == 0) {
                    jugadaX(i);
                    int resultadoX = RutinasGato.comprobarX();
                    if (resultadoX == 1) {
                        JOptionPane.showMessageDialog(null, "X ha ganado");
                        yaIngresado = true;
                      
                        break;
                    }
                    if(RutinasGato.buscarEmpate() ==-1){
                        JOptionPane.showMessageDialog(null, "EMPATE");
                        yaIngresado = true;
                        break;
                    }
                } else {
                    jugadaO(i);
                    int resultadoO = RutinasGato.comprobarO();
                    if (resultadoO == 1) {
                        JOptionPane.showMessageDialog(null, "O ha ganado");
                        yaIngresado = true;
                        
                        break;
                    }
                    if(RutinasGato.buscarEmpate() ==-1){
                        JOptionPane.showMessageDialog(null, "EMPATE");
                        break;
                    }
                }
                 
            }
            
            
           

        } while (!yaIngresado || i > 9);
    }

    static void jugadaX(int i) throws IOException {
        int indice;
        int fila, columna;
        do {
            JOptionPane.showMessageDialog(null, "Turno Jugador X, jugada # " + (i + 1));
            fila = Integer.parseInt(JOptionPane.showInputDialog("X: Escoga fila"));
            columna = Integer.parseInt(JOptionPane.showInputDialog("X: Escoga columna"));

            indice = RutinasGato.buscarJugada(fila, columna);
            if (indice == -1) {
                JOptionPane.showMessageDialog(null, "CASILLA OCUPADA, INTENTE DE NUEVO");
            }
        } while (indice != 1);

        RutinasGato.agregaPosicionX(fila, columna);

        imprimirTablero();

    }

    static void jugadaO(int i) throws IOException {
        int indice, fila, columna;
        do {
            JOptionPane.showMessageDialog(null, "Turno Jugador O, jugada # " + (i + 1));
            fila = Integer.parseInt(JOptionPane.showInputDialog("O: Escoga fila"));
            columna = Integer.parseInt(JOptionPane.showInputDialog("O: Escoga columna"));

            indice = RutinasGato.buscarJugada(fila, columna);
            if (indice == -1) {
                JOptionPane.showMessageDialog(null, "CASILLA OCUPADA, INTENTE DE NUEVO");
            }
        } while (indice != 1);
        RutinasGato.agregaPosicionO(fila, columna);

        juego[fila][columna] = 'O';
        imprimirTablero();

    }

    static void imprimirTablero() {
        String tablero;
        tablero = RutinasGato.imprimir();
        System.out.println(tablero + "\n");
    }
    static void inicializarTablero(){
        RutinasGato.inicializar();
    }

}
