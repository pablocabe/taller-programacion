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
public class P2Ej3bmejorado {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // Creo las variables
        int dias = 5;
        int turnos = 8;
        int entrevistados = 0;
        int ultimoDia = -1;
        int aux = 0;
        // Creo la matriz y el vector
        Persona [][] matriz = new Persona [dias][turnos];
        int [] vector = new int [dias];
        // Inicializo el vector contador
        for (int i=0 ; i<dias ; i++) {
            vector[i]=0;
        }
        
        String nombre = GeneradorAleatorio.generarString(3);
        while ((!nombre.equals("ZZZ")) && (entrevistados < 40)) {
            matriz[aux][vector[aux]] = new Persona (nombre, GeneradorAleatorio.generarInt(40), GeneradorAleatorio.generarInt(100));
            // Aumento en 1 la cantidad de anotados para el dia aux
            vector[aux]++;
            ultimoDia = aux;
            // Paso a otro dia si es 8
            if (vector[aux]== 8) {
                aux++;
            }
            nombre = GeneradorAleatorio.generarString(3);
            entrevistados++;
        }
        for (int i=0 ; i <= ultimoDia ; i++) {
            for (int j=0 ; j < vector[i] ; j++) {
                System.out.println("Dia " + (i+1) + ", entrevista " + (j+1) + " es de: " + matriz[i][j].getNombre());
            }
        }
    }
}


/*
3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals.
*/