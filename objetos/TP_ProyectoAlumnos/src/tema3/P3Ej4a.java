/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P3Ej4a {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int numeroHabitaciones;
        System.out.println("Ingrese la cantidad de habitaciones que posee el hotel:");
        numeroHabitaciones = Lector.leerInt();
        Hotel hotel = new Hotel (numeroHabitaciones);
    }
}
