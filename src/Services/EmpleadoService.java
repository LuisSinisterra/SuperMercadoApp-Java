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
    }

    //Metodo para agregar un empleado de tipo cajero (Metodo sin completar)
    public void agregarEmpleadoCajero(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String turno) {
        if (buscarEmpleado(idEmpleado)) {
            Cajero cajero = new Cajero(idEmpleado, nombreCompleto, correo, salarioMensual, turno);
            this.empleados.add(cajero);
        }
    }

    //Metodo para agregar un empleado de tipo genrente (Metodo sin completar)
    public void agregarEmpleadoGerente(int idEmpleado, String nombreCompleto, String correo, double salarioMensual, String bonificacion) {
        if (buscarEmpleado(idEmpleado)) {
            Gerente gerente = new Gerente(idEmpleado, nombreCompleto, correo, salarioMensual, bonificacion);
            this.empleados.add(gerente);
        }
    }

    //Metodo para agregar un empleado de tipo reponedor (Metodo sin completar)
    public void agregarEmpleadoReponedor(int idEmpleado, String nombreCompleto, String correo, double salarioMensual) {
        if (buscarEmpleado(idEmpleado)) {
            Reponedor reponedor = new Reponedor(idEmpleado, nombreCompleto, correo, salarioMensual);
            this.empleados.add(reponedor);
        }
    }

    //Metetodo sin completar por ahora
    /*public void eliminarEmpleado(int idEmpleado){

        Empleado e;
        boolean existeEmpleado = false;

        for(Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                existeEmpleado = true;
                e = empleado;
            } else {
                e = empleado;
            }
        }

        if(existeEmpleado){
            this.empleados.remove(e);
        }

    }*/

    //Metetodo sin completar por ahora
    public void editarEmpleadoCajero(int idEmpleado,String nombreCompleto, String correo, double salarioMensual, String turno) {
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
    }

    //Metetodo sin completar por ahora
    public void editarEmpleadoGerente(int idEmpleado,String nombreCompleto, String correo, double salarioMensual, String bonificacion) {
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
    }

    //Metetodo sin completar por ahora
    public void editarEmpleadoReponedor(int idEmpleado,String nombreCompleto, String correo, double salarioMensual) {
        for (Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                if (empleado instanceof Reponedor){
                    empleado.setNombreCompleto(nombreCompleto);
                    empleado.setSalarioMensual(salarioMensual);
                    empleado.setCorreo(correo);
                }
            }
        }
    }

    //Metodo para buscar empleado, esto para poder dividir las tareas de la aplicacion
    private boolean buscarEmpleado(int idEmpleado){
        for(Empleado empleado : this.empleados){
            if(empleado.getIdEmpleado() == idEmpleado){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }

}
