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
public class Jugador extends Empleado{
    private int numPJ;
    private int numGoles;
    
    public Jugador (String unNombre, double unSueldo, int unaAntiguedad, int numPJ, int numGoles){
        super(unNombre,unSueldo, unaAntiguedad);
        setNumPJ(numPJ);
        setNumGoles(numGoles);
    }
    
    /*@Override
    public String toString(){
        String aux = super.toString() +
                " Partidos jugados: " + getNumPJ() +
                " Cantidad de goles: " + getNumGoles();
        return aux;
    }
    */

    public int getNumPJ() {
        return numPJ;
    }

    public void setNumPJ(int numPJ) {
        this.numPJ = numPJ;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }
    
    @Override
    public double calcularEfectividad(){
        double aux = (double) (getNumGoles() / getNumPJ());
        return aux;
    }
    
    @Override
    public double calcularSueldoACobrar() {
        double aux = this.calcularSueldoBasico();
        if (this.calcularEfectividad()>0.5) {
            aux += this.getSueldo();
        }
        return aux;
    }
    
}
