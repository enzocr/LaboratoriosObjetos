package CapaAccesoBD;

import CapaAccesoBD.AccesoBD;

/**
 * Clase Conector
 *
 * @version 1.0
 * @author Laura Monge Izaguirre Clase que inicializa la conexión con los
 * valores correctos y permite manejar una única conexión para todo el proyecto
 * y
 *
 */
public class Conector {
    //atributo de la clase	

    private static AccesoBD conectorBD = null;

    /**
     * Método estático que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */
//	public static AccesoBD getConector() throws 
//	java.sql.SQLException,Exception{
//		if (conectorBD == null){			
////			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDCxC","sa","jass2002");
//			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDCxCAccess","","");
//		}
//		return conectorBD;
//	}
//	
    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        if (conectorBD == null) {
            conectorBD = new AccesoBD("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://LAPTOP-EIK6EEL0;DatabaseName=CLINICA;integratedsecurity = true");
        }//Cuando se hace un
        return conectorBD;
    }

}
