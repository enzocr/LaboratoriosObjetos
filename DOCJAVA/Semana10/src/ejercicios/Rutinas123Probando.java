/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;

public class Rutinas123Probando{

        //Las variables importatantes aqui son globales.
	static int ciudadesReg=0;
	static int[]votos= new int[5];
	static String[] ciudades=new String[5];
        
        
	

	public static String[] obtenerMayorVotos(){
							 
	
		String[] resul=new String[2];
		int i, indice=0;
		int mayorVotos= votos[0];
		
		for(i = 1 ;i<  ciudadesReg;i++){			

			if( votos[i] > mayorVotos){

				mayorVotos = votos[i];				
				indice=i;
			} 
		}
                resul[0] = Integer.toString(indice);
		return resul;	
	}

	public static int calcularTotalVotos(){

		int totalVotos = 0;
		int i;

		for( i = 0; i< ciudadesReg;i++){

			totalVotos += votos[i]; //lo mismo que totalVotos = totalVotos + pvotos[i]
		}

		return totalVotos;
	}

	public static void registrarVotos(String pciudad, int pvotos){


			
	}
}
