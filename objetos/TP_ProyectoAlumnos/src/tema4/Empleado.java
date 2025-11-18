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
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;
    
    public Empleado(String unNombre, double unSueldo, int unaAntiguedad){
        setNombre(unNombre);
        setSueldo(unSueldo);
        setAntiguedad(unaAntiguedad);
    }
    
    @Override
    public String toString(){
        String aux = " Nombre: " + this.getNombre() + 
                " Sueldo a cobrar: " + this.calcularSueldoACobrar()+ 
                " Efectividad: " + this.calcularEfectividad();
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public double calcularSueldoBasico(){
        return getSueldo() + ((getSueldo()* 0.10) * getAntiguedad()); // Acá hace falta el this?
    }
    
    public abstract double calcularEfectividad();
    
    public abstract double calcularSueldoACobrar();
}
