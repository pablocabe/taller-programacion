/*
 F- Realizar un programa que instancie un jugador y un entrenador. Informe la
representación String de cada uno.
 */
package tema4;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P4Ej2f {
    public static void main(String[] args) {
        System.out.println("Se ingresará la información de un futbolista");
        System.out.println("Ingrese el nombre, sueldo y años de antiguedad");
        String nombre = Lector.leerString();
        double sueldo = Lector.leerDouble();
        int antiguedad = Lector.leerInt();
        System.out.println("Ingrese la cantidad de partidos disputados y la cantidad de goles");
        int cantidadPartidos = Lector.leerInt();
        int cantidadGoles = Lector.leerInt();
        Jugador jugador = new Jugador (nombre, sueldo, antiguedad, cantidadPartidos, cantidadGoles);
        
        System.out.println("Se ingresará la información de un entrenador");
        System.out.println("Ingrese el nombre, sueldo y años de antiguedad");
        nombre = Lector.leerString();
        sueldo = Lector.leerDouble();
        antiguedad = Lector.leerInt();
        System.out.println("Ingrese la cantidad de títulos obtenidos");
        int cantidadTitulos = Lector.leerInt();
        Entrenador entrenador = new Entrenador (nombre, sueldo, antiguedad, cantidadTitulos);
        
        System.out.println(jugador.toString());
        System.out.println(entrenador.toString());
    }
}
