/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.*;

public class CL {

    private static String[] videos = new String[5];
    private static int pos = 0;

    public static void registrarVideos(String pNombre) {
        if (pos < videos.length) {
            videos[pos] = pNombre;
            pos++;
        }

    }

    public static String[] getVideos() {
        return videos;
    }

}
