package CapaLogica;

import java.sql.*;
import java.util.Date;
import java.util.Vector;
import CapaAccesoBD.Conector;

public class MultiAbono {
	
	public  Abono crear(String pfecha, double pmonto,String pnumeroCuenta) 
			throws java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
		Abono abono=null;
		int numeroAbono=0;
		String sql;
		sql="INSERT INTO TAbono "+
		"(numCuenta, monto, fecha)"+
		"VALUES ('"+pnumeroCuenta+"',"+pmonto+",'"+pfecha+"');";
		Conector.getConector().ejecutarSQL(sql);
//		sql = "SELECT IDENT_CURRENT ('TAbono') AS nuevoNumero;";
		sql = "SELECT max(numero) AS nuevoNumero from TAbono;";

		rs = Conector.getConector().ejecutarSQL(sql, true);
		if (rs.next()) {
			numeroAbono = rs.getInt("nuevoNumero");
			abono = new Abono(numeroAbono, pfecha, pmonto,pnumeroCuenta);
		} else {
			throw new java.sql.SQLException ("Error en la BD.");
		}
		rs.close();
		return abono;
	}
	
	public  Abono buscar(String pnumero) throws
			java.sql.SQLException,Exception{
		Abono abono = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TAbono "+
		"WHERE numero='"+pnumero+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			abono = new Abono(
				rs.getInt("numero"),
				rs.getString("fecha"),
				rs.getDouble("monto"),
				rs.getString("numCuenta"));
		} else {
			throw new Exception ("El abono no está registrado en el sistema.");
		}
		rs.close();
		return abono;
	}
	
	public  Vector buscarPorCuenta(String pnumeroCuenta) throws java.sql.SQLException,Exception{
			java.sql.ResultSet rs;
		String sql;
		Abono abono=null;
		Vector abonos=null;
		sql="SELECT * "+
		"FROM TAbono "+
		"WHERE numCuenta='"+pnumeroCuenta+"';";
		Conector.getConector().ejecutarSQL(sql);
		rs = Conector.getConector().ejecutarSQL(sql,true);
		abonos = new Vector();
		while (rs.next()){
			abono = new Abono(
				rs.getInt("numero"),
				rs.getString("fecha"),
				rs.getDouble("monto"),
				rs.getString("numCuenta"));
				abonos.add(abono);
		}
		rs.close();
		return abonos;
	}
	
	public  void borrar(Abono pabono) throws
			java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
		String sql;
		sql= "DELETE FROM TAbono "+
		"WHERE numero='"+pabono.getNumeroAbono()+"'";
		Conector.getConector().ejecutarSQL(sql);
	}
}