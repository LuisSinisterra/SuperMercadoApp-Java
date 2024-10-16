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
    private String correo;
    double salarioMensual;
    
    public Empleado(int idEmpleado, String nombreCompleto, String correo, double salario){
        this.idEmpleado = idEmpleado;
        this.nombreCompleto = nombreCompleto;
        this.salarioMensual = salario;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double calcularSalario(){
       return 0;        
    }
        
}
