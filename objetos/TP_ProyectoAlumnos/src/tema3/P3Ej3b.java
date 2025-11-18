/*
 3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P3Ej3b {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estanteria estante = new Estanteria();
        
        for (int i=0 ; i<4 ; i++) {
            System.out.println("Se está cargando el libro N°" + (i+1));
            System.out.println("Ingrese el nombre, biografía y origen del autor");
            Autor autor = new Autor (Lector.leerString(), Lector.leerString(),Lector.leerString());
            System.out.println("Ingrese el nombre, editorial, año de edición, ISBN y precio del libro");
            Libro libro = new Libro (Lector.leerString(), Lector.leerString(), 
                    Lector.leerInt(), autor, Lector.leerString(), Lector.leerDouble());
            estante.agregarLibro(libro);
        }
        
        System.out.println("El nombre del autor de Mujercitas es: " +
                estante.buscarLibro("Mujercitas").getPrimerAutor().getNombre());
    }
}
