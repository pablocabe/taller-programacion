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
public class Encargado extends Trabajador{
    private int cantidadEmpleados;

    public Encargado (String nombre, int DNI, int añoIngreso, double sueldoBasico, int cantidadEmpleados){
        super(nombre, DNI, añoIngreso, sueldoBasico);
        setCantidadEmpleados(cantidadEmpleados);
    }
    
    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }

    @Override
    public double calcularSueldo() {
        return (super.calcularSueldo() + (1000*getCantidadEmpleados()));
    }

}
   
