

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Formatter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author enzoq
 */
public class ArchivosTexto {
     static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        try {
            File x = new File("txt.txt");

            Scanner sc = new Scanner(x);
            while (sc.hasNext()) {
                out.println(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            out.println("Error");
        }

        File file = new File("list.txt");
        Formatter f = new Formatter("list.txt");
        if (file.exists()) {
            String n;
            out.println("Digite n");
            n = in.readLine();
            f.format(n + "\n");
            f.close();
        }

    }

}
