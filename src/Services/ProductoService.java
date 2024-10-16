package Services;

import Dao.ProductoDao;
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;

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
    private ProductoDao pd;
    
    public ProductoService() {
        this.pd = new ProductoDao();
    }

    //metodo registrar(validar no mismo codigo)
    public void agregarProducto(Producto producto) throws RuntimeException{
        //El codigo debera autogenerarse
        /*
        for(Producto pro : productosDisponibles){
            if(pro.getCodigoProducto() == producto.getCodigoProducto()) {
               throw new RuntimeException("ESTE CODIGO YA EXISTE");
            }
        }*/
        
        if(producto instanceof ProductoPerecedero){
            pd.agregarProductoPerecedero((ProductoPerecedero)producto);
        }else{
            pd.agregarProductoNoPerecedero((ProductoNoPerecedero)producto);
        }
    }
    
    //actualizar
    public void editarProducto(Producto producto) {
        pd.editarProducto(0, producto);
    }

    //eliminar
    public void eliminarProducto(int codProducto) {
        pd.eliminarProducto(codProducto);
    }

    //buscar producto nombre
    /*public Producto buscarProductoNombre(String nombre) {
        
    }*/

    //buscar producto codigo
    public Producto buscarProductoCodigo(int codProducto) {
        return pd.buscarProductoCodigo(codProducto);
    }

    //buscar producto precio
    /*public Producto buscarProductoPrecio(int precio) {
        
    }*/

    //buscar producto stock
    /*public Producto buscarProductoStock(int stock) {
        
    }*/
    
    public ArrayList<Producto> getProductos(){
        return pd.getProductos();
    }

}
