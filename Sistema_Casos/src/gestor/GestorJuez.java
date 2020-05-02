/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.logging.Level;
import java.util.logging.Logger;
import multis.MultiJuez;

/**
 *
 * @author enzoq
 */
public class GestorJuez {

    static MultiJuez multi = new MultiJuez();

    public void registrarJuez(String sala, String clave, String nombreUsuario, String cedula, String primerNombre,
            String segundoNombre, String primerApellido, String segundoApellido, String telefono) {

        try {
            new MultiJuez().crearJuez(sala, clave, nombreUsuario, cedula,
                    primerNombre, segundoNombre, primerApellido, segundoApellido, telefono);
        } catch (Exception ex) {
            Logger.getLogger(GestorJuez.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /*
     public static boolean textFieldNotEmpty(TextField texto) {

        boolean r = false;

        if (texto.getText() != null && !texto.getText().isEmpty()) {
            r = true;
        }
        return r;

    }

    public static boolean textFieldNotEmpty(TextField texto, Label label, String textoValidar) {
        boolean r = true;
        String c = null;
        if (!textFieldNotEmpty(texto)) {
            r = false;
            c = textoValidar;

        }

        texto.setText(c);
        return r;

    
    
    
    *****************************
    
    
      public void agregarItem(ActionEvent event) {
        boolean nombreJuez = Validaciones.textFieldNotEmpty(primerNombre, nameLabel, "Nombre requerido");
        boolean apellidoJuez = Validaciones.textFieldNotEmpty(primerApellido, apellidoLabel, "Primer apellido requerido");
        boolean telefonoJuez = Validaciones.textFieldNotEmpty(telefono, telefonoLabel, "Telefono requerido");
        boolean salaJuez = Validaciones.textFieldNotEmpty(sala, salaLabel, "Sala requerida");
        boolean claveJuez = Validaciones.textFieldNotEmpty(clave, claveLabel, "Clave requerida");
        boolean usuarioJuez = Validaciones.textFieldNotEmpty(nombreUsuario, usuarioLabel, "Usuario requerido");
        boolean cedulaJuez = Validaciones.textFieldNotEmpty(cedula, cedulaLabel, "Cedula requerida");
    }
     */
}
