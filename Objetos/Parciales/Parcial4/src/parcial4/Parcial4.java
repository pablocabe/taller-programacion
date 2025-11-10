/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author Pablo
 */
public class Parcial4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion funcion = new Funcion ("Joker2", 10, 20, 7, 10);
        funcion.ocuparButaca(1, 2);
        funcion.ocuparButaca(3, 4);
        funcion.ocuparButaca(5, 4);
        funcion.ocuparButaca(3, 1);
        funcion.ocuparButaca(4, 6);
        funcion.ocuparButaca(6, 4);
        funcion.ocuparButaca(2, 8);
        funcion.ocuparButaca(5, 5);
        
        funcion.desocuparFila(2);
        System.out.println(funcion.obtenerColumna(4));
        System.out.println(funcion.toString());
    }
    
}
