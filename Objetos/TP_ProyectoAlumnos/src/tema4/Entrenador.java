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
public class Entrenador extends Empleado{
    private int cantidadTitulos;
    
    public Entrenador (String unNombre, double unSueldo, int unaAntiguedad, int cantidadTitulos){
        super(unNombre, unSueldo, unaAntiguedad);
        setCantidadTitulos(cantidadTitulos);
    }
    
    /*@Override
    public String toString(){
        String aux = super.toString() + " Cantidad de títulos obtenidos: " + getCantidadTitulos();
        return aux;
    }
    */

    public int getCantidadTitulos() {
        return cantidadTitulos;
    }

    public void setCantidadTitulos(int cantidadTitulos) {
        this.cantidadTitulos = cantidadTitulos;
    }

    @Override
    public double calcularEfectividad() {
        double aux = (double) getCantidadTitulos() / getAntiguedad(); // Acá hace falta el this?
        return aux;
    }

    @Override
    public double calcularSueldoACobrar() {
        double aux = this.calcularSueldoBasico();
        if (this.getCantidadTitulos() == 0){
            return aux;
        }
        else {
            if (this.getCantidadTitulos() >= 1 && this.getCantidadTitulos() <= 4){
            aux += 5000;
            }
            else if (this.getCantidadTitulos() >= 5 && this.getCantidadTitulos() <= 10){
                aux += 30000;
            }
            else
                aux += 50000;
        }
        return aux;  
    }
}
//Para los entrenadores: se adiciona un plus por campeonatos ganados (5000$ si ha
//ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos;
//50.000$ si ha ganado más de 10 campeonatos).

