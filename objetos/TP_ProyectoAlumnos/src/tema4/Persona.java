/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Pablo
 */
public class Persona {
    private String nombre;
    private int DNI;
    private int edad;
    
    public Persona (String nombre, int DNI, int edad){
       this.setNombre(nombre);
       this.setDNI(DNI);
       this.setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + this.getNombre() +
                ", mi DNI es " + this.getDNI() + 
                " y tengo " + this.getEdad() + " años.";
        return aux;
    }
}
