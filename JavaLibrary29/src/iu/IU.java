package iu;

import gestor.Logica;
import java.io.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Logica miLogica = new Logica();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 7);
    }

    /**
     * Muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1. Agregar Libro");
        out.println("2. Listar Libros");
        out.println("3. Agregar Reloj");
        out.println("4. Listar Relojes");
        out.println("5. Obtener ultimo libro");
        out.println("6. Obtener ultimo reloj");
        out.println("7. Salir");

        out.println();
    }

    /**
     * Parsea opcion digitada por el usuario y la retorna
     *
     * @return opcion
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     * Ejecuta un metodo, depende de la opcion escogida por el usuario
     *
     * @param pOpcion
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:
                datosLibro();

                break;

            case 2:
                listarLibros();
                break;
            case 3:
                datosReloj();
                break;
            case 4:
                listarRelojes();
                break;
            case 5:
                break;
            case 7:
                ultimoLibro();
                break;
            case 8:
                ultimoReloj();
                break;
            case 9:
                break;
            default:
                out.println("Opcion invalida");
        }
    }

    public static void datosLibro() throws IOException {
        String nombre, autor, ISBM;
        int tam, dow = 0;
        out.println("Digite tam de arreglo");
        tam = Integer.parseInt(in.readLine());
        miLogica.inicializarLibro(tam);
        do {
            out.println("Digite el nombre del libro");
            nombre = in.readLine();
            out.println("Digite el autor del libro");
            autor = in.readLine();
            out.println("Digite el codigo ISBM");
            ISBM = in.readLine();
            miLogica.agregarLibro(nombre, autor, ISBM);
            dow++;
        } while (dow < tam);

    }

    public static void listarLibros() {

        for (int i = 0; i < miLogica.listarLibros().length; i++) {
            out.println(miLogica.listarLibros()[i]);
        }

    }

    public static void datosReloj() throws IOException {
        String marca;
        double precio;
        int tam, dow = 0;
        out.println("Digite tam de arreglo");
        tam = Integer.parseInt(in.readLine());
        miLogica.inicializarReloj(tam);

        do {
            out.println("Digite la marca del reloj");
            marca = in.readLine();
            out.println("Digite el precio del reloj");
            precio = Integer.parseInt(in.readLine());

            miLogica.agregarReloj(marca, precio);
            dow++;
        } while (dow < tam);

    }

    public static void listarRelojes() {
        for (int i = 0; i < miLogica.listarRelojes().length; i++) {
            out.println(miLogica.listarRelojes()[i]);
        }
    }

    public static void ultimoLibro() {
        out.println(miLogica.listarUltimoLibro());
    }

    public static void ultimoReloj() {
        out.println(miLogica.listarUltimoReloj());
    }

}
