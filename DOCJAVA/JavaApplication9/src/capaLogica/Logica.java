package capaLogica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Enzo Quartino Zamora
 */
public class Logica {

    protected ArrayList<String[][]> listaCatalogos;
    protected ArrayList<Cliente> listaClientes;
    protected ArrayList<Orden> listaOrdenes;
    protected ArrayList<Camiseta> listaCamisas;
//    protected String[][] catalogo;
//    protected int fila = 0;
//    protected int col = 0;

    public Logica() {
        this.listaCatalogos = new ArrayList<>();
        this.listaCamisas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
        //this.catalogo = new String[20][20];
    }

    public Logica(ArrayList<Cliente> listaClientes, ArrayList<Orden> listaOrdenes,
            String[][] catalogo, int fila, int col) {
        this.listaCatalogos = new ArrayList<>();
        this.listaCamisas = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
        //this.catalogo = new String[20][20];

    }

    public ArrayList<String[][]> getListaCatalogos() {
        return listaCatalogos;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

    public ArrayList<Camiseta> getListaCamisas() {
        return listaCamisas;
    }

//    public String[][] getCatalogo() {
//        return catalogo;
//    }
//
//    public void setCatalogo(String[][] catalogo) {
//        this.catalogo = catalogo;
//    }
//
//    public int getFila() {
//        return fila;
//    }
//
//    public void setFila(int fila) {
//        this.fila = fila;
//    }
//
//    public int getCol() {
//        return col;
//    }
//
//    public void setCol(int col) {
//        this.col = col;
//    }
    public void agregarCliente(String nombre) {
        Cliente elCliente = new Cliente(nombre);
        listaClientes.add(elCliente);

    }

    public void agregarCamiseta(String iD, String color, String tam, String descripcion, String precio) {

        Camiseta laCamiseta = new Camiseta(iD, color, tam, descripcion, precio);
        listaCamisas.add(laCamiseta);

    }

    public String[] getCamisas() {

        int size = this.listaCamisas.size();
        String[] camisas = new String[size];
        int i = 0;
        for (Camiseta miCamisa : listaCamisas) {
            camisas[i] = miCamisa.toString();
            i++;
        }

        return camisas;

    }

    public void agregarCatalogo(LocalDate nombre, String idCamisa, int i) {
        int k = 0, j = 0;
        for (String[][] catalogo : listaCatalogos) {

            catalogo[k][j] = "iD";
            catalogo[k][j + 1] = "color";
            catalogo[k][j + 2] = "tam";
            catalogo[k][j + 3] = "descripcion";
            catalogo[k][j + 4] = "precio";
            catalogo[k + 1][j] = listaCamisas.get(i).getiD();
            catalogo[k + 1][j + 1] = listaCamisas.get(i).getColor();
            catalogo[k + 1][j + 2] = listaCamisas.get(i).getTam();
            catalogo[k + 1][j + 3] = listaCamisas.get(i).getDescripcion();
            catalogo[k + 1][j + 4] = listaCamisas.get(i).getPrecio();

            listaCatalogos.add(catalogo);

        }

        Catalogo elCatalogo = new Catalogo(nombre);

    }

    public int comprobarIdCamisa(String idCamisa) {
        for (int i = 0; i < getListaCamisas().size(); i++) {
            if (idCamisa.equals(getListaCamisas().get(i).getiD())) {
                return -1;
            }
        }
        return 1;
    }

    public int comprobarIdOrden(String idOrden) {
        for (int i = 0; i < getListaOrdenes().size(); i++) {
            if (idOrden.equals(getListaOrdenes().get(i).getiD())) {
                return -1;
            }
        }
        return 1;
    }

    public String[] getCatalogos() {

        String despliegue[] = new String[10];
        for (int i = 0; i < listaCatalogos.size(); i++) {
            Catalogo cat = new Catalogo();
            //despliegue[i] += listaCatalogos.get(j).getNombre() + "\n";
            //despliegue[i]+= cat.getNombre()[i];
            despliegue[i] += listaCatalogos.get(i)[0][0] + "       " + listaCatalogos.get(i)[0][1] + "       " + listaCatalogos.get(i)[0][2] + "       " + listaCatalogos.get(i)[0][3] + "       " + listaCatalogos.get(i)[0][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[1][0] + "       " + listaCatalogos.get(i)[1][1] + "       " + listaCatalogos.get(i)[1][2] + "       " + listaCatalogos.get(i)[1][3] + "       " + listaCatalogos.get(i)[1][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[2][0] + "       " + listaCatalogos.get(i)[2][1] + "       " + listaCatalogos.get(i)[2][2] + "       " + listaCatalogos.get(i)[2][3] + "       " + listaCatalogos.get(i)[2][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[3][0] + "       " + listaCatalogos.get(i)[3][1] + "       " + listaCatalogos.get(i)[3][2] + "       " + listaCatalogos.get(i)[3][3] + "       " + listaCatalogos.get(i)[3][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[4][0] + "       " + listaCatalogos.get(i)[4][1] + "       " + listaCatalogos.get(i)[4][2] + "       " + listaCatalogos.get(i)[4][3] + "       " + listaCatalogos.get(i)[4][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[5][0] + "       " + listaCatalogos.get(i)[5][1] + "       " + listaCatalogos.get(i)[5][2] + "       " + listaCatalogos.get(i)[5][3] + "       " + listaCatalogos.get(i)[5][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[6][0] + "       " + listaCatalogos.get(i)[6][1] + "       " + listaCatalogos.get(i)[6][2] + "       " + listaCatalogos.get(i)[6][3] + "       " + listaCatalogos.get(i)[6][4] + "\n";
            despliegue[i] += listaCatalogos.get(i)[7][0] + "       " + listaCatalogos.get(i)[7][1] + "       " + listaCatalogos.get(i)[7][2] + "       " + listaCatalogos.get(i)[7][3] + "       " + listaCatalogos.get(i)[7][4] + "\n";
        }

        return despliegue;

    }

    public void agregarOrden(String iD, String tipo, LocalDate fechaOrden, String precioCamiseta, String cantCamisetas) {

        Orden laOrden = new Orden(iD, tipo, fechaOrden, precioCamiseta, cantCamisetas);
        listaOrdenes.add(laOrden);

    }

    public String[] getOrdenes() {
        int size = this.listaOrdenes.size();
        String[] ordenes = new String[size];
        int i = 0;
        for (Orden miOrden : listaOrdenes) {
            ordenes[i] = miOrden.toString();
            i++;
        }

        return ordenes;
    }

}
