/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.ArrayList;
import Models.Proveedor;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProveedorService {
    ArrayList<Proveedor> proveedores;
    
    public ProveedorService() {
        proveedores = new ArrayList<Proveedor>();
    }
    
    // Agrega proveedor default, falta configurar el id incrementable mejor
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    // Elimina proveedor por id, si no encuentra lanza excepcion
    public void eliminarProveedor(int idProveedor) throws RuntimeException{
        for(Proveedor proveedor : proveedores){
            if(proveedor.getIdProveedor() == idProveedor){
                proveedores.remove(proveedor);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Proveedor que desea eliminar");
    }
    
      // Edita el proveedor, segun la busqueda del id de este mismo
    public void editarProveedor(Proveedor proveedor) throws RuntimeException {
        //proveedors.set(proveedors.indexOf(proveedor), proveedor); // esto no esta bien creo
        Proveedor aux = buscarProveedorPorId(proveedor.getIdProveedor());
        if (aux != null) {
            aux.setNombreEmpresa(proveedor.getNombreEmpresa());
            aux.setTelefonoContacto(proveedor.getTelefonoContacto());
            aux.setEmail(proveedor.getEmail());
            
            return;
        }
        throw new RuntimeException("No se encuentra el Proveedor que desea editar");
    }
    
    // Busca Proveedor Por Id
    public Proveedor buscarProveedorPorId(int idProveedor){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getIdProveedor() == idProveedor){
                return proveedor;
            }
        }
        return null;
    }
}
