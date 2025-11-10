/*
 B- Modifique el programa Demo01Constructores (carpeta tema3) para instanciar los libros
con su autor, considerando las modificaciones realizadas. Luego, a partir de uno de los
libros instanciados, obtenga e imprima la representación del autor de ese libro.
 */
package tema3;

/**
 *
 * @author Pablo
 */
public class P3Ej2b {
    public static void main(String[] args) {
        Autor autor1 = new Autor ("Pablo", "aa", "La Plata");
        Autor autor2 = new Autor ("Matías", "bb", "Ensenada");
        Libro libro1= new  Libro( "Java: A Beginner's Guide",   
                                 "Mcgraw-Hill", 2014,   
                                 autor1, "978-0071809252", 21.72);
        Libro libro2= new Libro("Learning Java by Building Android Games",  
                              "CreateSpace Independent Publishing", 
                               autor2, "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " +libro2.getPrecio());
        System.out.println("Año edición del libro2: " +libro2.getAñoEdicion());
        System.out.println(autor1.toString());
        System.out.println(autor2.toString());
    }
}
