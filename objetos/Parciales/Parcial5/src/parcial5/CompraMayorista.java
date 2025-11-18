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
public class CompraMayorista extends Compra{
    private int CUIT;
    
    
    public CompraMayorista(int numero, int n, int CUIT){
        super(numero, n);
        this.CUIT = CUIT;
    }
    
    @Override
    public String toString(){
        String aux = super.toString() + ". CUIT: " + this.CUIT;
        return aux;
    }
}
