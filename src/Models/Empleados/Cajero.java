/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Empleados;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Cajero extends Empleado{
    
    private String turno;
    
    public Cajero(int idEmpleado, String nombreCompleto, double salarioMensual, String turno){
        super(idEmpleado, nombreCompleto, salarioMensual);
        this.turno = turno;
    }
    
    @Override
    public double calcularSalario(){
        return 0;
    }
    
}
