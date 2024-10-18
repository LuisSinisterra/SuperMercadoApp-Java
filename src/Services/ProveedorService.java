/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.ProveedorDAO;
import java.util.ArrayList;
import Models.Proveedor;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProveedorService {

    //ArrayList<Proveedor> proveedores;
    private ProveedorDAO proveedorDAO;

    public ProveedorService() {
        proveedorDAO = new ProveedorDAO();
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedorDAO.getProveedores();
    }

    public void agregarProveedor(Proveedor proveedor) throws RuntimeException{
        // Valida campos de proveedor
        if (isVacioCampo(proveedor)) {
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
        if (!esEmailValido(proveedor.getEmail())) {
            throw new RuntimeException("El email debe ser de un formato válido");
        }
        proveedorDAO.agregarProveedor(proveedor);
    }

    // Elimina proveedor por id, si no encuentra lanza excepcion
    public void eliminarProveedor(int idProveedor) {
        proveedorDAO.eliminarProveedor(idProveedor);
    }

    // Edita el proveedor, segun la busqueda del id de este mismo
    public void editarProveedor(Proveedor proveedor) throws RuntimeException {
        // VALIDA LOS CAMPOS
        if (isVacioCampo(proveedor)) {
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
        if (!esEmailValido(proveedor.getEmail())) {
            throw new RuntimeException("El email debe ser de un formato válido");
        }
        
        proveedorDAO.editarProveedor(proveedor);

    }

    // Busca Proveedor Por Id
    public Proveedor buscarProveedorPorId(int idProveedor) {
        return proveedorDAO.buscarProveedorId(idProveedor);
    }

    public boolean isVacioCampo(Proveedor proveedor) {
        return proveedor.getEmail().trim().isEmpty()
                || proveedor.getNombreEmpresa().trim().isEmpty() || proveedor.getTelefonoContacto().trim().isEmpty();

    }
    private boolean esEmailValido(String email) {
        // Verifica que el email contenga '@' y '.' después del '@'
        int indexArroba = email.indexOf('@');
        int indexPunto = email.lastIndexOf('.');

        // Debe tener un '@', un '.' después del '@', y algo antes y después de esos caracteres
        return indexArroba > 0 && indexPunto > indexArroba + 1 && indexPunto < email.length() - 1;
    }
}
