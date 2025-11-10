/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P2Ej3b {
    public static void main(String[] args) {
        int cantidadDias=5, cantidadTurnos=8;
        Persona[][] matriz = new Persona[cantidadDias][cantidadTurnos];
        Persona p = new Persona();
        int dia = 0;
        int turno;
        String nombre;
        System.out.println("Comienza el casting");
        System.out.println("Ingrese el nombre");
        nombre = Lector.leerString();
        while ((dia < cantidadDias) && (!nombre.equals("ZZZ"))) {
            turno=0;
            while ((turno < cantidadTurnos) && (!nombre.equals("ZZZ"))) {
                p.setNombre(nombre);
                System.out.println("Ingrese el DNI");
                p.setDNI(Lector.leerInt());
                System.out.println("Ingrese la edad");
                p.setEdad(Lector.leerInt());
                matriz [dia][turno] = p;
                p = new Persona();
                System.out.println("Ingrese el nombre");
                nombre = Lector.leerString();
                turno++;
                }
            dia++;
            }
        
        if (nombre.equals("ZZZ")) {
            System.out.println("El casting terminó porque se ingresó el nombre ZZZ");
        } else {
            System.out.println("El casting terminó porque se utilizaron los 40 cupos");
        }
        
        System.out.println("Se informará el nombre de las personas del casting");
        int i=0, j=0;
        while ((i<cantidadDias) && (matriz[i][j] != null)) {
            j=0;
            while ((j<cantidadTurnos) && (matriz[i][j] != null)){
                System.out.println("Día " + (i+1) + " Turno " + (j+1) + ": " + matriz[i][j].getNombre());
                j++;
            }
            i++;
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

Opción1: for (int i=0 ; i < dia ; i++) {
            for (int j=0 ; j<8 ; j++) {
                System.out.println("Día " + (i+1) + " Turno " + (j+1) + ": " + matriz[i][j].getNombre());
            }
        }
        if (turno > 0 && dia < 5) {
            for (int j=0; j < turno ; j++) {
            System.out.println("Día " + (dia+1) + " Turno " + (j+1) + ": " + matriz[dia][j].getNombre());
            }
        }

   Opción2: for (int i=0; i < matriz.length ; i++) {
            for (int j=0; j < matriz[i].length ; j++) {
                System.out.println("Día " + (i+1) + " Turno " + (j+1) + ": " + matriz[i][j].getNombre());
            }
        }
*/


/* Copia por las dudas:
package tema2;

import PaqueteLectura.Lector;

public class P2Ej3b {
    public static void main(String[] args) {
        int cantidadDias=5, cantidadTurnos=8;
        Persona[][] matriz = new Persona[cantidadDias][cantidadTurnos];
        Persona p = new Persona();
        int dia = 0, turno= 0;
        String nombre;
        System.out.println("Comienza el casting");
        System.out.println("Ingrese el nombre");
        nombre = Lector.leerString();
        while ((dia < cantidadDias) && (!nombre.equals("ZZZ"))) {
            turno=0;
            while ((turno < cantidadTurnos) && (!nombre.equals("ZZZ"))) {
                p.setNombre(nombre);
                System.out.println("Ingrese el DNI");
                p.setDNI(Lector.leerInt());
                System.out.println("Ingrese la edad");
                p.setEdad(Lector.leerInt());
                matriz [dia][turno] = p;
                p = new Persona();
                nombre = Lector.leerString();
                if (!nombre.equals("ZZZ")) {
                    turno++;
                }
            }
            if (!nombre.equals("ZZZ")) {
                dia++;
            }
        }
        if (nombre.equals("ZZZ")) {
            System.out.println("El casting terminó porque se ingresó el nombre ZZZ");
        } else {
            System.out.println("El casting terminó porque se utilizaron los 40 cupos");
        }
        // cómo hago acá el inciso B?
        
        System.out.println("Se informará el nombre de las personas del casting");
        int i=0, j=0;
        while ((i<cantidadDias) & (matriz[i][j] != null)) {
            j=0;
            while ((j<cantidadTurnos) & (matriz[i][j] != null)){
                System.out.println("Día " + (i+1) + " Turno " + (j+1) + ": " + matriz[i][j].getNombre());
                j++;
            }
            i++;
        }
    }
}
*/
