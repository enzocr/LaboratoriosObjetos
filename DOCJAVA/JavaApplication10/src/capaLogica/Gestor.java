
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaLogica;

import java.util.*;

/**
 *
 * @author Pabs
 */
public class Gestor {

    protected ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     * @return the listaClientes
     */
    public ArrayList<Cliente> getListaClientes() {

        return listaClientes;

    }

    /**
     * @param pidentificacion
     * @param pnombre
     * @param pcorreo
     */
    public void agregarCliente(String pidentificacion, String pnombre, String pcorreo) {

        Cliente nuevoCliente = new Cliente(pidentificacion, pnombre, pcorreo);

        listaClientes.add(nuevoCliente);

    }

    public Cliente buscarClienteId(String pId) {

        Cliente clienteEncontrado = null;

        for (Cliente objCliente : listaClientes) {

            if (objCliente.getIdentificacion().equals(pId)) {

                clienteEncontrado = objCliente;
            }

        }
        return clienteEncontrado;

    }

    public void agregarMascotaCliente(Cliente pobjCliente, String pidentificacion,
            String pnombre, String ptipo, String praza) {

        Mascota nuevaMascota = new Mascota(pidentificacion, pnombre, ptipo, praza);

        pobjCliente.asignarMascota(nuevaMascota);

    }

    public ArrayList<Mascota> getListaMascotasCliente(String pidCliente) {

        ArrayList<Mascota> listaMascotas = null;

        for (Cliente objCliente : listaClientes) {

            if (objCliente.getIdentificacion().equals(pidCliente)) {

                listaMascotas = objCliente.getListaMascotas();

            }

        }

        return listaMascotas;
    }

}
