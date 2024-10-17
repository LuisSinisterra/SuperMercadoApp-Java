/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Simón David Cruz S
 */
import Models.Productos.Producto;
import Models.Productos.ProductoNoPerecedero;
import Models.Productos.ProductoPerecedero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDao {
    private DataBaseConnector dbc = new DataBaseConnector();
    
    public void agregarProductoPerecedero(ProductoPerecedero producto){
        String sql = "INSERT INTO Productos (nombre,precio,stock,tipo,caducidad,tiempo_almacen,id_proveedor)"
                + " VALUES (?,?,?,?,?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getClass().getSimpleName() + "");
            pstmt.setString(5, producto.getFechaCaducidad());
            pstmt.setString(6, "");
            pstmt.setInt(7, producto.getIdProveedor());
            
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR PERECEDERO " + e.getMessage());
        }
    }
    
        public void agregarProductoNoPerecedero(ProductoNoPerecedero producto){
        String sql = "INSERT INTO Productos (nombre,precio,stock,tipo,caducidad,tiempo_almacen,id_proveedor)"
                + " VALUES (?,?,?,?,?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setString(4, producto.getClass().getSimpleName() + "");
            pstmt.setString(5, "");
            pstmt.setString(6, producto.getDuracionAlmacen());
            pstmt.setInt(7, producto.getIdProveedor());
            
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL AGREGAR NO PERECEDERO " + e.getMessage());
        }
    }
    
    public ArrayList<Producto> getProductos(String criterio){
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos ORDER BY " + criterio;
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    int codigo = rs.getInt("codigo_producto");
                    String nombre = rs.getString("nombre");
                    int precio = rs.getInt("precio");
                    int stock = rs.getInt("stock");
                    String caducidad = rs.getString("caducidad");
                    int id_proveedor = rs.getInt("id_proveedor");
                    String tiempoAlmacen = rs.getString("tiempo_almacen");
                    
                    if(caducidad.equals("")){
                        productos.add(new ProductoNoPerecedero(codigo,nombre,precio,stock,tiempoAlmacen,id_proveedor));
                    }else{
                        productos.add(new ProductoPerecedero(codigo,nombre,precio,stock,caducidad,id_proveedor));
                    }
                }
        }catch(SQLException e){
            System.out.println("FALLO EN getProductos" + e.getMessage());
        }
        return productos;
    }
    
    public void eliminarProducto(int codProducto){
        String sql = "DELETE FROM Productos WHERE codigo_producto = ?";
        
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setInt(1, codProducto);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL ELIMINAR " + e.getMessage());
        }
    }
    
    public void editarProducto(int id, Producto producto) {
        String sql = "UPDATE Productos SET nombre = ?, precio = ?, stock = ? , id_proveedor = ?, caducidad = ?, tiempo_almacen = ? "
                + "WHERE codigo_producto = ?";
      

        try (Connection con = dbc.connect(); 
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, producto.getNombreProducto());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getIdProveedor());
            
            if (producto instanceof ProductoPerecedero) {
                pstmt.setString(5, ((ProductoPerecedero) producto).getFechaCaducidad());
                pstmt.setString(6, "");
            }else{
                pstmt.setString(5, "");
                pstmt.setString(6, ((ProductoNoPerecedero) producto).getDuracionAlmacen());
            }
            pstmt.setInt(7, producto.getCodigoProducto());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("FALLO AL EDITAR " + e.getMessage());
        }
    }
    
    public Producto buscarProductoCodigo(int codigo){
        Producto producto = null;
        String sql = "SELECT * FROM Productos WHERE codigo_producto = ?";
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            String nombre = rs.getString("nombre");
            int precio = rs.getInt("precio");
            int stock = rs.getInt("stock");
            String caducidad = rs.getString("caducidad");
            int id_proveedor = rs.getInt("id_proveedor");
            String tiempoAlmacen = rs.getString("tiempo_almacen");

            if (caducidad.equals("")) {
                producto = new ProductoNoPerecedero(codigo, nombre, precio, stock, tiempoAlmacen, id_proveedor);
            } else {
                producto = new ProductoPerecedero(codigo, nombre, precio, stock, caducidad, id_proveedor);
            }

        }catch(SQLException e){
            System.out.println("FALLO EN buscarProductoCodigo " + e.getMessage());
        }
        return producto;
    }
  
}
