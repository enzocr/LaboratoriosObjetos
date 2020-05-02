package iu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import estructuras.PilaE;
import gestor.Logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IUErrores {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Logica miLogica = new Logica();
    static PilaE pE = new PilaE();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws Exception {

        try {
            int e = 0;
            do {
                error1();

                e++;
            } while (e != 4);

        } catch (Exception error) {
            out.println(error.getMessage());
            miLogica.agregarError(error.getMessage());

        }
        printError();

    }

    public static void error1() throws Exception {
        int tam;
        out.println("Digite tam de arreglo");
        tam = Integer.parseInt(in.readLine());

        miLogica.inicializarError(tam);

    }

    public static void printError() throws IOException {

        out.println(miLogica.pilaErrores());

    }

}
