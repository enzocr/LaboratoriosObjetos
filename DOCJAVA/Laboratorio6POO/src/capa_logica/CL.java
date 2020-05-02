package capa_logica;

import java.util.ArrayList;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class CL {

    /**
     *Se declara un ArrayList de clase Persona
     */
    protected ArrayList<Persona> listaPersonas;

    /**
     *Se crea un constructor por defecto
     */
    public CL() {
        this.listaPersonas = new ArrayList<>();
    }

    /**
     *Inicializa constructor
     * @param listaPersonas
     */
    public CL(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = new ArrayList<>();
    }

    /**
     *Retorna un arraylist de clase Persona
     * @return listaPersonas
     */
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    /**
     *Recibe los datos del cliente y los registra en un arraylist
     * @param direccion
     * @param telefono1
     * @param telefono2
     * @param correo
     * @param iD
     * @param nombre
     * @param apellidos
     * @param password
     */
    public void agregarCliente(String direccion, String telefono1, String telefono2,
            String correo, String iD, String nombre, String apellidos, String password) {
        Cliente miCliente = new Cliente(iD, nombre, apellidos, password, direccion, telefono1, telefono2, correo);
        listaPersonas.add(miCliente);
    }

    /**
     *Recibe los datos del usuario y los registra en un arraylist
     * @param iD
     * @param nombre
     * @param apellidos
     * @param password
     * @param perfil
     */
    public void agregarUsuario(String iD, String nombre, String apellidos, String password, String perfil) {

        Usuario miUsuario = new Usuario(iD, nombre, apellidos, password, perfil);
        listaPersonas.add(miUsuario);

    }

    /**
     *Retorna arreglo de los toString's del ArrayList listaPersonas
     * @return personas
     */
    public String[] getPersonas() {
        int size = this.listaPersonas.size();
        String[] personas = new String[size];
        int i = 0;
        for (Persona miPersona : listaPersonas) {

            personas[i] = miPersona.toString();
            i++;

        }

        return personas;
    }

    /**
     *Se retorna un objeto de clase Persona
     * @param pId
     * @return encontrada
     */
    public Persona buscarPersona(String pId) {
        Persona encontrada = null;
        for (Persona laPersona : listaPersonas) {
            if (laPersona.getiD().equals(pId)) {
                encontrada = laPersona;
            }
        }
        return encontrada;
    }

}
