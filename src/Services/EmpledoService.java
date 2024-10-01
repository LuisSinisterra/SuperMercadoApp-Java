package Services;

import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;
import Models.Empleados.Reponedor;

import java.util.ArrayList;

public class EmpledoService {
    ArrayList<Empleado> empleados;
    public EmpledoService() {
        //ArrayList que sera un contenedor polimorfico para poder agregar los 3 tipos de empleados del sistema
        this.empleados = new ArrayList<>();
    }

    //Metodo para agregar un empleado de tipo cajero (Metodo sin completar)
    public void agregarEmpleadoCajero(int idEmpleado, String nombreCompleto, double salarioMensual, String turno) {
        Cajero cajero = new Cajero(idEmpleado, nombreCompleto, salarioMensual, turno);
        empleados.add(cajero);
    }

    //Metodo para agregar un empleado de tipo genrente (Metodo sin completar)
    public void agregarEmpleadoGerente(int idEmpleado, String nombreCompleto, double salarioMensual, String bonificacion) {
        Gerente gerente = new Gerente(idEmpleado, nombreCompleto, salarioMensual, bonificacion);
        empleados.add(gerente);
    }

    //Metodo para agregar un empleado de tipo reponedor (Metodo sin completar)
    public void agregarEmpleadoReponedor(int idEmpleado, String nombreCompleto, double salarioMensual) {
        Reponedor reponedor = new Reponedor(idEmpleado, nombreCompleto, salarioMensual);
        empleados.add(reponedor);
    }

    //Metetodo sin completar por ahora
    public void eliminarEmpleado(int idEmpleado){
        for(Empleado empleado : empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                empleados.remove(empleado);
            }
        }
    }

    //Metetodo sin completar por ahora
    public void editarEmpleado(Empleado empleado) {
        empleados.set(empleados.indexOf(empleado), empleado);
    }

}
