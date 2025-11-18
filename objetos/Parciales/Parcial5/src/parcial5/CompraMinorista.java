/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial5;

/**
 *
 * @author Pablo
 */
public class CompraMinorista extends Compra{
    private boolean esJubilado;
    
    public CompraMinorista(int numero, int n, boolean esJubilado){
        super(numero, n);
        this.esJubilado = esJubilado;
    }
    
    @Override
    public String toString(){
        String aux = super.toString() + ". Es jubilado: " + this.esJubilado;
        return aux;
    }
}
