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
public class Parcial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento estacionamiento = new Estacionamiento ("Calle 125", 50, 4, 3);
        Vehiculo vehiculo1 = new Vehiculo ("AAA111", 10, "Renault", "2010");
        Vehiculo vehiculo2 = new Vehiculo ("BBB222", 4, "Peugeot", "2000");
        Vehiculo vehiculo3 = new Vehiculo ("CCC333", 20, "Chevrolet", "2015");
        Vehiculo vehiculo4 = new Vehiculo ("DDD444", 2, "Audi", "2020");
        
        estacionamiento.registrarVehiculo(1, 2, vehiculo1);
        estacionamiento.registrarVehiculo(3, 3, vehiculo2);
        estacionamiento.registrarVehiculo(3, 2, vehiculo3);
        estacionamiento.registrarVehiculo(2, 1, vehiculo4);
        
        estacionamiento.liberarLugares("Peugeot", 3);
        System.out.println("La mayor recaudación corresponde al sector N° :" + estacionamiento.obtenerMayorRecaudacion());
        System.out.println(estacionamiento.toString());
    }
    
}
