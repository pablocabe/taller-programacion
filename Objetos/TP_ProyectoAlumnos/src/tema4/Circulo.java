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
public class Circulo extends Figura{
    private double radio;
    
    public Circulo (double radio, String unColorR, String unColorL){
        super(unColorR, unColorL);
        setRadio(radio);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return (Math.PI * (radio * radio));
    }

    @Override
    public double calcularPerimetro() {
        return (2 * radio * Math.PI);
    }
    
    @Override
    public String toString(){
        String aux = super.toString() +
                " Radio: " + getRadio();
        return aux;
    }
}
