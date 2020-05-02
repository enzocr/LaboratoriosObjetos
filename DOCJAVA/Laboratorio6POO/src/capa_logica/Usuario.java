package capa_logica;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Usuario extends Persona {

    /**
     *Se declara el atributo perfil del usuario
     */
    protected String perfil;

    /**
     *Se crea por defecto un constructor
     */
    public Usuario() {
        super();
    }

    /**
     *Inicializa atributos del usuario
     * @param iD
     * @param nombre
     * @param apellidos
     * @param password
     * @param perfil
     */
    public Usuario(String iD, String nombre, String apellidos, String password, String perfil) {
        super(iD, nombre, apellidos, password);
        this.perfil = perfil;
    }

    /**
     *Retorna perfil de la persona
     * @return perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     *Fija valor de atributo perfil del usuario
     * @param perfil
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
/**
 * Retorna como string los atributos del usuario
 * @return String's
 */
    @Override
    public String toString() {
        return "***********USUARIO************\n"
                + "Perfil: " + perfil + " \n "
                + "ID: " + iD + " \n "
                + "Nombre: " + nombre + " \n "
                + "Apellidos: " + apellidos + " \n "
                + "Password: " + password;

    }

}
