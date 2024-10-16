package Services;

import Models.Venta;

import java.util.ArrayList;

public class VentaService {
    ArrayList<Venta> ventas;

    public VentaService(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }


    //registrar venta(excepcion stock insuficiente)

    //version de prueba
    public void agregarVenta(Venta venta) {
        this.ventas.add(venta);
    }
}
