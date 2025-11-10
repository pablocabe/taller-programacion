/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;

/**
 *
 * @author Pablo
 */
public class Materia {
    private String nombreMateria;
    private int nota;
    private int fecha;
    
    public Materia (String nombreMateria, int nota, int fecha){
        this.nombreMateria = nombreMateria;
        this.nota = nota;
        this.fecha = fecha;
    }
    
    public boolean esTesis(){
        return (this.nombreMateria == "Tesis");
    }
    
    @Override
    public String toString(){
        String aux = "Nombre: " + this.nombreMateria + ", nota: " + this.nota + "fecha: " + this.fecha + "\n";
        return aux;
    }
}
