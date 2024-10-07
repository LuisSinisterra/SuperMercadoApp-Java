/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Empleados;

/**
 *
 * @author Luis Sinisterra, Simon Cruz, Leonardo Argoty
 */
public class Gerente extends Empleado{
    
    private double bonificacion;
    
    public Gerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, double bonificacion){
        super(idEmpleado, nombreCompleto, correo ,salarioMensual);
        this.bonificacion = bonificacion;
    }
    
    @Override
    public double calcularSalario(){
        return 0;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

}
