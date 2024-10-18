/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.ClienteDAO;
import Helpers.HelperFunctions;
import java.util.ArrayList;
import Models.Cliente;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ClienteService {

    private ClienteDAO clienteDAO;

    public ClienteService() {
        clienteDAO = new ClienteDAO();
    }

    public ArrayList<Cliente> getClientes() {
        return clienteDAO.getClientes();
    }

    // Agrega cliente default
    public void agregarCliente(Cliente cliente) throws RuntimeException {
        // Valida campos de cliente
        if (isVacioCampo(cliente)) {
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
        if (!HelperFunctions.esEmailValido(cliente.getEmail())) {
            throw new RuntimeException("El email debe ser de un formato válido");
        }

        clienteDAO.agregarCliente(cliente);
    }

    // Elimina cliente
    public void eliminarCliente(int idCliente) {
        clienteDAO.eliminarCliente(idCliente);
    }

    // Edita el cliente, segun la busqueda del id de este mismo
    public void editarCliente(Cliente cliente) throws RuntimeException {
        // VALIDA LOS CAMPOS
        if (isVacioCampo(cliente)) {
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
        if (!HelperFunctions.esEmailValido(cliente.getEmail())) {
            throw new RuntimeException("El email debe ser de un formato válido");
        }

        clienteDAO.editarCliente(cliente);
    }

    // Busca Cliente Por Id
    public Cliente buscarClientePorId(int idCliente) {
        return clienteDAO.buscarClienteId(idCliente);
    }

    public boolean isVacioCampo(Cliente cliente) {
        return cliente.getEmail().trim().isEmpty()
                || cliente.getNombreCompleto().trim().isEmpty() || cliente.getTelefono().trim().isEmpty();

    }
}
