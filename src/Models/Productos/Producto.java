/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public abstract class Producto {
    
    private int codigoProducto;
    private String nombreProducto;
    private double precio;
    private int stock;

    public Producto(int codigoProduto, String nombreProducto, double precio, int stock) {
        this.codigoProducto = codigoProduto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }


    //

    public abstract double calcularPrecio();

    public abstract void mostrarInformacion();
    
    public void setCodigoProdcuto(int codigoProducto){
        this.codigoProducto = codigoProducto;
    }
    
    public int getCodigoProducto(){
        return this.codigoProducto;
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

}
