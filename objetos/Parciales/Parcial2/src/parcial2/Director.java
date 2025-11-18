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
public class Director extends Trabajador{
    private double montoViaticos;
    
    
    public Director (String nombre, int DNI, int añoIngreso, double sueldoBasico, double montoViaticos){
        super(nombre, DNI, añoIngreso, sueldoBasico);
        setMontoViaticos(montoViaticos);
    }

    public double getMontoViaticos() {
        return montoViaticos;
    }

    public void setMontoViaticos(double montoViaticos) {
        this.montoViaticos = montoViaticos;
    }

    @Override
    public double calcularSueldo() {
        return (super.calcularSueldo() + getMontoViaticos());
    }

}
