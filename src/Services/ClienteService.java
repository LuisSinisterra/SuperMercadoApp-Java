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

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Agrega cliente default, falta configurar el id incrementable mejor
    public void agregarCliente(Cliente cliente) throws RuntimeException {
        // Valida campos de cliente
        if(isVacioCampo(cliente)){
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
        // VALIDA EL ID Y EL EMAIL
        for (Cliente c : clientes) {
            if (c.getIdCliente() == cliente.getIdCliente()) {
                throw new RuntimeException("Lo siento, El id de este cliente ya existe");
            }
            if (c.getEmail().equals(cliente.getEmail())) {
                throw new RuntimeException("Lo siento, El email de este cliente ya existe");
            }
        }

        clientes.add(cliente);
    }

    // Elimina cliente, si no encuentra su id lanza excepcion
    public void eliminarCliente(int idCliente) throws RuntimeException {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                clientes.remove(cliente);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Cliente que desea eliminar");
    }

    // Edita el cliente, segun la busqueda del id de este mismo
    public void editarCliente(Cliente cliente) throws RuntimeException {
        // VALIDA LOS CAMPOS
        if(isVacioCampo(cliente)){
            throw new RuntimeException("FALTAN CAMPOS");
        }

        Cliente aux = buscarClientePorId(cliente.getIdCliente());
        if (aux != null) {
            // Valida que el email no exista en otros clientes
            for (Cliente c : clientes) {
                if (c.getEmail().equals(cliente.getEmail())) {
                    throw new RuntimeException("Lo siento, El email de este cliente ya existe");
                }
            }
            // Se ejecuta si no hay problema
            aux.setNombreCompleto(cliente.getNombreCompleto());
            aux.setTelefono(cliente.getTelefono());
            aux.setEmail(cliente.getEmail());

            return;
        }
        throw new RuntimeException("No se encuentra el Cliente que desea editar");
    }

    // Busca Cliente Por Id
    public Cliente buscarClientePorId(int idCliente) throws RuntimeException{
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        throw new RuntimeException("No se encuentra el Cliente");
    }
    
    public boolean isVacioCampo(Cliente cliente){
        return cliente.getEmail().trim().isEmpty() || 
                cliente.getNombreCompleto().trim().isEmpty() || cliente.getTelefono().trim().isEmpty();
        
    }
}
