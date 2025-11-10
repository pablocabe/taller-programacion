/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Pablo
 */
public class Habitacion {
    private double costoNoche;
    private boolean ocupada;
    Cliente cliente;

    public Habitacion (){
        costoNoche = GeneradorAleatorio.generarDouble(6000)+2000;
        ocupada = false;
        cliente = null;
    }
    
    /* public Habitacion(double costoNoche, boolean ocupada, Cliente cliente) {
        this.costoNoche = costoNoche;
        this.ocupada = ocupada;
        if (ocupada) {
            this.cliente = cliente;
        }
    } */

    public double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    
    public void ocupar(){
        this.ocupada = true;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void aumentarPrecio (double monto) {
        costoNoche = costoNoche + monto;
        
        // otra forma: costoNoche += monto;
    }
    
    @Override
    public String toString(){
        String aux;
        aux = "Cuesta " + costoNoche + "y está " + ocupada;
        if (ocupada){
            aux += "Información del cliente: " + cliente.toString();
        }
        return aux;
    }
    
    
    // {Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}

   /* "Habitacion N° " + i + " cuesta " + this.habitaciones[i].getCostoNoche() + 
                    " está " + this.habitaciones[i].isOcupada();
            if (this.habitaciones[i].isOcupada() == true)
                aux = aux + this.habitaciones[i].getCliente()
            */
}
