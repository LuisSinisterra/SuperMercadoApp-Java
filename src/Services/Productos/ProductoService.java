package Services.Productos;

import Models.Productos.Producto;

import java.util.ArrayList;

public class ProductoService {
    /*README-------------------------------------------------------------
    * 1. Cuando se realioce una venta, se le resta el stock seleccionado
    * por el cliente al stock del producto en el arrayList.
    *
    * 2. Se debe retornar el producto con el numero de stock seleccionado por el cliente,
//    * (cantidad comprada de ese producto) y este retornado, a su ves agregado al arrayList de
//    * productos de la venta, la venta entrara en el historial del cliente(ArryList de ventas).
    * */
    private ArrayList<Producto> productosDisponibles;

    public ProductoService() {
        this.productosDisponibles = new ArrayList<>();
    }

    //metodo registrar(validar no mismo codigo)
    public void registrarProducto(Producto producto) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getCodigoProducto() == producto.getCodigoProducto()) {
                this.productosDisponibles.add(producto);
            }
        }
    }
    //actualizar
    public void actualizarProducto(Producto producto) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getCodigoProducto() == producto.getCodigoProducto()) {
                productosDisponibles.set(i, producto);
            }
        }
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getCodigoProducto() == codProducto) {
                productosDisponibles.remove(i);
            }
        }
    }

    //buscar producto nombre
    public Producto buscarProductoNombre(String nombre) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if (productosDisponibles.get(i).getNombreProducto().equals(nombre)) {
                return productosDisponibles.get(i);
            }
        }
        return null;
    }

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getCodigoProducto() == codProducto) {
                return productosDisponibles.get(i);
            }
        }
        return null;
    }

    //buscar producto precio
    public Producto buscarProductoPrecio(int precio) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getPrecio() == precio) {
                return productosDisponibles.get(i);
            }
        }
        return null;
    }

    //buscar producto stock
    public Producto buscarProductoStock(int stock) {
        for(int i = 0; i < productosDisponibles.size(); i++) {
            if(productosDisponibles.get(i).getStock() == stock) {
                return productosDisponibles.get(i);
            }
        }
        return null;
    }



}
