/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P1Ej5 {

    public static void main(String[] args) {
        int[][] restaurante = new int[5][4];
        // inicializo la matriz en 0
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                restaurante[i][j] = 0;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("----------------------------");
            System.out.println("Se ingresaran las calificaciones del cliente " + (i + 1));
            for (int j = 0; j < 4; j++) {
                System.out.println("La calificacion del cliente sobre " + j + " es: ");
                restaurante[i][j] = Lector.leerInt();
            }
        }
        double total, promedio;
        for (int j = 0; j < 4; j++) {
            total = 0;
            for (int i = 0; i < 5; i++) {
                total = total + restaurante[i][j];
            }
            promedio = total / 5;
            System.out.println("El promedio del aspecto " + (j) + " es: " + promedio);
        }
    }
}

/*
5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
*/
