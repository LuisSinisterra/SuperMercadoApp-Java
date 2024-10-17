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
    
    public void agregarProveedor(Proveedor proveedor) {
        // Valida campos de proveedor
        if(isVacioCampo(proveedor)){
            throw new RuntimeException("FALTAN CAMPOS");
        }
        // VALIDA EL ID Y EL EMAIL (ESTE CODIGO YA ES DEFECTUOSO POR EL MOMENTO)
//        for (Proveedor p : proveedores) {
//            if (p.getIdProveedor()== proveedor.getIdProveedor()) {
//                throw new RuntimeException("Lo siento, El id de este proveedor ya existe");
//            }
//            if (p.getEmail().equals(proveedor.getEmail())) {
//                throw new RuntimeException("Lo siento, El email de este proveedor ya existe");
//            }
//        }
        proveedorDAO.agregarProveedor(proveedor);
    }

    // Elimina proveedor por id, si no encuentra lanza excepcion
    public void eliminarProveedor(int idProveedor) throws RuntimeException{
        proveedorDAO.eliminarProveedor(idProveedor);
        //throw new RuntimeException("No se encuentra el Proveedor que desea eliminar");
    }
    
      // Edita el proveedor, segun la busqueda del id de este mismo
    public void editarProveedor(Proveedor proveedor) throws RuntimeException {
        // VALIDA LOS CAMPOS
        if(isVacioCampo(proveedor)){
            throw new RuntimeException("FALTAN CAMPOS");
        }
        
//        Proveedor aux = buscarProveedorPorId(proveedor.getIdProveedor());
//        if (aux != null) {
//            // Valida que el email no exista en otros proveedors
//            for (Proveedor p : proveedores) {
//                if (p.getEmail().equals(proveedor.getEmail())) {
//                    throw new RuntimeException("Lo siento, El email de este proveedor ya existe");
//                }
//            }
//            
//            aux.setNombreEmpresa(proveedor.getNombreEmpresa());
//            aux.setTelefonoContacto(proveedor.getTelefonoContacto());
//            aux.setEmail(proveedor.getEmail());
//            
//            return;
//        }
//        throw new RuntimeException("No se encuentra el Proveedor que desea editar");
        proveedorDAO.editarProveedor(proveedor);
    }
    
    // Busca Proveedor Por Id
    public Proveedor buscarProveedorPorId(int idProveedor) throws RuntimeException{
//        for(Proveedor proveedor : proveedores){
//            if(proveedor.getIdProveedor() == idProveedor){
//                return proveedor;
//            }
//        }
        return proveedorDAO.buscarProveedorId(idProveedor);
        //throw new RuntimeException("No se encuentra el Proveedor");
    }
    
    public boolean isVacioCampo(Proveedor proveedor){
        return proveedor.getEmail().trim().isEmpty() || 
                proveedor.getNombreEmpresa().trim().isEmpty() || proveedor.getTelefonoContacto().trim().isEmpty();
        
    }
}
