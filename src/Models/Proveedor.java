/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Productos.Producto;
import java.util.ArrayList;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Proveedor {
    private int idProveedor;
    private String nombreEmpresa;        
    private String telefonoContacto;        
    private String email;
    private ArrayList<Producto> productosSuministrados;

    public Proveedor(int idProveedor, String nombreEmpresa, String telefonoContacto, String email) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoContacto = telefonoContacto;
        this.email = email;
        this.productosSuministrados = new ArrayList<Producto>();
    }
    
    public void suministrarProducto(Producto producto) {
        // Yo creeria que falta validar que el producto que se pase exista en el array de Productos
        productosSuministrados.add(producto);
    }
    
    public void eliminarProducto(int codProducto) throws RuntimeException {
        // Busca el producto por su codigo y si lo encuentra lo borra del array, si no manda excepcion
        for (int i = 0; i < productosSuministrados.size(); i++) {
            if (productosSuministrados.get(i).getCodigoProducto() == codProducto) {
                productosSuministrados.remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el Producto que desea eliminar en este proveedor");
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Producto> getProductosSuministrados() {
        return productosSuministrados;
    }

    public void setProductosSuministrados(ArrayList<Producto> productosSuministrados) {
        this.productosSuministrados = productosSuministrados;
    }
    
    
    
    
}
