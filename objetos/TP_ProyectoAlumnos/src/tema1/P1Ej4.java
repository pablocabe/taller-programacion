/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Pablo
 */
public class P1Ej4 {
    public static void main (String[] args) {
        GeneradorAleatorio.iniciar();
        int [][] edificio = new int [8][4];
        int i, j;
        for (i=0 ; i<8 ; i++) // inicializamos en 0 la matriz
            for (j=0 ; j<4 ; j++)
                edificio[i][j] = 0;
        int numPiso, numOficina;
        numPiso = GeneradorAleatorio.generarInt(8);
        while (numPiso != 8) {
            numOficina = GeneradorAleatorio.generarInt(4);
            edificio[numPiso][numOficina] = edificio[numPiso][numOficina] + 1;
            numPiso = GeneradorAleatorio.generarInt(9);
        }
        System.out.println ("La carga de datos finalizó");
        for (i=0 ; i<8 ; i++) {
            System.out.println ("Piso " + (i+1));
            for (j=0 ; j<4 ; j++)
                System.out.println ("La cantidad de personas en la oficina " + (j+1) + " es: " + edificio[i][j]);
        }
    }
}

/*
4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido.
*/
