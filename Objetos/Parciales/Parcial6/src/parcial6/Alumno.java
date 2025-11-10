/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Pablo
 */
public class Alumno {
    private String nombre;
    private int DNI;
    private int temaAsignado;
    
    public Alumno(String nombre, int DNI){
        this.nombre = nombre;
        this.DNI = DNI;
        this.temaAsignado = -1;
    }
    
    public void asignarTemaAlumno(int m){
        this.temaAsignado = GeneradorAleatorio.generarInt(m)+1;
    }
    
    public boolean rindeTemaT(int T){
        return (this.temaAsignado == T);
    }
    
    @Override
    public String toString (){
        String aux = "Alumno " + this.nombre + ", DNI " + this.DNI;
        return aux;
    }
}
