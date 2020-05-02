package CapaLogica;

import java.sql.*;
import java.io.*;
import java.util.*;
import CapaAccesoBD.Conector;

public class MultiCliente {

	public  Cliente crear(String pnombre, String pidentificacion) 
			throws Exception{
		Cliente cliente=null;
		String sql;
		sql = "INSERT INTO TCliente "+
		"(nombre, identificacion) "+
		"VALUES ('"+pnombre+"', '"+pidentificacion+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			cliente = new Cliente (pnombre, pidentificacion);
		}
		catch (Exception e) {
			throw e;
		}
		return cliente;
	}
	
	public  Cliente buscar(String pidentificacion) throws 
			java.sql.SQLException,Exception{
		Cliente cliente=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT nombre, identificacion "+
		"FROM TCliente "+
		"WHERE identificacion='"+ pidentificacion +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			cliente = new Cliente (rs.getString("nombre"), rs.getString("identificacion"));
		} else {
			throw new Exception ("El cliente no está registrado.");
		}
		rs.close();
		return cliente;
	}
	
	public  Vector buscarPorNombre(String pnomCliente) throws 
			java.sql.SQLException,Exception{
		Cliente cliente=null;
		Vector clientes=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT nombre, identificacion "+
		"FROM TCliente "+
		"WHERE nombre LIKE '%"+pnomCliente+"%';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		clientes = new Vector ();
		if (rs.next()) {//rs.next() si hay mas registros true o false
			do {
				cliente = new Cliente (rs.getString("nombre"), rs.getString("identificacion"));
				clientes.add(cliente);
			} while (rs.next());
		} else {
			throw new Exception ("No hay clientes con ese nombre.");// no conviene mandar excepciones en esta caso porque aqui si es valido que existan clientes
		}//exepciones solo condiciones exepcionales
		rs.close();
		return clientes;
	}
	
	public  void actualizar(Cliente pcliente) throws 
			java.sql.SQLException,Exception{
		String sql;
		sql = "UPDATE TCliente "+
		"SET nombre='"+pcliente.getNombre()+"' "+
		"WHERE identificacion='"+pcliente.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El cliente no está registrado.");
		}
	}
	
	public  void borrar(Cliente pcliente) throws 
			java.sql.SQLException,Exception{
		String sql;
		sql = "DELETE FROM TCliente "+
		"WHERE identificacion='"+pcliente.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El cliente tiene cuentas.");
		}
	}
}