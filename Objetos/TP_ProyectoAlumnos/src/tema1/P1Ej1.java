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
public class P1Ej1 {
    public static void main (String[] args) {
        GeneradorAleatorio.iniciar();
        int i, numero, DF = 11;
        int [] tabla2 = new int [DF]; // indices de 0 a 10
        for (i=0 ; i<DF ; i++)
            tabla2[i]=2*i;
        numero = GeneradorAleatorio.generarInt(12); // si pusiera 11 nunca terminaría porque iría de 0 a 10
        while (numero != 11) {
            System.out.println("El " + numero + " multiplicado por 2 es: " + tabla2[numero]);
            numero = GeneradorAleatorio.generarInt(12);
        }
    }
}

/**
 * 1- Analice el programa Ej01Tabla2.java, que carga un vector que representa la tabla
del 2. Genere enteros aleatorios hasta obtener el número 11. Para cada número muestre
el resultado de multiplicarlo por 2 (accediendo al vector)
 */