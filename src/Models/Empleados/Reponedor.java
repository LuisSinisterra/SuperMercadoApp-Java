/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Empleados;

/**
 *
 * @author luis
 */
public class Reponedor extends Empleado{
        
    public Reponedor(int idEmpleado, String nombreCompleto, double salario){
        super(idEmpleado, nombreCompleto, salario);
    }
    
    @Override
    public double calcularSalario(){
        return 0;
    }
    
    
    
}
