package Services;

import Models.Empleados.Cajero;
import Models.Empleados.Empleado;
import Models.Empleados.Gerente;
import Models.Empleados.Reponedor;

import java.util.ArrayList;

public class EmpleadoService {
    ArrayList<Empleado> empleados;
    public EmpleadoService() {
        //ArrayList que sera un contenedor polimorfico para poder agregar los 3 tipos de empleados del sistema
        this.empleados = new ArrayList<>();
        this.empleados.add(new Gerente(100, "admin", "admin@", 2000000, 0.1));        
    }

    public void agregarEmpleadoCajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno) throws RuntimeException{
        if (!buscarEmpleado(idEmpleado)) {
            Cajero cajero = new Cajero(idEmpleado, nombreCompleto, correo, salarioMensual, turno);
            this.empleados.add(cajero);
        }
        throw new RuntimeException("Este cajero ya existe en el sistema");
    }

    public void agregarEmpleadoGerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, double bonificacion) throws RuntimeException{
        if (!buscarEmpleado(idEmpleado)) {
            Gerente gerente = new Gerente(idEmpleado, nombreCompleto, correo, salarioMensual, bonificacion);
            this.empleados.add(gerente);
        }
        throw new RuntimeException("Este gerente ya existe en el sistema");

    }

    public void agregarEmpleadoReponedor(int idEmpleado, String nombreCompleto, String correo, double salarioMensual) throws RuntimeException{
        if (!buscarEmpleado(idEmpleado)) {
            Reponedor reponedor = new Reponedor(idEmpleado, nombreCompleto, correo, salarioMensual);
            this.empleados.add(reponedor);
        }
        throw new RuntimeException("Este reponedor ya existe en el sistema");
    }

    public void eliminarEmpleado(int idEmpleado) throws RuntimeException {
        for (int i = empleados.size() - 1; i >= 0; i--) {
            Empleado empleado = empleados.get(i);
            if (empleado.getIdEmpleado() == idEmpleado) {
                empleados.remove(i);
                return;
            }
        }
        throw new RuntimeException("No se encuentra el empleado que desea eliminar");
    }


    public void editarEmpleadoCajero(int idEmpleado,String nombreCompleto, String correo, double salarioMensual, String turno) throws RuntimeException{
        for (Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                if (empleado instanceof Cajero){
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                    ((Cajero) empleado).setTurno(turno);
                }
            }
        }
        throw new RuntimeException("No se encuentra el cajero que desea editar");

    }

    public void editarEmpleadoGerente(int idEmpleado,String nombreCompleto, String correo, double salarioMensual, double bonificacion) throws RuntimeException{
        for (Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                if (empleado instanceof Gerente){
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                    ((Gerente) empleado).setBonificacion(bonificacion);
                }
            }
        }
        throw new RuntimeException("No se encuentra el gerente que desea editar");

    }

    public void editarEmpleadoReponedor(int idEmpleado,String nombreCompleto, String correo, double salarioMensual) throws RuntimeException{
        for (Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                if (empleado instanceof Reponedor){
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                }
            }
        }
        throw new RuntimeException("No se encuentra el reponedor que desea editar");

    }

    private boolean buscarEmpleado(int idEmpleado) {
        for (Empleado empleado : this.empleados) {
            if (empleado.getIdEmpleado() == idEmpleado) {
                return true; 
            }
        }
        return false; 
    }


    
    public Empleado iniciarSesion(int idEmpleado, String correo) {
        if(buscarEmpleado(idEmpleado)){
            if (correo == null) {
                return null; 
            }

            for (Empleado empleado : this.empleados) {
                if (empleado.getIdEmpleado() == idEmpleado && correo.equals(empleado.getCorreo())) {
                    return empleado;
                }
            }
        }
        return null;
    }

    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

}
