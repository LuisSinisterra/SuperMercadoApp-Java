/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Models.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Javier Argoty
 */
public class ProveedorDAO {
    private DataBaseConnector dbc = new DataBaseConnector();
    
    
    public void agregarProveedor(Proveedor proveedor) throws RuntimeException{
        String sql = "INSERT INTO Proveedores (nombreEmpresa,telefonoContacto,email)"
                + " VALUES (?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, proveedor.getNombreEmpresa());
            pstmt.setString(2, proveedor.getTelefonoContacto());
            pstmt.setString(3, proveedor.getEmail());
  
            pstmt.executeUpdate();
        }catch(SQLException e){
             throw new RuntimeException("El email ya existe en otro proveedor: " + e.getMessage(), e);
        }
    }
    
    public ArrayList<Proveedor> getProveedores(){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedores";
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombreEmpresa");
                    String telefono = rs.getString("telefonoContacto");
                    String email = rs.getString("email");
                    
                    proveedores.add(new Proveedor(id,nombre,telefono,email));
                }
        }catch(SQLException e){
            System.out.println("FALLO AL OBTENER PROVEEDORES" + e.getMessage());
        }
        return proveedores;
    }
    
    public void eliminarProveedor(int idProveedor){
        String sql = "DELETE FROM Proveedores WHERE id = ?";
        
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setInt(1, idProveedor);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL ELIMINAR PROVEEDOR " + e.getMessage());
        }
    }
    
    public void editarProveedor(Proveedor proveedor) {
        String sql = "UPDATE Proveedores SET nombreEmpresa = ?, telefonoContacto = ?, email = ? WHERE id = ?";

        try (Connection con = dbc.connect(); 
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, proveedor.getNombreEmpresa());
            pstmt.setString(2, proveedor.getTelefonoContacto());
            pstmt.setString(3, proveedor.getEmail());
            pstmt.setInt(4, proveedor.getIdProveedor());


            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Este email ya existe en otro proveedor");
        }
    }
    
    public Proveedor buscarProveedorId(int idProveedor){
        Proveedor proveedor = null;
        String sql = "SELECT * FROM Proveedores WHERE id = ?";
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idProveedor);
            ResultSet rs = pstmt.executeQuery();
            
            String nombre = rs.getString("nombreEmpresa");
            String telefono = rs.getString("telefonoContacto");
            String email = rs.getString("email");

            proveedor = new Proveedor(idProveedor, nombre, telefono, email);
        }catch(SQLException e){
            System.out.println("FALLO EN BUSCAR PROVEEDOR POR ID " + e.getMessage());
        }
        return proveedor;
    }
}
