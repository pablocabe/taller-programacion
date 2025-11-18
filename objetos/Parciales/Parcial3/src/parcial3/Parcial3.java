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
public class Parcial3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacion estacion = new Estacion ("Calle 125");
        Surtidor surtidor1 = new Surtidor ("Nafta", 100, 10);
        Surtidor surtidor2 = new Surtidor ("Gasoil", 50, 10);
        
        estacion.agregarSurtidor(surtidor1);
        estacion.agregarSurtidor(surtidor2);
        
        estacion.agregarVenta(1, 43600403, 20, "Efectivo");
        estacion.agregarVenta(2, 200000, 10, "Tarjeta");
        estacion.agregarVenta(1, 10000, 40, "Tarjeta");
        
        System.out.println(estacion.toString());
        System.out.println("El surtidor que más dinero recaudo es: " + (estacion.buscarSurtidor()+1));
    }
    
}
