/*
Nombre del programa: IU Estudiantes Cenfo
Descripción: Suponga que usted tiene que guardar la información del registro de
notas de Cenfotec, para esto por cada estudiante se guardan las
notas de los cuatro cursos que tomó el estudiante en el
cuatrimestre. Suponga que son sólo 10 estudiantes.
a. Cómo va a organizar la información? (en una matriz? Cuántas
matrices? De qué tipo y de qué dimensiones la(s) matriz(ces)?)
b. Haga un procedimiento en Java que lea la(s) matriz(ces) del
punto a.
c. Haga una función en Java que recibe las notas de todos los
estudiantes y el número de un estudiante, y retorne el promedio
de los cursos de ese estudiante.
d. Haga una función en Java que recibe las notas de todos los
estudiantes, y retorne el estudiante que obtuvo la máxima nota
en el curso 1.
e. Haga un procedimiento en Java que imprima la(s) matriz(ces)
del punto a.
f. Haga un programa principal en el que declare la(s)
matriz(ces) que necesite, reserve espacio en memoria, use el
procedimiento del punto a para leer la(s) matriz(ces), imprima
los datos calculados en las funciones b, c y d, y luego use el
procedimiento del punto e para imprimir la(s) matriz(ces).
Fecha de creación:28/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:28/07/2017
Modificado por:
 */
package ejercicios;

import java.io.*;

public class EstudiantesCenfo {

    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream imprimir = System.out;

    public static void main(String[] args) throws IOException {
        int opc;
        boolean noSalir = true;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);
        } while (noSalir);

    }

    static void mostrarMenu() {
        imprimir.println();
        imprimir.println("1.  Leer Matriz");
        imprimir.println("2.  Promedio de un estudiante");
        imprimir.println("3.  Nota mayor curso #1");
        imprimir.println("4.  Imprimir Matriz");
        imprimir.println("5.  Salir");

        imprimir.println();

    }

    static int leerOpcion() throws java.io.IOException {

        int opcion;

        imprimir.print("Seleccione su opcion: ");
        opcion = Integer.parseInt(leer.readLine());
        imprimir.println();

        return opcion;
    }

    static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        boolean noSalir = true;

        switch (popcion) {

            case 1: //Leer matriz

                leerMatriz();

                break;

            case 2:// Promedio de un estudiante
                imprimir.println("De cual estudiante desea adquirir el promedio? 0 al 9");
                int estudiante = Integer.parseInt(leer.readLine());
                imprimir.println("El promedio del estudiante " + estudiante + " es: " + RutinasCenfo.promedioEstudiante(estudiante));

                break;

            case 3: //Nota Mayor curso 1
                imprimir.println("El estudiante " + RutinasCenfo.notaMayor() + " tuvo la mayor nota");

                break;

            case 4: //imprimir matriz
                String datos;
                datos = RutinasCenfo.imprimirMatriz();
                imprimir.println(datos);
                
                   

                break;

            case 5: //Salir de la aplicacion

                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                imprimir.println("Opcion invalida");
                imprimir.println();
                break;
        }
        return noSalir;

    }

    static void leerMatriz() throws IOException {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                imprimir.println("Digite la nota del Estudiante: " + i + " Curso: " + j);
                int nota = Integer.parseInt(leer.readLine());
                RutinasCenfo.agregarNotas(i, j, nota);
            }
        }
    }
}
