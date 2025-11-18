/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Pablo
 */
public class P2Ej4bmejorado {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int dias = 5;
        int turnos = 8;
        int entrevistados = 0;
        
        Persona matriz [][] = new Persona [dias][turnos];
        int [] vector = new int [dias];
        
        // Inicializo el vector contador
        for (int i=0 ; i<dias ; i++) {
            vector[i]=0;
        }
        
        String nombre = GeneradorAleatorio.generarString(3);
        while ((entrevistados < 40) && (!nombre.equals("ZZZ"))) {
            System.out.println("Ingrese el dia en el que desea anotarse");
            int diaAux = GeneradorAleatorio.generarInt(dias);
            if (vector[diaAux] < 8) {
                matriz[diaAux][vector[diaAux]]= new Persona (nombre, GeneradorAleatorio.generarInt(40), GeneradorAleatorio.generarInt(100));
                vector[diaAux]++;
                entrevistados++;
            } else {
                System.out.println("No hay mas turnos disponibles para el dia " + diaAux);
            }
            nombre = GeneradorAleatorio.generarString(3);
        }
        
        for (int i=0 ; i < dias ; i++) {
            for (int j=0 ; j < vector[i] ; j++) {
                System.out.println("Dia " + (i+1) + ", entrevista " + (j+1) + " es de: " + matriz[i][j].getNombre());
            }
            System.out.println("La cantidad de inscriptos el dia " + (i+1) + " fue: " + vector[i]);
        }
    }
}

/*
4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de
casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.
*/
