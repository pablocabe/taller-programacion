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
public abstract class Compra {
    private int numero;
    private Producto [] vectorProductos;
    private int cantidadAgregadosDL;
    private int maximaCantidadDF;
    
    public Compra(int numero, int n){
        this.numero = numero;
        this.maximaCantidadDF = n;
        this.cantidadAgregadosDL = 0;
        vectorProductos = new Producto [n];
        for (int i=0 ; i<maximaCantidadDF ; i++){
            vectorProductos[i] = null;
        }
    }

    public void agregarCompra (Producto unProducto){
        vectorProductos[cantidadAgregadosDL] = unProducto;
        cantidadAgregadosDL++;
    }
    
    public double obtenerPrecioTotal (){
        double aux = 0;
        for (int i=0 ; i<cantidadAgregadosDL ; i++){
            aux += vectorProductos[i].obtenerPrecioUnidad();
        }
        aux += (aux/100)*21;
        return aux;
    }
    
    @Override
    public String toString(){
        String aux = "Número " + this.numero + "Productos: \n";
        for (int i=0 ; i<cantidadAgregadosDL ; i++){
            aux += vectorProductos[i].toString() + "\n";
        }
        aux += "Precio a pagar: " + obtenerPrecioTotal();
        return aux;
    }
}
