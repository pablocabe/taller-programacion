/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
/**
 *
 * @author Pablo
 */
public class Hotel {
    private Habitacion [] habitaciones;
    
    public Hotel (int numeroHabitaciones){
        habitaciones = new Habitacion [numeroHabitaciones];
        for (int i=0 ; i<numeroHabitaciones ; i++) {
            habitaciones [i] = new Habitacion();
        }
    }
    /*
    En Java, cuando creas un arreglo de objetos como 
    Habitacion[] habitaciones = new Habitacion[numeroHabitaciones];, 
    lo único que se hace es reservar espacio para ese arreglo de referencias. 
    Sin embargo, no se crean los objetos individuales dentro de ese arreglo. 
    En su estado inicial, todos los elementos del arreglo serán null hasta 
    que se inicialicen explícitamente.
    Por eso, tu código que usa un bucle for para inicializar cada posición 
    del arreglo con una instancia de Habitacion es correcto y necesario. 
    El bucle asegura que cada referencia en el arreglo apunte a un objeto Habitacion en lugar de null.
    */
    
    public void agregarCliente (Cliente C, int X){
        this.habitaciones[X].setCliente(C);
        this.habitaciones[X].ocupar();
    }
    
    public void aumentarPrecios (double monto, int numeroHabitaciones){
        for (int i=0 ; i<numeroHabitaciones ; i++){
            this.habitaciones[i].aumentarPrecio(monto);
        }
    }
    
    public String toString(int numeroHabitaciones) {
        String aux = "";
        for (int i=0 ; i<numeroHabitaciones ; i++) {
            aux += "Habitación N° " + (i+1) + ": " + habitaciones[i].toString() + "\n";

        }
        return aux;
    }
}
