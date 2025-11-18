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
public class Triangulo extends Figura{
    private double lado1;
    private double lado2;
    private double lado3;
    
    
    public Triangulo (double lado1, double lado2, double lado3, String unColorR, String unColorL){
        super (unColorR, unColorL);
        setLado1(lado1);
        setLado2(lado2);
        setLado3(lado3);
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        return ((lado1+lado2+lado3) / 2);
    }

    @Override
    public double calcularPerimetro() {
        return (lado1 + lado2 + lado3);
    }
    
    @Override
    public String toString(){
        String aux = super.toString() + 
                " Lado 1: " + getLado1() +
                " Lado 2: " + getLado2() +
                " Lado 3: " + getLado3();
        return aux;
    }
}
