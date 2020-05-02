/*

Nombre del programa: IUTareaMatriz
Descripción: Matriz Filas y columnas
Fecha de creación:27/07/2017
Autor: Enzo Quartino Zamora
Fecha de modificación:27/07/2017
Modificado por: 
 */



package ejercicios;



import java.io.*;

public class IUTarea {

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
        imprimir.println("1.  Crear Matriz");
        imprimir.println("2.  Llenar Matriz");
        imprimir.println("3.  Mostrar Matriz");
        imprimir.println("4.  Promedio de una fila");
        imprimir.println("5.  Promeido de una columna");
        imprimir.println("6.  Mostrar promedio general");
        imprimir.println("7. Salir");
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

            case 1: //Opcion Agregar Matriz

                crear();

                break;

            case 2:// Llenar matriz
                llenarMatriz();

                break;

            case 3: //Mostrar matriz
                imprimir.println(Rutinas.imprimirMatriz());

                break;

            case 4: //Promedio de una fila determinada
                int filaP;
                imprimir.println("Digite la fila que quiere promediar");
                filaP=Integer.parseInt(leer.readLine());
                imprimir.println("EL promedio de la fila "+filaP+" es:"+Rutinas.promedioFila(filaP));

                break;

            case 5://
                int columnaP;
                imprimir.println("Digite la columna que quiere promediar");
                columnaP=Integer.parseInt(leer.readLine());
                imprimir.println(Rutinas.promedioColumna(columnaP));

                break;
               

            case 6://promedio general
                
                imprimir.println("El promedio general es: "+Rutinas.promedioGeneral());
                
                
                
                break;
            
            case 7: //Salir de la aplicacion

                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                imprimir.println("Opcion invalida");
                imprimir.println();
                break;
        }
        return noSalir;
    }
    static void crear()throws IOException{
        
         int fila = solicitarTamFila();
        int columna = solicitarTamCol();
        Rutinas.crearMatriz(fila, columna);
        
        
    }

    static int solicitarTamFila() throws IOException {

        int fila;
        imprimir.println("Digite cuantas filas");
        fila = Integer.parseInt(leer.readLine());

        return fila;

    }

    static int solicitarTamCol() throws IOException {
        int columna;
        imprimir.println("Digite cuantas columnas");
        columna = Integer.parseInt(leer.readLine());
        return columna;
    }

    static void llenarMatriz() throws IOException {
        int dato;

        for (int i = 0; i < Rutinas.cantFilas(); i++) {
            for (int j = 0; j < Rutinas.cantColumnas(); j++) {
                imprimir.println("Digite el dato en la posicion [" + (i) + " , " + (j) + " ]");
                dato = Integer.parseInt(leer.readLine());
                Rutinas.agregarMatriz(i, j, dato);

            }
        }

    }
    
   
    
    
    }

