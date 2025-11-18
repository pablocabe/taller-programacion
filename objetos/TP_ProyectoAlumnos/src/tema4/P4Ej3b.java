/*
 B- Realice un programa que instancie una persona y un trabajador y muestre la
representación de cada uno en consola.
 */
package tema4;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P4Ej3b {
    public static void main(String[] args) {
        System.out.println("Ingrese los datos de una persona: nombre, DNI y edad");
        Persona persona = new Persona (Lector.leerString(), Lector.leerInt(), Lector.leerInt());
        
        System.out.println("Ingrese los datos de un trabajador: nombre, DNI, edad y tarea");
        Trabajador trabajador = new Trabajador (Lector.leerString(), Lector.leerInt(), 
                Lector.leerInt(), Lector.leerString());
        
        System.out.println(persona.toString());
        System.out.println(trabajador.toString());
    }
}
