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
public class P2Ej4b {
    
    public static void main(String[] args) {
        int cantidadDias = 5, cantidadTurnos = 8;
        Persona[][] matriz = new Persona[cantidadDias][cantidadTurnos];
        Persona p;
        int diaSolicitado;
        int turnoDisponible;
        int cantidadAnotados = 0;
        String nombre;
        System.out.println("Comienza el casting");
        System.out.println("Ingrese el nombre");
        nombre = Lector.leerString();
        while ((cantidadAnotados < 40) && (!nombre.equals("ZZZ"))) {
            p = new Persona();
            p.setNombre(nombre);
            System.out.println("Ingrese el DNI");
            p.setDNI(Lector.leerInt());
            System.out.println("Ingrese la edad");
            p.setEdad(Lector.leerInt());
            System.out.println("Ingrese el dia (entre 1 y 5) en el cual se quiere presentar al casting");
            diaSolicitado = Lector.leerInt();
            turnoDisponible = 0;
            while ((turnoDisponible < cantidadTurnos)&&((matriz[diaSolicitado - 1][turnoDisponible]) != null)) {
                turnoDisponible++;
            }
            if (turnoDisponible < cantidadTurnos) {
                matriz[diaSolicitado - 1][turnoDisponible] = p;
                cantidadAnotados++;
                System.out.println("Turno asignado de forma correcta");
            } else {
                System.out.println("El turno no pudo ser asignado");
            }
            System.out.println("Ingrese el nombre");
            nombre = Lector.leerString();
        }
        if (nombre.equals("ZZZ")) {
            System.out.println("El casting terminó porque se ingresó el nombre ZZZ");
        } else {
            System.out.println("El casting terminó porque se utilizaron los 40 cupos");
        }
        for (int i=0 ; i<5 ; i++) {
            
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