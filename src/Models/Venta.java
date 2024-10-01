package Models;

import Models.Empleados.Empleado;
import Models.Productos.Producto;

import java.util.ArrayList;

public class Venta {
    //Arreglar en caso de ser necesario
    private int idVenta;
    private Cliente Cliente;
    private ArrayList<Producto> productos;
    private double total;
    private Empleado empleado;

    public Venta(int idVenta, Models.Cliente cliente, Empleado empleado, double total, ArrayList<Producto> productos) {
        this.idVenta = idVenta;
        Cliente = cliente;
        this.empleado = empleado;
        this.total = total;
        this.productos = productos;
    }

    public Models.Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Models.Cliente cliente) {
        Cliente = cliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
//registrar venta(excepcion stock insuficiente)