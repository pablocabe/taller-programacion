/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Pablo
 */
public abstract class Trabajador {
    private String nombre;
    private int DNI;
    private int añoIngreso;
    private double sueldoBasico;
    
    public Trabajador (String nombre, int DNI, int añoIngreso, double sueldoBasico){
        setNombre(nombre);
        setDNI(DNI);
        setAñoIngreso(añoIngreso);
        setSueldoBasico(sueldoBasico);
    }

    public double calcularSueldo(){
        double aux = getSueldoBasico();
        if ((2024 - getAñoIngreso()) > 20){
            aux += (getSueldoBasico() / 100) * 10;
        }
        return aux;
    }
    
    @Override
    public String toString(){
        String aux = "Nombre " + getNombre() + ", DNI " + getDNI() + ", sueldo a cobrar " + calcularSueldo();
        return aux;
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

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
    
    
}
