package Controllers.Productos;

import Models.Productos.Producto;
import Services.Productos.ProductoService;

public class ProductoController {

    ProductoService productoService;

    public ProductoController() {
        this.productoService = new ProductoService();
    }

    public void registrarProducto(Producto producto) {
        productoService.registrarProducto(producto);
    }

    //actualizar
    public void actualizarProducto(Producto producto) {
        productoService.actualizarProducto(producto);
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        productoService.eliminarProducto(codProducto);
    }

    //buscar producto nombre
    public Producto buscarProductoNombre(String nombre) {
        return productoService.buscarProductoNombre(nombre);
    }

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        return productoService.buscarProductoCodigo(codProducto);
    }

    //buscar producto precio
    public Producto buscarProductoPrecio(int precio) {
        return productoService.buscarProductoPrecio(precio);
    }

    //buscar producto stock
    public Producto buscarProductoStock(int stock) {
        return productoService.buscarProductoStock(stock);
    }
}
