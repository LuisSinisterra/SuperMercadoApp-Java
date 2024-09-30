/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Empleados;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Empleado {
    private int idEmpleado;
    private String nombreCompleto;
    private double salario;
    
    public Empleado(int idEmpleado, String nombreCompleto, double salario){
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public double getSalario() {
        return salario;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    public double calcularSalario(){
       return 0;        
    }
        
}
