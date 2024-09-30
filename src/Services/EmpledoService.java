package Services;

import Models.Empleados.Empleado;

import java.util.ArrayList;

public class EmpledoService {
    ArrayList<Empleado> empleados;
    public EmpledoService() {
        //ArrayList que sera un contenedor polimorfico para poder agregar los 3 tipos de empleados del sistema
        this.empleados = new ArrayList<>();
    }

    //Metetodo sin completar por ahora
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
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
