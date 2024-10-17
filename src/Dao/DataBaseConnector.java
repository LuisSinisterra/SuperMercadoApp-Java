/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author Simón David Cruz S
 */
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnector {
    private String URL = "jdbc:sqlite:src\\Dao\\DataBase.db";
    
    public Connection connect(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL);
        }catch(SQLException e){
            System.out.println("FALLO EN CONEXION " + e.getMessage());
        }
        return con;
    }
}
