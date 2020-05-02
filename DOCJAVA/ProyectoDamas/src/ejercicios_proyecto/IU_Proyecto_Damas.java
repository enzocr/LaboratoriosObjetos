
/*Nombre del programa: IU_Proyecto_Damas
Descripción: Interfaz de usuario de la aplicacion
Fecha de creación:09/08/2017
Autor: Enzo Quartino Zamora, John Hewitt, Mariano Monge, Lindsay Rodriguez
Fecha de modificación:16/08/2017
Modificado por: Enzo Quartino Zamora, John Hewitt,
Mariano Monge, Lindsay Rodriguez
***La aplicacion es semifuncional

 */
package ejercicios_proyecto;

import java.io.*;
import javax.swing.JOptionPane;

public class IU_Proyecto_Damas {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int opc;
        boolean noSalir;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        } while (noSalir);
    }

    static void mostrarMenu() throws IOException {

        out.println();
        out.println("1.  Jugar");
        out.println("2.  Instrucciones");
        out.println("3.  Creditos");
        out.println("4   Salir del juego");
        out.println();
    }

    static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    static boolean ejecutarAccion(int popcion) throws IOException {

        boolean noSalir = true;

        switch (popcion) {

            case 1:

                boolean volver = false;

                do {
                    JOptionPane.showMessageDialog(null, "***JUEGO INICIADO, SUERTE***");
                    int retirar, jugar, cantDamas;
                    boolean bandera = false;
                    inicializa();
                    while (!bandera) {
                        JOptionPane.showMessageDialog(null, "Turno jugador B");

                        if ((Rutinas_ProyectoDamas.movimientosB() == -1) || (Rutinas_ProyectoDamas.movimientosN() == -1)) {
                            
                            if (Rutinas_ProyectoDamas.movimientosB() == -1) {
                                if (Rutinas_ProyectoDamas.contadorN == Rutinas_ProyectoDamas.contadorB) {
                                    cantDamas = Rutinas_ProyectoDamas.verificarEmpateDamas();
                                    if (cantDamas == 1) {
                                        JOptionPane.showMessageDialog(null, "***El jugador B tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 2) {
                                        JOptionPane.showMessageDialog(null, "***El jugador N tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 3) {
                                        JOptionPane.showMessageDialog(null, "***Ambos Jugadores tienen la misma, "
                                                + "cantidad de damas, HAY EMPATE***");
                                        break;
                                    }
                                }
                                if (Rutinas_ProyectoDamas.contadorB > Rutinas_ProyectoDamas.contadorN) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR B NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR B ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }
                                if (Rutinas_ProyectoDamas.contadorN > Rutinas_ProyectoDamas.contadorB) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR B NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR N ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }

                            }
                            if (Rutinas_ProyectoDamas.movimientosN() == -1) {

                                if (Rutinas_ProyectoDamas.contadorN == Rutinas_ProyectoDamas.contadorB) {
                                    cantDamas = Rutinas_ProyectoDamas.verificarEmpateDamas();
                                    if (cantDamas == 1) {
                                        JOptionPane.showMessageDialog(null, "***El jugador B tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 2) {
                                        JOptionPane.showMessageDialog(null, "***El jugador N tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 3) {
                                        JOptionPane.showMessageDialog(null, "***Ambos Jugadores tienen la misma, "
                                                + "cantidad de damas, HAY EMPATE***");
                                        break;
                                    }
                                }

                                if (Rutinas_ProyectoDamas.contadorN > Rutinas_ProyectoDamas.contadorB) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR N NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR N ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }
                                if (Rutinas_ProyectoDamas.contadorB > Rutinas_ProyectoDamas.contadorN) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR N NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR B ES EL GANADOR, PORQUE TIENE MAS FICHAS***");
                                    break;
                                }
                            }

                        }

                        retirar = retirarJugadorB();
                        if (retirar == 1) {

                            JOptionPane.showMessageDialog(null, "***EL JUGADOR N  ES EL GANADOR***");
                            break;
                        }
                        consultarFichaB();

                        if (Rutinas_ProyectoDamas.contadorN == 0) {
                            JOptionPane.showMessageDialog(null, "***EL JUGADOR B ES EL GANADOR***");
                            break;
                        }

                        JOptionPane.showMessageDialog(null, "Turno jugador N");

                        if ((Rutinas_ProyectoDamas.movimientosB() == -1) || (Rutinas_ProyectoDamas.movimientosN() == -1)) {
                            if (Rutinas_ProyectoDamas.movimientosB() == -1) {
                                if (Rutinas_ProyectoDamas.contadorN == Rutinas_ProyectoDamas.contadorB) {
                                    cantDamas = Rutinas_ProyectoDamas.verificarEmpateDamas();
                                    if (cantDamas == 1) {
                                        JOptionPane.showMessageDialog(null, "***El jugador B tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 2) {
                                        JOptionPane.showMessageDialog(null, "***El jugador N tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 3) {
                                        JOptionPane.showMessageDialog(null, "***Ambos Jugadores tienen la misma, "
                                                + "cantidad de damas, HAY EMPATE***");
                                        break;
                                    }
                                }
                                if (Rutinas_ProyectoDamas.contadorB > Rutinas_ProyectoDamas.contadorN) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR B NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR B ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }
                                if (Rutinas_ProyectoDamas.contadorN > Rutinas_ProyectoDamas.contadorB) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR N NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR N ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }

                            }
                            if (Rutinas_ProyectoDamas.movimientosN() == -1) {

                                if (Rutinas_ProyectoDamas.contadorN == Rutinas_ProyectoDamas.contadorB) {
                                    cantDamas = Rutinas_ProyectoDamas.verificarEmpateDamas();
                                    if (cantDamas == 1) {
                                        JOptionPane.showMessageDialog(null, "***El jugador B tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 2) {
                                        JOptionPane.showMessageDialog(null, "***El jugador N tiene mas Damas, "
                                                + "es el ganador***");
                                        break;
                                    }
                                    if (cantDamas == 3) {
                                        JOptionPane.showMessageDialog(null, "***Ambos Jugadores tienen la misma, "
                                                + "cantidad de damas, HAY EMPATE***");
                                        break;
                                    }
                                }

                                if (Rutinas_ProyectoDamas.contadorN > Rutinas_ProyectoDamas.contadorB) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR N NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR N ES EL GANADOR, YA QUE TIENE MAS FICHAS***");
                                    break;
                                }
                                if (Rutinas_ProyectoDamas.contadorB > Rutinas_ProyectoDamas.contadorN) {
                                    JOptionPane.showMessageDialog(null, "***EL JUGADOR N NO PUEDE MOVER MAS FICHAS, \n"
                                            + "EL JUGADOR B ES EL GANADOR, PORQUE TIENE MAS FICHAS***");
                                    break;
                                }
                            }

                        }
                        retirar = retirarJugadorN();
                        if (retirar == 1) {

                            JOptionPane.showMessageDialog(null, "***EL JUGADOR B ES EL GANADOR***");
                            break;
                        }
                        consultarFichaN();

                        if (Rutinas_ProyectoDamas.contadorB == 0) {
                            JOptionPane.showMessageDialog(null, "***EL JUGADOR N ES EL GANADOR***");
                            break;
                        }

                    }
                    jugar = Integer.parseInt(JOptionPane.showInputDialog("Desea volver a jugar? \n"
                            + "1=SI \n"
                            + "2=NO \n"));

                    if (jugar == 2) {

                        noSalir = false;
                        volver = true;

                        JOptionPane.showMessageDialog(null, "***GRACIAS POR JUGAR***");

                    }

                } while (!volver);
                break;

            case 2:
                JOptionPane.showMessageDialog(null, "Cada jugador dispone de 12 piezas (B y N) que al principio de la\n"
                        + "partida se colocan en las casillas tres filas más próximas a él. El objetivo del juego de\n"
                        + "damas es capturar las fichas del oponente o acorralarlas para que los únicos movimientos que\n"
                        + "puedan realizar sean los que lleven a su captura. Se juega por turnos alternos. Empieza a jugar quien\n"
                        + "tiene las fichas B. En su turno cada jugador mueve una pieza propia y depende de la posibilidad\n"
                        + "puede comer una vez.\n"
                        + "Las piezas se mueven (cuando no comen) una posición adelante (nunca hacia atrás desde su\n"
                        + "perspectiva) en diagonal a la derecha o a la izquierda, a una posición adyacente vacía.\n"
                        + "Una partida de damas finaliza cuando estamos en una de estas situaciones:\n"
                        + "1 Pierde quien se queda sin piezas sobre el tablero.\n"
                        + "2 Si cuando llega el turno de un jugador no puede mover sus fichas.\n"
                        + "3 Gana quien más piezas tenga, a igual número de piezas gana quién más reinas/damas tenga,\n"
                        + "y si en esto también se empata la partida termina en empate.\n"
                        + "***PUEDE RETIRARSE CUANDO GUSTE***");
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "                Creadores del Juego\n"
                        + "-----------------------------------------------------------------------\n"
                        + "Enzo Quartino Zamora \n"
                        + "John Hewitt \n"
                        + "Lindsay Rodriguez \n"
                        + "Mariano Monge \n");

                break;

            case 4:
                JOptionPane.showMessageDialog(null, "***GRACIAS POR JUGAR***");
                noSalir = false;

                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                JOptionPane.showMessageDialog(null, "Opcion invalida");

                break;
        }
        return noSalir;
    }

    static void inicializa() throws IOException {
        Rutinas_ProyectoDamas.inicializarTablero();
    }

    static int retirarJugadorN() {//PREGUNTA JUGADOR N SI SE QUIERE RETIRAR
        int retirar;
        retirar = Integer.parseInt(JOptionPane.showInputDialog("JUGADOR N: Desea retirarse? \n"
                + "Le quedan " + Rutinas_ProyectoDamas.contadorN + " fichas \n"
                + "1=SI \n"
                + "2=NO \n"));
        return retirar;
    }

    static int retirarJugadorB() {//PREGUNTA JUGADOR B SI SE QUIERE RETIRAR
        int retirar;
        retirar = Integer.parseInt(JOptionPane.showInputDialog("JUGADOR B: Desea retirarse? \n"
                + "Le quedan " + Rutinas_ProyectoDamas.contadorB + " fichas \n"
                + "1=SI \n"
                + "2=NO \n"));
        return retirar;

    }

   

    static void consultarFichaB() throws IOException {

        imprimirFichas();
        consultarFilaColB();

    }

    static void consultarFilaColB() throws IOException {
        int fila, columna, decision, comprobacion, movimiento;
        boolean proceder = false;

        while (proceder == false) {
            fila = Integer.parseInt(JOptionPane.showInputDialog("TURNO B: Digitar fila en la \n que se encuentra la ficha"
                    + " que desea mover"));
            columna = Integer.parseInt(JOptionPane.showInputDialog("TURNO B: Digitar columna en la \n  que se encuentra la ficha"
                    + " que desea mover"));
            comprobacion = Rutinas_ProyectoDamas.comprobarB(fila, columna);
            if (comprobacion == 1) {

                movimiento = Rutinas_ProyectoDamas.validarB(fila, columna);
                if (movimiento == 1) {

                    imprimirFichas();
                    do {
                        decision = Integer.parseInt(JOptionPane.showInputDialog("TURNO B: A cual posicion desea mover la ficha?"));
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4) {
                            break;
                        } else {

                            JOptionPane.showMessageDialog(null, "TURNO B: Movimiento invalido, intente de nuevo");

                        }

                    } while (decision < 1 || decision > 4);
                    Rutinas_ProyectoDamas.moverB(decision, fila, columna);
                    imprimirFichas();

                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "TURNO B: No puede mover esta ficha \n"
                            + "Intente otra ficha");
                }

            } else {
                JOptionPane.showMessageDialog(null, "TURNO B: No hay ficha en esta posicion, intente de nuevo");
            }

        }

    }
    
     static void consultarFichaN() throws IOException {

        imprimirFichas();
        consultarFilaColN();

    }

    static void consultarFilaColN() throws IOException {
        int fila, columna, decision, comprobacion, movimiento;
        boolean proceder = false;

        while (proceder == false) {
            fila = Integer.parseInt(JOptionPane.showInputDialog("TURNO N: Digitar fila en la \n que se encuentra la ficha"
                    + " que desea mover"));
            columna = Integer.parseInt(JOptionPane.showInputDialog("TURNO N: Digitar columna en la \n  que se encuentra la ficha"
                    + " que desea mover"));
            comprobacion = Rutinas_ProyectoDamas.comprobarN(fila, columna);
            if (comprobacion == 1) {

                movimiento = Rutinas_ProyectoDamas.validarN(fila, columna);
                if (movimiento == 1) {

                    imprimirFichas();
                    do {
                        decision = Integer.parseInt(JOptionPane.showInputDialog("TURNO N: A cual posicion desea mover la ficha?"));
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "TURNO N: Movimiento invalido, intente de nuevo");

                        }

                    } while (decision < 1 || decision > 4);
                    Rutinas_ProyectoDamas.moverN(decision, fila, columna);
                    imprimirFichas();

                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "TURNO N: No puede mover esta ficha \n"
                            + "Intente otra ficha");
                }

            } else {
                JOptionPane.showMessageDialog(null, "TURNO N: No hay ficha en esta posicion, intente de nuevo");
            }

        }

    }

    static void imprimirFichas() {
        String fichas;
        fichas = Rutinas_ProyectoDamas.imprimirFichasR();
        out.println(fichas + "\n");
        out.println("FICHAS BLANCAS: " + Rutinas_ProyectoDamas.contadorB);
        out.println("FICHAS NEGRAS: " + Rutinas_ProyectoDamas.contadorN);

    }

}
