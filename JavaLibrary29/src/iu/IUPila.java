/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import estructuras.PilaException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author enzoq
 */
public class IUPila {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * @param args the command line arguments
     * @throws estructuras.PilaException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws PilaException, IOException {
        try {
            System.out.println("Sin error");
            throw new PilaException("Todo bien!");
        } catch (PilaException e) {
            
            System.out.println(e.getMessage());
            e.addExc(e.getMessage());

        }
    }

}
