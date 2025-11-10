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
public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;
    
    public Producto (int codigo, double precio, String descripcion){
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    public double obtenerPrecioUnidad(){
        return this.precio;
    }
    
    @Override
    public String toString(){
        String aux = "Codigo " + this.codigo + ", precio " + this.precio + ", descripción " + this.descripcion;
        return aux;
    }
}
