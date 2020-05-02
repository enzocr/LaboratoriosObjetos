/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import java.util.ArrayList;
import multis.MultiArticulo;
import multis.MultiCategoria;
import multis.MultiCliente;
import multis.MultiDireccion;
import multis.MultiFabrica;
import objetos.Articulo;
import objetos.Categoria;
import objetos.Cliente;
import objetos.Direccion;
import objetos.Fabrica;

/**
 *
 * @author enzoq
 */
public class Gestor {

    public Cliente registrarCliente(String nombre) throws Exception {
        Cliente cliente;
        cliente = new MultiCliente().crearCliente(nombre);
        return cliente;
    }

    public ArrayList<Cliente> listarClientes() throws Exception {
        ArrayList<Cliente> lista;
        lista = (new MultiCliente()).listarClientes();
        return lista;
    }

    public Cliente buscarCliente(String nombre) throws Exception {
        Cliente cliente = null;
        cliente = (new MultiCliente()).buscarCliente(nombre);
        return cliente;
    }

    public Articulo crearArticulo(String descripcion, double precio, Categoria categoria) throws Exception {
        Articulo articulo = null;
        articulo = (new MultiArticulo()).crearArticulo(descripcion, precio, categoria);
        return articulo;
    }

    public Articulo buscarArticulo(String descripcion) throws Exception {
        Articulo articulo = null;
        articulo = (new MultiArticulo()).buscarArticulo(descripcion);
        return articulo;
    }

    public ArrayList<Articulo> listarArticulos() throws Exception {
        ArrayList<Articulo> lista;
        lista = (new MultiArticulo()).listarArticulos();
        return lista;
    }

    public Categoria crearCategoria(String nombre, double descuento) throws Exception {
        Categoria categoria = null;
        categoria = (new MultiCategoria()).crearCategoria(nombre, descuento);
        return categoria;
    }

    public Categoria buscarCategoria(String nombre) throws Exception {
        Categoria categoria = null;
        categoria = (new MultiCategoria()).buscarCategoria(nombre);
        return categoria;
    }

    public ArrayList<Categoria> listarCategorias() throws Exception {
        ArrayList<Categoria> lista;
        lista = (new MultiCategoria()).listarCategorias();
        return lista;
    }

    public Fabrica crearFabrica(String nombre) throws Exception {
        Fabrica fabrica = null;
        fabrica = (new MultiFabrica()).crearFabrica(nombre);
        return fabrica;
    }

    public Fabrica buscarFabrica(String nombre) throws Exception {
        Fabrica fabrica = null;
        fabrica = (new MultiFabrica()).buscarFabrica(nombre);
        return fabrica;
    }

    public ArrayList<Fabrica> listarFabricas() throws Exception {
        ArrayList<Fabrica> lista;
        lista = (new MultiFabrica()).listarFabricas();
        return lista;
    }

    public Direccion buscarDireccion(String nombreCalle) throws Exception {
        Direccion direccion = null;
        direccion = (new MultiDireccion()).buscarDireccion(nombreCalle);
        return direccion;
    }

    public ArrayList<Direccion> listarDirecciones() throws Exception {
        ArrayList<Direccion> lista = (new MultiDireccion()).listarDirecciones();
        return lista;
    }

    public void agregarDireccionCliente(Cliente cliente, int numeroCalle, String nombreCalle,
            String canton, String provincia) throws Exception {
        new MultiDireccion().creaDireccionCliente(cliente, numeroCalle, nombreCalle, canton, provincia);

    }

    public void agregarDireccionFabrica(Fabrica fabrica, int numeroCalle, String nombreCalle,
            String canton, String provincia) throws Exception {
        new MultiDireccion().creaDireccionFabrica(fabrica, numeroCalle, canton, canton, provincia);
    }

}
