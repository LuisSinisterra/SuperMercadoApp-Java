/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

import Models.Proveedor;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public abstract class Producto {
    
    private int codigoProduto;
    private String nombreProducto;
    private double precio;
    private int stock;
    private Proveedor proveedor;

    public Producto(int codigoProduto, String nombreProducto, double precio, int stock, Proveedor proveedor) {
        this.codigoProduto = codigoProduto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }


    //

    public abstract double calcularPrecio();

    public abstract void mostrarInformacion();
    
    public void setCodigoProdcuto(int codigoProducto){
        this.codigoProduto = codigoProducto;
    }
    
    public int getCodigoProducto(){
        return this.codigoProduto;
    }
    
    public void setNombreProducto(String nombreProducto){ 
        this.nombreProducto = nombreProducto;
    }
    
    public String getNombreProducto(){
        return this.nombreProducto;
    }
    
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }
    
    public int getStock(){
        return this.stock;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}
