/*
 2-A- Modifique la clase Libro.java (carpeta tema3) para ahora considerar que el primer
autor es un objeto instancia de la clase Autor.
Implemente la clase Autor, sabiendo que se caracterizan por nombre, biografía y origen
y que deben permitir devolver/modificar el valor de sus atributos y devolver una
representación String formada por nombre, biografía y origen.
Luego realice las modificaciones necesarias en la clase Libro
 */
package tema3;

/**
 *
 * @author Pablo
 */
public class Autor {
    private String nombre = "Default";
    private String biografia = "Default";
    private String origen = "Default";

    public Autor(String nombre, String biografia, String origen){
        this.nombre = nombre;
        this.biografia = biografia;
        this.origen = origen;
    }
    
    public Autor() {
    
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    @Override
    public String toString(){
        String aux;
        aux = ("Autor " + nombre + ". Biografía: " + biografia + ". Origen: " + origen);
        return aux;
    }
}
