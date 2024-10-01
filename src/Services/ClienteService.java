/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.ArrayList;
import Models.Cliente;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ClienteService {
    ArrayList<Cliente> clientes;
    
    public ClienteService() {
        clientes = new ArrayList<Cliente>();
    }
    
    //Metetodo sin completar por ahora
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    //Metetodo sin completar por ahora
    public void eliminarCliente(int idCliente){
        for(Cliente cliente : clientes){
            if(cliente.getIdCliente() == idCliente){
                clientes.remove(cliente);
            }
        }
    }

    //Metetodo sin completar por ahora
    public void editarCliente(Cliente cliente) {
        clientes.set(clientes.indexOf(cliente), cliente);
    }
}
