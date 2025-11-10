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
public class Estacion {
    private String direccion;
    private Surtidor [] vectorSurtidores;
    private int cantidadSurtidoresDF;
    private int cantidadSurtidoresDL;
    
    public Estacion(String direccion){
        this.direccion = direccion;
        vectorSurtidores = new Surtidor [6];
        this.cantidadSurtidoresDL = 0;
        this.cantidadSurtidoresDF = 6;
        for (int i=0 ; i<cantidadSurtidoresDF ; i++){
            vectorSurtidores[i] = null;
        }
    }
    
    public boolean hayLugarSurtidores(){
        return (cantidadSurtidoresDF > cantidadSurtidoresDL);
    }
    
    public void agregarSurtidor (Surtidor unSurtidor){
        if (hayLugarSurtidores()){
            vectorSurtidores[cantidadSurtidoresDL] = unSurtidor;
            cantidadSurtidoresDL++;
        }
    }
    
    public void agregarVenta (int N, int DNI, int cantidadLitros, String medioPago){
        vectorSurtidores[N-1].generarVenta(DNI, cantidadLitros, medioPago);
    }
    
    public int buscarSurtidor (){
        int surtidorMax = 0;
        double cantidadMaxima = 0;
        for (int i=0 ; i<cantidadSurtidoresDL ; i++){
            double recaudado = vectorSurtidores[i].contabilizarSurtidor();
            if (recaudado > cantidadMaxima){
                surtidorMax = i;
                cantidadMaxima = recaudado;
            }
        }
        return surtidorMax;
    }
    
    @Override
    public String toString(){
        String aux = "Estación de servició: Dirección: " + this.direccion + 
                     " Cantidad de surtidores: " + this.cantidadSurtidoresDL;
        for (int i=0 ; i<cantidadSurtidoresDL ; i++){
            aux += "Surtidor N°" + (i+1) + ": " + vectorSurtidores[i].toString() + "\n";
        }
        return aux;
    }
}