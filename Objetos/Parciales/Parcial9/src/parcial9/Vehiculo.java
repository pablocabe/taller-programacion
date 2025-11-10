/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

/**
 *
 * @author Pablo
 */
public class Vehiculo {
    private String patente;
    private int horasEstacionado;
    private String marca;
    private String modelo;
    
    public Vehiculo (String patente, int horasEstacionado, String marca, String modelo){
        this.patente = patente;
        this.horasEstacionado = horasEstacionado;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public boolean esMarcaM (String marcaM){
        return (this.marca == marcaM);
    }
    
    @Override
    public String toString(){
        String aux = "Patente " + this.patente + ", marca " + this.marca + 
                ", modelo " + this.modelo + ", horas estacionado " + this.horasEstacionado + ". \n";
        return aux;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }
    
}
