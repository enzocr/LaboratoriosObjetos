package ejercicios;

import java.io.*;

public class UIVotos123Probando {

    //Variables globales para interactuar con el usuario.
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;	// variables objetos in y out para

    public static void main(String[] args) throws java.io.IOException {

        int opc;
        boolean noSalir = true;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);

        } while (noSalir); //Es lo mismo que decir noSalir = true.
    }

    static void mostrarMenu() {

        out.println();
        out.println("Con variables globales en Rutinas");
        out.println();
        out.println("1.  Agregar votos.");
        out.println("2.  Total votos.");
        out.println("3.  Mayor numero votos.");
        out.println("4.  Salir.");
        out.println();
    }

    static int leerOpcion() throws java.io.IOException {

        int opcion;

        out.print("Seleccione su opci\u00a2n: ");
        opcion = Integer.parseInt(in.readLine());
        out.println();

        return opcion;
    }

    //A PARTIR DE ESTA RUTINA COMIENZO A HACER LAS PRUEBAS
    static boolean ejecutarAccion(int popcion) throws java.io.IOException {

        boolean noSalir = true;

//		out.println("********************************");
//		out.println("Estoy en ejecutarAccion");
//		out.println("Se recibe  " + popcion);
        switch (popcion) {

            case 1: //Opcion Agregar Votos				

//				out.println("Se envia  " + "nada");
                agregarVotos(); //Interactua con el usuario y no calcula.

//				out.println("Estoy de nuevo en ejecutarAccion");
//				out.println("Se obtiene " + "nada");
                break;

            case 2:// 'Opcion Total de votos registrados

                int total;

//				out.println("Se envia  " + "nada");
                //Se utiliza rutina de capa lógica.
                total = Rutinas123Probando.calcularTotalVotos();

                out.println("Estoy de nuevo en ejecutarAccion");
                out.println("Se obtiene " + total);

                break;

            case 3: //Obtener mayor numero de votos

                String[] resul;

//				out.println("Se envia  " + "nada");
                resul = Rutinas123Probando.obtenerMayorVotos();

//				out.println("Estoy de nuevo en ejecutarAccion");
                out.println("Se obtiene " + resul);

                break;

            case 4: //Salir de la aplicacion

                noSalir = false;
                break;

            default: //Cualquier otro valor dado por el usuario se considera inválido

                out.println("Opcion inv\u00a0lida");
                out.println();
                break;
        }

//		out.println("Se retorna " +  noSalir + " y termina ejecutarAccion");
//		out.println("********************************\n");
        return noSalir;
    }

    static void agregarVotos() throws java.io.IOException {

        String ciudad = "";
        int votos = 0;

        //Solicitud de datos
        out.print("Deme el nombre de la ciudad: ");
        ciudad = in.readLine();
        out.println();

        out.print("Deme el n\u00a3mero de votos: ");
        votos = Integer.parseInt(in.readLine());
        out.println();

//        out.println("********************************");
//        out.println("Estoy en agregarVotos");
//        out.println("Se recibe  " + "nada");

        out.println("Se envia  " + ciudad + " y " + votos);//PARA CADA SERVIDORA QUE LLAMA, HAGA COPY DESDE AQUI

        Rutinas123Probando.registrarVotos(ciudad, votos);

//        out.println("Estoy de nuevo en agregarVotos");
//        out.println("Se obtiene " + "nada");		//HASTA AQUI
//
//        out.println("Se retorna " + "nada" + " y termina agregarVotos");
//        out.println("********************************\n");

    }

}
