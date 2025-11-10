/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

/**
 *
 * @author Pablo
 */
public class Venta {
    private int DNI;
    private int cantidadLitros;
    private double montoAbonado;
    private String medioPago;
    
    public Venta (int DNI, int cantidadLitros, double montoAbonado, String medioPago){
        this.DNI = DNI;
        this.cantidadLitros = cantidadLitros;
        this.montoAbonado = montoAbonado;
        this.medioPago = medioPago;
    }
    
    public double sumarValorVenta (){
        return this.montoAbonado;
    }
    
    @Override
    public String toString(){
       String aux = "DNI del cliente " + this.DNI 
               + ", cantidad de litros cargados " + this.cantidadLitros
               + ", monto abonado " + this.montoAbonado
               + ", medio de pago " + this.medioPago;
       return aux;
    }
    
    /* public void crearVenta (int DNI, int cantidadLitros, String medioPago){
        this.DNI = DNI;
        this.cantidadLitros = cantidadLitros;
        this.medioPago = medioPago;
    }
    */
}
