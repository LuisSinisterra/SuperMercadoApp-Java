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
    public void agregarProducto(Producto producto) {
        for(Producto pro : productosDisponibles){
            if(pro.getCodigoProducto() == producto.getCodigoProducto()) {
               return;
            }
        }
        this.productosDisponibles.add(producto);
    }
    //actualizar
    public void editarProducto(Producto producto) {
        for(Producto pro : productosDisponibles) {
            if(pro.getCodigoProducto() == producto.getCodigoProducto()) {
                productosDisponibles.set(productosDisponibles.indexOf(pro), producto);
            }
        }
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        for(Producto pro : productosDisponibles) {
            if(pro.getCodigoProducto() == codProducto) {
                productosDisponibles.remove(pro);
            }
        }
    }

    //buscar producto nombre
    public Producto buscarProductoNombre(String nombre) {
        for(Producto pro : productosDisponibles) {
            if (pro.getNombreProducto().equals(nombre)) {
                return pro;
            }
        }
        return null;
    }

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        for(Producto pro : productosDisponibles) {
            if (pro.getCodigoProducto() == codProducto) {
                return pro;
            }
        }
        return null;
    }

    //buscar producto precio
    public Producto buscarProductoPrecio(int precio) {
        for(Producto pro : productosDisponibles) {
            if (pro.getPrecio() == precio) {
                return pro;
            }
        }
        return null;
    }

    //buscar producto stock
    public Producto buscarProductoStock(int stock) {
        for(Producto pro : productosDisponibles) {
            if (pro.getStock() == stock) {
                return pro;
            }
        }
        return null;
    }

    public ArrayList<Producto> getProductos(){
        return productosDisponibles;
    }
}
