/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Productos;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class ProductoNoPerecedero extends Producto{

    String duracionAlmacen;

    public ProductoNoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String duracionAlmacen) {
        super(codigoProduto, nombreProducto, precio, stock);
        this.duracionAlmacen = duracionAlmacen;
    }

    @Override
    public double calcularPrecio() {
        return 2;//valor temporal
    }

    @Override
    public void mostrarInformacion() {

    }

    public String getDuracionAlmacen() {
        return duracionAlmacen;
    }

    public void setDuracionAlmacen(String duracionAlmacen) {
        this.duracionAlmacen = duracionAlmacen;
    }
}
