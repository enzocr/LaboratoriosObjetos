package iu;

import capa_logica.Categoria;
import capa_logica.Logica;
import java.io.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class iu_categorias {

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
        } while (opc != 4);
    }

    /**
     * Muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Agregar categoria");
        out.println("2.  Listar categorias");
        out.println("3.  Buscar categorias");
        out.println("4.  Salir");

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
                datosCategoria();

                break;

            case 2:
                listarCategorias();

                break;
            case 3:
                comprobarCategoria();

                break;
        }
    }

    /**
     * Se ingresan los datos de la categoria y se envian como parametro
     *
     * @throws IOException
     */
    public static void datosCategoria() throws IOException {
        String iD, nombre, descripcion;
        out.println("Digite el iD de la categoria");
        iD = in.readLine();
        Categoria miCategoria = miLogica.buscarCategoria(iD);
        if (miCategoria == null) {
            out.println("Digite el nombre de la categoria");
            nombre = in.readLine();
            out.println("Agregue una descripcion a la categoria");
            descripcion = in.readLine();

            miLogica.agregarCategoria(iD, nombre, descripcion);
        } else {
            out.println("***CATEGORIA YA REGISTRADA***");
            out.println("ID REGISTRADO: " + miCategoria.getiD());
            out.println("NOMBRE REGISTRADO: " + miCategoria.getNombre());
            out.println("DESCRIPCION REGISRADA: " + miCategoria.getDescripcion());
        }

    }

    /**
     * Lista las categorias registradas
     *
     * @throws IOException
     */
    public static void listarCategorias() throws IOException {
        for (int i = 0; i < miLogica.getCategorias().length; i++) {

            out.println("CATEGORIA #: " + (i));
            out.println(miLogica.getCategorias()[i]);
            out.println("********************");
        }

    }

    /**
     * Valida si la Categoria ya esta registrada
     *
     * @throws IOException
     */
    public static void comprobarCategoria() throws IOException {
        String iD;
        int decision;
        out.println("Digite el iD de la categoria que desea buscar");
        iD = in.readLine();

        if (miLogica.buscarCategoria(iD) == null) {

            out.println("CATEGORIA NO EXISTE \n"
                    + "SI DESEA AGREGARLA DIGITE 1 \n"
                    + "SI DESEA VOLVER AL MENU DIGITE 2");
            decision = Integer.parseInt(in.readLine());
            if (decision == 1) {
                datosCategoria();

            }

        }

    }

}
