/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Javier Argoty
 */
public class ClienteDAO {
    private DataBaseConnector dbc = new DataBaseConnector();
    
    
    public void agregarCliente(Cliente cliente) throws RuntimeException{
        String sql = "INSERT INTO Clientes (nombre_completo,telefono,email)"
                + " VALUES (?,?,?)";
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, cliente.getNombreCompleto());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
  
            pstmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("El email ya existe en otro cliente");
        }
    }
    
    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    int id = rs.getInt("id_cliente");
                    String nombre = rs.getString("nombre_completo");
                    String telefono = rs.getString("telefono");
                    String email = rs.getString("email");
                    
                    clientes.add(new Cliente(id,nombre,telefono,email));
                }
        }catch(SQLException e){
            System.out.println("FALLO AL OBTENER CLIENTES" + e.getMessage());
        }
        return clientes;
    }
    
    public void eliminarCliente(int idCliente){
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
        
        try(Connection con = dbc.connect();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setInt(1, idCliente);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("FALLO AL ELIMINAR CLIENTE" + e.getMessage());
        }
    }
    
    public void editarCliente(Cliente cliente) throws RuntimeException{
        String sql = "UPDATE Clientes SET nombre_completo = ?, telefono = ?, email = ? WHERE id_cliente = ?";

        try (Connection con = dbc.connect(); 
                PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, cliente.getNombreCompleto());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setInt(4, cliente.getIdCliente());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("El email ya existe en otro cliente");
        }
    }
    
    public Cliente buscarClienteId(int idCliente){
        Cliente cliente = null;
        String sql = "SELECT * FROM Clientes WHERE id_cliente = ?";
        
        try(Connection con = dbc.connect();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            
            String nombre = rs.getString("nombre_completo");
            String telefono = rs.getString("telefono");
            String email = rs.getString("email");

            cliente = new Cliente(idCliente, nombre, telefono, email);
        }catch(SQLException e){
            System.out.println("FALLO EN BUSCAR CLIENTE POR ID " + e.getMessage());
        }
        return cliente;
    }
}
