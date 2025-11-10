/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P1Ej3 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int[][] matriz = new int[5][5];
        // cargo la matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
        // muestro en consola la matriz
        for (int i = 0; i < 5; i++) {
            System.out.println("-----------");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "//");
            }
        }
        // sumo los valores de la primera fila
        int suma = 0;
        for (int j = 0; j < 5; j++) {
            suma = suma + matriz[0][j];
        }
        System.out.println("La suma de la primera fila es: " + suma);
        // genero un vector de 5 posiciones
        int[] vector = new int[5];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                vector[j] = vector[j] + matriz[i][j];
            }
        }
        // imprimo el vector de 5 posiciones
        for (int j = 0; j < 5; j++) {
            System.out.print(vector[j] + "//");
        }

        System.out.println("Ingrese un valor, el cual se buscará en la matriz");
        int numero = Lector.leerInt();
        boolean esta = false;
        int i=0, j;
        while ((i<5) && (!esta)) {
            j=0;
            while ((j<5) && (!esta)) {
                if (numero == matriz[i][j]) {
                    esta = true;
                    System.out.println ("El numero está en la posicion " + i + "," + j);
                }
                j++;
            }
            i++;
        }
        if (!esta) {
            System.out.println ("No se encontró el elemento");
        }
    }
}
/*
 * 3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice
la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma
de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Leer un valor entero e indicar si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”.
NOTA: Dispone de un esqueleto para este programa en Ej03Matrices.java
* 
* Otra forma de hacer el vector de 5 posiciones: 
*      int [] vector = new int [5];
       for (j=0 ; j<5 ; j++) { // genero un vector de 5 posiciones
           for (i=0 ; i<5 ; i++) 
               vector [j] = vector [j] + matriz [i][j];
       }
       for (j=0 ; j<5 ; j++) // imprimo el vector de 5 posiciones
           System.out.print (vector[j] + "//");

for (int i=0 ; i<5 & !esta ; i++)
           for (int j=0 ; j<5 & !esta ; j++)
               if (numero == matriz [i][j]) {
                   esta = true;
                   System.out.println ("El numero está en la posicion " + i + "," + j);
               }
       if (esta == false)  
           System.out.println ("No se encontró el elemento");
 */
