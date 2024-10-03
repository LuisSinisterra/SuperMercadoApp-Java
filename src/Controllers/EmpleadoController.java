package Controllers;

import Models.Empleados.Empleado;
import Services.EmpledoService;

public class EmpleadoController {
    EmpledoService empleadoService;

    public EmpleadoController() {
        empleadoService = new EmpledoService();
    }

    //Metodo para agregar empleado cajero
    public void agregarEmpleadoCajero(int idEmpleado, String nombreCompleto, double salarioMensual, String turno) {
        this.empleadoService.agregarEmpleadoCajero(idEmpleado, nombreCompleto, salarioMensual, turno);
    }

    //Metodo para agregar empleaado gerente
    public void agregarEmpleadoGerente(int idEmpleado, String nombreCompleto, double salarioMensual, String bonificacion) {
        this.empleadoService.agregarEmpleadoGerente(idEmpleado, nombreCompleto, salarioMensual, bonificacion);
    }

    //Metodo para agreagar empleado reponedor
    public void agregarEmpleadoReponedor(int idEmpleado, String nombreCompleto, double salarioMensual) {
        this.empleadoService.agregarEmpleadoReponedor(idEmpleado, nombreCompleto, salarioMensual);
    }

    //Metodo para eliminar empleado por su id empleado
    public void eliminarEmpleado(int idEmpleado) {
        this.empleadoService.eliminarEmpleado(idEmpleado);
    }

    public void editarEmpleado(int idEmpleado, String nombreCompleto, double salarioMensual) {
        this.empleadoService.editarEmpleado(idEmpleado, nombreCompleto, salarioMensual);
    }

}
