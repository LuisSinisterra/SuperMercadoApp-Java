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
    
    //Metetodo sin completar por ahora
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    //Metetodo sin completar por ahora
    public void eliminarProveedor(int idProveedor){
        for(Proveedor proveedor : proveedores){
            if(proveedor.getIdProveedor() == idProveedor){
                proveedores.remove(proveedor);
            }
        }
    }

    //Metetodo sin completar por ahora
    public void editarProveedor(Proveedor proveedor) {
        proveedores.set(proveedores.indexOf(proveedor), proveedor);
    }
}
