/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Dao.ProveedorDAO;
import Helpers.HelperFunctions;
import java.util.ArrayList;

import Models.Proveedor;
import Models.Productos.Producto;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProveedorService {

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
        
        if (!HelperFunctions.esEmailValido(proveedor.getEmail())) {
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
        
        if (!HelperFunctions.esEmailValido(proveedor.getEmail())) {
            throw new RuntimeException("El email debe ser de un formato válido");
        }
        
        proveedorDAO.editarProveedor(proveedor);
    }

    // Busca Proveedor Por Id
    public Proveedor buscarProveedorPorId(int idProveedor) {
        return proveedorDAO.buscarProveedorId(idProveedor);
    }
    
    // Busca Productos por Id Proveedor
    public ArrayList<Producto> buscarProductosProveedor(int idProveedor) {
        return proveedorDAO.buscarProductosProveedor(idProveedor);
    }

    private boolean isVacioCampo(Proveedor proveedor) {
        return proveedor.getEmail().trim().isEmpty()
                || proveedor.getNombreEmpresa().trim().isEmpty() || proveedor.getTelefonoContacto().trim().isEmpty();

    }
}
