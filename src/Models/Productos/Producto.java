/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Producto {
    
    private int codigoProduto;
    private String nombreProducto;
    private double precio;
    private int stock;
    
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
    
    public void calcularPrecio(){
        //Codigo de calcular precio
    }
    
    public void mostrarInformacion(){
        //Codigo de mostrar informacion
    }
    
}
