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
    private double salarioMensual;
    
    public Empleado(int idEmpleado, String nombreCompleto, double salario){
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.salarioMensual = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setSalarioMensual(double salario) {
        this.salarioMensual = salario;
    }
    
    
    public double calcularSalario(){
       return 0;        
    }
        
}
