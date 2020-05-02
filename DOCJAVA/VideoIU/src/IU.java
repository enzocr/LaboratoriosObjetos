



import capaLogica.Tienda;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;


/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Tienda miTienda = new Tienda();

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
        } while (opc != 10);
    }

    /**
     * muestra el menu
     *
     * @throws IOException
     */
    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1.  Ingresar cliente");
        out.println("2.  Ingresar videos");
        out.println("3.  Registrar tienda");
        out.println("4.  Listar clientes");
        out.println("5.  Listar videos");
        out.println("6.  Listar tienda");
        out.println("7.  Alquilar");
        out.println("8.  Buscar Video");
        out.println("9.  Buscar Cliente");
        out.println("10. Mostrar herencia");
        out.println("11. Salir");

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
    public static void ejecutarAccion(int pOpcion) throws IOException {

        switch (pOpcion) {

            case 1:

                datosCliente();

                break;

            case 2:
                datosVideo();

                break;

            case 3:
                datosTienda();

                break;

            case 4:
                listarClientes();
                break;

            case 5:
                listarVideos();
                break;

            case 6:
                listarTienda();
                break;

            case 7:
                alquilar();
                break;

            case 8:
                buscarVideo();

                break;
            case 9:
                buscarCliente();
            case 10:
                mostrarHerencia();
                break;
            case 11:
                break;
            default:
                out.println("Opcion invalida");

        }

    }
    public static void mostrarHerencia(){
        /*
        
        
        ArrayList<Persona> listaCliente= new ArrayList<>();
        Empleado miEmpleado=new Empleado(todos loa valores);
        Cliente miCliente=new Cliente(todos los valores);
        lista.add(miCliente);
        lista.add(miEmpleado);
        for(int i=0;i<lista.size();i++){
        
        out.println(lista.get(i).toString());
        Persona p=lista.get(i);
        Empleado e=(Empleado) lista.get(i);
        p.toString();
        out.println(p);
        }
        
        
        
        */
        
        //crear un array list clientes
        //crear un cliente y un empleado
        //agregar el cliente y el empleado al array list
        //imprimir el toString de cada elemento del array list
    }
            
    
    

    /**
     * Se digitan los datos del Cliente, se confirma que la cedula del cliente
     * se encuentre registrada y se agrega a un Array List los datos
     *
     * @throws IOException
     */
    public static void datosCliente() throws IOException {
        int i = 0;
        String nombre, cedula, direccion, contrato;
        LocalDate fecha;

        out.println("Digite el nombre del cliente");
        nombre = in.readLine();

        do {
            out.println("Digite el numero de cedula del cliente");
            cedula = in.readLine();

            if (miTienda.comprobarCedulaCliente(cedula) == 1) {

                out.println("Cedula del cliente agregada");
                i = 1;
            }
            if (miTienda.comprobarCedulaCliente(cedula) == -1) {
                out.println("El numero de cedula del cliente ya esta en el sistema");

            }
        } while (i != 1);

        out.println("Digite la direccion del cliente");
        direccion = in.readLine();

        out.println("La fecha de ingreso del cliente será la de hoy: " + (LocalDate.now()));
        fecha = LocalDate.now();

        out.println("Digite el numero de contrato del cliente");
        contrato = in.readLine();
        
        out.println("Digite el codigo");
        String codigo=in.readLine();
        miTienda.registrarCliente(nombre, cedula, direccion, contrato, codigo, fecha);

        out.println("Datos del cliente agregados con exito");
    }

    /**
     * Se digitan los datos del video, se confirma que el titulo del video se
     * encuentre registrado o no y se agrega a un Array List los datos
     *
     * @throws IOException
     */
    public static void datosVideo() throws IOException {
        String titulo, tipo, iD;
        int i = 0;
        out.println("Digite el tipo del video");
        tipo = in.readLine();

        do {
            out.println("Digite el titulo del video");
            titulo = in.readLine();

            if (miTienda.comprobarVideo(titulo) == 1) {

                out.println("Titulo agregado");
                i = 1;
            }
            if (miTienda.comprobarVideo(titulo) == -1) {
                out.println("El titulo del video ya existe");

            }
        } while (i != 1);
        out.println("Digite el ID del video");
        iD = in.readLine();

        miTienda.registrarVideo(tipo, titulo, iD);

        out.println("Datos del video agregados");

    }

    /**
     * Se digitan los datos de la Tienda, para registrarlos
     *
     * @throws IOException
     */
    public static void datosTienda() throws IOException {
        String nombre, cedula, direccion;
        out.println("Digite el nombre de la tienda");
        nombre = in.readLine();
        out.println("Digite la cedula juridica de la tienda");
        cedula = in.readLine();
        out.println("Digite la direccion de la tienda");
        direccion = in.readLine();

        miTienda.registrarTienda(nombre, cedula, direccion);

    }

    /**
     * Lista los clientes registrados
     */
    public static void listarClientes() {
        
        
        for (int i = 0; i < miTienda.getClientes().length; i++) {

            out.println("CLIENTE # " + (i) + ": " + miTienda.getClientes()[i]);
            out.println("****************************************************");
        }
    }

    /**
     * Se listan los videos registrados
     *
     * @throws IOException
     */
    public static void listarVideos() throws IOException {
        for (int i = 0; i < miTienda.getVideos().length; i++) {

            out.println("VIDEO # " + (i));
            out.println(miTienda.getVideos()[i]);
            out.println("********************");
        }
    }

    /**
     * Se listan los datos de la tienda registrada
     *
     * @throws IOException
     */
    public static void listarTienda() throws IOException {

        out.println(miTienda.toString());

    }

    /**
     * Se inserta la cedula de identificacion del cliente, se comprueba que ya
     * el usuario este registrado en la Tienda, se consulta que tipo de video y
     * cual video se desea alquilar y a su vez comprueba que el video exista en
     * la tienda
     *
     * @throws IOException
     */
    public static void alquilar() throws IOException {
        String tipo;
        String video;
        String ID;

        out.println("Digite su identificacion");
        ID = in.readLine();
        if (miTienda.comprobarCedulaCliente(ID) == -1) {

            out.println("Digite el tipo de video que desea alquilar");
            tipo = in.readLine();

            out.println("Cual " + tipo + " desea alquilar");
            video = in.readLine();

            if (miTienda.comprobarVideo(video) == -1) {
                if ("DVD".equals(tipo)) {

                    out.println("***ALQUILER DEL DVD " + video + "*** \n"
                            + " Por el Cliente " + ID + " \n"
                            + " 2500 COLONES");

                }
                if ("Cinta".equals(tipo)) {

                    out.println("***ALQUILER DE LA CINTA " + video + "*** \n"
                            + " Por el Cliente " + ID + " \n"
                            + " 1500 COLONES");

                }
            } else {
                out.println("El Video no lo tiene la tienda");
            }

        } else {

            out.println("El cliente no esta registrado en el sistema");

        }

    }

    /**
     * Se digita el numero de cedula del cliente, indica si esta registrado o no
     * si esta registrado imprime los datos del cliente
     *
     * @throws IOException
     */
    public static void buscarCliente() throws IOException {
        String numCedula;
        out.println("Digite el numero de ID del cliente que desea buscar");
        numCedula = in.readLine();
        for (String cliente : miTienda.getClientes()) {
            
            if (miTienda.comprobarCedulaCliente(numCedula) == -1) {
                out.println("************" + numCedula + "***********");
                out.println(cliente);
            } else {
                out.println("No existe este cliente en el sistema");
            }
        }
    }

    /**
     * Se digite el titulo del video, indica si esta registrado o no si esta
     * registrado imprime los datos del video
     *
     * @throws IOException
     */
    public static void buscarVideo() throws IOException {
        String titulo;
        out.println("Digite el titulo del video que desea buscar");
        titulo = in.readLine();
        for (int i = 0; i < miTienda.getVideos().length; i++) {

            if (miTienda.comprobarVideo(titulo) == -1) {
                out.println("************" + titulo + "***********");
                out.println(miTienda.getVideos()[i]);

            } else {
                out.println("No existe este video en la tienda");
            }

        }

    }

}
