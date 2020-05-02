package iu;


import capa_logica.CL;
import capa_logica.Materiales;
import capa_logica.Usuarios;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Iu_laboratorio7 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static CL capa = new CL();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {

        int opc;

        do {
            mostrarMenu();
            opc = leerOpcion();
            ejecutarAccion(opc);
        } while (opc != 7);
    }

    /**
     * muestra el menu1
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Registrar Usuario");
        out.println("2.  Modificar Usuario");
        out.println("3.  Listar Usuario");
        out.println("4.  Registrar Material");
        out.println("5.  Modificar Material");
        out.println("6.  Listar Material");
        out.println("7.  Salir");

        out.println();
    }

    /**
     * La opcion escogida por el cliente es parseada y se retorna
     *
     * @return la opcion escogida por el cliente o administrador
     * @throws IOException
     */
    public static int leerOpcion() throws IOException {

        int opcion;

        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));

        return opcion;
    }

    /**
     *
     * @param pOpcion recibe opcion digitada por el usuario y la usa en el
     * switch
     * @throws IOException
     */
    public static void ejecutarAccion(int pOpcion) throws IOException, Exception {

        switch (pOpcion) {

            case 1:
                datosUsuario();
                break;
            case 2:
                modificarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                datosMateriales();
                break;
            case 5:
                modificarMateriales();
                break;
            case 6:
                listarMateriales();
                break;
            case 7:
                break;
            default:
                out.println("Opcion invalida");

        }

    }

    /**
     * Registra los datos del usuario y los registra enviandolos por parametro
     *
     * @throws IOException
     */
    public static void datosUsuario() throws IOException {
        int decision;

        out.println("Digite la opcion \n"
                + "Registrar Estudiante(1)\n"
                + "Registrar Profesor(2)\n"
                + "Registrar Administrativo(3)");
        decision = Integer.parseInt(in.readLine());
        if (decision == 1) {
            String iD, nombre, apellido;
            String carrera;
            int creditos;
            out.println("Digite el iD del estudiante");
            iD = in.readLine();
            out.println("Digite el nombre del estudiante");
            nombre = in.readLine();
            out.println("Digite el apellido del estudiante");
            apellido = in.readLine();
            out.println("Digite la carrera cursada");
            carrera = in.readLine();
            out.println("Digite creditos obtenidos");
            creditos = Integer.parseInt(in.readLine());
            capa.agregarEstudiante(iD, nombre, apellido, carrera, creditos);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiU());

        }
        if (decision == 2) {
            String iD, nombre, apellido;
            String tipoContrato;
            LocalDate fechaContratacion;

            out.println("Digite el iD del profesor");
            iD = in.readLine();
            out.println("Digite el nombre del profesor");
            nombre = in.readLine();
            out.println("Digite el apellido del profesor");
            apellido = in.readLine();
            out.println("Digite el tipo de contrato(tiempo medio o completo)");
            tipoContrato = in.readLine();
            out.println("Fecha de contratacion :" + (LocalDate.now()));
            fechaContratacion = LocalDate.now();
            capa.agregarProfesor(iD, nombre, apellido, tipoContrato, fechaContratacion);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiU());

        }
        if (decision == 3) {
            String nombramiento;
            double cantHoras;
            String iD, nombre, apellido;
            out.println("Digite el iD del administrativo");
            iD = in.readLine();
            out.println("Digite el nombre del administrativo");
            nombre = in.readLine();
            out.println("Digite el apellido del administrativo");
            apellido = in.readLine();
            out.println("Digite el tipo de nombramiento(A, B, C)");
            nombramiento = in.readLine();
            out.println("Digite la cantidad de horas semanales trabajadas");
            cantHoras = Double.parseDouble(in.readLine());
            capa.agregarAdministrativo(iD, nombre, apellido, nombramiento, cantHoras);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiU());

        }
    }

    /**
     * Registra los datos del material y los registra enviandolos por parametro
     *
     * @throws IOException
     */
    public static void datosMateriales() throws IOException {

        int decision;

        out.println("Digite la opcion \n"
                + "Registrar Texto(1)\n"
                + "Registrar Audio(2)\n"
                + "Registrar Video(3)\n"
                + "Registrar Otro(4)");
        decision = Integer.parseInt(in.readLine());
        if (decision == 1) {
            int opcion, numPaginas;
            String titulo, autor, idioma, iD, tema;
            LocalDate fechaPublicacion, fechaCompra;
            boolean restringido = false;

            out.println("Digite el iD del texto");
            iD = in.readLine();
            out.println("Fecha de compra: " + LocalDate.now());
            fechaCompra = LocalDate.now();
            out.println("El texto es restringido? Si(1)No(2)");
            opcion = Integer.parseInt(in.readLine());
            if (opcion == 1) {
                restringido = true;
            }
            out.println("Digite el tema del texto");
            tema = in.readLine();
            out.println("Digite el titulo del texto");
            titulo = in.readLine();
            out.println("Digite el nombre del autor");
            autor = in.readLine();
            out.println("Fecha de Publicacion: " + LocalDate.now());
            fechaPublicacion = LocalDate.now();
            out.println("Digite la cantidad de paginas del texto");
            numPaginas = Integer.parseInt(in.readLine());
            out.println("Digite el idioma del texto");
            idioma = in.readLine();
            capa.agregarTexto(iD, fechaCompra, restringido, tema, titulo, autor, fechaPublicacion, numPaginas, idioma);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiM());
        }
        if (decision == 2) {
            int opcion;
            String iD, tema, formato, duracion, idioma, director;
            LocalDate fechaCompra;
            boolean restringido = false;
            out.println("Digite el iD del video");
            iD = in.readLine();
            out.println("Fecha de compra: " + LocalDate.now());
            fechaCompra = LocalDate.now();
            out.println("El video es restringido? Si(1)No(2)");
            opcion = Integer.parseInt(in.readLine());
            if (opcion == 1) {
                restringido = true;
            }

            out.println("Digite el tema del video");
            tema = in.readLine();
            out.println("Digite el formato del video(VHS, VCD, DVD)");
            formato = in.readLine();
            out.println("Digite la duracion del video");
            duracion = in.readLine();
            out.println("Digite el nombre del director");
            director = in.readLine();
            out.println("Digite el idioma del video");
            idioma = in.readLine();

            capa.agregarVideo(iD, fechaCompra, restringido, tema, formato, duracion, director, idioma);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiM());

        }
        if (decision == 3) {
            int opcion;
            String iD, tema, formato, duracion, idioma;
            LocalDate fechaCompra;
            boolean restringido = false;
            out.println("Digite el iD del audio");
            iD = in.readLine();
            out.println("Fecha de compra: " + LocalDate.now());
            fechaCompra = LocalDate.now();
            out.println("El audio es restringido? Si(1)No(2)");
            opcion = Integer.parseInt(in.readLine());
            if (opcion == 1) {
                restringido = true;
            }
            out.println("Digite el tema del audio");
            tema = in.readLine();
            out.println("Digite el formato del audio(Casete, CD, DVD");
            formato = in.readLine();
            out.println("Digite la duracion del audio");
            duracion = in.readLine();
            out.println("Digite el idioma del audio");
            idioma = in.readLine();

            capa.agregarAudio(iD, fechaCompra, restringido, tema, formato, duracion, idioma);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiM());

        }
        if (decision == 4) {
            int opcion;
            String iD, descripcion, tema;
            LocalDate fechaCompra;
            boolean restringido = false;
            out.println("Digite el iD del otro material");
            iD = in.readLine();
            out.println("Fecha de compra: " + LocalDate.now());
            fechaCompra = LocalDate.now();
            out.println("El otro material es restringido? Si(1)No(2)");
            opcion = Integer.parseInt(in.readLine());
            if (opcion == 1) {
                restringido = true;
            }

            out.println("Digite el tema del otro material");
            tema = in.readLine();
            out.println("Digite descripcion del otro material");
            descripcion = in.readLine();

            capa.agregarOtro(iD, fechaCompra, restringido, tema, descripcion);
            out.println("Sus datos fueron guardados en la clave # " + capa.getiM());

        }

    }

    /**
     * lista los usuarios registrados
     */
    public static void listarUsuarios() {

        for (int i = 0; i < capa.getUsuariosTree().size(); i++) {
            Usuarios u = (Usuarios) capa.getUsuariosTree().get(i);
            out.println(u.toString());
        }

    }

    /**
     * lista los materiales registrados
     */
    public static void listarMateriales() {

        for (int i = 0; i < capa.getMaterialesTree().size(); i++) {
            Materiales m = (Materiales) capa.getMaterialesTree().get(i);
            out.println(m.toString());

        }

    }

    /**
     * Remueve el usuario digitado
     *
     * @throws IOException
     */
    public static void modificarUsuario() throws IOException {

        int opc, decision;
        out.println("Cual es la clave del usuario que desea remover?");
        opc = Integer.parseInt(in.readLine());
        if (capa.getUsuariosTree().containsKey(opc) == true) {
            Usuarios u = (Usuarios) capa.getUsuariosTree().get(opc);
            out.println(u.toString());
            out.println("Desea remover este usuario? Si(1) No(2)");
            decision = Integer.parseInt(in.readLine());
            if (decision == 1) {
                capa.getUsuariosTree().remove(opc);
            }
        } else {
            out.println("No hay datos registrados en la opcion digitada");
        }

    }

    /**
     * Remueve el material digitado
     *
     * @throws IOException
     */
    public static void modificarMateriales() throws IOException {
        int opc;
        out.println("Cual es la clave del material que desea remover?");
        opc = Integer.parseInt(in.readLine());
        if (capa.getMaterialesTree().containsKey(opc) == true) {
            capa.getMaterialesTree().remove(opc);
        } else {
            out.println("No hay datos registrados en la opcion digitada");
        }

    }
}
