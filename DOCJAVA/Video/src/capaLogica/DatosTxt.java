package capaLogica;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DatosTxt {

    /**
     * Crea y agrega una tienda a un .txt
     *
     * @param miTienda objeto de tipo Tienda
     */
    public void addTienda(Tienda miTienda) {
        try {
            // Esta clase es para crear el archivo
            File myFile = new File("Tienda.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;

            if (myFile.exists()) { // Si el archivo existe entonces que cree una linea por cada objeto insertado
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine(); // salto de linea por cada nuevo objeto
                bWriter.write(
                        miTienda.getNombreTienda()+ "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miTienda.getCedulaTienda() + "%" // en este caso es el %
                     //   + miTienda.getDireccion()
                );

            } else {
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(
                        miTienda.getNombreTienda()+ "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miTienda.getCedulaTienda() + "%" // en este caso es el %
                       // + miTienda.getDireccion()
                );
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println("Error de addTienda " + e.getMessage());
        }
    }

    /**
     * Crea y agrega un objeto de tipo cliente al .txt
     *
     * @param miCliente objeto de tipo cliente
     */
    public void addCliente(Cliente miCliente) {
        try {
            // Esta clase es para crear el archivo
            File myFile = new File("Clientes.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;

            if (myFile.exists()) { // Si el archivo existe entonces que cree una linea por cada objeto insertado
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine(); // salto de linea por cada nuevo objeto
                bWriter.write(
                        miCliente.getNombre() + "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miCliente.getCedula() + "%" // en este caso es el %
                        + miCliente.getDireccion() + "%"
                       // + miCliente.getFecha_ingreso() + "%"
                        + miCliente.getNumContratoCliente()
                );

            } else {
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(
                        miCliente.getNombre() + "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miCliente.getCedula() + "%" // en este caso es el %
                        + miCliente.getDireccion() + "%"
                       // + miCliente.getFecha_ingreso() + "%"
                        + miCliente.getNumContratoCliente()
                );
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println("Error de addCliente " + e.getMessage());
        }
    }

    /**
     * Crea y agrega a un .txt un objeto de tipo video
     *
     * @param miVideo objeto de tipo Video
     */
    public void addVideo(Video miVideo) {
        try {
            // Esta clase es para crear el archivo
            File myFile = new File("Videos.txt");
            FileWriter fWriter;
            BufferedWriter bWriter;

            if (myFile.exists()) { // Si el archivo existe entonces que cree una linea por cada objeto insertado
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.newLine(); // salto de linea por cada nuevo objeto
                bWriter.write(
                        miVideo.getiD()+ "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miVideo.getTipo() + "%" // en este caso es el %
                        + miVideo.getTitulo()
                );

            } else {
                fWriter = new FileWriter(myFile, true);
                bWriter = new BufferedWriter(fWriter);
                bWriter.write(
                        miVideo.getiD() + "%" // para saber que corresponde de cada uno necesitamos un simbolo
                        + miVideo.getTipo() + "%" // en este caso es el %
                        + miVideo.getTitulo()
                );
            }
            bWriter.close();
            fWriter.close();
        } catch (IOException e) {
            System.out.println("Error de addVideo " + e.getMessage());
        }
    }

    /**
     * Lee el .txt de tienda y lo guarda dentro de un arreglo
     */
    public void showTienda() {
        try {
            // Accedemos al archivo
            File myFile = new File("Tienda.txt");
            if (myFile.exists()) { // Si el archivo existe entonces leeremos
                FileReader fReader = new FileReader(myFile);
                BufferedReader bufferReader = new BufferedReader(fReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {

                    /*
                        Creamos un arreglo que se llena con la linea 
                        que lea dependiendo de las separaciones que encuentra
                        con el porcentaje que los separa
                     */
                    String[] datos = linea.split("%");
                    Tienda obj = new Tienda(
                            datos[0],
                            datos[1],
                            datos[2]
                    );
                    obj.imprimirTienda();
                    System.out.println(" ");
                }

            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Lee el .txt de clientes y lo guarda dentro de un arreglo
     */
    public void showCliente() {
        try {
            // Accedemos al archivo
            File myFile = new File("Clientes.txt");
            if (myFile.exists()) { // Si el archivo existe entonces leeremos
                FileReader fReader = new FileReader(myFile);
                BufferedReader bufferReader = new BufferedReader(fReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {

                    /*
                        Creamos un arreglo que se llena con la linea 
                        que lea dependiendo de las separaciones que encuentra
                        con el porcentaje que los separa
                     */
                    String[] datos = linea.split("%");
                    Cliente obj = new Cliente(
                            datos[0],
                            datos[2],
                            datos[1],
                            datos[4],
                            datos[3]
                    );
                    obj.imprimirCliente();
                    System.out.println(" ");
                }

            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Lee el .txt de videos y lo guarda dentro de un arreglo
     */
    public void showVideo() {
        try {
            // Accedemos al archivo
            File myFile = new File("Videos.txt");
            if (myFile.exists()) { // Si el archivo existe entonces leeremos
                FileReader fReader = new FileReader(myFile);
                BufferedReader bufferReader = new BufferedReader(fReader);
                String linea;

                while ((linea = bufferReader.readLine()) != null) {

                    /*
                        Creamos un arreglo que se llena con la linea 
                        que lea dependiendo de las separaciones que encuentra
                        con el porcentaje que los separa
                     */
                    String[] datos = linea.split("%");
                    Video obj = new Video(
                            datos[0],
                            datos[2],
                            datos[1]
                    );
                   // obj.imprimirVideo();
                    System.out.println(" ");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
