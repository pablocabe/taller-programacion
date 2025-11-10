/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author Pablo
 */
public class Butaca {
    private String descriptor;
    private double precio;
    private boolean ocupada;
    
    public Butaca(String descriptor, double precio){
        this.descriptor = descriptor;
        this.precio = precio;
        this.ocupada = false;
    }
    
    public void ocuparButaca(){
        this.ocupada = true;
    }
    
    public void desocuparButaca(){
        this.ocupada = false;
    }
    
    public boolean estaOcupada(){
        return (this.ocupada);
    }
    
    public double obtenerPrecio(){
        return precio;
    }
    
    @Override
    public String toString(){
        String aux = "Descriptor: " + this.descriptor +
                     "Precio: " + this.precio +
                     "Estado: " + this.ocupada;
        return aux;
    }
}
