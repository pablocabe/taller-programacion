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
public class Parcial5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompraMayorista compraMayorista = new CompraMayorista (1, 10, 43600403);
        CompraMinorista compraMinorista = new CompraMinorista (2, 7, true);
        
        Producto producto1 = new Producto (1, 100, "Arroz");
        Producto producto2 = new Producto (2, 700, "Carne");
        Producto producto3 = new Producto (3, 50, "Polenta");
        Producto producto4 = new Producto (4, 1000, "Sushi");
        Producto producto5 = new Producto (5, 800, "Queso");
        Producto producto6 = new Producto (6, 750, "Jamón");
        
        compraMayorista.agregarCompra(producto1);
        compraMayorista.agregarCompra(producto2);
        compraMayorista.agregarCompra(producto3);
        compraMinorista.agregarCompra(producto4);
        compraMinorista.agregarCompra(producto5);
        compraMinorista.agregarCompra(producto6);
        
        System.out.println(compraMayorista.toString());
        System.out.println(compraMinorista.toString());
    }
}
