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
public class Surtidor {
    private String combustible;
    private double precioPorLitro;
    private Venta [] vectorVentas;
    private int cantidadVentasDL;
    private int cantidadVentasDF;
    
    public Surtidor(String combustible, double precioPorLitro, int cantidadMaximaVentas){
        this.combustible = combustible;
        this.precioPorLitro = precioPorLitro;
        this.cantidadVentasDL = 0;
        this.cantidadVentasDF = cantidadMaximaVentas;
        vectorVentas = new Venta [cantidadMaximaVentas];
        for (int i=0 ; i<cantidadVentasDF ; i++){
            vectorVentas[i] = null;
        }
    }
    
    public boolean hayLugarVentas(){
        return (cantidadVentasDF > cantidadVentasDL);
    }
    
    public void generarVenta (int DNI, int cantidadLitros, String medioPago){
        if (hayLugarVentas()){
            double monto = cantidadLitros * precioPorLitro;
            Venta venta = new Venta (DNI, cantidadLitros, monto, medioPago);
            vectorVentas[cantidadVentasDL] = venta;
            cantidadVentasDL++;
        }
    }
    
    public double contabilizarSurtidor (){
        double aux = 0;
        for (int i=0 ; i<cantidadVentasDL ; i++){
            aux += vectorVentas[i].sumarValorVenta();
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux = "Combustible dispensado: " + this.combustible + 
                     " Precio por litro: " + this.precioPorLitro + ". Ventas:";
        for (int i=0 ; i<cantidadVentasDL ; i++){
            aux += "Venta N°" + (i+1) + ": " + vectorVentas[i].toString() + "\n";
        }
        return aux;
    }
}
