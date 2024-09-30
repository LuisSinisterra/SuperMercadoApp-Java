/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Cliente {
    private int idCliente;
    private String nombreCompleto;        
    private String telefono;        
    private String email;
    
    // Por ahora no se que tipo de dato es, puse str, lo mas probable es que es con el objeto "Ventas" que aparece en morado esa seccion, aun no se hace
    private ArrayList<String> historialCompras; 

    public Cliente(int idCliente, String nombreCompleto, String telefono, String email) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
        this.historialCompras = new ArrayList<>();
    }
    
    // Este metodo se supone que muestra compras pero solo es una prueba, realmente no es adecuado
    public String mostrarCompras() throws RuntimeException {
        if (historialCompras.isEmpty()) throw new RuntimeException("Lo siento, este cliente no tiene compras registradas.");
        
        String compras = "";
        for (String compra : historialCompras) {
            compras += compra;
        }
        
        return compras;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(ArrayList<String> historialCompras) {
        this.historialCompras = historialCompras;
    }
    
    
}
