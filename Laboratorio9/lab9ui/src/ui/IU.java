package ui;


import capaLogica.Correo;
import capaLogica.Mensaje;
import capaLogica.Gestor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class IU {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor capa = new Gestor();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            int opc;

            do {

                mostrarMenu();
                opc = leerOpcion();
                ejecutarAccion(opc);

            } while (opc != 3);
        } catch (Exception e) {
            out.println(e.getMessage());

        }
    }

    public static void mostrarMenu() throws IOException {

        out.println();
        out.println("-----BIENVENIDO-----");
        out.println("1. ---INICIAR SESION---");
        out.println("2. ---REGISTRARSE---");
        out.println("3. SALIR");
        

        out.println();
    }

    public static int leerOpcion() throws Exception {

        int opcion;

        
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione accion a realizar"));
        
        if(opcion<0||opcion>3){
            
            throw new Exception ("OPCION INVALIDA");
            
        }
        
        return opcion;
    }

    public static void ejecutarAccion(int pOpcion) throws Exception {

        switch (pOpcion) {

            case 1:
                iniciarSesion();
                
                break;
            case 2:
                registrarUsuario();
                break;
            case 3:
                break;
            
            default:
                out.println("Opcion invalida");
                throw new Exception("OPCION INVALIDA");
        }
    }

    public static void iniciarSesion() throws Exception {

        out.println("Correo electronico");
        String correo = in.readLine();
        Correo email = capa.buscarEmail(correo);
        if (email == null) {
            out.println("No esta registrado, desea registrarse SI(1) NO(2)?");
            int decision = Integer.parseInt(in.readLine());
            if(decision <1 || decision>2){
                throw new Exception("ERROR");
            }
            if (decision == 1) {
                registrarUsuario();
            }
            
        } else {
            out.println("Digite la clave de usuario");
            String password = in.readLine();
            Correo clave = capa.buscarClave(password);
            if (clave == null) {
                out.println("Clave incorrecta");
            } else {
                out.println("---HA INICIADO SESION---");
                mostrarInbox(email);
                out.println("---outbox---");
                mostrarOutbox(email);

                out.println("1. NEW");
                int decision = Integer.parseInt(in.readLine());
                if (decision == 1) {
                    out.println("Correo electronico al que desea enviar mensaje");
                    String correoTo = in.readLine();
                    Correo emailTo = capa.buscarEmail(correoTo);
                    if (emailTo == null) {
                        out.println("NO EXISTE ESTE CORREO");
                    } else {
                        out.println("TO: " + emailTo.getEmail());
                        out.println("FROM: " + email.getEmail());
                        out.println("Escribir mensaje...");
                        String mensaje = in.readLine();
                        out.println("Asunto");
                        String asunto = in.readLine();
                        Mensaje m = new Mensaje(emailTo, email, mensaje, asunto);
                        if (capa.enviar(m) == 1) {
                            //se envio
                        } else {
                            //no se envio
                        }
                    }

                }

            }

        }

    }

    public static void registrarUsuario() throws IOException {
        out.println("Digite el nombre");
        String nombre = in.readLine();
        out.println("Digite apellidos");
        String apellidos = in.readLine();
        out.println("Digite el nombre del email");
        String email = in.readLine();
        out.println("Digite clave");
        String clave = in.readLine();

        capa.agregarCorreo(nombre, apellidos, email, clave);

    }

    private static void mostrarInbox(Correo email) {
        HashSet<Mensaje> listaMensajes = capa.recibir(email);
        out.println(listaMensajes.toString() + "\n");

    }

    private static void mostrarOutbox(Correo email) {
        HashSet<Mensaje> listaMensajes = capa.recibirOutbox(email);
        out.println(listaMensajes.toString() + "\n");
    }

}
