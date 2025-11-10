/*
 3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
 */
package tema3;

/**
 *
 * @author Pablo
 */
public class Estanteria {
    private Libro [] libros;
    private int dF = 20;
    private int cantidadLibros = 0;
    
    // Todas las posiciones del vector apuntarán a null gracias a Java, hasta que se realice new Libro[pos]
    public Estanteria(){
        libros = new Libro [dF];
    }
    // I
    public int getCantidadLibros(){
        return cantidadLibros;
    }
    
    // II
    public boolean estaLleno(){
        return (cantidadLibros == dF);
    }
    
    // III
    public boolean agregarLibro (Libro libro){
        if (!estaLleno()){
            libros [cantidadLibros++] = libro;
            return true;
        } else {
            return false;
        }
    }
    
    // IV
    public Libro buscarLibro (String nombreLibro){
        int aux = 0;
        while ((aux < dF) & (!libros[aux].getTitulo().equals(nombreLibro))) {
            aux++;
        }
        if (aux < cantidadLibros) {
            return libros[aux];
        } else
            return null;
    }
    
    // C
    public Estanteria (int n){
        dF = n;
        libros = new Libro [n];
    }
}

    