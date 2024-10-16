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
public class ProductoPerecedero extends Producto{

    private String fechaCaducidad;

    public ProductoPerecedero(int codigoProduto, String nombreProducto, double precio, int stock, String fechaCaducidad, int id_proveedor) {
        super(codigoProduto, nombreProducto, precio, stock, id_proveedor);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public double calcularPrecio() {
        return 2;//valor temporal
    }

    @Override
    public void mostrarInformacion() {

    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}
